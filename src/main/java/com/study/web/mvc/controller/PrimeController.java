package com.study.web.mvc.controller;

import com.study.web.mvc.model.Prime;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/prime/*")
public class PrimeController extends HttpServlet {

    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/prime.jsp");
        String path = req.getPathInfo();
        Prime prime = new Prime();
        switch (path) {
            case "/input":
                rd.forward(req, resp);
                break;
            case "/calc":
                int n = Integer.parseInt(req.getParameter("number"));

                boolean result = prime.getResult(n);
                Map<Integer, Boolean> results = prime.getResults();

                req.setAttribute("result", result);
                req.setAttribute("n", n);
                req.setAttribute("results", results);

                rd.forward(req, resp);

                break;
            case "/del":
                int num = Integer.parseInt(req.getParameter("number"));
                prime.del(num);
                req.setAttribute("results",prime.getResults() );
                rd.forward(req, resp);
                break;
            default:
                resp.getWriter().println("path fail");
                break;

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);

    }

}
