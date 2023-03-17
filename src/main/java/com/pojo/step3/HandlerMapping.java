package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HandlerMapping {
    static Logger logger = Logger.getLogger( HandlerMapping.class );
    
    /****************************************************************************************
     * @param upmu[](upmu[0]-업무명[폴더명], upmu[1]-메소드명,기능명,페이지이름,분기)
     * @param request                  -1-1, 1-2와는 다르게 인터페이스를 implements 하지 않는다
     * @param response
     *                                 질문? 어디서 받아오지?
     * @return Object
     *                                 
     ****************************************************************************************/
    public static Object getController( String[] upmu, HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        logger.info( upmu[0] + ", " + upmu[1] );
        Controller3  controller = null;
        String       path       = null;
        Object       obj        = null;
        ModelAndView mav        = null;
        
        if ( "common".equals( upmu[0] ) ) {
            controller = new CommonController();
            
            if ( "zipcodeList".equals( upmu[1] ) ) {// html화면 출력이 나감 - text/html
                obj = controller.zipcodeList( req, res );
                
                // 리턴타입이 ModelAndView
                if ( obj instanceof ModelAndView ) {
                    return ( ModelAndView ) obj;
                }
                // 리턴타입이 String
                else if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }///// end of zipcodeList
        }
        else if ( "board3".equals( upmu[0] ) ) {
            controller = new Board3Controller();
            
            // 게시글 전체 목록
            if ( "boardList".equals( upmu[1] ) ) {// html화면 출력이 나감 - text/html
                obj = controller.boardList( req, res );
                
                // 리턴타입이 ModelAndView
                if ( obj instanceof ModelAndView ) {
                    return ( ModelAndView ) obj;
                }
                // 리턴타입이 String
                else if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }
            else if ( "jsonBoardList".equals( upmu[1] ) ) {// json포맷 나감 - application/json
                obj = controller.jsonBoardList( req, res );
                
                // 리턴타입이 ModelAndView
                if ( obj instanceof ModelAndView ) {
                    return ( ModelAndView ) obj;
                }
                // 리턴타입이 String
                else if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }
            else if ( "boardDetail".equals( upmu[1] ) ) {// json포맷 나감 - application/json
                obj = controller.boardDetail( req, res );
                
                // 리턴타입이 ModelAndView
                if ( obj instanceof ModelAndView ) {
                    return ( ModelAndView ) obj;
                }
                // 리턴타입이 String
                else if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }
            else if ( "boardInsert".equals( upmu[1] ) ) {// 글입력 - 새글쓰기와 댓글쓰기
                obj = controller.boardInsert( req, res );
                logger.info( "boardInsert호출==> boolean : " + obj instanceof String );
                
                // 리턴타입이 String
                if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }
            else if ( "imageUpload".equals( upmu[1] ) ) {// 리액트 quill editor 이미지 추가
                obj = controller.imageUpload( req, res );
                logger.info( "imageUpload호출==> boolean : " + obj instanceof String );
                
                // 리턴타입이 String
                if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }
            else if ( "imageGet".equals( upmu[1] ) ) {// 리액트 quill editor 이미지 추가
                obj = controller.imageGet( req, res );
                logger.info( "imageGet호출==> boolean : " + obj instanceof String );
                
                // 리턴타입이 String
                if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }
            else if ( "imageDownload".equals( upmu[1] ) ) {// 리액트 quill editor 이미지 추가
                obj = controller.imageDownload( req, res );
                logger.info( "imageDownload호출==> boolean : " + obj instanceof String );
                
                // 리턴타입이 String
                if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }
            else if ( "boardUpdate".equals( upmu[1] ) ) {// 글수정 - 첨부파일 수정 유무 고려하기
                obj = controller.boardUpdate( req, res );
                
                // 리턴타입이 String
                if ( obj instanceof String ) {
                    return ( String ) obj;
                }
                
            }
            else if ( "boardDelete".equals( upmu[1] ) ) {// 글입력 - 첨부파일 삭제 유무 고려하기
                obj = controller.boardDelete( req, res );
                
                // 리턴타입이 String
                if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }
        }// end of 게시판 구현
        
        // 인증관리 - 김유신
        else if ( "auth".equals( upmu[0] ) ) {
            
        }
        // 회원관리 - 이순신
        else if ( "member".equals( upmu[0] ) ) {
            controller = new MemberController();
            if ( "login".equals( upmu[1] ) ) {
                obj = controller.login( req, res );
                if ( obj instanceof ModelAndView ) {
                    return ( ModelAndView ) obj;
                }
                // 리턴타입이 String
                else if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }//end of login
            else if ( "logout".equals( upmu[1] ) ) {
                obj = controller.logout( req, res );
                if ( obj instanceof ModelAndView ) {
                    return ( ModelAndView ) obj;
                }
                // 리턴타입이 String
                else if ( obj instanceof String ) {
                    return ( String ) obj;
                }
            }//end of logout
        } // 주문관리 - 강감찬
        else if ( "order".equals( upmu[0] ) ) {
            
        }
        return obj;
    }
}
