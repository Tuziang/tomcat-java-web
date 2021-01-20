package mypack;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyTask implements Runnable{
  private AsyncContext asyncContext;

  public MyTask(AsyncContext asyncContext){
    this.asyncContext = asyncContext;
  }

  public void run(){
    try{
      //˯��5�룬ģ��ܺ�ʱ��һ��ҵ�����
      Thread.sleep(5*1000);
      asyncContext.getResponse()
                  .getWriter()
                  .write("�����õ���!");   
      asyncContext.complete();
    }catch(Exception e){e.printStackTrace();}
  }
}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/

