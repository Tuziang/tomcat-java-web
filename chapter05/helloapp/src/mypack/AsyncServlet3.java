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
     //�趨�첽�����ĳ�ʱʱ��
     asyncContext.setTimeout(60*1000); 
     
     //�����첽�̵߳ķ�ʽ�� 
     executor.execute(new MyTask(asyncContext));
  }

  public void destroy(){
    //�ر��̳߳�
    executor.shutdownNow();
  }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
