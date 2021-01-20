package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@WebServlet(name="AsyncServlet4",
            urlPatterns="/async4",
            asyncSupported=true)

public class AsyncServlet4 extends HttpServlet{
  public void service(HttpServletRequest request,
              HttpServletResponse response)
              throws ServletException,IOException{  

     response.setContentType("text/plain;charset=GBK");
     AsyncContext asyncContext = request.startAsync();
     //�趨�첽�����ĳ�ʱʱ��
     asyncContext.setTimeout(60*1000); 
     
     //ע���첽��������� 
     asyncContext.addListener(new AsyncListener(){

       public void onComplete(AsyncEvent asyncEvent) 
                                throws IOException {
         System.out.println("on Complete...");
       }

       public void onTimeout(AsyncEvent asyncEvent) 
                                throws IOException {
         System.out.println("on Timeout...");
       }

       public void onError(AsyncEvent asyncEvent) 
                                throws IOException {
         System.out.println("on Error...");
       }

       public void onStartAsync(AsyncEvent asyncEvent)
                                throws IOException {
         System.out.println("on Start...");
       }
     });
     
     asyncContext.start(new MyTask(asyncContext));
  }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
