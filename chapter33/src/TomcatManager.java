import java.net.*;
import java.io.*;
import java.util.*;

public class TomcatManager {
  public static void main(String args[]){
    Socket socket=null;
    String host="localhost";
    int port=8005;
    
    try{
      socket=new Socket(host,port); //与Tomcat建立FTP连接
    }catch(Exception e){e.printStackTrace();}
  
    try{
      String command="SHUTDOWN";
      /*发送HTTP请求*/
      OutputStream socketOut=socket.getOutputStream();//获得输出流  
      socketOut.write(command.getBytes());
    
      Thread.sleep(2000); //睡眠2秒
    
      System.out.println("已经发送SHUTDOWN命令"); 
      
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
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
