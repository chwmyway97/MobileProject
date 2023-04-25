package com.chocho.sevenproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Sub {

    private ImageView P1_1, P1_2, P2_1, P2_2;
    private TextView P1_win, P2_win, P1_rate, P2_rate;
    private int[] deckOfCard, P1_deck, P2_deck;
    private int trigger, whole_game, P1Win, P2Win;
    private Random rnd;

    public Sub(ImageView P1_1, ImageView P1_2, ImageView P2_1, ImageView P2_2, TextView P1_win, TextView P2_win,
               TextView P1_rate, TextView P2_rate, int[] deckOfCard, int[] P1_deck, int[] P2_deck, int trigger,
               int whole_game, int P1Win, int P2Win, Random rnd) {
        this.P1_1 = P1_1;
        this.P1_2 = P1_2;
        this.P2_1 = P2_1;
        this.P2_2 = P2_2;
        this.P1_win = P1_win;
        this.P2_win = P2_win;
        this.P1_rate = P1_rate;
        this.P2_rate = P2_rate;
        this.deckOfCard = deckOfCard;
        this.P1_deck = P1_deck;
        this.P2_deck = P2_deck;
        this.trigger = trigger;
        this.whole_game = whole_game;
        this.P1Win = P1Win;
        this.P2Win = P2Win;
        this.rnd = rnd;
    }

    public void shuffleAndDeal() {
        trigger = 1;
        do {
            P1_deck[0] = rnd.nextInt(13) + 1;
            P1_deck[1] = rnd.nextInt(13) + 1;
            P2_deck[0] = rnd.nextInt(13) + 1;
            P2_deck[1] = rnd.nextInt(13) + 1;
        } while (P1_deck[0] == P1_deck[1] || P2_deck[0] == P2_deck[1]);
    }

    public void playRound() {
        if(trigger == 1){//셔플을 안하고 게임을 시작하는 걸 방지하기 위해서
            P1_1.setImageResource(deckOfCard[P1_deck[0]]);
            P1_2.setImageResource(deckOfCard[P1_deck[1]]);
            P2_1.setImageResource(deckOfCard[P2_deck[0]]);
            P2_2.setImageResource(deckOfCard[P2_deck[1]]);

            whole_game++;
            int P1 = P1_deck[0] + P1_deck[1];
            int P2 = P2_deck[0] + P2_deck[1];

            if (P1 == P2) {
                //draw
                P1_win.setText("비겼습니다");
                P2_win.setText("비겼습니다");
            }
            else if(P1 > P2){
                P1_win.setText("이겼습니다");
                P2_win.setText("졌습니다");
                P1Win++;
            }
            else{
                P1_win.setText("졌습니다");
                P2_win.setText("이겼습니다");
                P2Win++;
            }
            P1_rate.setText("승률:"+Math.round(P1Win/(float)whole_game*10000)/100.00+"%");
            P2_rate.setText("승률:"+Math.round(P2Win/(float)whole_game*10000)/100.00+"%");
            trigger = 0;
        }
    }
}