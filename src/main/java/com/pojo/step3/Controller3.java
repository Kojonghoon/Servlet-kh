package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller3 {
    public Object boardList( HttpServletRequest req, HttpServletResponse res );
    
    public Object boardDetail( HttpServletRequest req, HttpServletResponse res );
    
    public Object boardInsert( HttpServletRequest req, HttpServletResponse res );
    
    public Object boardUpdate( HttpServletRequest req, HttpServletResponse res );
    
    public Object boardDelete( HttpServletRequest req, HttpServletResponse res );
    
}
