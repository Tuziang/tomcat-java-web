package mypack;

import org.apache.velocity.Template;  
import org.apache.velocity.context.Context;  
import org.apache.velocity.tools.view.VelocityViewServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.util.*;

public class PropertiesServlet_1 extends VelocityViewServlet{

  public Template handleRequest(HttpServletRequest request, HttpServletResponse response,Context context){
  

      Client client=new Client();
      client.setFirstname("Weiqin");
      client.setLastname("Sun");
      client.setPhone("56781234");
      context.put("client",client);
      return getTemplate("properties.vm");

  }

}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
