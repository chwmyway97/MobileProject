package com.chocho.sevenproject;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ShuffleCard {
    int[] P1_deck = new int[2];
    int[] P2_deck = new int[2];

    Random rnd = new Random();
    int trigger = 0;


    public void Shuffle(){
        trigger = 1;
        do{
            P1_deck[0] = rnd.nextInt(13)+1;
            P1_deck[1] = rnd.nextInt(13)+1;
            P2_deck[0] = rnd.nextInt(13)+1;
            P2_deck[1] = rnd.nextInt(13)+1;
        }while(P1_deck[0] == P1_deck[1] || P2_deck[0] == P2_deck[1]);

    }


}
