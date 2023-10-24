<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>LandLord List</title>
</head>
<style>
    body, .container {
        text-align: center;
    }

    .avatar-img {
        max-width: 50px;
        max-height: 50px;
    }

    .pagination {
        margin-top: 20px;
    }

    table {
        margin-left: 21%;
    }

    th, td {
        border: 1px solid black;
        text-align: center;
        vertical-align: middle;
    }

    th {
        font-size: 24px;
    }
</style>
<body>
<h1>List Landlord</h1>
<div class="container">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Id User</th>
                <th>Avatar</th>
                <th>Full Name</th>
                <th>Phone</th>
                <th>Revenue</th>
                <th>Number of House for Rent</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="landlord" items="${landLordList}">
                <tr>
                    <td>${landlord.id}</td>
                    <td><img src="${landlord.avatar}" alt="Avatar of User" class="avatar-img"></td>
                    <td>${landlord.fullName}</td>
                    <td>${landlord.phone}</td>
                    <td>${landlord.revenue}</td>
                    <td>${landlord.numberHouseForRent}</td>
                    <td>${landlord.status}</td>
                    <td>
                        <c:choose>
                            <c:when test="${landlord.status eq 'Đang hoạt động'}">
                                <a href="lock?id=${landlord.id}">Khóa</a>
                            </c:when>
                            <c:when test="${landlord.status eq 'Khóa'}">
                                <a href="unlock?id=${landlord.id}">Mở khóa</a>
                            </c:when>
                            <c:when test="${landlord.status eq 'Đang chờ'}">
                                <a href="approve?id=${landlord.id}">Duyệt</a>
                                <a href="reject?id=${landlord.id}">Từ chối</a>
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="pagination">
        <c:forEach var="i" begin="1" end="${totalPages}">
            <c:choose>
                <c:when test="${i eq currentPage}">
                    <span class="current-page">${i}</span>
                </c:when>
                <c:otherwise>
                    <a href="landlordlist?page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</div>

</body>
</html>
