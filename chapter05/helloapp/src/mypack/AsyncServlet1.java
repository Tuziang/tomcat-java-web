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
     //�趨�첽�����ĳ�ʱʱ��
     asyncContext.setTimeout(60*1000);  
     
     //�����첽�̵߳ķ�ʽһ
     asyncContext.start(new MyTask(asyncContext));

  }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
