import java.net.*;
import java.io.*;
import java.util.*;

public class TomcatManager {
  public static void main(String args[]){
    Socket socket=null;
    String host="localhost";
    int port=8005;
    
    try{
      socket=new Socket(host,port); //��Tomcat����FTP����
    }catch(Exception e){e.printStackTrace();}
  
    try{
      String command="SHUTDOWN";
      /*����HTTP����*/
      OutputStream socketOut=socket.getOutputStream();//��������  
      socketOut.write(command.getBytes());
    
      Thread.sleep(2000); //˯��2��
    
      System.out.println("�Ѿ�����SHUTDOWN����"); 
      
    }catch(Exception e){ 
      e.printStackTrace();
    }finally{
      try{
        socket.close();  
      }catch(Exception e){e.printStackTrace();}
    }
  } 
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
