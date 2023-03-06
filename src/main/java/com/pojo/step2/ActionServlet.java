package com.pojo.step2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Logger                    logger           = Logger.getLogger( ActionServlet.class );
    
    protected void doService( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        logger.info( "doService 호출" );
        String uri = req.getRequestURI();
        logger.info( uri );//
        String context = req.getContextPath();
        logger.info( context );//
        String command = uri.substring( context.length() + 1 );
        int    end     = command.lastIndexOf( "." );// 16 -st1잘라내기 위해 사용
        command = command.substring( 0, end );// dept/getDeptList
        String upmu[] = null;
        upmu = command.split( "/" );
        //test http://localhost:9000/board/getBoardList.st2
        logger.info( upmu[0] + "," + upmu[1] );
        req.setAttribute( "upmu", upmu );
        Board2Controller boardController = new Board2Controller();
        Object           obj             = "";
        obj = boardController.execute( req, res );
        
        if ( obj != null ) {
            String pageMove[] = null;
            if ( obj instanceof String ) {
                logger.info( "나는 obj" +obj );
                if ( ( ( String ) obj ).contains( ":" ) ) {
                    logger.info( ":포함되어 있어요." );
                    pageMove = obj.toString().split( ":" );
                }else {
                    logger.info( ":포함되어 있지 않아요." );
                    pageMove = obj.toString().split( "/" );
                }
                logger.info( pageMove[0] + "," + pageMove[1] );
            }
            if ( pageMove != null ) {
                // pageMove[0]=redirect or forward
                // pageMove[1]=XXX.jsp
                String path = pageMove[1];
                if ( "redirect".equals( pageMove[0] ) ) {
                    res.sendRedirect( path );
                }else if ( "forward".equals( pageMove[0] ) ) {
                    RequestDispatcher view = req.getRequestDispatcher( "/" + path + ".jsp" );
                    view.forward( req, res );
                }else {
                    path = pageMove[0] + "/" + pageMove[1];
                    RequestDispatcher view = req.getRequestDispatcher( "/WEB-INF/view/" + path + ".jsp" );
                    view.forward( req, res );
                }
            }
        }// end of 페이지 이동처리에 대한 공통 코드 부분
    }
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        logger.info( "doGet 호출" ); // 브라우저의 주소창을 통해 요청하는건 모두 get방식이다. - doGet()호출
        doService( req, resp );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        logger.info( "doPost 호출" );
        doService( req, resp );
    }
}