package com.thinking.machines.service;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.zip.*;
import java.nio.file.*;

@WebServlet("/SqlToExcel")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class SqlToExcel extends HttpServlet 
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String uploadPath = request.getServletContext().getRealPath("");
System.out.println(uploadPath);        
String savePath = uploadPath+"WEB-INF"+File.separator+"uploads"+File.separator;
System.out.println(savePath);
File fileSaveDir = new File(savePath);
if(!fileSaveDir.exists()) 
{
fileSaveDir.mkdir();
}
System.out.println("hello");
String vishal="";
for (Part part : request.getParts()) 
{
String fileName = extractFileName(part);
vishal=new String(fileName);
fileName = new File(fileName).getName();
part.write(savePath + File.separator + fileName);
}
String filePath=savePath+vishal;
String dbName=vishal.split("\\.")[0];
System.out.println(dbName);
String dbUserName="root";
String dbPassword="vishal";
String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, dbName,"-e", " source "+filePath};
Process runtimeProcess;  
Connection con;
boolean found=false;
try 
{
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user="+dbUserName+"&password="+dbPassword);
Statement stmt ;
stmt= con.createStatement();
ResultSet rs ;
rs= con.getMetaData().getCatalogs();
while(rs.next())
{
String catalogs = rs.getString(1);
if(dbName.equals(catalogs))
{
System.out.println("the database "+dbName+" exists");
found=true;
}
}
if(!found)
{
String sql = "CREATE DATABASE "+dbName;
stmt.executeUpdate(sql);
}
runtimeProcess = Runtime.getRuntime().exec(executeCmd);  
int processComplete = runtimeProcess.waitFor();  
System.out.println(processComplete);
if (processComplete == 0) 
{  
System.out.println("Backup restored successfully");  
} 
else
{  
System.out.println("Could not restore the backup");  
}
rs.close();
con.close(); 

savePath = uploadPath+"WEB-INF"+File.separator+"result"+File.separator;
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName+"?user="+dbUserName+"&password="+dbPassword);
Statement stmtt = conn.createStatement();
Statement stm=conn.createStatement();
ResultSet r = stmtt.executeQuery("Show tables");
String tableName;
String zipFileName = savePath+dbName.concat(".zip");
FileOutputStream fos = new FileOutputStream(zipFileName);
ZipOutputStream zos = new ZipOutputStream(fos);
ResultSet result=null;
while(r.next())
{
tableName=r.getString(1);
System.out.println(r.getString(1));
String sql = "SELECT * INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/"+tableName+".xls' FROM "+tableName;                 
result = stm.executeQuery(sql);
String zipPath = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/"+tableName+".xls"; 
File zip=new File(zipPath);
zos.putNextEntry(new ZipEntry(zip.getName()));
byte[] bytes = Files.readAllBytes(Paths.get(zipPath));
zos.write(bytes, 0, bytes.length);
zos.closeEntry();           
}
zos.close();
fos.close();
r.close();
result.close();
conn.close();

/*PrintWriter out=response.getWriter();
response.setContentType("APPLICATION/OCTET-STREAM");
FileInputStream fileInputStream=new FileInputStream(zipFileName);
int i;
while((i=fileInputStream.read())!=-1)
{
out.write(i);
}
fileInputStream.close();
out.close();		
*/
dbName=dbName+".zip";
out.write("<center><div class='result-download result-panel hidden'>");
out.write("<a href=\"download?filename="+dbName+"\">");
out.write("<img src='img/download.png' width='30' alt='' />");
out.write("Download<span class='hide-450-down'> the converted</span> file");
out.write("</a>");
out.write("</div></center>");
}
catch (Exception ex) 
{  
ex.printStackTrace();  
}
}
catch(Exception e)
{
System.out.println(e);
}

}


public String extractFileName(Part part) 
{
String contentDisp = part.getHeader("content-disposition");
String[] items = contentDisp.split(";");
for (String s : items) 
{
if (s.trim().startsWith("filename")) 
{
return s.substring(s.indexOf("=") + 2, s.length()-1);
}
}
return "";
}
}