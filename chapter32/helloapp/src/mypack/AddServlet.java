package mypack;
import org.apache.velocity.Template;  
import org.apache.velocity.context.Context;  
import org.apache.velocity.tools.view.VelocityViewServlet;  
 
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class AddServlet extends VelocityViewServlet{
  
  public Template handleRequest(HttpServletRequest request, HttpServletResponse response,Context context){
    
    int a=11;	
    int b=22;
    int c=a+b;
    context.put("a",Integer.valueOf(a));
    context.put("b",Integer.valueOf(b));
    context.put("c",Integer.valueOf(c));
      
    return getTemplate("add.vm");
  }
}

/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
