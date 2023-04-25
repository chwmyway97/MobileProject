package com.chocho.sevenproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button start_btn;
    ImageView P1_1, P1_2, P2_1, P2_2, shuffle_img;
    TextView P1_win, P2_win, P1_rate, P2_rate;

    int[] P1_deck = new int[2];
    int[] P2_deck = new int[2];

    Random rnd = new Random();

    int trigger = 0;
    int whole_game = 0;
    int P1Win = 0, P2Win = 0;
    int[] deckOfCard = {
            R.drawable.b,
            R.drawable._1,
            R.drawable._2,
            R.drawable._3,
            R.drawable._4,
            R.drawable._5,
            R.drawable._6,
            R.drawable._7,
            R.drawable._8,
            R.drawable._9,
            R.drawable._10,
            R.drawable.j,
            R.drawable.q,
            R.drawable.k
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_btn = findViewById(R.id.start_btn);

        P1_1 = findViewById(R.id.P1_1);
        P1_2 = findViewById(R.id.P1_2);
        P2_1 = findViewById(R.id.P2_1);
        P2_2 = findViewById(R.id.P2_2);

        shuffle_img = findViewById(R.id.shuffling);

        P1_win = findViewById(R.id.P1_view);
        P2_win = findViewById(R.id.P2_view);
        P1_rate = findViewById(R.id.P1_rate);
        P2_rate = findViewById(R.id.P2_rate);

        Sub sub = new Sub(P1_1, P1_2, P2_1, P2_2, P1_win, P2_win, P1_rate, P2_rate, deckOfCard, P1_deck, P2_deck,
                trigger, whole_game, P1Win, P2Win, rnd);

        shuffle_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub.shuffleAndDeal();
            }
        });

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub.playRound();
            }
        });


//        main();

    }
}

//    protected void main(){
//
//        shuffle_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                trigger = 1;
//                do{
//                    P1_deck[0] = rnd.nextInt(13)+1;
//                    P1_deck[1] = rnd.nextInt(13)+1;
//                    P2_deck[0] = rnd.nextInt(13)+1;
//                    P2_deck[1] = rnd.nextInt(13)+1;
//                }while(P1_deck[0] == P1_deck[1] || P2_deck[0] == P2_deck[1]);
//            }
//        });
//
//        start_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(trigger == 1){//셔플을 안하고 게임을 시작하는 걸 방지하기 위해서
//                    P1_1.setImageResource(deckOfCard[P1_deck[0]]);
//                    P1_2.setImageResource(deckOfCard[P1_deck[1]]);
//                    P2_1.setImageResource(deckOfCard[P2_deck[0]]);
//                    P2_2.setImageResource(deckOfCard[P2_deck[1]]);
//
//                    whole_game++;
//                    int P1 = P1_deck[0] + P1_deck[1];
//                    int P2 = P2_deck[0] + P2_deck[1];
//
//                    if (P1 == P2) {
//                        //draw
//                        P1_win.setText("비겼습니다");
//                        P2_win.setText("비겼습니다");
//                    }
//                    else if(P1 > P2){
//                        P1_win.setText("이겼습니다");
//                        P2_win.setText("졌습니다");
//                        P1Win++;
//                    }
//                    else{
//                        P1_win.setText("졌습니다");
//                        P2_win.setText("이겼습니다");
//                        P2Win++;
//                    }
//                    P1_rate.setText("승률:"+Math.round(P1Win/(float)whole_game*10000)/100.00+"%");
//                    P2_rate.setText("승률:"+Math.round(P2Win/(float)whole_game*10000)/100.00+"%");
//                    trigger = 0;
//                }
//            }
//        });
//    }
