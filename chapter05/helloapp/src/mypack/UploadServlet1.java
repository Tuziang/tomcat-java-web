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
 
//ʹ��@WebServlet����UploadServlet�ķ���·��
@WebServlet(name="UploadServlet1",urlPatterns="/upload1")
//ʹ��ע��@MultipartConfig��һ��Servlet��ʶΪ֧���ļ��ϴ�
@MultipartConfig//��ʶServlet֧���ļ��ϴ�

public class UploadServlet1 extends HttpServlet {
  public void doPost(HttpServletRequest request, 
              HttpServletResponse response)
              throws ServletException, IOException {
     response.setContentType("text/plain");
     //�����ļ���·��
     String savePath = request.getServletContext()
                              .getRealPath("/store");
     PrintWriter out = response.getWriter();

     //��ȡ���ı����ݣ���ŵ�parts������
     Collection<Part> parts = request.getParts();
     
     //�������ı������е�ÿ������
     for(Part part : parts) {//ѭ�������ϴ����ļ�
       String header = part.getHeader("content-disposition");
       //��Tomcat����������ʾÿ���Ӳ��ֵ���Ϣ  
       System.out.println("-----Part-----");
       System.out.println("type:"+part.getContentType());
       System.out.println("size:"+part.getSize());
       System.out.println("name:"+part.getName());
       System.out.println("header:"+header);
       
        //���Ϊ���е��ı���,����ʾ�ı�������ֺ�ȡֵ      
       if(part.getContentType()==null){
         String name=part.getName();
         String value=request.getParameter(name);
         out.println(name+": "+value+"\r\n");   
 
       }else if(part.getName().indexOf("file")!=-1){
         //���Ϊ���е�file1��file2�ļ��򣬾ͽ����ļ��ϴ�

         //��ȡ�ϴ��ļ���
         String fileName = getFileName(header); 
         //���ļ�д��ָ��·��
         part.write(savePath+File.separator+fileName);
         out.println(fileName +" is saved.");
         out.println("The size of "+fileName+" is "
                      +part.getSize()+" byte\r\n");  
       }
    }    
       
    out.close();
  }
   
  /* ��һ��Part������ͷ�л�ȡ�ļ��� */ 
  public String getFileName(String header) {

    //���һ��Part������ͷ������Ϊ��
    //form-data; name="file1"; filename="FromClient.rar"
    //��ô�����ļ���Ϊ��FromClient.rar��

    String fileName=header.substring(
                       header.lastIndexOf("=")+2,
                       header.length()-1); 

    return fileName;
  }
}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/

