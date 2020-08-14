package com.thinking.machines.service.error;
public class RegistrationError
{
private String userName;
private String emailId;
private String password;
private String captchaCode;
public RegistrationError()
{
System.out.println("Error Object bana");
this.userName="";
this.emailId="";
this.password="";
this.captchaCode="";
}
public void setUserName(String userName)
{
System.out.println("user name set kiya");
this.userName=userName;
}
public void setEmailId(String emailId)
{
System.out.println("email set kiya");
this.emailId=emailId;
}
public String getUserName()
{
return this.userName;
}
public String getEmailId()
{
return this.emailId;
}
public String getPassword()
{
return this.password;
}
public void setPassword(String password)
{
System.out.println("password set kiya");
this.password=password;
} 
public void setCaptchaCode(String captchaCode)
{
System.out.println("captcha set kiya");
this.captchaCode=captchaCode;
}
public String getCaptchaCode()
{
return this.captchaCode;
}
}