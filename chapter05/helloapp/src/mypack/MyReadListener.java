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
    System.out.println("数据可用！");
    try{
      // 暂停5秒，模拟读取数据是一个耗时操作。
      Thread.sleep(5000);
    
       int len = -1;
      byte[] buff = new byte[1024];

      //读取浏览器向Servlet提交的数据
      while (input.isReady() && (len = input.read(buff)) > 0){
        String data = new String(buff , 0 , len);
        sb.append(data);
      }
    }catch (Exception ex){ex.printStackTrace();}
  }

  public void onAllDataRead(){
    System.out.println("数据读取完成！");
    System.out.println(sb);
    //将数据设置为request范围的属性
    context.getRequest().setAttribute("msg" , sb.toString());
    //把请求派发給OutputServlet组件
    context.dispatch("/output");
  }

  public void onError(Throwable t){
    t.printStackTrace();  
  }
}