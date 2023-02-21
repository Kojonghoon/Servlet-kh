package com.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

// 서블릿은 java인데 브라우저에 출력할 수 있다 - 화면을 그리는데 서블릿을 사용함 - 가능해
// 서블릿을 경유하여 응답페이지를 jsp로 가져가는 실습니다.
// 최초 mimeHtmlResult.jsp 직접 호출하는 것이 아니라
// 23번에 있는 url 즉 /day1/html.do로 요청했을 떄 아패 코드 39번을 만나서 mimeHtmlResult.jsp
// 주소창이 변경되는 것을 관찰한 뒤 서블릿에서 세션에 담은 정보를 mimeHtmlResult.jsp페이지에서
// 유지되는지 확인하는 실습니다.
@WebServlet( "/day1/html.do" ) // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeHtmlServlet2 extends HttpServlet {
    Logger logger = Logger.getLogger( MimeHtmlServlet2.class );
    
    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        logger.info( "doGet호출" );
        // 요청객체로 세션객체를 생성함 - 요청객체가 있어야만 세션사용이 가능함
        // 시간을 연장할 수 있다.
        // 서블릿에서는 객체의 유지 정도가 다르다??? 다를 수 있다??? 진짜??
        // scope가 지원됨
        // page scope - 그 페이지 안에서만 기억해 준다 -쓰레기
        // request scope - 요청이 유지되는 동안에만 유지됨 -URL주소가 그대로 이면 유지 바뀌면 잃어버림
        // session scope - URL주소가 바뀌어도 유지됨 - 톰캣은 기본이 30분셋
        // application scope - 불사조 - 사용하면 안됨 - 서버가 다운되니까
        HttpSession session = req.getSession();
        String      myName  = new String( "이순신" );
        int         age     = 35;
        
        Map<String, Object> rmap = new HashMap<>();
        rmap.put( "mem_id", "kiwi" );
        rmap.put( "mem_pw", "222" );
        rmap.put( "mem_name", "키위" );
        
        List<Map<String, Object>> mList = new ArrayList<>();
        
        if ( rmap != null ) {
            rmap.clear();// 휴지통비우기
        }
        rmap = new HashMap<>();
        rmap.put( "mem_id", "tomato" );
        rmap.put( "mem_pw", "111" );
        rmap.put( "mem_name", "토마토" );
        mList.add( rmap );
        
        rmap = new HashMap<>();
        rmap.put( "mem_id", "kiwi" );
        rmap.put( "mem_pw", "222" );
        rmap.put( "mem_name", "키위" );
        mList.add( rmap );
        
        rmap = new HashMap<>();
        rmap.put( "mem_id", "banana" );
        rmap.put( "mem_pw", "111" );
        rmap.put( "mem_name", "바나나" );
        mList.add( rmap );
        
        session.setAttribute( "myName", myName );
        session.setAttribute( "age", age );
        session.setAttribute( "rmap", rmap );
        session.setAttribute( "mList", mList );
        res.sendRedirect( "./mimeHtmlResult.jsp" );
    }
}
