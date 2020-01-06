package com.study.web.filter;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {

    private PrintWriter out;
    private CharArrayWriter bufferedwriter;

    public MyResponse(HttpServletResponse response) {
        super(response);
        bufferedwriter = new CharArrayWriter();
        out = new PrintWriter(bufferedwriter);
    }

    @Override
    public PrintWriter getWriter() {
        return out;
    }

    public String getHTMLString() {
        return bufferedwriter.toString();
    }

}
