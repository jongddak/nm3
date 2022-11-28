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


    /*회원가입 페이지로 정보 보낼려면 겟셋 두번 하기 or 한번에 보내주는 법 찾기 */


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
        /*
        Intent intent = getIntent();
        final String data1 = intent.getStringExtra("UserNum");
        final String data2 = intent.getStringExtra("UserName");
        final String data3 = intent.getStringExtra("UserClass");
        final String data4 = intent.getStringExtra("UserSex");
*/
        testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserinfoNum.setText(Userdata1);
                UserinfoName.setText(Userdata2);
                UserinfoClass.setText(Userdata3);
                UserinfoSex.setText(Userdata4);

            }
        });

        UserinfoNum.setText(Userdata1);
        UserinfoName.setText(Userdata2);
        UserinfoClass.setText(Userdata3);
        UserinfoSex.setText(Userdata4);



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