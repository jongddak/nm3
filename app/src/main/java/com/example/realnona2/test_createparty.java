package com.example.cap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class test_createparty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_createparty);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.l_f_act_chg_slide_left_enter,R.anim.l_f_act_chg_slide_left_exit);
    }
}