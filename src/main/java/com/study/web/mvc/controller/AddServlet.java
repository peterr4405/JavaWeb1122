package com.study.web.mvc.controller;

import com.study.web.mvc.model.Cal;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/mvc/add")
public class AddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        
        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));
        Cal cal = new Cal();
        
        int result = cal.cal(x, y);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/add.jsp");
        req.setAttribute("x", x);
        req.setAttribute("y", y);
        req.setAttribute("result", result);
        
        rd.forward(req, resp);
        
    }
    
    
    
}
