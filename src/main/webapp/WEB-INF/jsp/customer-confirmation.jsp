<jsp:useBean id="customer" scope="request" type="soft.dev.academy.springmvc.entity.Customer"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JL
  Date: 07.06.2018
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free passes: ${customer.freePasses}

<br><br>

Postal Code: ${customer.postalCode}

<br><br>

Course Code: ${customer.courseCode}


</body>
</html>
