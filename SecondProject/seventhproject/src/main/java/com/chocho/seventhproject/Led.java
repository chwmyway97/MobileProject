package com.chocho.seventhproject;

public class Led {
    final boolean HIGH = true;
    final boolean LOW = false;
    final String OUTPUT = "출력으로 설정";
    private byte pin;   // byte에는 8비트의 메모리 공간이 할당



    public Led(){
        this.pin = 9;
        init();

    }
    public Led(byte pin) {   // 생성자 : 객체 생성시에 자동 실행
        this.pin = pin; //this 요클 라스안에서 나타나는 변수
        init();

    }
    private void init() {	// 메서드 1
        pinMode(pin, OUTPUT);
        off();  // LED Off 초기값 설정
    }
    public void on() {	// 메서드 2
        digitalWrite(pin, HIGH);


    }
    public void off() {	// 메서드 3
        digitalWrite(pin, LOW);

    }
    private void digitalWrite(byte pin, boolean onoff ) {
        if (onoff)
            System.out.println("LED ON");
        else
            System.out.println("LED OFF");
    }
    private void pinMode(byte pin, String inoutput) {
        System.out.println(inoutput);
    }
}
