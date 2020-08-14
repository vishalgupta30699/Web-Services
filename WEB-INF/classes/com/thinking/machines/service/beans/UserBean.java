package com.thinking.machines.service.beans;
public class UserBean
{
private String userName;
private String emailId;
public UserBean()
{
System.out.println("Bean object bana");
this.userName="";
this.emailId="";
}
public void setUserName(String userName)
{
this.userName=userName;
}
public void setEmailId(String emailId)
{
this.emailId=emailId;
}
public String getEmailId()
{
return this.emailId;
}
public String getUserName()
{
return this.userName;
}
}