<%--
  Created by IntelliJ IDEA.
  User: Czj_
  Date: 2023/3/24
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
<h1>Oops! Something went wrong.</h1>
<p>We are sorry, but an error has occurred while processing your request.</p>
<p>Please try again later or contact us for assistance if the problem persists.</p>
<hr>
<p>Error message: ${javax.servlet.error.message}</p>
<p>Error code: ${javax.servlet.error.status_code}</p>
<p>Error type: ${javax.servlet.error.exception_type}</p>
<p>Error stack trace: ${javax.servlet.error.exception}</p>
</body>
</html>
