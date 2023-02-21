package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import lombok.extern.log4j.Log4j2;

@SuppressWarnings( "serial" )
public class HelloServlet extends HttpServlet {
    Logger logger = Logger.getLogger( HelloServlet.class );
    
    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        logger.info( "doGet 호출 성공" );
        String mem_id = req.getParameter( "mem_id" );
        logger.info( "사용자가 입력한 아이디는 " + mem_id + "입니다." );
        res.setContentType( "text/html;charset=UTF-8" );
        // 인스턴스화에서 메서드를 사용하는 경우는 뭐가 다른걸까요 ?
        PrintWriter out = res.getWriter();
        String      msg = "안녕하세요";
        // 브라우저에서 요청 [get방식]시 d응답으로 나가는 문자열
        // 문자열(1.텍스트파일:숫자의 경우 문자로 변환 후 쓴다, 2. 바이너리파일:데이터를 있는 그대로 읽고 쓴다.)
        // text메인타입 html서브타입 - 브라우저 번역 - 태그는 ㅇ벗고 내용만 출력
        out.print( "<font size=36px color=violet>" + msg + "</font>" ); // 리소스
        // BookDao bDao = new BookDao();
        // logger.info(bDao.testDate());
    }
    // 단위테스트가 불가하다. - Postman 사용하면 가능하다
    // Post방식은 브라우저 통해서 테스트 불가함
    
    public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        logger.info( "doPost 호출 성공" );
        res.setContentType( "text/html;charset=UTF-8" );
        // 인스턴스화에서 메서드를 사용하는 경우는 뭐가 다른걸까요 ?A a = new A()
        PrintWriter out = res.getWriter();
        out.print( "<h3>doPost</h3>호출" );
    }
}

/*
 * [Web Service]
 * 웹 서비스 제공을 위한 언어
 * 
 * Request / Response
 * 요청을 어디에 하지?
 * 요청 방식에는 몇 가지가 있다?
 * 요청을 위해서는 무엇이 준비되어 있어야 하나요 ?
 * 
 * GET 방식
 * - 서버측의 RESOURCE(HTML, CSS, JS....)를 가져오기 위해서
 * - 쿼리스트링으로 전송(소용량)
 * - 노출
 * - 공유 -> 쿠팡 도메일 ? 상품아이디 = aaa1234
 * - 검색
 * 
 * 
 * 
 * Post방식
 * - 서버에 데이터를 올리기 위해 설계됨
 * - 전송 데이터 크기의 제한이 없음(대용량)
 * - 보안에 유리, 공유에는 불리
 * - 데이터 메시지의 body에 담아 전송함
 * - 글쓰기, 로그인, 회원가입
 * 
 * 
 * GET: 클라이언트가 서버에게 URL에 해당하는 자료의 전송을 요청한다.
 * HEAD: GET 요청으로 반환될 데이터 중 헤더 부분에 해당하는 데이터만 요청한다.
 * POST: 클라이언트가 서버에서 처리할 수 있는 자료를 보낸다. 예를 들어, 게시판에 글을 쓸 때 클라이언트의 문서가 서버로 전송되어야 한다. 멱등성을 보장하지 않는다.
 * PATCH: 클라이언트가 서버에게 지정한 URL의 데이터를 부분적으로 수정할 것을 요청한다.
 * PUT: 클라이언트가 서버에게 지정한 URL에 지정한 데이터를 저장할 것을 요청한다.
 * DELETE: 클라이언트가 서버에게 지정한 URL의 정보를 제거할 것을 요청한다.
 * TRACE: 클라이언트가 서버에게 송신한 요청의 내용을 반환해 줄 것을 요청한다.
 * CONNECT: 클라이언트가 특정 종류의 프록시 서버에게 연결을 요청한다.
 * OPTIONS: 해당 URL에서 지원하는 요청 메세지의 목록을 요청한다.
 * 
 */