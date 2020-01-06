package com.study.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LottoServlet extends GenericServlet {
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        Set<Integer> lottos = new HashSet<>();
        
        while (lottos.size() < 6) {
            int num = new Random().nextInt(49) + 1;
            lottos.add(num);
        }
        PrintWriter out = res.getWriter();
        out.print(lottos);
    }
    
}
