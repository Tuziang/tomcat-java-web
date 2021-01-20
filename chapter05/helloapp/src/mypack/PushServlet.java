package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/push")
public class PushServlet extends HttpServlet{

  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response)

                       throws ServletException,IOException{

    response.setContentType("text/html;charset=GBK");
    PrintWriter pw = response.getWriter();

    PushBuilder pb = request.newPushBuilder();
    if(pb != null) {
      pb.path("images/javacover.jpg");
      pb.push();
      pw.println("<html>");
      pw.println("<body>");
      pw.println("<p>以下图片来自于服务器端推送</p>");
      pw.println("<img src=\"" + request.getContextPath() 
                          + "/images/javacover.jpg\"/>");
      pw.println("</body>");
      pw.println("</html>");
      pw.flush();
    }else{
      pw.println("<html>");
      pw.println("<body>");
      pw.println("<p>当前HTTP协议不支持服务器端推送</p>");
      pw.println("</body>");
      pw.println("</html>");
    }
  }  

}