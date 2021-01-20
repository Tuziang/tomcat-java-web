package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebFilter(
filterName = "AsyncFilter", 	
urlPatterns = "/async", 	
asyncSupported=true
)
public class AsyncFilter implements Filter {
  //������Servlet�����ṩ��FilterConfig���� 
  private FilterConfig config = null;  

  public void init(FilterConfig config) throws ServletException {
    System.out.println("AsyncFilter: init()"); 
    //��Servlet�����ṩ��FilterConfig���󴫸�config��Ա����
    this.config = config; 
  }

  public void doFilter(ServletRequest request,ServletResponse response, 
          FilterChain chain) throws IOException, ServletException {
     System.out.println("AsyncFilter: doFilter()"); 

    AsyncContext asyncContext = request.startAsync();
    //�趨�첽�����ĳ�ʱʱ��
    asyncContext.setTimeout(60*1000);  
    asyncContext.start(new MyTask(asyncContext));
    //������ת���������Ĺ���������Web���
    chain.doFilter(request, response);
  }
  
  public void destroy() {
    System.out.println("AsyncFilter: destroy()"); 
    config = null;
  }

  class MyTask implements Runnable{
    private AsyncContext asyncContext;
    public MyTask(AsyncContext asyncContext){
      this.asyncContext = asyncContext;
    }

    public void run(){
      try{
        config.getServletContext().log(
              "AsyncFilter:doFilter()");

       }catch(Exception e){e.printStackTrace();}
    }
  }
}
