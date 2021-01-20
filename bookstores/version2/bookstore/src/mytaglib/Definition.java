
package mytaglib;
import java.util.HashMap;

public class Definition {
   private HashMap<String,Parameter> params = new HashMap<String,Parameter>();

   public void setParam(Parameter p) {
      params.put(p.getName(), p);
   }
   public Parameter getParam(String name) {
      return params.get(name);
   }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
