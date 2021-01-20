import org.apache.catalina.LifecycleException;

import org.apache.catalina.core.StandardServer;

import org.apache.catalina.startup.Tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;

public class EmbeddedTomcat {
    
  private Tomcat tomcat;
    
  public void start(int port,String baseDir) throws LifecycleException {

    tomcat = new Tomcat();
       
   
    //设置服务器以及虚拟主机的根路径
    tomcat.setBaseDir(".");
   
    tomcat.getHost().setAppBase(baseDir); 
    
    //设置监听端口
    tomcat.setPort(port);
    
    //获得连接器，如果还没有连接器，就会先创建一个默认的连接器
    Connector connector=tomcat.getConnector();
       
    //加入默认的web应用         
    Context context1=tomcat.addWebapp("", baseDir+"/ROOT");

    //加入examples应用
    Context context2=tomcat.addWebapp("/examples", baseDir+"/examples");

    //加入docs应用
    Context context3=tomcat.addWebapp("/docs", baseDir+"/docs");
 
    tomcat.start();
  //启动服务器  

   
   //终止服务器的办法一：主线程调用Tomcat类的stop()方法
   /*
    try{
      //主线程睡眠60*60秒后关闭服务器
      Thread.sleep(60000*60);
      stop();  
    }catch(Exception e){e.printStackTrace();} 
   */

    //终止服务器的办法二：监听8005端口的SHUTDOWN命令

    StandardServer server = (StandardServer) tomcat.getServer();
   
    //设置服务器监听SHUTDOWN命令的端口
    server.setPort(8005);
    server.await();  //主线程进入等待状态，直到接收到SHUTDOWN命令



  }
   

  public void stop() throws LifecycleException {
        
    tomcat.stop();
  //关闭Tomcat服务器 
  } 
    

  public static void main(String[] args) {
        
    try{
            
      int port=8080;
           
      String baseDir = "C:/tomcat/webapps";
           
      EmbeddedTomcat tomcat = new EmbeddedTomcat();
           
      tomcat.start(port, baseDir);
           
    }catch (Exception e) {
e.printStackTrace();
 }
   
  } 

}

