package com.thinking.machines.service;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/download")
public class FileDownload extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
String filename = request.getParameter("filename");   
String filepath = getServletContext().getRealPath("") + File.separator + "WEB-INF"+File.separator+"result"+File.separator;  
response.setContentType("APPLICATION/OCTET-STREAM");   
response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
            
int i;   
while ((i=fileInputStream.read()) != -1) 
{  
out.write(i);   
}   
fileInputStream.close();   
out.close();   
}    
catch(Exception e)
{
System.out.println(e);
}
}
}