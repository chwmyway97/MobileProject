package com.chocho.seventhproject;

public class Motor extends Led {

    public Motor(){
        super(); //생성자를 호출
    }

    public void on() {	// 메서드 2
        System.out.println("Motor ON");
//        super.on(); //led의 on 호출

    }
    public void off() {	// 메서드 3
        System.out.println("Motor OFF");

    }

}
