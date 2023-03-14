package com.pojo.step3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

// @Service
// @Repository
public class CommonDao {
    Logger               logger = Logger.getLogger( CommonDao.class );
    MyBatisCommonFactory mcf    = new MyBatisCommonFactory();
    
    public List<Map<String, Object>> zipcodeList( Map<String, Object> pMap ) {
        logger.info( "zipcodeList호출" );
        List<Map<String, Object>> zList             = null;
        SqlSessionFactory         sqlSessionFactory = null;
        SqlSession                sqlSession        = null;
        
        try {
            sqlSessionFactory = mcf.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            pMap.put( "dong", "역삼" );
            zList = sqlSession.selectList( "zipcodeList", pMap );
            logger.info( zList );// 3건 조회
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return zList;
    }
}
