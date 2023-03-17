package com.chocho.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int countUP =0;
    private TextView textView1; //클래스 선언 1!!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView1 = findViewById(R.id.text1); //객체 생성 2!!
//        textView1. 점에 뜨는게 메서드 3!!
    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "조형우", Toast.LENGTH_LONG);
        toast.show();
        countUP = 0;
        textView1.setText(String.valueOf(countUP));
    }
    public void countUp(View view){

    // 여러줄 주석은 /* ~ */

        countUP += 1;
        if (countUP == 10){
            countUP = 0;
        }

        textView1.setText(String.valueOf(countUP));
        textView1.setTextColor(ContextCompat.getColor(this, R.color.orange));
//        textView.setText(Integer.toString(countUP));

    }


}