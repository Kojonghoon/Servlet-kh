package com.pojo.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board3Logic {
    Logger    logger   = Logger.getLogger( Board3Logic.class );
    Board3Dao boardDao = new Board3Dao();
    
    public List<Map<String, Object>> boardList() {
        logger.info( "boardList호출" );
        List<Map<String, Object>> bList = null;
        bList=boardDao.boardList();
        return null;
    }
    
}
