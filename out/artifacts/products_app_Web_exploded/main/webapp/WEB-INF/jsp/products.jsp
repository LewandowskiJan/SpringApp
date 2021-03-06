<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product List</title>

    <style>
        tr:first-child {
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2><spring:message code="form.products.header.text" /></h2>

<form action="/products-web/list">
    <table>
        <tr>
            <td>Product name : <input name="productName" type="text" value=""></td>
        </tr>
        <tr>
            <td>Product type : <input name="productType" type="text" value=""></td>
        </tr>
        <tr>
            <td> <input type="submit" value="Search products"/></td>
        </tr>

    </table>
</form>
<table>
    <tr>
        <td>NAME</td>
        <td>quantity</td>
        <td>type</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.quantity}</td>
            <td>${product.type}</td>
            <td><a href="<c:url value='/products-web/edit/${product.id}' />">Edit</a></td>
            <td><a href="<c:url value='/products-web/delete/${product.id}' />">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/products-web/new' />">Add new product</a>
</body>
</html>