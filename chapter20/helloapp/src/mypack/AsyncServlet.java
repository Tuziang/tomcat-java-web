package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name="AsyncServlet",
            urlPatterns="/async",
            asyncSupported=true)

public class AsyncServlet extends HttpServlet{

  public void service(HttpServletRequest request,
              HttpServletResponse response)
              throws ServletException,IOException{  

     response.setContentType("text/plain;charset=GBK");
     AsyncContext asyncContext = request.getAsyncContext();
     asyncContext.start(new MyTask(asyncContext));

  }

  class MyTask implements Runnable{
    private AsyncContext asyncContext;

    public MyTask(AsyncContext asyncContext){
      this.asyncContext = asyncContext;
    }

    public void run(){
      try{
        //睡眠5秒，模拟很耗时的一段业务操作
        Thread.sleep(5*1000);
        asyncContext.getResponse()
                  .getWriter()
                  .write("让您久等了!");   
        asyncContext.complete();
      }catch(Exception e){e.printStackTrace();}
    }
  }
}





/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
