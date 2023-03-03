package com.pojo.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board3Dao {
    Logger logger = Logger.getLogger( Board3Dao.class );

    public List<Map<String, Object>> boardList() {
        logger.info( "boardList호출" );
        return null;
    }
}
