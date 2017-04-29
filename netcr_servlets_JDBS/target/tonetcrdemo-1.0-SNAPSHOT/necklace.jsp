<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Necklace</title>
    <link href="<c:url value="/css/jquery.dataTables.min.css"/>" rel="stylesheet">
</head>
<body>
    <table id="necklace" class="display" cellspacing="0" width="70%">
        <thead>
        <th1>Necklace</th1>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Carat</th>
            <th>Price</th>
        </tr>
        </thead>

        <tfoot>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Carat</th>
            <th>Price</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${necklace}" var="neckl">
            <tr>
                <td>${neckl.id}</td>
                <td>${neckl.name}</td>
                <td>${neckl.carat}</td>
                <td>${neckl.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<form name="caratSortForm" method="POST" action="stones">
    <input type="hidden" name="command" value="sortByCarat" />
    <input type="submit" value="Sort By Carat"><br/>
</form>
<form name="priceSortForm" method="POST" action="stones">
    <input type="hidden" name="command" value="sortByPrice" />
    <input type="submit" value="Sort By Price"><br/>
</form>
<form name="necklCaratForm" method="POST" action="stones">
    <input type="hidden" name="command" value="getNecklCarat" />
    <tr>
        <td><input type="submit" value="Carat SUM"></td>
        <td>${caratSum}</td>
    </tr>
</form>
<form name="necklPriceForm" method="POST" action="stones">
    <input type="hidden" name="command" value="getNecklPrice" />
    <tr>
        <td><input type="submit" value="Price SUM"></td>
        <td>${priceSum}</td>
    </tr>
</form>
<form name="rangeForm" method="POST" action="stones">
    <input type="hidden" name="command" value="findStonesInRange" />
    Find in a range of carat:<br/>
    <input type="submit" value="Find"/>
    A:
    <input type="number" name="a" value=""/>
    B:
    <input type="number" name="b" value=""/>
    <br/>
    ${invalidNumbers}
</form>

    <table id="rangeStonesTable" class="display" cellspacing="0" width="70%">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Carat</th>
            <th>Price</th>
        </tr>
        </thead>

        <tfoot>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Carat</th>
            <th>Price</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${rangeStones}" var="stone">
            <tr>
                <td>${stone.id}</td>
                <td>${stone.name}</td>
                <td>${stone.carat}</td>
                <td>${stone.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


<script src="<c:url value="/js/lib/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/js/lib/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/js/stones.js"/>"></script>
</body>
</html>