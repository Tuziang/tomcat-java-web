package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckServlet1 extends HttpServlet {

   /** 响应客户请求*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    
    PrintWriter out=response.getWriter();

    //读取用户名
    String username = request.getParameter("username");
    String message=null;
    if(username==null){
      message="Please input username.";
    }else{
      message="Hello,"+username;
    }

    //在request对象中添加msg属性
    request.setAttribute("msg", message);

    out.println("Output from CheckServlet1 before redirecting."); 
    System.out.println("Output from CheckServlet1 before redirecting.");

    response.sendRedirect("/helloapp/output1?msg="+message); //ok
    //response.sendRedirect("/output1?msg="+message"); //wrong
   // response.sendRedirect("http://localhost:8080/helloapp/output1?msg="+message); //ok
   //response.sendRedirect("http://www.javathinker.net"); //ok


    out.println("Output from CheckServlet1 after redirecting."); 
    System.out.println("Output from CheckServlet1 after redirecting.");
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
