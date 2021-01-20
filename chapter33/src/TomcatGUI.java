import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.apache.catalina.LifecycleException;

import org.apache.catalina.core.StandardServer;

import org.apache.catalina.startup.Tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;

public class TomcatGUI extends JPanel {
  private Tomcat tomcat;
  private final String LABEL_START="启动Tomcat服务器";
  private final String LABEL_STOP="终止Tomcat服务器";
  private int port=8080;
  private String baseDir = "C:/tomcat/webapps";

  JButton button;
  JLabel label;
  boolean isStart=false;
   
  public TomcatGUI(){
    button=new JButton(LABEL_START);
    label=new JLabel();

    //注册一个匿名监听器
    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        if(!isStart){
          try{
            startTomcat();
            button.setText(LABEL_STOP);
            label.setText("Tomcat服务器已经启动");
            isStart=true;
          }catch(Exception e){ 
            label.setText("Tomcat服务器启动失败");
            e.printStackTrace();
          } 
        }else{
          try{
            stopTomcat();
            button.setText(LABEL_START);
            label.setText("Tomcat服务器已经终止");
            isStart=false;
          }catch(Exception e){ 
            label.setText("无法关闭Tomcat服务器");
            e.printStackTrace();
          }
        }
      }  
    });

    add(button);
    add(label);
  }

  public void startTomcat() throws LifecycleException {

    tomcat=new Tomcat(); 
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
  }

  public void stopTomcat() throws LifecycleException {

    if(isStart){
      tomcat.stop();
   
      tomcat.destroy(); //销毁Tomcat服务器占用的资源，确保不再绑定8080端口
    }
  }

  public static void main(String args[]){
    JFrame frame=new JFrame("Tomcat管理器");
    TomcatGUI gui=new TomcatGUI();
    frame.add(gui);
    
    frame.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent evt){
        try{
          gui.stopTomcat();  //终止服务器
          System.exit(0); 
        }catch(Exception e){e.printStackTrace();} 
      }
    });

    frame.setSize(400,300);
    frame.setVisible(true);
  }
}
