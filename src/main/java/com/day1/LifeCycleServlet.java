package com.day1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

// GenericServlet(service())<-HttpServlet(doGet,doPost)
// WebServlet 어노테이션이 있는 서블잇은 커트롤 계층을 담당함
// 서블릿은 구조상 뷰계층을 담당하지 않는다.
@WebServlet( "/lifeCycle" )// spring @Controller[컨트롤계층] +@RequestMapping[URL패턴 정의]
public class LifeCycleServlet extends HttpServlet {
    Logger                    logger           = Logger.getLogger( LifeCycleServlet.class );
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void service( HttpServletRequest arg0, HttpServletResponse arg1 ) throws ServletException, IOException {
        // 입력, 처리, 출력을 담당함
        // 사용자의 요청을 받는 메소드
        logger.info( "service 호출" );
    }
    
    @Override
    public void destroy() {
        // 서블릿이 메모리에서 제거될 때 서블릿 컨테이너에 의해 자동 호출됨
        logger.info( "destroy 호출" );
    }
    
    @Override
    public void init() throws ServletException {
        // 서블릿이 초기화 될 떄 자동 호출되는 메소드
        // 서블릿의 초기호 작업 담당
        // 개발자가 호출하는 메소드 아님
        logger.info( "init 호출" );
    }
}
