package com.pojo.step1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//SELECT empno, ename, job, hiredate FROM emp
import org.apache.log4j.Logger;

public class EmpController implements Action {
    Logger logger = Logger.getLogger( DeptController.class );
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        
        return null;
    }
    
}
