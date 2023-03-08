package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

// Spring 부트에서는 requestParam 대신 해줌 Model, ModelMap
// 사용자가 입력한 값을 Map에 담아 준다
// 담을 map 은 콘트롤 계층에서 bind 메소드 호출시 파라미터를 이용해서 원본 주소번지를 받아온다.
// 그리고 그 안에 담는다.
public class HashMapBinder {
    HttpServletRequest req = null;// 저변
    
    public HashMapBinder() {}
    //생성자 파라미터에 요청객체(지변)가 필요한 이유 뭐죠?
    public HashMapBinder( HttpServletRequest req ) {
        //생성자의 1역할 - 전변의 초기화
        this.req = req;
    }
    
    // 어떤 페이지 어떤 상황에서 공통코드 재사용 가능하게 할 것인가?
    // 업무별 요청 클래스에서 주입 받을 객체를 정해서 메소드의 파라미터로 전달받음
    // 전달받은 주소번지 원본에 값을 담아준다.
    public void bind( Map<String, Object> pMap ) {
        pMap.clear();
        Enumeration<String> en = req.getParameterNames();
        
        while ( en.hasMoreElements() ) {
            String key = en.nextElement();
            pMap.put( key, req.getParameter( key ) );
        }
    }
}
