package com.example.realnona2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class test_userActivity extends AppCompatActivity {
    private TextView UserinfoNum,UserinfoName,UserinfoClass,UserinfoSex;
    private Button Logout,testbtn;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_user);

        UserinfoNum = findViewById(R.id.UserinfoNum);
        UserinfoName = findViewById(R.id.UserinfoName);
        UserinfoClass = findViewById(R.id.UserinfoClass);
        UserinfoSex = findViewById(R.id.UserinfoSex);
        testbtn= findViewById(R.id.testbtn);
        mContext = this;
        Logout = findViewById(R.id.Logout);

        String Userdata1 = Loginsave.getString(mContext,"UserNum");
        String Userdata2 = Loginsave.getString(mContext,"UserName");
        String Userdata3 = Loginsave.getString(mContext,"UserClass");
        String Userdata4 = Loginsave.getString(mContext,"UserSex");

        UserinfoNum.setText(Userdata1);
        UserinfoName.setText(Userdata2);
        UserinfoClass.setText(Userdata3);
        UserinfoSex.setText(Userdata4);

        testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*회원탈퇴 들어갈 부분*/

            }
        });




      //로그아웃 버튼
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Loginsave.clear(mContext);

                Toast.makeText( getApplicationContext(), String.format("로그아웃 되었습니당!"), Toast.LENGTH_SHORT ).show();
                Intent intent3 = new Intent( test_userActivity.this, F_F_Login_form_Activity.class );
                startActivity( intent3 );



            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.l_f_act_chg_slide_left_enter,R.anim.l_f_act_chg_slide_left_exit);
    }


}