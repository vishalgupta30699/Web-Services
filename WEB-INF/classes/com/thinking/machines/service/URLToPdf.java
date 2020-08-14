package com.thinking.machines.service;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/URLToPdf")
public class URLToPdf extends HttpServlet 
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
{
RequestDispatcher requestDispatcher = request.getRequestDispatcher("URLToPdf.jsp");
requestDispatcher.forward(request,response);
} 
}