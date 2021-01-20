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

    try{  //关闭MySQL的AbandonedConnectionCleanupThread
      com.mysql.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
    }catch(Exception e){e.printStackTrace();}

    try{
      Enumeration<Driver> drivers = DriverManager.getDrivers();
      while(drivers.hasMoreElements()) { //注销JDBC驱动程序
        DriverManager.deregisterDriver(drivers.nextElement());
      }
    }catch(Exception e){e.printStackTrace();}
  }
}





/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
