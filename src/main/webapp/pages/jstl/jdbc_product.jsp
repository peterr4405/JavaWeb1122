<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="datasource.jspf"  %>

<sql:query dataSource="${mydb}" var="product">
    SELECT p.PRODUCT_ID,p.PURCHASE_COST,p.QUANTITY_ON_HAND,(p.PURCHASE_COST*p.QUANTITY_ON_HAND)
    AS subtotal,p.DESCRIPTION
    FROM APP.PRODUCT p
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
                    <th onclick="sort('PRODUCT_ID')">PRODUCT_ID</th>
                    <th onclick="sort('PURCHASE_COST')">PURCHASE_COST</th>
                    <th onclick="sort('QUANTITY_ON_HAND')">QUANTITY_ON_HAND</th>
                    <th onclick="sort('subtotal')">subtotal</th>
                    <th onclick="sort('DESCRIPTION')">DESCRIPTION</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${product.rows}" var="p" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${p.PRODUCT_ID}</td>
                        <td>${p.PURCHASE_COST}</td>
                        <td>${p.QUANTITY_ON_HAND}</td>
                        <td>${p.subtotal}</td>
                        <td>${p.DESCRIPTION}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
