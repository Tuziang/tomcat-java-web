import org.apache.catalina.LifecycleException;

import org.apache.catalina.core.StandardServer;

import org.apache.catalina.startup.Tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;

public class EmbeddedTomcat {
    
  private Tomcat tomcat;
    
  public void start(int port,String baseDir) throws LifecycleException {

    tomcat = new Tomcat();
       
   
    //���÷������Լ����������ĸ�·��
    tomcat.setBaseDir(".");
   
    tomcat.getHost().setAppBase(baseDir); 
    
    //���ü����˿�
    tomcat.setPort(port);
    
    //����������������û�����������ͻ��ȴ���һ��Ĭ�ϵ�������
    Connector connector=tomcat.getConnector();
       
    //����Ĭ�ϵ�webӦ��         
    Context context1=tomcat.addWebapp("", baseDir+"/ROOT");

    //����examplesӦ��
    Context context2=tomcat.addWebapp("/examples", baseDir+"/examples");

    //����docsӦ��
    Context context3=tomcat.addWebapp("/docs", baseDir+"/docs");
 
    tomcat.start();
  //����������  

   
   //��ֹ�������İ취һ�����̵߳���Tomcat���stop()����
   /*
    try{
      //���߳�˯��60*60���رշ�����
      Thread.sleep(60000*60);
      stop();  
    }catch(Exception e){e.printStackTrace();} 
   */

    //��ֹ�������İ취��������8005�˿ڵ�SHUTDOWN����

    StandardServer server = (StandardServer) tomcat.getServer();
   
    //���÷���������SHUTDOWN����Ķ˿�
    server.setPort(8005);
    server.await();  //���߳̽���ȴ�״̬��ֱ�����յ�SHUTDOWN����



  }
   

  public void stop() throws LifecycleException {
        
    tomcat.stop();
  //�ر�Tomcat������ 
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

