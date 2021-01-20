package mypack;
 
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
//使用@WebServlet配置UploadServlet的访问路径
@WebServlet(name="UploadServlet1",urlPatterns="/upload1")
//使用注解@MultipartConfig将一个Servlet标识为支持文件上传
@MultipartConfig//标识Servlet支持文件上传

public class UploadServlet1 extends HttpServlet {
  public void doPost(HttpServletRequest request, 
              HttpServletResponse response)
              throws ServletException, IOException {
     response.setContentType("text/plain");
     //保存文件的路径
     String savePath = request.getServletContext()
                              .getRealPath("/store");
     PrintWriter out = response.getWriter();

     //获取正文表单数据，存放到parts集合中
     Collection<Part> parts = request.getParts();
     
     //处理正文表单数据中的每个部分
     for(Part part : parts) {//循环处理上传的文件
       String header = part.getHeader("content-disposition");
       //在Tomcat服务器端显示每个子部分的信息  
       System.out.println("-----Part-----");
       System.out.println("type:"+part.getContentType());
       System.out.println("size:"+part.getSize());
       System.out.println("name:"+part.getName());
       System.out.println("header:"+header);
       
        //如果为表单中的文本域,就显示文本域的名字和取值      
       if(part.getContentType()==null){
         String name=part.getName();
         String value=request.getParameter(name);
         out.println(name+": "+value+"\r\n");   
 
       }else if(part.getName().indexOf("file")!=-1){
         //如果为表单中的file1或file2文件域，就进行文件上传

         //获取上传文件名
         String fileName = getFileName(header); 
         //把文件写到指定路径
         part.write(savePath+File.separator+fileName);
         out.println(fileName +" is saved.");
         out.println("The size of "+fileName+" is "
                      +part.getSize()+" byte\r\n");  
       }
    }    
       
    out.close();
  }
   
  /* 从一个Part的请求头中获取文件名 */ 
  public String getFileName(String header) {

    //如果一个Part的请求头的内容为：
    //form-data; name="file1"; filename="FromClient.rar"
    //那么其中文件名为“FromClient.rar”

    String fileName=header.substring(
                       header.lastIndexOf("=")+2,
                       header.length()-1); 

    return fileName;
  }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/

