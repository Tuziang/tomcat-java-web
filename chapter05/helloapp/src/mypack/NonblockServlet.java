package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(urlPatterns="/nonblock",
            asyncSupported=true)
public class NonblockServlet extends HttpServlet{

  public void service(HttpServletRequest request ,
              HttpServletResponse response)
              throws IOException , ServletException{

    response.setContentType("text/html;charset=GBK");
    PrintWriter out = response.getWriter();
    out.println("<title>非阻塞IO示例</title>");
    out.println("进入Servlet的service()方法的时间："
      + new java.util.Date() + ".<br/>");

    // 创建AsyncContext，开始异步调用
    AsyncContext context = request.startAsync();
    //设置异步调用的超时时长
    context.setTimeout(60 * 1000);

    ServletInputStream input = request.getInputStream();
    //为输入流注册监听器
    input.setReadListener(new MyReadListener(input, context));

    out.println("退出Servlet的service()方法的时间："
               + new java.util.Date() + ".<br/><hr>");
    out.flush();
  }
}


