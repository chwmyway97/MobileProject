package com.chocho.thirdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //문자 변수
    private TextView tx_1,tx_2,tx_success,tx_round,tx_round_winner;
    private TextView tx_persent1,tx_persent2;
    private TextView liar,one_liar,two_liar;

    //버튼형 변수
    private Button start, winner, reset;
    private Button start_liar1 , winner_liar1;
    private Button start_liar2, winner_liar2;

    //랜덤형 변수
    private Random random;

    //이미지 변수
    private ImageView Img1,Img2;

    //인트형 변수
    int num = 0;
    int count,count_liar1,count_liar2;
    double num1 = 0, num2 = 0, num0 = 0;
    double Sum0,Sum1,Sum2, Sum_p1, Sum_p2;

    //문자열 변수
    String dnum0,dnum1,dnum2,dSum0,dSum1,dSum2;
    String Round;

    //array 변수
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
        liar = findViewById(R.id.liar);
        one_liar = findViewById(R.id.one);
        two_liar = findViewById(R.id.two);

        //버튼
        start = findViewById(R.id.start);
        winner = findViewById(R.id.winner);
        reset = findViewById(R.id.reset);

        //거짓버튼1
        start_liar1 = findViewById(R.id.start_liar1);
        winner_liar1 = findViewById(R.id.winner_liar1);

        //거짓버튼2
        start_liar2 = findViewById(R.id.start_liar2);
        winner_liar2 = findViewById(R.id.winner_liar2);


        //이미지 뷰
        Img1 = findViewById(R.id.imageView);
        Img2 = findViewById(R.id.imageView2);

        //버튼 클릭
        start.setOnClickListener(this::START);
        winner.setOnClickListener(this::WINNER);
        reset.setOnClickListener(this::Reset);
        one_liar.setOnClickListener(this::Liar_1);
        start_liar1.setOnClickListener(this::START_Liar1);

        //그냥 추가
        two_liar.setOnClickListener(this::Liar_2);
        start_liar2.setOnClickListener(this::START_Liar2);

        //앱이 켜졌을 때
        tx_1.setText("?");
        tx_2.setText("?");
        winner.setEnabled(false);
        start_liar1.setEnabled(false);
        winner_liar1.setEnabled(false);
        start_liar2.setEnabled(false);
        winner_liar2.setEnabled(false);

        // 액티비티를 풀스크린 모드로 설정
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 뒤로가기 버튼 숨기기
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);


    }

    //게임 시작 버튼
    public void START(View view) {

        String result = "";
        tx_success.setText(result);
        //버튼 선택을 위한 카운트
        count = 1;
        count_liar1 =0;
        count_liar2 =0;

        //라운드 증가
        num++;
        Round = num + " ROUND";
        tx_round.setText(Round);
        tx_round.setGravity(Gravity.CENTER);

        //랜덤 함수 발생
        random = new Random();
        int getInt1 = random.nextInt(3) + 1; //0부터 시작이 아닌 1부터 시작
        int getInt2 = random.nextInt(3) + 1;

        int ImgView = R.drawable.img; //가위
        int Img1View = R.drawable.img_1; //바위
        int Img2View = R.drawable.img_2; //보


        tx_1.setText(hands[getInt1]); //해석 : 랜덤 함수로 뽑힌 숫자의 hands 자리에서 가져오겠다. 그리고 가져온 글자를 tx_1에 넣겠다.
        tx_2.setText(hands[getInt2]);

        //만약 랜덤 하게 뽑힌 숫자가 ~라면
        if (getInt1 == 1) {
            Img1.setImageResource(ImgView);//이미지 뷰에 가위를 넣겠다 //setImageResource 는 이미지 뷰에 ID 지정하여 넣을수 있다.
        } else if (getInt1 == 2) {
            Img1.setImageResource(Img1View);//이미지 뷰에 바위를 넣겠다
        } else {
            Img1.setImageResource(Img2View);//이미지 뷰에 보를 넣겠다
        }

        if (getInt2 == 1) {
            Img2.setImageResource(ImgView);
        } else if (getInt2 == 2) {
            Img2.setImageResource(Img1View);
        } else {
            Img2.setImageResource(Img2View);
        }

        start.setEnabled(false); //시작 버튼 비활성화
        winner.setEnabled(true); //결과 발표 버튼 활성화

//        Toast.makeText(this, "결과 버튼을 클릭해주세요.", Toast.LENGTH_SHORT).show(); //메세지 띄움

    }

    //결과 발표 버튼

    public void WINNER(View view) {

        Log.d("확인", String.valueOf(count)); //카운터 값 오는지 확인
        Log.d("확인", String.valueOf(count_liar1));
        Log.d("확인", String.valueOf(count_liar2));

        int first = Arrays.asList(hands).indexOf(tx_1.getText().toString());
        int second = Arrays.asList(hands).indexOf(tx_2.getText().toString());
        /**
         1. hands 라는 배열 안에서 tx_1.getText().toString()의 값과 일치하는 요소의 인덱스를 찾습니다.
         2. Arrays.asList(hands)는 hands 배열을 List 객체로 변환합니다.
         3. List 객체에서 indexOf() 메소드를 호출하여 tx_1.getText().toString()의 값과 일치하는 요소의 인덱스를 검색합니다.
         4. 검색 결과로 찾은 인덱스 값을 반환합니다.
         즉, hands 배열에서 tx_1의 텍스트와 일치하는 값의 인덱스를 찾아 반환하는 것입니다.
         이때 Arrays.asList() 메소드를 사용하여 배열을 List 변환한 이유는, List 객체의 indexOf() 메소드를 사용하기 위함입니다.
         배열 자체에 indexOf() 메소드가 없기 때문입니다.
         by chatGPT
         **/

        //결과는 밑에 있는 문자 = 누가 이겼는지를 나타냄
        String result = "";

        if (first == second) {
            result = "무승부";
            num0++; //무승부 횟수 증가
        } else if ((first == 1 && second == 3) || (first == 2 && second == 1) || (first == 3 && second == 2)) {
            result = "1P 승리";
            num1++; //1P 승리 횟수 증가
        } else {
            result = "2P 승리";
            num2++; //2P 승리 횟수 증가
        }

        //회수 증가 확인
        Log.d("숫자", String.valueOf(num));
        Log.d("숫자1", String.valueOf(num1));
        Log.d("숫자2", String.valueOf(num2));

        //만약 라운드가 15라면
        if (num == 10) {

            //회수 증가 확인
            Log.d("15숫자", String.valueOf(num0));
            Log.d("15숫자1", String.valueOf(num1));
            Log.d("15숫자2", String.valueOf(num2));

            //버튼 전부 비활성화
            start.setEnabled(false);
            winner.setEnabled(false);
            start_liar1.setEnabled(false);
            start_liar2.setEnabled(false);

            //결과는 -> 최종결과로 바꿈
            tx_round_winner.setText("최종 결과는?");


            DecimalFormat decimalFormat = new DecimalFormat("#"); //소수점 없애고 싶어서 추가한 함수 //가격 소수점 표시할 때 자주 사용
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP); //반올림 하는 함수

//            Sum0 = (num0 / num) * 100.0; //무승부 횟수
            Sum1 = (num1 / num) * 100.0; //P1 승리 횟수
            Sum2 = (num2 / num)* 100.0; //P2 승리 횟수




            dnum0 = decimalFormat.format(num0);
            dnum1 = decimalFormat.format(num1);
            dnum2 = decimalFormat.format(num2);
//            dSum0 = decimalFormat.format(num0); //소수점 제거
            dSum1 = decimalFormat.format(Sum1);
            dSum2 = decimalFormat.format(Sum2);




            // % -> 문자열로 나타낼 때는 %%
            // %S %d %f 문자열 정수 실수 값 출력 그래서 뒤에 순서대로 입력 됨
            tx_persent1.setText(String.format("승리 : %s회\n\n 패배 : %s회\n\n 무승부 : %s회\n\n 게임 승률 :\n %s%%", dnum1, dnum2,dnum0,dSum1));
            tx_persent2.setText(String.format("승리 : %s회\n\n 패배 : %s회\n\n 무승부 : %s회\n\n 게임 승률 :\n %s%%", dnum2, dnum1,dnum0,dSum2));

            tx_persent1.setGravity(Gravity.CENTER); //중앙 정렬
            tx_persent2.setGravity(Gravity.CENTER);


            if (num1 > num2) { //만약 P1 승리시
                tx_success.setText("1P 승리"); //노란색 뜨는 이유 @SuppressLint("SetTextI18n") 다국어 지원 등을 놓칠수 있데요
            } else if (num1 < num2) { //만약 P2 승리시
                tx_success.setText("2P 승리");
            } else { //만약 무승부시
                tx_success.setText("무승부");
            }

        } else { //15라운드가 아니라면

            tx_success.setText(result); //result = 결과(승리자 ,무승부)를 텍스트 뷰에 넣음

            winner.setEnabled(false); // 결과 버튼 비활성화

            if(count == 1){ //아까 시작버튼 눌러서 카운트가 1이 되었다면

                start.setEnabled(true);

            } else if (count_liar1 ==1) { //시작_거짓1

                start_liar1.setEnabled(true);

            }else if (count_liar2 == 1){ //시작_거짓2

                start_liar2.setEnabled(true);
            }


        }
        tx_success.setGravity(Gravity.CENTER);


