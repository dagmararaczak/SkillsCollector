<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>




<div>
    <p>Hej ${param.get("firstName")} ${param.get("lastName")} Dzisiaj jest ${LocalDateTime.now()}</p>
</div>

</html>
