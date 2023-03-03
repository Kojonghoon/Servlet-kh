package com.pojo.step2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Board2Controller implements Controller {
    Logger      logger     = Logger.getLogger( Board2Controller.class );
    Board2Logic boardLogic = new Board2Logic();
    @Override
    public String execute( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        logger.info( "execute 호출" );
        String upmu[]=(String[])req.getAttribute( "upmu" );
        String page = null;
        if("boardList".equals( upmu[1] )) {
            logger.info( "게시글 목록 보기" );
            List<Map<String,Object>> bList = null;
            bList=boardLogic.boardList();
            req.setAttribute( "bList", bList );
            page="forward:board2/boardList"; //->/board2/boardList.jsp
        }
        return page;
    }
}
