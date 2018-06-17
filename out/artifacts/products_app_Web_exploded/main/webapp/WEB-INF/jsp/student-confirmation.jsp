<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: JL
  Date: 06.06.2018
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br><br>

FavouritesLanguage: ${student.favouriteLanguage}

<br><br>

Operationg Systems:

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">

        <li> ${temp} </li>

    </c:forEach>
</ul>


</body>
</html>
