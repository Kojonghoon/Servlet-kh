package com.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class TestDao {
    Logger               logger = Logger.getLogger( TestDao.class );
    MyBatisCommonFactory mcf    = new MyBatisCommonFactory();
    
    public List<Map<String, Object>> getBookMember() {
        List<Map<String, Object>> mList             = null;
        SqlSessionFactory         sqlSessionFactory = null;
        SqlSession                sqlSession        = null;
        
        try {
            sqlSessionFactory = mcf.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            Map<String, Object> pMap = new HashMap<>();
            pMap.put( "mem_id", "tomato" );
            pMap.put( "mem_pw", "123" );
            mList = sqlSession.selectList( "getBookMember", pMap ); // test.xml과 id가 같아야함
            logger.info( mList ); // 3건 모두 조
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return mList;
    }
    
    public String testDate() {
        String            cTime             = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession        sqlSession        = null;
        
        try {
            sqlSessionFactory = mcf.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            cTime = sqlSession.selectOne( "testDate" ); // test.xml과 id가 같아야함
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return cTime;
    }
}
