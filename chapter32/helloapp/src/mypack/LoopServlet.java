package mypack;

import org.apache.velocity.Template;  
import org.apache.velocity.context.Context;  
import org.apache.velocity.tools.view.VelocityViewServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.util.*;

public class LoopServlet extends VelocityViewServlet{

 
  public Template handleRequest(HttpServletRequest request, HttpServletResponse response,Context context){
  
    
      Hashtable<String,Client> clientlist=new Hashtable<String,Client>();
      
      Client client=new Client();
      client.setFirstname("Xiaowen");
      client.setLastname("Li");
      client.setPhone("56781234");
      clientlist.put(client.getFirstname(),client);

      client=new Client();
      client.setFirstname("Xiaowei");
      client.setLastname("Cao");
      client.setPhone("56782345");
      clientlist.put(client.getFirstname(),client);

      client=new Client();
      client.setFirstname("Xiaojie");
      client.setLastname("Sun");
      client.setPhone("56783456");
      clientlist.put(client.getFirstname(),client);
      
      context.put("clientlist",clientlist);

      return getTemplate("loop.vm");
  }

}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
