package com.study.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/auth/*")
public class AuthFilter0 extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Hello AuthFilter0 Begin");
        MyRequest myRequest = new MyRequest(req);
        String email = req.getParameter("email");
        if (email != null && email.contains("yahoo.com.tw")) {
            myRequest.setParameter("email", email.split("@")[0]);
            chain.doFilter(myRequest, res);
        } else {
            res.sendRedirect("../forms/auth_login.html");
        }
        System.out.println("Hello AuthFilter0 End");
    }

}
