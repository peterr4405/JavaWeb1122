package com.study.web.session;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/session/*")
public class AuthCodeFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String code = req.getParameter("code");
        String authCode = session.getAttribute("authCode") + "";
        boolean authPass =Boolean.parseBoolean(session.getAttribute("authPass")+"");
        boolean pass = authPass || (code != null && code.equals(authCode) ? true : false);

        
        if (pass) {
            req.getSession().setAttribute("authPass", true);
            chain.doFilter(req, res);
        } else {
            session.invalidate(); // session 失效
            req.setAttribute("message", "驗證碼錯誤!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/session/login.jsp");
            rd.forward(req, res);
        }

    }
}
