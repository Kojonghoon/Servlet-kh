package com.book.scope;

public class Sonata {
    public int    speed    = 10;
    public String carName  = "2023년형 소나타";
    public int    wheelNum = 4;
    
    public Sonata() {
        //10, 2023년형 소타나, 4
        System.out.println( "디폴트 생성자 - 파라미터가 없는 생성자" );
    }
    
    public Sonata( int speed ) {
        //speed, 2023년형 소나타, 4
        this.speed=speed;
    }
    
    public Sonata( int speed, String carName ) {
        // speed, carName치환, 4
        this.speed = speed;
        this.carName= carName;
    }
    
    public Sonata( int speed, String carName, int wheelNum ) {
        // speed, carName치환, wheelNum
        this.speed = speed;
        this.carName = carName;
        this.wheelNum=wheelNum;
    }
}
