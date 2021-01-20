<!--首先导入一些必要的packages-->
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!--设置中文输出-->
<%@ page contentType="text/html; charset=GB2312" %>

<html>
<head>
  <title>dbaccess3.jsp</title>
</head>
<body>
<%
try{
  Connection con;
  Statement stmt;
  ResultSet rs;

  //建立数据库连接
  Context ctx = new InitialContext();
  DataSource ds =(DataSource)ctx.lookup("java:comp/env/jdbc/BookDB");
  con = ds.getConnection();

  //创建一个SQL声明
  stmt=con.createStatement(
               ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
%>

<%@ include file="pages1.jsp" %> 

<%
  stmt.close();
  con.close();
}catch(Exception e){out.println(e.getMessage());}

%>
</body>
</html>
