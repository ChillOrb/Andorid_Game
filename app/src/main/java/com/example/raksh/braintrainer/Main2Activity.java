package com.example.raksh.braintrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    int score,scoree;
    TextView texx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        texx= (TextView) findViewById(R.id.textView2);
        Intent mIntent = getIntent();
        score = mIntent.getIntExtra("Numerator", 0);
        scoree = mIntent.getIntExtra("Denominator", 0);

        texx.setText(score+ "/"+ scoree);
    }



    public void cfc (View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }





}
