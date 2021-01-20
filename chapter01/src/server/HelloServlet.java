package server;
import java.io.*;
public class HelloServlet implements Servlet{
  public void init()throws Exception{
    System.out.println("HelloServlet is inited");
  }

  public void service(byte[] requestBuffer, 
                     OutputStream out)throws Exception{
    String request=new String(requestBuffer);

    //获得HTTP请求的第一行
    String firstLineOfRequest=
              request.substring(0,request.indexOf("\r\n"));
    //解析HTTP请求的第一行 
    String[] parts=firstLineOfRequest.split(" "); 
    String method=parts[0]; //获得HTTP请求中的请求方式
    String uri=parts[1]; //获得HTTP请求中的uri
    
                    
    /*获得请求参数username */
    String username=null;
    //如果请求方式为“GET”，则请求参数紧跟HTTP请求的第一行的uri的后面
    if(method.equalsIgnoreCase("get") 
       && uri.indexOf("username=")!=-1){
      
      /*假定uri="servlet/HelloServlet?username=Tom&password=1234"*/
      //parameters="username=Tom&password=1234"
      String parameters=
                uri.substring(uri.indexOf("?"),uri.length()); 
      
      //parts={"username=Tom","password=1234"};
      parts=parameters.split("&");
      //parts={"username","Tom"};
      parts=parts[0].split("=");
      username=parts[1];   
    } 
    //如果请求方式为“POST”，则请求参数位于HTTP请求的请求正文中。
    if(method.equalsIgnoreCase("post")){
      int locate=request.indexOf("\r\n\r\n");
      //获得响应正文 
      String content=request.substring(locate+4,request.length());
      if(content.indexOf("username=")!=-1){
        /*假定content="username=Tom&password=1234"*/
        //parts={"username=Tom","password=1234"};
        parts=content.split("&");
        //parts={"username","Tom"};
        parts=parts[0].split("=");
        username=parts[1];   
      } 
    } 
    
    /*创建并发送HTTP响应*/
    //发送HTTP响应第一行
    out.write("HTTP/1.1 200 OK\r\n".getBytes());
    //发送HTTP响应头
    out.write("Content-Type:text/html\r\n\r\n".getBytes());
    //发送HTTP响应正文
    String content="<html><head><title>HelloWorld"
                   +"</title></head><body>";
    content+="<h1>Hello:"+username+"</h1></body><head>";
    out.write(content.getBytes());
    
  }
}
