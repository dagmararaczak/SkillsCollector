
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="fragments/header.jsp"/>

<div class="jumbotron text-center" style="background-color: lightseagreen">
    <h1 style="font-family: cursive "> Logowanie </h1>
</div>
<form action="/login" method="post">

    <div class="container">

        <div class="form-group" >
            <label ><strong>&nbsp;&nbsp;Nazwa użytkownika</strong></label>
            <input type="text" name="username" placeholder="username" class="form-control">
        </div>
        <div class="form-group" >
            <label ><strong>&nbsp;Hasło</strong></label>
            <input type="password" name="password" placeholder="password" class="form-control">
        </div>
        <input aria-setsize="20px" class="btn" style="background-color: teal" type="submit" value="Login"/>

    </div>
</form>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
