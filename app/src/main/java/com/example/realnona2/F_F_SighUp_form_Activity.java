package com.example.realnona2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class F_F_SighUp_form_Activity extends AppCompatActivity {

    private EditText F_V_signup_email, F_V_signup_pwd, F_V_signup_name, F_V_signup_pwd_ck;
    private Button F_V_signup_btn, F_V_signup_pwd_ck_btn;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.f_f_activity_signup);

        //아이디값 찾아주기
        F_V_signup_email = findViewById( R.id.F_V_signup_email);
        F_V_signup_pwd = findViewById( R.id.F_V_signup_pwd);
        F_V_signup_name = findViewById( R.id.F_V_signup_name);
        F_V_signup_pwd_ck = findViewById(R.id.F_V_signup_pwd_ck);


        //아이디 중복 체크
        F_V_signup_pwd_ck_btn = findViewById(R.id.F_V_signup_pwd_ck_btn);

        F_V_signup_pwd_ck_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String UserEmail = F_V_signup_email.getText().toString();
                if (validate) {
                    return; //검증 완료
                }

                if (UserEmail.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(F_F_SighUp_form_Activity.this);
                    dialog = builder.setMessage("아이디를 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = response -> {
                    try {

                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");

                        AlertDialog.Builder builder = new AlertDialog.Builder(F_F_SighUp_form_Activity.this);
                        if (success) {
                            dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
                            dialog.show();
                            F_V_signup_email.setEnabled(false); //아이디값 고정
                            validate = true; //검증 완료
                            F_V_signup_pwd_ck_btn.setBackgroundColor(getResources().getColor(R.color.gray));
                        }
                        else {
                            dialog = builder.setMessage("이미 존재하는 아이디입니다.").setNegativeButton("확인", null).create();
                            dialog.show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                };
                F_F_php_UserVakudate validateRequest = new F_F_php_UserVakudate(UserEmail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(F_F_SighUp_form_Activity.this);
                queue.add(validateRequest);
            }
        });



        //회원가입 버튼 클릭 시 수행
        F_V_signup_btn = findViewById( R.id.F_V_signup_btn);
        F_V_signup_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String UserEmail = F_V_signup_email.getText().toString();
                final String UserPwd = F_V_signup_pwd.getText().toString();
                final String UserName = F_V_signup_name.getText().toString();
                final String PassCk = F_V_signup_pwd_ck.getText().toString();


                //아이디 중복체크 했는지 확인
                if (!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(F_F_SighUp_form_Activity.this);
                    dialog = builder.setMessage("중복된 아이디가 있는지 확인하세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //한 칸이라도 입력 안했을 경우
                if (UserEmail.equals("") || UserPwd.equals("") || UserName.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(F_F_SighUp_form_Activity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            //회원가입 성공시
                            if(UserPwd.equals(PassCk)) {
                                if (success) {

                                    Toast.makeText(getApplicationContext(), String.format("%s님 가입을 환영합니다.", UserName), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(F_F_SighUp_form_Activity.this, F_F_Login_form_Activity.class);
                                    startActivity(intent);

                                    //회원가입 실패시
                                } else {
                                    Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(F_F_SighUp_form_Activity.this);
                                dialog = builder.setMessage("비밀번호가 동일하지 않습니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청
                F_F_SighUp_form_Request FFSighUpformRequest = new F_F_SighUp_form_Request( UserEmail, UserPwd, UserName, responseListener);
                RequestQueue queue = Volley.newRequestQueue( F_F_SighUp_form_Activity.this );
                queue.add(FFSighUpformRequest);

            }
        });
    }
}