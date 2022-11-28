package com.example.realnona2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class F_F_Login_form_Activity extends AppCompatActivity {

    private EditText login_email, login_password;
    private Button login_button, join_button;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.f_f_activity_login);

        login_email = findViewById( R.id.login_email );
        login_password = findViewById( R.id.login_password );

        mContext = this;

        join_button = findViewById( R.id.F_V_signup_btn);
        join_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( F_F_Login_form_Activity.this, F_F_SighUp_form_Activity.class );
                startActivity( intent );
            }
        });


        login_button = findViewById( R.id.login_button );
        login_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserNum = login_email.getText().toString();
                String UserPwd = login_password.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {//로그인 성공시

                                Loginsave.setString(mContext, "succ", "succ"); // 로그인 성공시 값 저장

                                String UserNum = jsonObject.getString( "UserNum" );
                                String UserPwd = jsonObject.getString( "UserPwd" );
                                String UserName = jsonObject.getString( "UserName" );
                                String UserClass = jsonObject.getString( "UserClass" );
                                String UserSex = jsonObject.getString( "UserSex" );

                                Toast.makeText( getApplicationContext(), String.format("%s님 환영합니다.", UserName), Toast.LENGTH_SHORT ).show();
                                Intent intent = new Intent( F_F_Login_form_Activity.this, F_F_main_form_Activity.class );

                                Intent intent2 = new Intent(F_F_Login_form_Activity.this,test_userActivity.class);

                                intent2.putExtra( "UserNum", UserNum );
                                intent2.putExtra( "UserPwd", UserPwd );
                                intent2.putExtra( "UserName", UserName );
                                intent2.putExtra( "UserClass", UserClass );
                                intent2.putExtra( "UserSex", UserSex );


                                startActivity( intent );
                               /* startActivity(intent2);*/


                            } else {//로그인 실패시
                                Toast.makeText( getApplicationContext(), "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT ).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                F_F_Login_Request FFLoginRequest = new F_F_Login_Request( UserNum, UserPwd, responseListener );
                RequestQueue queue = Volley.newRequestQueue( F_F_Login_form_Activity.this );
                queue.add(FFLoginRequest);

            }
        });
    }
}