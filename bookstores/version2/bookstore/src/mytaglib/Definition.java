
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
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
