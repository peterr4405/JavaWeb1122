package com.study.web.servlet.various;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/various/bmi")
public class BMIController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        double h = Double.parseDouble(req.getParameter("height"));
        double w = Double.parseDouble(req.getParameter("weight"));

        double bmi = calBMI(h, w);
        out.print(bmi);

    }

    private double calBMI(double h, double w) {

        double bmi = w / Math.pow(h / 100, 2);
        return bmi;
    }

}
