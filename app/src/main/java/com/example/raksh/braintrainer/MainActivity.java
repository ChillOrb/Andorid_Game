package com.example.raksh.braintrainer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int sum,a,b, scorea=0,scoreb=0,scoreaa,scorebb;
    long second;
    double aa,bb;
    CountDownTimer cd;
    TextView sec;
    TextView tex;
    TextView tvs;
    TextView tsum;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    int count=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        second=30;scorea=0;scoreb=0;aa=1;bb=1;
        count=1;
        sec= (TextView) findViewById(R.id.textsec);
        tex= (TextView)findViewById(R.id.textView);
        tvs= (TextView) findViewById(R.id.textscore);
        tsum=(TextView) findViewById(R.id.textsum);
        tv1=(TextView) findViewById(R.id.text1);
        tv2=(TextView) findViewById(R.id.text2);
        tv3=(TextView) findViewById(R.id.text3);
        tex.setVisibility(View.INVISIBLE);
        tv4=(TextView) findViewById(R.id.text4);


        change();

        cd= new CountDownTimer(second*1000,1000) {
            public void onTick(long milli) {

                second = milli / 1000;
                String nu = "" + second;
                sec.setText(nu);

            }

            public void onFinish() {

                display();
            }

        }.start();

    }




    public void check(View view)
    {
        TextView tv= (TextView)view;
        int n = Integer.parseInt(tv.getText().toString());
        if (n==sum)
        {tex.setVisibility(View.VISIBLE);
            scorea++;
            tex.setText("Correct!");
            if(count==-1) {
                aa+=0.5;
            }
            else{
                bb=bb+0.5;
            }
            count*=-1;


        }
        else {
            tex.setVisibility(View.VISIBLE);

            tex.setText("Incorrect");
        }
        scoreb++;

        tvs.setText(scorea+"/"+scoreb);



        change();


    }

    public void change()
    {
        Random rand= new Random();
        int ans[ ]=new int[4];
        a= (int) (rand.nextInt(21)*aa);
        b=(int)(rand.nextInt(21)*bb);
        sum=a+b;


        tsum.setText(a + " + " + b);
        int tagg=rand.nextInt(4);
        int wrong;
        int an=(int)(aa>bb?aa:bb);
        for(int i=0;i<=3;++i)
        {
            if(i==tagg)
            {
                ans[i]=sum;
            }
            else
            {
                wrong=rand.nextInt(41);
                while (wrong== a+b)
                {
                    wrong=rand.nextInt(41)*an;

                }
                ans[i]=wrong;
            }


        }



        tv1.setText(Integer.toString(ans[0]));
        tv2.setText(Integer.toString(ans[1]));
        tv3.setText(Integer.toString(ans[2]));
        tv4.setText(Integer.toString(ans[3]));

    }


    public void display()
    {
        tv1.setEnabled(false);
        tv2.setEnabled(false);
        tv3.setEnabled(false);
        tv4.setEnabled(false);

        sec.setText("0");

        Log.i("Score",scorea +"  "+scoreb);
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("Numerator", scorea);
        intent.putExtra("Denominator", scoreb);
        startActivity(intent);

    }




}
