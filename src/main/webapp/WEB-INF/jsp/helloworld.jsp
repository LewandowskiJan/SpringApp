<jsp:useBean id="message" scope="request" type=""/>
<%--
  Created by IntelliJ IDEA.
  User: JL
  Date: 04.06.2018
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Hello World - Inpur Form</title>
</head>
<body>

Hello World of Spring!

<br><br>

Student name: ${param.studentName}
<br><br>

The message: ${message}


</body>
</html>
