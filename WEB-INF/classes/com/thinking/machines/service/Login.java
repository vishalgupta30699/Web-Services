package com.thinking.machines.service;
import com.thinking.machines.service.error.*;
import com.thinking.machines.service.beans.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/login")
public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
String userName=request.getParameter("userName");
String password=request.getParameter("password");
System.out.println(userName);;
System.out.println(password);
RegistrationError registrationError=new RegistrationError();
String fileName="user.data";
File file=new File(fileName);
String vUserName,vEmailId,vPassword;
int p=0;
RandomAccessFile raf=new RandomAccessFile(file,"rw");
while(raf.getFilePointer()<raf.length())
{
vUserName=raf.readLine();
vEmailId=raf.readLine();
vPassword=raf.readLine();
if(vUserName.equals(userName))
{
if(vPassword.equals(password)) { p=1; break;}
}
}
raf.close();
System.out.println("yha aaya");
if(p==0)
{
registrationError.setUserName("Invalid UserName and Password!");
request.setAttribute("registrationError",registrationError);
RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
requestDispatcher.forward(request,response);
}
else
{
request.getSession().setAttribute("userName",userName);
RequestDispatcher requestDispatcher = request.getRequestDispatcher("PSH.jsp");
requestDispatcher.forward(request,response);
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}