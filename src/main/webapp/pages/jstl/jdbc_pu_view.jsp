<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="datasource.jspf"  %>

<sql:query dataSource="${mydb}" var="PU_VIEW">
    SELECT 
        ORDER_NUM, CUSTOMER_NAME, PRODUCT_ID, PRODUCT_NAME,
        PURCHASE_COST, RATE, QUANTITY, SUBTOTAL
    FROM PU_VIEW
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
                    <th onclick="sort('ORDER_NUM')">ORDER_NUM</th>
                    <th onclick="sort('CUSTOMER_NAME')">CUSTOMER_NAME</th>
                    <th onclick="sort('PRODUCT_ID')">PRODUCT_ID</th>
                    <th onclick="sort('PRODUCT_NAME')">PRODUCT_NAME</th>
                    <th onclick="sort('PURCHASE_COST')">PURCHASE_COST</th>
                    <th onclick="sort('RATE')">RATE</th>
                    <th onclick="sort('QUANTITY')">QUANTITY</th>
                    <th onclick="sort('SUBTOTAL')">SUBTOTAL</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${PU_VIEW.rows}" var="p" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${p.ORDER_NUM}</td>
                        <td>${p.CUSTOMER_NAME}</td>
                        <td>${p.PRODUCT_ID}</td>
                        <td>${p.PRODUCT_NAME}</td>
                        <td>${p.PURCHASE_COST}</td>
                        <td>${p.RATE}</td>
                        <td>${p.QUANTITY}</td>
                        <td>${p.SUBTOTAL}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
