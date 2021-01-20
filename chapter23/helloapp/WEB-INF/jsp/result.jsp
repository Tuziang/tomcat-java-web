<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
  <head>
   <title>Spring MVC Sample</title>
  </head>

  <body>
    <h2>Submitted Student Information</h2>
    <table>
      <tr>
        <td>Name:</td>
        <td>${name}</td>
      </tr>
      <tr>
        <td>Age:</td>
        <td>${age}</td>
      </tr>
      <tr>
        <td>ID:</td>
        <td>${id}</td>
      </tr>
    </table>  
  </body>
</html>