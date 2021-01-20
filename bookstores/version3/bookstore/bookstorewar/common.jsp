<%@ page import="mypack.*" %>
<%@ page import="java.util.Properties" %>
<%@ page errorPage="errorpage.jsp" %>
<%@ page import="javax.naming.*" %>
<%!
    private BookDBEJB bookDB;

    public void jspInit() {

      bookDB =
          (BookDBEJB)getServletContext().getAttribute("bookDB");

      if (bookDB == null) {
        try {

          Properties pro = new Properties();
          pro.setProperty("java.naming.factory.initial","org.wildfly.naming.client.WildFlyInitialContextFactory");
          pro.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
          pro.setProperty("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
          Context context =new InitialContext(pro);
          bookDB=(BookDBEJB) context.lookup("ejb:bookstore/bookstore/bookdb!mypack.BookDBEJB");
          getServletContext().setAttribute("bookDB", bookDB);

        } catch (Exception ex) {
            System.out.println("Couldn't create database bean." + ex.getMessage());
        } 
      }
    }

   public void jspDestroy() {
      bookDB = null;
   }
%>
