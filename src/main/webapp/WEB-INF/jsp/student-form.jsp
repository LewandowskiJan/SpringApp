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

    Country:

    <form:select path="country">

        <form:options items="${student.countryOptions}"/>

    </form:select>

    <br><br>

    Favourite Language:
    
    Java <form:radiobutton path="favouriteLanguage" value="Java" />
    C# <form:radiobutton path="favouriteLanguage" value="C#" />
    PHP <form:radiobutton path="favouriteLanguage" value="PHP" />
    Ruby <form:radiobutton path="favouriteLanguage" value="Ruby" />

    <br><br>

    Operating Systems:

    Linux <form:checkbox path="operatingSystems" value="Linux" />
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
    MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />

    <br><br>
    
    <input type="submit" value="Submit">

</form:form>

</body>
</html>
