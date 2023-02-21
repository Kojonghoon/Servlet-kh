package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc.dao.TestDao;

public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Logger                    logger           = Logger.getLogger( TestServlet.class );
    
    public void doService( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        logger.fatal( "doService 호출" );
        logger.debug( "doService 호출" );
        logger.info( "doService 호출" );
        logger.warn( "doService 호출" );
        logger.error( "doService 호출" );
        TestDao                   tDao  = new TestDao();
        List<Map<String, Object>> mList = tDao.getBookMember();
        // 페이지 이동
        // 페이지 이름 getMemberList.jsp
        // 페이지의 물리적인 경로는 어디를 바라보고 있는가? ->web.xml->Servlet-mapping[/test/test.do]
        // ->url-pattern
        // 경로명/요청을 처리하는 이름.do[뒤에 온 확장자는 의미없다-why? 해당 요철을 인터셉트해서 해당 업무를 담당하는
        // 클래스에 연결(FrontController.java설계-각 업무별 XXXController필요함)을 해야함]
        // 페이지 처리는 JSP에 맡김
        // 서블릿은 요철을 받아서 업무 담당자에게 연결(매핑,매칭)
        // 이것을 어떻게 나눌것인가?
        // 요청을 업무 담당자나 사용자 선택에 따라 결정됨
        // 결정에 대응하는 클래스는 FrontController연결
        // FrontController에서 실제 업무를 담당하는 XXXController에 전달할 때
        // 요청 객체와 응답객체 또한 전달이 되어야한다.
        // 요청객체 무엇을 누릴 수 있나?
        // 1. 사용자가 입력한 값을 듣기 위해 필요하다
        // 2. getSession
        // request.getParameter(""):String
        // request.getAttribute(""):Object
        // request.getParameter("xxx"); mem_id, mem_name, mem_address
        // HttpSession session = request.getSesstion(); // 세션객체 생성
        // http 프로토콜이 비상태 프로토콜 이므로 상태값을 관리하는 별도의 메카니즘 필요
        // 쿠키와 세션(시간을 지배한다-신) <-list,map<-객체배멸<-배열<-원시형타입(변수)
        // response
        // response.setContentType(); 마입타입을 결정한다
        // 서블릿인데 json, 서블릿인데 html, 서블릿인데 XML
        // response.setContentType("application/java");
        // response.setContentType("text/html");
        // response.setContentType("text/xml");
        // response.setContentType("text/css");
        // response.redirection("페이지이름"); ->페이지 이동
        // 주소창이 바뀐다 -> 기존에 요청이 끊어지고 새로운 요청이 발샐함
        // 그런데 마치 계속 유지하고 있ㄴ느 것처럼 보여져야함 -> 그러니까 쿠키나 세션에 담아둔다 ->왜냐하면 비상태 프로토콜
        // 쿠키는-문자열 - 객체는 못받음
        // 세션 - 캐시메모리 - 객체 - very good
        // http://localhost:9000/test/test.do
        // 를 보여주다가 아래 무나를 만나면 그떄 http://localhost:9000/test/test/getMemberList.jsp를 요청함
        res.sendRedirect( "./getMemberList.jsp" );
        // String cTime = tDao.testDate();
        // logger.info("today : " + cTime);
    }
    
    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        doService( req, res );
    }
    
    @Override
    public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        doService( req, res );
        
    }
}
