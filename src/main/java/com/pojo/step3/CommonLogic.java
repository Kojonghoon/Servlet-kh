package com.pojo.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

//@Service
public class CommonLogic {
    CommonDao commonDao = new CommonDao();
    Logger logger = Logger.getLogger( CommonLogic.class );
//    @Autowired
    public List<Map<String, Object>> zipcodeList( Map<String, Object> pMap ) {
        logger.info( "zipcodeList호출 : " + pMap );
        List<Map<String, Object>> zList = null;
        zList = commonDao.zipcodeList( pMap );
        return zList;
    }
}
