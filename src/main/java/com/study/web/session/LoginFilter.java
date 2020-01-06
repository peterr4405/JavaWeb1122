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
public class LoginFilter extends HttpFilter {

    private static Map<String, String> users;

    static {
        users = new LinkedHashMap<>();
        users.put("admin", "1234");
        users.put("peter", "1111");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = req.getSession();
        boolean pass = false;

        if (session.getAttribute("username") == null) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String remember = req.getParameter("remember");
            pass = check(username, password); // 登入驗證
            if (pass) { // 登入是否成功
                session.setAttribute("username", username); // 寫入 session 資料
                Cookie cookie_user, cookie_pass, cookie_remember;
                if (remember != null) {
                    cookie_user = new Cookie("username", username);
                    cookie_pass = new Cookie("password", password);
                    cookie_remember = new Cookie("remember", "checked");
                    cookie_user.setMaxAge(7 * 24 * 60 * 60);
                    cookie_pass.setMaxAge(7 * 24 * 60 * 60);
                    cookie_remember.setMaxAge(7 * 24 * 60 * 60);

                }else{
                    cookie_user = new Cookie("username", "");
                    cookie_pass = new Cookie("password", "");
                    cookie_remember = new Cookie("remember", "");
                }
                res.addCookie(cookie_user);
                res.addCookie(cookie_pass);
                res.addCookie(cookie_remember);
                
            }
        } else {
            // 此人已登入
            pass = true;
        }

        if (pass) {
            chain.doFilter(req, res); // 重導到下一頁
        } else {
            session.invalidate(); // session 失效
            req.setAttribute("message", "登入錯誤或請重新登入");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/session/login.jsp");
            rd.forward(req, res);
        }

    }

    private boolean check(String username, String password) {
        return users.get(username) != null && users.get(username).equals(password);
    }
}
