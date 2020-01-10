package com.study.web.mytag;

import java.io.PrintWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class fib implements Tag {

    private PageContext pageContext;
    private Tag parent;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parent = tag;
    }

    @Override
    public Tag getParent() {
        return parent;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            //PrintWriter out = pageContext.getResponse().getWriter();
            JspWriter out = pageContext.getOut();
            out.println(count + ": " + fib(count));

        } catch (Exception e) {
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

    public int fib(int count) {
        if (count == 0) {
            return 0;
        }
        if (count == 1 || count == 2) {
            return 1;
        }
        return fib(count - 1) + fib(count - 2);
    }

}
