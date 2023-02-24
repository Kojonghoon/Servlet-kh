package com.pojo.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//개발자가 정의한 서블릿 - 표준 서블릿이 아니다
//doService메소드는 요청처리에 대한 창구를일원화 하기 위해 개발장가 정의한 메소드 임
//따라서 request객체와 response객체를 톰캣서버로부터 주입 받을 수 없다.
//이 문제 해겨을 위해서 메소드 파라미터 자리를 이용하여 doGet이나 doPost메소드에서 주입받은
//request객체와 response객체를 넘겨 받아서 사용함
public class FrontMVC1 extends HttpServlet {
    Logger logger = Logger.getLogger( FrontMVC1.class );
    /*
     * 이 메소드는 톰캣 서버로 부터 직접 요청객체와 응답객체를 주입 받을 수 없다
     * 따라서 doGet메소드와 doPost메소드 안에서 doService메소드 호출할 떄 파라미터로 넘겨받음 
     */
    protected void doService( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        logger.info( "doService 호출" );
        String uri = req.getRequestURI();//주소창에 입력된 값 중 도메인과 포트번호가 제외된 값만 담음
        String        context = req.getContextPath();  // "/"->server.xml
        logger.info( uri ); // /dept/getDeptList.st1
        //http://localhost:9000/dept/getDeptList.st1
        //http://localhost:9000/업무명폴더명/getDeptList.st1
        //http://localhost:9000/member/getDeptList.st1
        //http://localhost:9000/board/getDeptList.st1
        //http://localhost:9000/board/boardInsert.st1
        //http://localhost:9000/board/boardUpdate.st1
        //http://localhost:9000/board/boardDelete.st1
        String command = uri.substring(context.length()+1);//context정보만 제외된 나머지 경로정보담음
        System.out.println( command );  //dept/getDeptList.st1
        int end = command.lastIndexOf( "." );   // 16 - st1잘라내기 위해 사용
        System.out.println( end );//16
        command = command.substring( 0,end );
        System.out.println( command );  // dept/getDeptList
        String upmu[]=null; // upmu[0] = 업무명|폴더명, upmu[1] = 요청기능이름
        upmu=command.split( "/" );  //dept, getDeptList
        for(String imsi:upmu) {
            System.out.println( imsi );
        }
        ActionForward af      = null;
        //게으른 인스턴스화
        //아직 결정 되지 않았다. - 업무명이 Controller 클래스의 접두어 이다.
        DeptController deptController = null;
        EmpController empController=null;
        //request객체는 저장소이다. - setAttribute, getAttribute
        //아래 코드는 request저장소에 upmu배열의 주소번지 원본을 저장하는 구문
        req.setAttribute( "upmu", upmu );
        if("dept".equals(upmu[0])) {
            //인스턴스화->execute() 호출하려고 -> 안하면 NullPointerException이니까 -> 500번
            deptController = new DeptController();
            //왜 DeptController는 req와 res를 주입 받을 수 없나요? - 서블릿이 아니라서
            //그래서 파라미터로 doGet메소드가 주입받은 req와 res주소번지 원본을 넘겨줌
            //이렇게 넘기지 않으면 DeptController에서는 req와 res를 누릴 수 없다.
            //이런 이유로(서블릿이 아니라서) 메소드를 하나만 가질 수 있다. - 장애
            //다른 메소드를 정의하는 것은 자유이지만 req와 res는 주입 받을 수 없다.
            //입력, 수정, 삭제, 조회 4가지 메소드가 필요함
            //DeptLogic메소드 4가지를 호출해야 하는데 upmu[1]방에 정보가 필요함
            af = deptController.execute( req, res );
        }
        else if("emp".equals(upmu[0])) {
            //인스턴스화
            empController = new EmpController();
            af = empController.execute( req, res );
            //
        }
        // 페이지 이동처리 공통 코드 만듦
        // 1. res.sendRedirect("/dept/getDeptList.jsp"); // jsp->서블릿->jsp
        // or res.sendRedirect("/dept/getDeptList.st1"); // jsp->서블릿->서블릿->jsp
        if ( af != null ) {
            if ( af.isRedirect() ) {
                res.sendRedirect( af.getPath() );
            }
            else {
                RequestDispatcher view = req.getRequestDispatcher( af.getPath() );
                view.forward( req, res );
            }
        }
    }// end of 페이지 이동처리에 대한 공통 코드 부분
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        logger.info( "doGet 호출" ); // 브라우저의 주소창을 통해 요청하는건 모두 get방식이다. - doGet()호출
        doService( req, res );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        logger.info( "doPost 호출" );
        doService( req, res );
    }
}
