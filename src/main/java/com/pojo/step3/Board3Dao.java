package com.pojo.step3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class Board3Dao {
	Logger logger = Logger.getLogger(Board3Dao.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList호출");
		List<Map<String,Object>> bList = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try { 
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			bList = sqlSession.selectList("boardList", pMap);
			logger.info(bList);//3건 조회
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return bList;			
	}
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert 호출");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try { 
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			//insert이지만 update로 하는 이유는 리턴타입이 Object이기때문이다
			//메소드이름은 상관없이 해당 쿼리문을 id로 찾기 때문이다.
			result = sqlSession.update("boardMInsert", pMap);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);//
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return result;
	}
	public int getBGroup() {
		int result  = 0;
		logger.info("getBGroup호출");
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try { 
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("getBGroup", "");
			logger.info(result);//채번한 글그룹번호 
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return result;
	}
	public int getBNo() {
		int result  = 0;
		logger.info("getBNo호출");
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try { 
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("getBNo", "");
			logger.info(result);//채번한 글번호 
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return result; 
	}
	public void bStepUpdate(Map<String, Object> pMap) {
		int result =0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try { 
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("bStepUpdate", pMap);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);//
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}//end of bStepUpdate
	/*******************************************************
	 * 글 수정하기 구현
	 * @param pMap - 사용자가 입력한 값 받아옴
	 *******************************************************/
	public int boardMUpdate(Map<String, Object> pMap) {
		int result =0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try { 
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardMUpdate", pMap);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);//
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return result;
	}//end of bStepUpdate
	/*******************************************************
	 * 글 삭제하기 구현
	 * @param pMap - 사용자가 입력한 값 받아옴
	 *******************************************************/
	public int boardMDelete(Map<String, Object> pMap) {
		int result =0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try { 
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			int bm_no = 0;
			if(pMap.get("bm_no")!=null) {
				bm_no = Integer.parseInt(pMap.get("bm_no").toString());
			}
			result = sqlSession.update("boardMDelete", bm_no);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);//
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return result;
	}//end of bStepUpdate
}
