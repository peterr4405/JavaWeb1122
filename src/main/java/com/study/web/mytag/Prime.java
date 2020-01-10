package com.study.web.mytag;

import java.io.PrintWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class Prime implements Tag {

    private PageContext pageContext;
    private Tag parent;

    public boolean check(int n) {

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
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
            PrintWriter out = pageContext.getResponse().getWriter();
            out.println("hello tag");
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

}
