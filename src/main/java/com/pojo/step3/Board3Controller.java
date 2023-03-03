package com.pojo.step3;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Board3Controller implements Controller3 {
    Logger      logger     = Logger.getLogger( Board3Controller.class );
    Board3Logic boardLogic = new Board3Logic();
    
    @Override
    public ModelAndView boardList( HttpServletRequest req, HttpServletResponse res ) {
        logger.info( "boardList호출" );
        List<Map<String, Object>> bList = null;
        bList = boardLogic.boardList();
        return null;
    }
    
    @Override
    public Object boardDetail( HttpServletRequest req, HttpServletResponse res ) {
        logger.info( "boardDetail호출" );
        return null;
    }
    
    @Override
    public Object boardInsert( HttpServletRequest req, HttpServletResponse res ) {
        logger.info( "boardInsert호출" );
        return null;
    }
    
    @Override
    public Object boardUpdate( HttpServletRequest req, HttpServletResponse res ) {
        logger.info( "boardUpdate호출" );
        return null;
    }
    
    @Override
    public Object boardDelete( HttpServletRequest req, HttpServletResponse res ) {
        logger.info( "boardDelete호출" );
        return null;
    }
    
}
