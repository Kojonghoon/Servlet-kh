package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿은 java인데 브라우저에 출력할 수 있다 - 화면을 그리는데 서블릿을 사용함 - 가능해
@WebServlet( "/xml.do" ) // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeXMLServlet extends HttpServlet {
    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        res.setContentType( "text/xml;charset=UTF-8" );
        // 메소드를 통해서 객체 생성하는 코드 - 고급
        PrintWriter   out = res.getWriter();
        StringBuilder sb  = new StringBuilder();
        sb.append( "<records>" );
        sb.append( "<record>" );
        sb.append( "<mem_id>tomato</mem_id>" );
        sb.append( "<mem_pw>111</mem_pw>" );
        sb.append( "<mem_name>토마토</mem_name>" );
        sb.append( "</record>" );
        sb.append( "<record>" );
        sb.append( "<mem_id>kiwi</mem_id>" );
        sb.append( "<mem_pw>222</mem_pw>" );
        sb.append( "<mem_name>키위</mem_name>" );
        sb.append( "</record>" );
        sb.append( "<record>" );
        sb.append( "<mem_id>banana</mem_id>" );
        sb.append( "<mem_pw>333</mem_pw>" );
        sb.append( "<mem_name>바나나</mem_name>" );
        sb.append( "</record>" );
        sb.append( "</records>" );
        out.print( sb.toString() );
    }
}
