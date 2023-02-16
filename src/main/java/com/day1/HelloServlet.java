package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// form전송시 클라이언트측의 요청을 서블릿이 듣는다
// method = "get"이면 doGet호출
// post이면 doPost호출됨
// 자바가 서블릿이 되기 위한 조건은 반드시 HttpServlet을 상속받는 것이다.
// 상속을 받으면 doGet과 doPost 오버라이딩 할 수 있는데 
// 이 함수의 파라미터를 통해서 request요청 객체와 response 응답 객체를 주입 받는다.
// 톰캣 서버에서 주입 해줌
// 웹 서비스를 위해서는 URL등록이 필수 이다 - 왜냐면 브라우저가 실행 주체 이니까
// 프로젝트에 필요한 URL등록은 annotation과 web.xml문서를 통해서 가능하다
// annotation은 자동이고 편하기는 하지만 수동처리와 비교해서 추가 작업이 불가능한 단점이 있다
// xml문서를 통해서 객체 등록하고 주입 받는다.
// 이유는 spring 사용시 메이븐 레포를 이용한 프로젝트 생성인 경우에 xml문서로 환경 설정함
// 클래스 사이의 객체 주입관계도 xml문서로 처리 가능함
public class HelloServlet extends HttpServlet {
   Logger logger = Logger.getLogger(HelloServlet.class);
   
   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException 
   {
      System.out.println("doGet호출");
      logger.info("doGet 호출 성공");
      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();
      out.print("<font size=28px color=red>주의</font>");
   }
   
   @Override
   public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException 
   {
      System.out.println("doPost호출");
      logger.info("doPost 호출 성공");
   }
}