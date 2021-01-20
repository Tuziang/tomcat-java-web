package mypack;

import org.apache.velocity.Template;  
import org.apache.velocity.context.Context;  
import org.apache.velocity.tools.view.VelocityViewServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.util.*;
public class PropertiesServlet extends VelocityViewServlet{

  public Template handleRequest(HttpServletRequest request, HttpServletResponse response,Context context){
      Hashtable<String,String> client=new Hashtable<String,String>();
      client.put("firstname","Weiqin");
      client.put("lastname","Sun");
      client.put("phone","56781234");
      context.put("client",client);
      return getTemplate("properties.vm");
  }

}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
