package com.chocho.fourthproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewOneLeft, imageViewOneRight;
    ImageView imageViewTwoLeft, imageViewTwoRight;
    ImageView imageViewGameStart;

    TextView textView;
    Button buttonHanaMan;


    Random random = new Random();

    float play =0;
    float play1 =0;
    float play2 =0;

    int[] array = {R.drawable.gawi, R.drawable.bawi, R.drawable.bo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonHanaMan = findViewById(R.id.buttonHanaMan);
        imageViewGameStart = findViewById(R.id.imageViewGameStart);
        imageViewOneLeft = findViewById(R.id.imageViewOneLeft);
        imageViewOneRight = findViewById(R.id.imageViewOneRight);
        imageViewTwoLeft = findViewById(R.id.imageViewTwoLeft);
        imageViewTwoRight = findViewById(R.id.imageViewTwoRight);
        textView = findViewById(R.id.textViewResult);


        ImageView[] imageViews = {imageViewOneLeft, imageViewTwoLeft, imageViewOneRight, imageViewTwoRight};

        // 화면에서 imageview invisible로 설정
        imageViews[0].setVisibility(View.INVISIBLE);
        imageViews[1].setVisibility(View.INVISIBLE);
        imageViews[2].setVisibility(View.INVISIBLE);
        imageViews[3].setVisibility(View.INVISIBLE);


        imageViewGameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                imageViews[0].setVisibility(View.VISIBLE);
                imageViews[1].setVisibility(View.VISIBLE);
                imageViews[2].setVisibility(View.VISIBLE);
                imageViews[3].setVisibility(View.VISIBLE);
                int a = random.nextInt(3);
                int s = random.nextInt(3);
                int d = random.nextInt(3);
                int f = random.nextInt(3);

                // 데이터 셔플링
                imageViewOneLeft.setImageResource(array[a]);
                imageViewTwoLeft.setImageResource(array[s]);
                imageViewOneRight.setImageResource(array[d]);
                imageViewTwoRight.setImageResource(array[f]);

                buttonHanaMan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        int num1 = random.nextInt(2);
                        int num2 = random.nextInt(2) + 2;
                        // imageViews[num1]..setVisibility(View.INVISIBLE);
                        imageViews[num1].setVisibility(View.INVISIBLE);
                        imageViews[num2].setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "승리는 누구 ?", Toast.LENGTH_SHORT).show();

                        if (imageViews[num1] == imageViews[0] && imageViews[num2] == imageViews[2]) {
                            if (s == f) {

                                Toast.makeText(getApplicationContext(), "비김", Toast.LENGTH_SHORT).show();

                            } else if (s == 0 && f == 1) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 0 && f == 2) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 1 && f == 0) {

                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();

                            }
                            else if (s == 1 && f == 2) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 2 && f == 0) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 2 && f == 1) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                        } else if (imageViews[num1] == imageViews[1] && imageViews[num2] == imageViews[3]) {
                            if (a == d) {
                                Toast.makeText(getApplicationContext(), "비김", Toast.LENGTH_SHORT).show();
                            } else if (a == 0 && d == 1) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 0 && d == 2) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 1 && d == 0) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 1 && d == 2) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 2 && d == 0) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 2 && d == 1) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                        } else if (imageViews[num1] == imageViews[0] && imageViews[num2] == imageViews[3]) {
                            if (s == d) {
                                Toast.makeText(getApplicationContext(), "비김", Toast.LENGTH_SHORT).show();
                            } else if (s == 0 && d == 1) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 0 && d == 2) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 1 && d == 0) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 1 && d == 2) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 2 && d == 0) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (s == 2 && d == 1) {
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                        } else if (imageViews[num1] == imageViews[1] && imageViews[num2] == imageViews[2]) {
                            if (a == f) {
                                Toast.makeText(getApplicationContext(), "비김", Toast.LENGTH_SHORT).show();
                            } else if (a == 0 && f == 1) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 0 && f == 2) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 1 && f == 0) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 1 && f == 2) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 2 && f == 0) {
                                play2++;
                                Toast.makeText(getApplicationContext(), "2P 승", Toast.LENGTH_SHORT).show();
                            }
                            else if (a == 2 && f == 1) {
                                play1++;
                                Toast.makeText(getApplicationContext(), "1P 승", Toast.LENGTH_SHORT).show();
                            }
                        }
                        play++;
                        if(play == 10){
                            if(play1 == play2){
                                textView.setText("무승부");
                            } else if (play1 > play2) {
                                float play1Result = (play1/play)*100;
                                textView.setText("1Play 승리 승률: " + play1Result);
                            } else{
                                float play2Result = (play2/play)*100;
                                textView.setText("2Play 승리 승률: " + play2Result);
                            }
                        }

                    }
                });
            }
        });

        //for (ImageView imageView : imageViews)
        //    imageView.setVisibility(View.INVISIBLE);

    }



//    int shuffleArray() {
//
//

//        Random rand = new Random();
//        for (int i = 0; i < array.length; i++) {
//            int randomIndexToSwap = rand.nextInt(array.length);
//            int temp = array[randomIndexToSwap];
//            array[randomIndexToSwap] = array[i];
//            array[i] = temp;
//        }
//        System.out.println(Arrays.toString(array));


}

