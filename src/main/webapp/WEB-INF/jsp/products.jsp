<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
</head>
<body>

<c:forEach items="${productList}" var="${product}">
    <div>
        <p>
            ${product.id},
        </p>
        <p>
                ${product.name},
        </p>
        <p>
                ${product.status},
        </p>
    </div>
</c:forEach>

</body>
</html>