<%@ page import ="java.io.*,java.util.*"%>
<!Doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hello World!</title>
</head>
     <body>
                 <h1>Hello, World!</h1>
                 <jsp:useBean id="date" class="java.util.Date"/>
                 <p> <%=date%>

                 <%-- <jsp:useBean id="user" class="com.models.user"/> --%>
                 <%-- <h1>name : <%=user.name%></h1> --%>
                 <%-- name: <jsp:getProperty name="user" property="getFirstname"/> --%>
        </body>
    </html>