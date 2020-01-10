<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytld" prefix="my" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><my:prime num="${param.num}"/></h1>
        <h1><my:fib count="${param.count}"/></h1>
        <h1><my:Lucky n="${param.n}">
                恭喜中獎!!
        </my:Lucky>
        </h1>
    </body>
</html>
