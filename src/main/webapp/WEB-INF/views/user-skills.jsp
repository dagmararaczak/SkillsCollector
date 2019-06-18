
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>User-Skills</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>

<jsp:include page="fragments/header.jsp"/>

<div class="jumbotron text-center" style="background-color: lightseagreen">
    <h1 style="font-family: cursive "> Umiejętności </h1>

</div>

<table class="table table-striped">

    <thead>
    <th>Lp.</th>
    <th>Umiejetnosci</th>
    <th>Stopien umiejetnosci</th>

    </thead>
    <tbody>

    <c:forEach items="${skills}" var="skill" varStatus="counter">
    <tr>
        <td>${counter.count}</td>
        <td>${skill.name}</td>
        <td>${skill.key}</td>
    </tr>

    </c:forEach>
    </tbody>



</table>


<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
