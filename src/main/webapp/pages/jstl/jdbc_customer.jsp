<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="datasource.jspf"  %>

<sql:query dataSource="${mydb}" var="customer">
    SELECT c.CUSTOMER_ID, c.DISCOUNT_CODE, c.NAME, c.PHONE, c.EMAIL, c.CREDIT_LIMIT 
    FROM CUSTOMER c
    ORDER BY ${sortcolname} ${sortflag}
</sql:query>
<html>
    <head>
        <%@include file="head.jspf" %>
    </head>
    <%@include file="menu.jspf"  %>
    <body>
        <table class="pure-table pure-table-bordered" width="100%">
            <thead>
                <tr style="cursor: help" title="按我一下可以排序" >
                    <th>#</th>
                    <th onclick="sort('CUSTOMER_ID')">CUSTOMER_ID</th>
                    <th onclick="sort('DISCOUNT_CODE')">DISCOUNT_CODE</th>
                    <th onclick="sort('NAME')">NAME</th>
                    <th onclick="sort('PHONE')">PHONE</th>
                    <th onclick="sort('EMAIL')">EMAIL</th>
                    <th onclick="sort('CREDIT_LIMIT')">CREDIT_LIMIT</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${customer.rows}" var="p" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${p.CUSTOMER_ID}</td>
                        <td>${p.DISCOUNT_CODE}</td>
                        <td>${p.NAME}</td>
                        <td>${p.PHONE}</td>
                        <td>${p.EMAIL}</td>
                        <td>${p.CREDIT_LIMIT}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
