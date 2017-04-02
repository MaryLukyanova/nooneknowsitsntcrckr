<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stones</title>
    <link href="<c:url value="//css/jquery.dataTables.min.css"/>" rel="stylesheet">
</head>
<body>
<table id="stones" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Name</th>
        <th>Carat</th>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <th>Name</th>
        <th>Carat</th>
    </tr>
    </tfoot>
    <tbody>
    <c:forEach items="${stones}" var="stone">
        <tr>
            <td>${stone.name}</td>
            <td>${stone.carat}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="test" target="_blank">Test Button</a>
<script src="<c:url value="//js/lib/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="//js/lib/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="//js/stones.js"/>"></script>
</body>
</html>