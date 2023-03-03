package com.pojo.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board2Logic {
    Logger    logger   = Logger.getLogger( Board2Logic.class );
    Board2Dao boardDao = new Board2Dao();
    public List<Map<String, Object>> boardList() {
        logger.info( "boardList호출" );
        List<Map<String, Object>> bList=new ArrayList<>();
        bList=boardDao.boardList();
        return bList;
    }
}
