package com.pojo.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ViewResolver {
    Logger logger = Logger.getLogger(ViewResolver.class);
    public ViewResolver(HttpServletRequest req, HttpServletResponse res, String[] pageMove)
    throws ServletException, IOException
    {
        String path = pageMove[1];
        //webapp바라본다.
        if("redirect".equals(pageMove[0])) {
            res.sendRedirect(path);
        }
        else if("forward".equals(pageMove[0])) {
            RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");
            view.forward(req, res);
        }
        //setViewName(~~~~~);
        //WEB-INF/views/(~~~~~).jsp
        else {
            logger.info("else");
            if(pageMove[0]!=null && pageMove[0].length()>0) {
            path = pageMove[0]+"/"+pageMove[1]; //""/member/cindex
            }else {
                path=pageMove[1];//member/cindex
            }
            RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/"+path+".jsp");
            view.forward(req, res);
        }
    }//end of ViewResolver(req,  res,  pageMove)
}//end of ViewResolver
