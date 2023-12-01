<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<%! int a = 1; %>
<% if (a == 1) { %>
<p style="color: red">Red</p>
<% } else { %>
<p style="color: blue">Blue</p>
<% } %>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>