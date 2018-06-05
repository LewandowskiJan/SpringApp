<%--
  Created by IntelliJ IDEA.
  User: JL
  Date: 05.06.2018
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

<%--@elvariable id="student" type="java"--%>
<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>

    <input type="submit" value="Submit">

</form:form>

</body>
</html>
