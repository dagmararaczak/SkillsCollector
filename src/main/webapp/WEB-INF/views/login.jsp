
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>

<form action="/login" method="post">

    Nazwa uzytkownika: <input type="text" name="username"/> Haslo: <input type="password" name="password"/>  <input type="submit" value="Login"/>
</form>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
