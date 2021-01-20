package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name="AsyncServlet1",
            urlPatterns="/async1",
            asyncSupported=true)

public class AsyncServlet1 extends HttpServlet{

  public void service(HttpServletRequest request,
              HttpServletResponse response)
              throws ServletException,IOException{  

     response.setContentType("text/plain;charset=GBK");
     AsyncContext asyncContext = request.startAsync();
     //设定异步操作的超时时间
     asyncContext.setTimeout(60*1000);  
     
     //启动异步线程的方式一
     asyncContext.start(new MyTask(asyncContext));

  }
}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
