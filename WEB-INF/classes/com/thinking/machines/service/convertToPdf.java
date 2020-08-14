package com.thinking.machines.service;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/convertToPdf")
public class convertToPdf extends HttpServlet 
{
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try 
{
String url=request.getParameter("PDFURL");
System.out.println(url);
String command = getServletContext().getRealPath("")+"WEB-INF"+File.separator+"python"+File.separator+"convert.py";
System.out.println(command);
String filename = url.split("\\.")[1]+".pdf";
System.out.println(filename);
ProcessBuilder pb=new ProcessBuilder("python",command,url);
Process p=pb.start();
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
while ((line =in.readLine()) != null) 
{
System.out.println(line);
}
out.write("<center><div class='result-download result-panel hidden'>");
out.write("<a href=\"download?filename="+filename+"\">");
out.write("<img src='img/download.png' width='30' alt='' />");
out.write("Download<span class='hide-450-down'> the converted</span> file");
out.write("</a>");
out.write("</div></center>");
} 
catch (Exception e) 
{
e.printStackTrace();
out.println("Failed to Created!");
}
} 
}