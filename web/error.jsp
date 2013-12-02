<%@ page isErrorPage="true" language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
        <title>Erro</title>
    </head>
    <body>
        Ops, something happend! <br/>
        Error code: ${statusCode} <br/>
        The error type is: ${errorType.message}
        <br/>
    </body>
</html>