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
  private final String LABEL_START="����Tomcat������";
  private final String LABEL_STOP="��ֹTomcat������";
  private int port=8080;
  private String baseDir = "C:/tomcat/webapps";

  JButton button;
  JLabel label;
  boolean isStart=false;
   
  public TomcatGUI(){
    button=new JButton(LABEL_START);
    label=new JLabel();

    //ע��һ������������
    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        if(!isStart){
          try{
            startTomcat();
            button.setText(LABEL_STOP);
            label.setText("Tomcat�������Ѿ�����");
            isStart=true;
          }catch(Exception e){ 
            label.setText("Tomcat����������ʧ��");
            e.printStackTrace();
          } 
        }else{
          try{
            stopTomcat();
            button.setText(LABEL_START);
            label.setText("Tomcat�������Ѿ���ֹ");
            isStart=false;
          }catch(Exception e){ 
            label.setText("�޷��ر�Tomcat������");
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
  }

  public void stopTomcat() throws LifecycleException {

    if(isStart){
      tomcat.stop();
   
      tomcat.destroy(); //����Tomcat������ռ�õ���Դ��ȷ�����ٰ�8080�˿�
    }
  }

  public static void main(String args[]){
    JFrame frame=new JFrame("Tomcat������");
    TomcatGUI gui=new TomcatGUI();
    frame.add(gui);
    
    frame.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent evt){
        try{
          gui.stopTomcat();  //��ֹ������
          System.exit(0); 
        }catch(Exception e){e.printStackTrace();} 
      }
    });

    frame.setSize(400,300);
    frame.setVisible(true);
  }
}
