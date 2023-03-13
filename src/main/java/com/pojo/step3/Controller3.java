package com.pojo.step3;
import java.io.IOException;

import javax.servlet.ServletException;
//javascript기반의 UI API
//바닐라 스크립트
//리액트 = 바닐라스크립트+ES6(주요이슈-spread, module, arrow),ES7 +html 섞어쓰기
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller3 {
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object imageGet( HttpServletRequest req, HttpServletResponse res );
	public Object imageUpload( HttpServletRequest req, HttpServletResponse res );
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
