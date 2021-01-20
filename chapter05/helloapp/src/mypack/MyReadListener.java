package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyReadListener implements ReadListener{
  private ServletInputStream input;
  private AsyncContext context;
  private StringBuilder sb = new StringBuilder();


  public MyReadListener(ServletInputStream input , 
                        AsyncContext context){
    this.input = input;
    this.context = context;
  }

  public void onDataAvailable(){
    System.out.println("���ݿ��ã�");
    try{
      // ��ͣ5�룬ģ���ȡ������һ����ʱ������
      Thread.sleep(5000);
    
       int len = -1;
      byte[] buff = new byte[1024];

      //��ȡ�������Servlet�ύ������
      while (input.isReady() && (len = input.read(buff)) > 0){
        String data = new String(buff , 0 , len);
        sb.append(data);
      }
    }catch (Exception ex){ex.printStackTrace();}
  }

  public void onAllDataRead(){
    System.out.println("���ݶ�ȡ��ɣ�");
    System.out.println(sb);
    //����������Ϊrequest��Χ������
    context.getRequest().setAttribute("msg" , sb.toString());
    //�������ɷ��oOutputServlet���
    context.dispatch("/output");
  }

  public void onError(Throwable t){
    t.printStackTrace();  
  }
}