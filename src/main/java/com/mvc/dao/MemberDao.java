package com.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class MemberDao {
    // log4j모듈 활용해서 로그 출력- 날짜와 시간, 클래스명, 라인번호, 링크
    // Syetem.out.println() 대신에 사용함
    Logger logger = Logger.getLogger( MemberDao.class );
    // DAO클래스와 오라클서버 사이에 MyBatis Layer에 필요한 설정 내용담기
    // member.xml의 물리적인 위치와 오라클서버의 정보가 담긴 MyBatisConfig.xml의
    // 정보를 IO로 읽어오는 코드가 포함됨
    // 마이바티스는 쿼리문을 xml문서에 따로 관리한다. -
    // 자바로 관리하는 것 보다 컴파일을 하지 않아도 되고 버전관리에도 효과적임
    MyBatisCommonFactory mcf = new MyBatisCommonFactory();
    
    public Map<String, Object> login( Map<String, Object> pMap ) {
        Map<String, Object> rmap = null;
        // MyBatisConfig.xml문서를 통해 스캔한 오라클 서버 정보로 연결통로 확보
        SqlSessionFactory sqlSessionFactory = null;
        // 위에서 SqlSessionFactory 생성되면 쿼리문을 요청하는 selectOne 메소드가 필요한데
        // 그메소드는 제공하는 클래스 및 commit, rollback지원
        SqlSession sqlSession = null;
        
        try {
            // 공통코드에서 연결통로 확보
            sqlSessionFactory = mcf.getSqlSessionFactory();
            // 연결 통로 확보로 생성된 객체로 SqlSession로딩하기
            sqlSession = sqlSessionFactory.openSession();
            // pMap = new HashMap<>();
            // pMap.put("mem_id", "tomato");
            // pMap.put("mem_pw", "123");
            rmap = sqlSession.selectOne( "login", pMap ); // test.xml과 id가 같아야함
            logger.info( rmap ); // 3건 모두 조
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return rmap;
    }
    
    public static void main( String[] args ) {
        MemberDao           mDao = new MemberDao();
        Map<String, Object> pMap = new HashMap<>();
        pMap.put( "mem_id", "tomato" );
        pMap.put( "mem_pw", "123" );
        Map<String, Object> rmap = mDao.login( pMap );
        System.out.println( rmap );
    }
}
