<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post">
        <input type="hidden" name="userName" value="${product.userName}">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}'/>"/>
            </c:if>
            <tr>
                <th>Username:</th>
                <td>
                    <p><c:out value='${product.userName}'/></p>
                </td>
            </tr>
            <tr>
                <th>Ảnh:</th>
                <td>
                    <input type="text" name="url_image" size="45"
                           value="<c:out value='${product.url_image}'/>" pattern="^[a-zA-Z0-9]+$"/>
                </td>
            </tr>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="full_name" size="15"
                           value="<c:out value='${product.full_name}' />" pattern="^[a-zA-Z0-9]+$" required/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${product.address}' />" pattern="^[a-zA-Z0-9]+$"/>
                </td>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="phone" size="15"
                           value="<c:out value='${product.phone}' />"pattern="^[a-zA-Z0-9]+$" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
