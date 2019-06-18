
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Zrodla wiedzy</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="fragments/header.jsp"/>

<div class="jumbotron text-center" style="background-color: lightseagreen">
    <h1 style="font-family: cursive "> Znane źródła wiedzy </h1>

</div>

    <table class="table table-striped">

    <thead>
    <th>Lp.</th>
    <th>Zrodla wiedzy</th>
    <th>Opis zrodla</th>

    </thead>
    <tbody>
   <c:forEach items="${sources}" var="source" varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td>${source.name}</td>
            <td>${source.description}</td>
        </tr>

    </c:forEach>
    </tbody>



</table>
</form>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>

<jsp:include page="fragments/footer.jsp"/>
</body>

</html>
