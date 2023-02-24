package com.pojo.step1;

public class Pattern {
    public static void main( String[] args ) {
//        String url = "/Servlet230216/업무이름/페이지이름 또는 요청 이름";
        String uri = "/Servlet230216/dept/getDeptList.kh";
        String context="Servlet230216/";
        
        //톰캣서버에 요청할 떄 사용되는 주소값을 가지고 업무명과 업무에 필요한 이름으로 
        //분리시켜서 사용자 요청에 따라 처리를 담당핳 XXXController 객체를 주입하는데 사용함
        String command = uri.substring(context.length()+1);
        System.out.println( command );
        System.out.println( "" );

        int end = command.lastIndexOf( "." );
        System.out.println( end );
        System.out.println( "" );
        
        command = command.substring( 0,end );
        System.out.println( command );
        System.out.println( "" );
        
        String upmu[]=null;
        upmu=command.split( "/" );
        for(String imsi:upmu) {
            System.out.println( imsi );
        }
        System.out.println( "" );
    }
}
