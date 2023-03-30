package com.chocho.thirdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tx_1;
    private TextView tx_2;
    private TextView tx_success;

    private Button start;
    private Button winner;

    private Random random;


    private ImageView Img1;
    private ImageView Img2;

    private final String[] hands = {"", "가위", "바위", "보"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx_1 = findViewById(R.id.tx_1);
        tx_2 = findViewById(R.id.tx_2);
        tx_success = findViewById(R.id.tx_success);
        Img1 = findViewById(R.id.imageView);
        Img2 = findViewById(R.id.imageView2);

        start = findViewById(R.id.start);
        winner = findViewById(R.id.winner);

        start.setOnClickListener(this::START);
        winner.setOnClickListener(this::WINNER);
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

        Toast.makeText(this, "위너 버튼을 클릭해주세요.", Toast.LENGTH_SHORT).show();
        start.setEnabled(false);
    }

    public void WINNER(View view) {
        int first = Arrays.asList(hands).indexOf(tx_1.getText().toString());
        int second = Arrays.asList(hands).indexOf(tx_2.getText().toString());
        String result = "";

        if (first == second) {
            result = "무승부";
        } else if ((first == 1 && second == 3) || (first == 2 && second == 1) || (first == 3 && second == 2)) {
            result = "첫번째 사람 승리";
        } else {
            result = "두번째 사람 승리";
        }

        tx_success.setText("승리자는 ? " + result);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        start.setEnabled(true);
    }
}