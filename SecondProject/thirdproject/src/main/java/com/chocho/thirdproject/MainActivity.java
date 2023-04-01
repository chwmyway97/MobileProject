package com.chocho.thirdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tx_1;
    private TextView tx_2;
    private TextView tx_success;

    private TextView tx_round;
    private TextView tx_round_winner;
    private TextView tx_persent1;

    private TextView tx_persent2;

    private Button start;
    private Button winner;

    private Random random;


    private ImageView Img1;
    private ImageView Img2;
    int num = 0;
    double num1 = 0;
    double num2 = 0;
    double num0 = 0;
    double Sum0;
    double Sum1;
    double Sum2;

    String dSum0;
    String dSum1;
    String dSum2;


    String Round;


    private final String[] hands = {"", "가위", "바위", "보"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //문자
        tx_1 = findViewById(R.id.tx_1);
        tx_2 = findViewById(R.id.tx_2);
        tx_persent1 = findViewById(R.id.tx_persent1);
        tx_persent2 = findViewById(R.id.tx_persent2);
        tx_success = findViewById(R.id.tx_success);
        tx_round_winner = findViewById(R.id.tx_round_winner);
        tx_round = findViewById(R.id.tx_round);

        //버튼
        start = findViewById(R.id.start);
        winner = findViewById(R.id.winner);

        //이미지 뷰
        Img1 = findViewById(R.id.imageView);
        Img2 = findViewById(R.id.imageView2);



        start.setOnClickListener(this::START);
        winner.setOnClickListener(this::WINNER);

        tx_1.setText("?");
        tx_2.setText("?");

    }

    public void START(View view) {



        random = new Random();
        int getInt1 = random.nextInt(3) + 1;
        int getInt2 = random.nextInt(3) + 1;


        int ImgView = R.drawable.img;
        int Img1View = R.drawable.img_1;
        int Img2View = R.drawable.img_2;




        tx_1.setText(hands[getInt1]);
        tx_2.setText(hands[getInt2]);
        if (getInt1 == 1) {
            Img1.setImageResource(ImgView);
        } else if (getInt1 == 2) {
            Img1.setImageResource(Img1View);
        } else {
            Img1.setImageResource(Img2View);
        }

        if (getInt2 == 1) {
            Img2.setImageResource(ImgView);
        } else if (getInt2 == 2) {
            Img2.setImageResource(Img1View);
        } else {
            Img2.setImageResource(Img2View);
        }

        Toast.makeText(this, "결과 버튼을 클릭해주세요.", Toast.LENGTH_SHORT).show();
        start.setEnabled(false);


    }

    @SuppressLint("SetTextI18n")
    public void WINNER(View view) {


        num++;

        Round = num+" ROUND";
        tx_round.setText(Round);
        tx_round.setGravity(Gravity.CENTER);

        int first = Arrays.asList(hands).indexOf(tx_1.getText().toString());
        int second = Arrays.asList(hands).indexOf(tx_2.getText().toString());
        String result = "";

        if (first == second) {
            result = "무승부";
            num0++;
        } else if ((first == 1 && second == 3) || (first == 2 && second == 1) || (first == 3 && second == 2)) {
            result = "1P 승리";
            num1++;
        } else {
            result = "2P 승리";
            num2++;
        }
        Log.d("숫자" , String.valueOf(num)  );
        Log.d("숫자1" , String.valueOf(num1)  );
        Log.d("숫자2" , String.valueOf(num2)  );


        if(num == 10){

            Log.d("숫자" , String.valueOf(num)  );
            Log.d("숫자1" , String.valueOf(num1)  );
            Log.d("숫자2" , String.valueOf(num2)  );

            start.setEnabled(false);
            winner.setEnabled(false);

            tx_round_winner.setText("최종 결과는?");

            DecimalFormat decimalFormat = new DecimalFormat("#");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

            Sum0 = (num0 / (num1 + num2 + num0) * 100.0);
            Sum1 = (num1 / (num1 + num2 + num0)) * 100.0;
            Sum2 = (num2 / (num1 + num2 + num0) * 100.0);

            dSum0 =decimalFormat.format(Sum0);
            dSum1 =decimalFormat.format(Sum1);
            dSum2 =decimalFormat.format(Sum2);

            tx_persent1.setText( "승리 확률 : " + dSum1 + "%" + "\n"  +"\n 패배 확률 : " + dSum2 + "%"+ "\n" + "\n무승부확률 : " + dSum0 + "%" );
            tx_persent2.setText( "승리 확률 : " + dSum2 + "%" + "\n" + "\n 패배 확률 : " + dSum1 + "%"+ "\n" + "\n무승부확률 : " + dSum0 + "%" );

            tx_persent1.setGravity(Gravity.CENTER);
            tx_persent2.setGravity(Gravity.CENTER);


            if (num1 > num2){
                tx_success.setText("1P 승리");
            }else{
                tx_success.setText("2P 승리");
            }

        } else{
            tx_success.setText(result);
            start.setEnabled(true);
        }
        tx_success.setGravity(Gravity.CENTER);


        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }
}