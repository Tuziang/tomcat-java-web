package mypack;
import java.util.*;

public class Tool {
  public static int add(String x, String y) {
    int a = 0;
    int b = 0;
    try {
      a = Integer.parseInt(x);
      b = Integer.parseInt(y);
    }catch(Exception e) {} 
 
    return a + b;
  }

  public static String convert(String str){
    try{
     	return str.toUpperCase();
    }catch(Exception e){return "";}
   }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
