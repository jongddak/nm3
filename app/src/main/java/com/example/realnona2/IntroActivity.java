package com.example.realnona2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    private Context mContext;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mContext = this;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                String text = Loginsave.getString(mContext, "succ");

                if(text.equals("succ")){
                    Intent intent = new Intent (getApplicationContext(), F_F_main_form_Activity.class);
                    startActivity(intent); //인트로 실행 후 로그인 되어있으면 메인 아니면 로그인창으로
                    finish();
                }
                else {
                    Intent intent1 = new Intent (getApplicationContext(), F_F_Login_form_Activity.class);
                    startActivity(intent1);
                    finish();
                }}
        },1000); //1초 후 인트로 실행
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
