package com.chocho.seventhproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button buttonOnLED, buttonOffLED, button;
    ImageView imageViewLED;

    static int count;

    final byte pinNumber = 9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOnLED = findViewById(R.id.buttonOnLED);
        buttonOffLED = findViewById(R.id.buttonOffLED);
        imageViewLED = findViewById(R.id.imageViewLED);
        button = findViewById(R.id.button);


        Led led = new Led();// 생성자
        Led led1 = new Led(pinNumber); //도는 생성자 2
        Motor motor = new Motor();// 모터 클라스
        buttonOnLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                led1.on();
                imageViewLED.setImageResource(R.drawable.led_on);
            }
        });

        buttonOffLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                led1.off();
                imageViewLED.setImageResource(R.drawable.led_off);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                Log.d("count",String.valueOf(count));
                if( count == 1 ){
                    led1.on();
                    motor.on();
                    imageViewLED.setImageResource(R.drawable.led_on);
                    button.setText("LED OFF button");

                }else{
                    led1.off();
                    motor.off();
                    imageViewLED.setImageResource(R.drawable.led_off);
                    button.setText("LED ON button");
                    count =0;
                }

            }
        });






    }
}