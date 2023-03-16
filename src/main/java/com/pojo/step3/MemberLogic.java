package com.pojo.step3;

import java.util.Map;

import org.apache.log4j.Logger;

public class MemberLogic {
    Logger logger = Logger.getLogger( MemberLogic.class);
    MemberDao memberDao = new MemberDao();
    public Map<String, Object> login( Map<String, Object> pMap ) {
        Map<String, Object> rMap = null;
        rMap = memberDao.login(pMap);
        return rMap;
    }
}
