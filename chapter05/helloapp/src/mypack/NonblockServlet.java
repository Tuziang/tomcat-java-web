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
    out.println("<title>������IOʾ��</title>");
    out.println("����Servlet��service()������ʱ�䣺"
      + new java.util.Date() + ".<br/>");

    // ����AsyncContext����ʼ�첽����
    AsyncContext context = request.startAsync();
    //�����첽���õĳ�ʱʱ��
    context.setTimeout(60 * 1000);

    ServletInputStream input = request.getInputStream();
    //Ϊ������ע�������
    input.setReadListener(new MyReadListener(input, context));

    out.println("�˳�Servlet��service()������ʱ�䣺"
               + new java.util.Date() + ".<br/><hr>");
    out.flush();
  }
}


