package com.bit.mvc1112;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
/*이게 조금 더 좋은거 같기도 하고 아닌거 같기기도 하고 아닌가 이게 제일 좋아 학원내에서는 이게 키감이 제일 짱인듯 싶네요
근데 코딩을 이렇게 소리가 좋게 날 정도로 빠르게 치시나요?? 궁금하네요ㅎㅎㅎ 수고하세요...
키감 개좋다 ㅋㅋㅋ 오 이거 좋다 오 이거 좋아 근데 개무거움 키감 굿 또닥또각또각 소리도 좋음
*/
@Controller
public class DownloadController implements ApplicationContextAware {

	private WebApplicationContext context = null;

	@RequestMapping("/file")
	public ModelAndView download() {
		
		Object modelObject = getFile();
		
		return new ModelAndView("downloadView", "downloadFile", modelObject);
	}
	
	private File getFile() {
		
		// 절대경로 잡아주기
		String path = context.getServletContext().getRealPath("/WEB-INF/설명.txt");
		File file = new File(path);
		
		return file; 
	}

	@RequestMapping("/download")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		this.context = (WebApplicationContext) applicationContext;
		
	}
	
}
