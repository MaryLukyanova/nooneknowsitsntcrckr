<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stones</title>
    <link href="<c:url value="/css/jquery.dataTables.min.css"/>" rel="stylesheet">
    <style>
        .layer1 {
            padding: 5px; /* Поля вокруг текста */
            float: left; /* Обтекание по правому краю */
            width: 45%; /* Ширина слоя */
        }
        .layer2 {
            padding: 5px; /* Поля вокруг текста */
            width: 45%; /* Ширина слоя */
            float: left; /* Обтекание по правому краю */
        }
        .clear {
            clear: left; /* Отмена обтекания */
        }
    </style>
</head>
<body>
<div class="layer1">
    <table id="gems" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Gems</th>
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
        <c:forEach items="${gems}" var="gem">
            <tr>
                <form name="buttonAddForm" method="POST" action="stones">
                    <input type="hidden" name="command" value="addStone" />
                    <td>${gem.id}</td>
                    <td>${gem.name}</td>
                    <td>${gem.carat}</td>
                    <td><input type="submit" value="Add" /></td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="layer2">
    <table id="semiprecious" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Semiprecious</th>
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
        <c:forEach items="${semiprecious}" var="semipr">
            <tr>
                <td>${semipr.id}</td>
                <td>${semipr.name}</td>
                <td>${semipr.carat}</td>
                <td><input type="submit" value="add"><br/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="clear"></div>
<form action="wolcome.jsp">
    <input type="text" name="uname">
    <input type="submit" value="go"><br/>
</form>


<a href="test" target="_blank">Test Button</a>
<script src="<c:url value="/js/lib/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/js/lib/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/js/stones.js"/>"></script>
</body>
</html>