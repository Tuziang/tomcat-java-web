package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

public class UploadServlet extends HttpServlet {
  private String filePath; //����ϴ��ļ���Ŀ¼
  private String tempFilePath; //�����ʱ�ļ���Ŀ¼

  public void init(ServletConfig config)throws ServletException {
    super.init(config);
    filePath=config.getInitParameter("filePath");
    tempFilePath=config.getInitParameter("tempFilePath");
    filePath=getServletContext().getRealPath(filePath);
    tempFilePath=getServletContext().getRealPath(tempFilePath);
  }
  public void doPost(HttpServletRequest request,
         HttpServletResponse response)
         throws ServletException, IOException {
    response.setContentType("text/plain");
    //��ͻ��˷�����Ӧ����
    PrintWriter out=response.getWriter(); 
    try{
      //����һ������Ӳ�̵�FileItem����
      DiskFileItemFactory factory = new DiskFileItemFactory();
      //������Ӳ��д����ʱ���õĻ������Ĵ�С���˴�Ϊ4K
      factory.setSizeThreshold(4*1024); 
      //������ʱĿ¼
      factory.setRepository(new File(tempFilePath));

      //����һ���ļ��ϴ�������
      ServletFileUpload upload = new ServletFileUpload(factory);
      //���������ϴ����ļ������ߴ磬�˴�Ϊ4M
      upload.setSizeMax(4*1024*1024); 
    
      List<FileItem> items = upload.parseRequest(request);    

      for(FileItem item:items){
        if(item.isFormField()) {
          processFormField(item,out); //������ͨ�ı���
        }else{
          processUploadedFile(item,out); //�����ϴ��ļ�
        }
      }
      out.close();
    }catch(Exception e){
       throw new ServletException(e);
    }
  }

  private void processFormField(FileItem item,PrintWriter out){
    String name = item.getFieldName();
    String value = item.getString();
    out.println(name+":"+value+"\r\n");
  }
  
  
  private void processUploadedFile(FileItem item,
               PrintWriter out)throws Exception{
    String filename=item.getName();
    int index=filename.lastIndexOf("\\");
    filename=filename.substring(index+1,filename.length());
    long fileSize=item.getSize();
    
    if(filename.equals("") && fileSize==0)return;

    File uploadedFile = new File(filePath+"/"+filename);
    item.write(uploadedFile);
    out.println(filename+" is saved.");
    out.println("The size of " +filename+" is "+fileSize+"\r\n");
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
