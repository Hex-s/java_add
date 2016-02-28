package com.niit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OpenServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filepath");
		Runtime runtime = Runtime.getRuntime();
		String type = "";
		if((filename.lastIndexOf(".xls")>0) || (filename.lastIndexOf(".xlsx")>0)){  
		     type = "application/vnd.ms-excel";    
		 }else if(filename.lastIndexOf(".pdf")>0){  
		     type = "application/pdf";            
		 }else if((filename.lastIndexOf(".doc")>0)  || (filename.lastIndexOf(".docx")>0)){  
		     type = "application/msword";         
		 }else if(filename.lastIndexOf(".txt")>0){   
		     type = "text/plain";                  
		 }else if(filename.lastIndexOf(".ppt") >0){  
		     type = "application/ppt";  
		     runtime.exec("rundll32 url.dll FileProtocolHandler "+"e:/"+filename);
		 }  

		 response.setContentType(type);   	
		
		//InputStream is = getServletContext().getResourceAsStream("/WEB-INF/1.pdf"); 
		InputStream is = new FileInputStream(new File("e:/"+filename)); 
		
		OutputStream os = response.getOutputStream(); 
		writeBytes(is, os); 
	} 

		private void writeBytes(InputStream in, OutputStream out) throws IOException { 
			byte[] buffer = new byte[1024]; 
			int length = -1; 
			while ((length = in.read(buffer)) != -1) { 
			out.write(buffer, 0, length); 
			} 
			in.close(); 
			out.close(); 
		} 
}
