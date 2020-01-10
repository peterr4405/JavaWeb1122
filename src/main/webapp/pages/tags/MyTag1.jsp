<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://my.scwcd" prefix="My" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><My:greet user="peter" /></h1>
        <h1><My:greet/></h1>
        <My:loop count="5">
            <My:mark search="0">
            <%= new Date() %>
            </My:mark>
            <p/>
        </My:loop>
    </body>
</html>
