<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String sno = "";
	String fileName= "";
	String dir = "";

	// 1. multipart/form-data 여부 확인
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	if(isMultipart){
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = upload.parseRequest(request);
		
		Iterator<FileItem> itr = items.iterator();
		
		while(itr.hasNext()){
			FileItem item = itr.next();
			
			
			if(item.isFormField()){
				String name = item.getFieldName();
				String value = item.getString("utf-8");
				sno = value;
				
				request.setAttribute("sno", sno);
				
			}else{ // type="file"
				String name = item.getFieldName();
				String fName = item.getName();
				String contentType = item.getContentType();
				boolean isInMemory = item.isInMemory();
				long fileSize = item.getSize();				
				
				fileName = fName + " : " + contentType + " : " + fileSize;
				
				String uploadUri = "/file";
				
				dir = request.getSession().getServletContext().getRealPath(uploadUri);
				
				item.write(new File(dir, fName));
				
				request.setAttribute("fileName", fName);
				
				request.setAttribute("file", fileName);
				
			}
		}
		
	}




%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학번 : ${sno } </h1>
<h1>file : ${file } </h1>
<%= dir %> <br>

<img alt="이미지" src="<%=request.getContextPath() %>/file/${fileName}" />


</body>
</html>