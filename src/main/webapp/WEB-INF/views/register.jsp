
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<head>
    <title>Rejestracja</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">


</head>
<body>
<jsp:include page="fragments/header.jsp"/>

<div class="jumbotron text-center" style="background-color: lightseagreen">
    <h1> Rejestracja </h1>
</div>

<form action="/register" method="post">

    <p><font color="red">${errorMessage}</font></p>
    <div class="form-group">
        <label ><strong>&nbsp;Nazwa uzytkownika</strong></label>
        <input type="text" name="username" value="${user.username}"  class="form-control">
    </div>


    <div class="form-group">
        <label ><strong>&nbsp;&nbsp;Imie</strong></label>
        <input type="text" name="firstName" value="${user.firstName}"  class="form-control">
    </div>

    <div class="form-group" >
        <label ><strong>&nbsp;&nbsp;Nazwisko</strong></label>
        <input type="text" name="lastName" value="${user.lastName}"  class="form-control">
    </div>

    <div class="form-group" >
        <label><strong>&nbsp;&nbsp;Haslo</strong></label>
        <input type="password" name="password" value="${user.password}"  class="form-control">
    </div>


    <input class="btn" style="background-color: teal" type="submit"value="Przeslij" >
    <input class="btn" style="background-color: crimson"  type="reset" value="Wyczysc">

</form>


<jsp:include page="fragments/footer.jsp"/>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>
</body>
</html>
