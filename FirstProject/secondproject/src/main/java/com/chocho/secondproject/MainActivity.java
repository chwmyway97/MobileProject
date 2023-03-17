package com.chocho.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button1.setOnClickListener(mymymy);
    }
    View.OnClickListener mymymy = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"미쳤나",Toast.LENGTH_LONG).show();
        }
    };
}