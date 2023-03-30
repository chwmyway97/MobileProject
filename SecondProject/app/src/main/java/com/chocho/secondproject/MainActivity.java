package com.chocho.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;
    TextView tx6;
    Random random;
    EditText et1;
    EditText et2;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    String IntText1;
    String IntText2;

    int text1;
    int text2;

    String[] randomText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        tx4 = findViewById(R.id.tx4);
        tx6 = findViewById(R.id.tx6);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);

//        bt3.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"덧셈 결과",Toast.LENGTH_SHORT).show();
//                String IntText1 = et1.getText().toString();
//                String IntText2 = et2.getText().toString();
//                int text1 = Integer.parseInt(IntText1);
//                int text2 = Integer.parseInt(IntText2);
//                String plus = String.valueOf(text1+text2);
//
//                tx3.setText(plus);
//            }
//        });

        bt1.setOnClickListener(this::X);
        bt2.setOnClickListener(this::Y);
        bt3.setOnClickListener(this::Plus);
        bt4.setOnClickListener(this::Minus);
        bt5.setOnClickListener(this::Random);


        String[] randomText = {"신수민","조형우","이다훈","조성현","유현빈"};
        tx6.setText(randomText[1]);



    }

    public void Plus(View view) {
        IntText1 = et1.getText().toString();
        IntText2 = et2.getText().toString();
        int text1 = Integer.parseInt(IntText1);
        int text2 = Integer.parseInt(IntText2);
        String plus = String.valueOf(text1+text2);

        tx3.setText("결과"+plus);
    }

    public void Minus(View view) {

        String IntText1 = et1.getText().toString();
        String IntText2 = et2.getText().toString();
        text1 = Integer.parseInt(IntText1);
        text2 = Integer.parseInt(IntText2);
        if(text1 - text2 < 0){
            Toast.makeText(getApplicationContext(),"0보다 작은 값은 얻을 수 없습니다.",Toast.LENGTH_SHORT).show();
            int i = text2 - text1;
            String minus = String.valueOf(i);
            tx3.setText("결과"+minus);
        }
        else {
            int i = text1 - text2;
            String minus = String.valueOf(i);
            tx3.setText("결과"+minus);
        }
    }
    public void X(View view) {
        String IntText1 = et1.getText().toString();
        String IntText2 = et2.getText().toString();
        int text1 = Integer.parseInt(IntText1);
        int text2 = Integer.parseInt(IntText2);
        int x = text1 * text2;
        String multiplication = String.valueOf(x);
            tx3.setText("결과"+multiplication);

    }
    public void Y(View view) {
        String IntText1 = et1.getText().toString();
        String IntText2 = et2.getText().toString();
        float text1 = Float.valueOf(IntText1);
        float  text2 = Float.valueOf(IntText2);
        float y= text1 / text2;
        if (text2 == 0){ Toast.makeText(this, "다시입력 바랍니다",Toast.LENGTH_SHORT).show(); }
        else {
            String multiplication = String.format("%.2f", y);

            tx3.setText("결과" + multiplication);
        }

    }
    public void Random(View view) {

        random = new Random();
        int getInt = random.nextInt(10);

        String O = String.valueOf(getInt);

        tx4.setText(O);

    }
}