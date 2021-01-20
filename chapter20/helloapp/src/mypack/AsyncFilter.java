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
  //引用由Servlet容器提供的FilterConfig对象 
  private FilterConfig config = null;  

  public void init(FilterConfig config) throws ServletException {
    System.out.println("AsyncFilter: init()"); 
    //把Servlet容器提供的FilterConfig对象传给config成员变量
    this.config = config; 
  }

  public void doFilter(ServletRequest request,ServletResponse response, 
          FilterChain chain) throws IOException, ServletException {
     System.out.println("AsyncFilter: doFilter()"); 

    AsyncContext asyncContext = request.startAsync();
    //设定异步操作的超时时间
    asyncContext.setTimeout(60*1000);  
    asyncContext.start(new MyTask(asyncContext));
    //把请求转发给后续的过滤器或者Web组件
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
