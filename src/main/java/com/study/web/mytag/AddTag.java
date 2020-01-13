package com.study.web.mytag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class AddTag extends SimpleTagSupport implements DynamicAttributes{
    List<Integer> list = new ArrayList<>();

    @Override
    public void doTag() throws JspException, IOException {
        int sum = list.stream().mapToInt(o -> o).sum();
        this.getJspContext().getOut().print(sum);
        
    }
    
    
    
    @Override
    public void setDynamicAttribute(String string, String string1, Object o) throws JspException {
        list.add(Integer.parseInt(o+""));
    }
    
}