//        Toast.makeText(this, result, Toast.LENGTH_SHORT).show(); //결과 값 메세지 띄우기


    }
    //초기화 버튼
    public void Reset(View view) {

        num = 0;
        num0 =0;
        num1 = 0;
        num2 = 0;

        count = 0;
        count_liar1 = 0;
        count_liar2 = 0;
        tx_persent1.setText("1P 확률");
        tx_persent2.setText("2P 확률");
        tx_round_winner.setText("결과는?");
        tx_round.setText("ROUND");
        tx_1.setText("?");
        tx_2.setText("?");
        tx_success.setText("");
        Img2.setImageDrawable(null); //자바에서는 처음 알게 된 사실인데  setImageResource 에는 null 이 불가능 그래서 setImageDrawable 씀
        Img1.setImageDrawable(null);
        start.setEnabled(true);

        start_liar1.setEnabled(false);
        start_liar2.setEnabled(false);

    }
    //승부 조작 -> 무조건 1P 승리
    //문자 1P를 누르면 -> 무조건 1P 승리
    public void Liar_1(View view) {

        //15라운드 후에 1P를 눌러서 버튼이 활성화 되는 것을 방지
        if (start_liar1.isEnabled()==false&&start.isEnabled()==false&&winner.isEnabled()==false){

            start.setEnabled(false);
            winner.setEnabled(false);
            start_liar1.setEnabled(false);

        }
        else {

            start.setEnabled(false); //기존에 있던 버튼 비활성화 -> 무작위 승리 버튼 비활성화
            winner.setEnabled(false);
            start_liar1.setEnabled(true); // 무조건 1P 승리 버튼 온

        }

    }

    // 무조건 1P 승리 버튼
    public void START_Liar1(View view) {

        String result = "";
        tx_success.setText(result);

        num++;
        count = 0; //다른 카운터 초기화
        count_liar2 =0; //다른 카운터 초기화
        count_liar1 = 1; // 카운터 증가

        //라운드 증가
        Round = num + " ROUND";
        tx_round.setText(Round);
        tx_round.setGravity(Gravity.CENTER);

        //랜덤 함수 발생
        random = new Random();
        int getInt1 = random.nextInt(3) + 1;
        int getInt2 = random.nextInt(3) + 1;

        //이미지
        int ImgView = R.drawable.img;
        int Img1View = R.drawable.img_1;
        int Img2View = R.drawable.img_2;

        //조작 시작
        if (num >= 5) { //9이상이 라운드가 되었는데

            Log.d("라이엇0", String.valueOf(num)); //라운드 확인

            if (num1 < 5) { //P1의 승리 횟수가 9보다 작다면

                tx_1.setText(hands[getInt1]); //P1은 무작위

                //P1 결과 값에 따라 바뀌게 되는 P2
                if (getInt1 == 1) {
                    Img1.setImageResource(ImgView);
                    tx_2.setText(hands[3]);
                    Img2.setImageResource(Img2View);
                } else if (getInt1 == 2) {
                    Img1.setImageResource(Img1View);
                    tx_2.setText(hands[1]);
                    Img2.setImageResource(ImgView);
                } else {
                    Img1.setImageResource(Img2View);
                    tx_2.setText(hands[2]);
                    Img2.setImageResource(Img1View);
                }

            } else { //P1이 9보다 크면 이미 승리 확정이라 다시 무작위
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
            }

        } else { //9라운드 이하면 일단 무작위
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
        }


//        Toast.makeText(this, "결과 버튼을 클릭해주세요.", Toast.LENGTH_SHORT).show();
        start_liar1.setEnabled(false);
        winner.setEnabled(true);

    }

    //승부 조작 -> 무조건 2P 승리
    //문자 2P를 누르면 -> 무조건 2P 승리
    public void Liar_2(View view) {
        if (start.isEnabled()==false&&winner.isEnabled()==false&&start_liar1.isEnabled()==false&&start_liar2.isEnabled()==false){
            start_liar2.setEnabled(false);
        }else {
            start.setEnabled(false);
            winner.setEnabled(false);
            start_liar1.setEnabled(false);
            start_liar2.setEnabled(true);
        }
    }
    //이하 동문
    public void START_Liar2(View view) {

        String result = "";
        tx_success.setText(result);

        count = 0;
        count_liar1 =0;
        count_liar2 = 1;

        num++;
        Round = num + " ROUND";
        tx_round.setText(Round);
        tx_round.setGravity(Gravity.CENTER);

        random = new Random();
        int getInt1 = random.nextInt(3) + 1;
        int getInt2 = random.nextInt(3) + 1;

        int ImgView = R.drawable.img;
        int Img1View = R.drawable.img_1;
        int Img2View = R.drawable.img_2;

        if (num >= 5) {
            if (num2 < 5) {
                tx_2.setText(hands[getInt2]);

                if (getInt2 == 1) {
                    Img2.setImageResource(ImgView);
                    tx_1.setText(hands[3]);
                    Img1.setImageResource(Img2View);
                } else if (getInt2 == 2) {
                    Img2.setImageResource(Img1View);
                    tx_1.setText(hands[1]);
                    Img1.setImageResource(ImgView);
                } else {
                    Img2.setImageResource(Img2View);
                    tx_1.setText(hands[2]);
                    Img1.setImageResource(Img1View);
                }

            } else {
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
            }

        } else {
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
        }

//        Toast.makeText(this, "결과 버튼을 클릭해주세요.", Toast.LENGTH_SHORT).show();
        start_liar2.setEnabled(false);
        winner.setEnabled(true);
    }


}