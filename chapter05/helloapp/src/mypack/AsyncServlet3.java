package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@WebServlet(name="AsyncServlet3",
            urlPatterns="/async3",
            asyncSupported=true)

public class AsyncServlet3 extends HttpServlet{
  private static ThreadPoolExecutor executor = 
          new ThreadPoolExecutor(100, 200, 50000L, 
                 TimeUnit.MILLISECONDS, 
                 new ArrayBlockingQueue<>(100));

  public void service(HttpServletRequest request,
              HttpServletResponse response)
              throws ServletException,IOException{  

     response.setContentType("text/plain;charset=GBK");
     AsyncContext asyncContext = request.startAsync();
     //设定异步操作的超时时间
     asyncContext.setTimeout(60*1000); 
     
     //启动异步线程的方式三 
     executor.execute(new MyTask(asyncContext));
  }

  public void destroy(){
    //关闭线程池
    executor.shutdownNow();
  }
}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
