<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Product</title>

    <style>
        tr:first-child {
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>Edit product</h2>
<form:form method="post" modelAttribute="productModel" action="/products-web/save">
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name" id="name" /></td>
        </tr>
        <tr>
            <td>Product type</td>
            <td><form:input path="type" id="type" /></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><form:input path="quantity" id="quantity" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update Product"/></td>
        </tr>
        <form:hidden path="id" id="id" />
    </table>
</form:form>




</body>
</html>