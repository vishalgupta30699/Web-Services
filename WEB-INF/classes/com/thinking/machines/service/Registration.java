package com.thinking.machines.service;
import com.thinking.machines.service.error.*;
import com.thinking.machines.service.beans.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/register")
public class Registration extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
String userName=request.getParameter("userName");
String emailId=request.getParameter("emailId");
String password=request.getParameter("password");
String rpassword=request.getParameter("rpassword");
String captcha=request.getParameter("captcha");
System.out.println(userName);
System.out.println(emailId);
System.out.println(password);
System.out.println(captcha);
RegistrationError registrationError=new RegistrationError();
UserBean userBean=new UserBean();
userBean.setUserName(userName);
userBean.setEmailId(emailId);
String fileName="user.data";
File file=new File(fileName);
String vUserName,vEmailId,vPassword;
int p=0,q=0,r=0,s=0;
RandomAccessFile raf=new RandomAccessFile(file,"rw");
while(raf.getFilePointer()<raf.length())
{
vUserName=raf.readLine();
vEmailId=raf.readLine();
vPassword=raf.readLine();
if(vUserName.equals(userName))
{
registrationError.setUserName("UserName already Exist!");
p=1;
}
if(vEmailId.equals(emailId))
{
registrationError.setEmailId("EmailId already Exist");
q=1;
}
if(p==1&&q==1) break;
}
raf.close();
if(!(password.equals(rpassword)))
{
registrationError.setPassword("Password Not matched!");
r=1;
}
String cap=(String)request.getSession().getAttribute("captcha");
System.out.println(cap);
if(!(cap.equals(captcha)))
{
registrationError.setCaptchaCode("Invalid Captcha!");
s=1;
}
System.out.println("yha aaya");
if(p==1||q==1||r==1||s==1)
{
request.setAttribute("registrationError",registrationError);
request.setAttribute("userBean",userBean);
RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
requestDispatcher.forward(request,response);
}
else
{
raf=new RandomAccessFile(file,"rw");
raf.seek(raf.length());
raf.writeBytes(userName);
raf.writeBytes("\n");
raf.writeBytes(emailId);
raf.writeBytes("\n");
raf.writeBytes(password);
raf.writeBytes("\n");
raf.close();
RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
requestDispatcher.forward(request,response);
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}