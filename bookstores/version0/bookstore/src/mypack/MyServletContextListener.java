package mypack;

import javax.servlet.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.servlet.annotation.*;

@WebListener
public class MyServletContextListener 
            implements ServletContextListener{
  public void contextDestroyed(ServletContextEvent sce){
    System.out.println("bookstore application is Destroyed.");

    try{  //�ر�MySQL��AbandonedConnectionCleanupThread
      com.mysql.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
    }catch(Exception e){e.printStackTrace();}

    try{
      Enumeration<Driver> drivers = DriverManager.getDrivers();
      while(drivers.hasMoreElements()) { //ע��JDBC��������
        DriverManager.deregisterDriver(drivers.nextElement());
      }
    }catch(Exception e){e.printStackTrace();}
  }
}





/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
