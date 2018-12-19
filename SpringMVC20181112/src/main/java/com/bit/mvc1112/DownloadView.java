package com.bit.mvc1112;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	public DownloadView() {
		
		setContentType("application/download; charset=utf-8");
		
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 컨트롤러에서 데이터 받기~~~ model에 담겨서 옵니다~~~
		
		File file = (File)model.get("downloadFile"); // File타입으로 형변환

		// 파일이 안 들어올 경우를 대비해서 null 일경우 어쩌구 해쥬면 ㅇㅋ
		
		response.setContentType(getContentType());
		response.setContentLength((int)file.length()); // length는 롱타입이라서 명시적으로 int로 형변환 필요
		
		// 브라우저 체크 ( 한글타입 안받을걸 대비해서 )
		String userAgent = request.getHeader("User-Agent");
		
		boolean ie =  userAgent.indexOf("MSIE") > -1; // 마이크로소프트 익스플로런가보다
		
		String fileName = "";
		
		if(ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8"); // 한글처리
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		// attachment; filename="메모.txt"; 이런식으로 들어간다
		
		response.setHeader("Content-Transfer-Encording", "binary");
		
		// 이제 전송할 차례
		OutputStream out = response.getOutputStream();
		
		FileInputStream fis = null;
		
		// 파일 쓰기위한 트라이-캐치
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		}finally {
			if(fis != null) {
				fis.close(); // 여기서도 예외날수가 있어서 캐치해줘야 하는데 일단 그냥 넘어갑니다... 교안 참고
			}
		}
		out.flush();
		
	}

	
	
}
