package com.example.realnona2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class F_F_SighUp_form_Activity extends AppCompatActivity {

    private EditText userNum, userName,userClass,userSex,F_V_signup_pwd,  F_V_signup_pwd_ck;
    private Button signup_btn, check_button,delete;
    private AlertDialog dialog;
    private boolean validate = false;
    /*private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2;
    private int state;
    private int sex;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.f_f_activity_signup);

        //아이디값 찾아주기
        userNum = findViewById( R.id.userNum);
        userName = findViewById( R.id.userName);
        userClass = findViewById( R.id.userClass);
        userSex = findViewById( R.id.userSex);
        delete = findViewById(R.id.delete);
/*

        radioGroup =findViewById(R.id.radiogroup);
        radioButton1 =findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
*/

        F_V_signup_pwd = findViewById( R.id.F_V_signup_pwd);
        F_V_signup_pwd_ck = findViewById(R.id.F_V_signup_pwd_ck);

        signup_btn = findViewById(R.id.signup_btn);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F_F_SighUp_form_Activity.this, F_F_Login_form_Activity.class);
                startActivity(intent);

            }
        });



        //아이디 중복 체크
        check_button = findViewById(R.id.check_button);

        check_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String UserNum = userNum.getText().toString();
                if (validate) {
                    return; //검증 완료
                }

                if (UserNum.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(F_F_SighUp_form_Activity.this);
                    dialog = builder.setMessage("학번을 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = response -> {
                    try {

                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");

                        AlertDialog.Builder builder = new AlertDialog.Builder(F_F_SighUp_form_Activity.this);
                        if (success) {
                            dialog = builder.setMessage("사용할 수 있는 학번입니다.").setPositiveButton("확인", null).create();
                            dialog.show();
                            userNum.setEnabled(false); //아이디값 고정
                            validate = true; //검증 완료
                            check_button.setBackgroundColor(getResources().getColor(R.color.gray));
                        }
                        else {
                            dialog = builder.setMessage("이미 존재하는 학번입니다.").setNegativeButton("확인", null).create();
                            dialog.show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                };
                F_F_php_UserVakudate validateRequest = new F_F_php_UserVakudate(UserNum, responseListener);
                RequestQueue queue = Volley.newRequestQueue(F_F_SighUp_form_Activity.this);
                queue.add(validateRequest);
            }
        });


    /*    RadioButton radioButton1 = findViewById( radioGroup.getCheckedRadioButtonId() );
        RadioButton radioButton2 = findViewById( radioGroup.getCheckedRadioButtonId() );
*/


        //회원가입 버튼 클릭 시 수행

        signup_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String UserNum = userNum.getText().toString();
                final String UserPwd = F_V_signup_pwd.getText().toString();
                final String UserName = userName.getText().toString();
                final String UserClass = userClass.getText().toString();
                final String UserSex = userSex.getText().toString();
                final String PassCk = F_V_signup_pwd_ck.getText().toString();

                //성별 학과 값넘기기 어려움....




                //아이디 중복체크 했는지 확인
                if (!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(F_F_SighUp_form_Activity.this);
                    dialog = builder.setMessage("중복된 학번이 있는지 확인하세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //한 칸이라도 입력 안했을 경우
                if (UserNum.equals("") || UserPwd.equals("") || UserName.equals("")) {
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
                F_F_SighUp_form_Request FFSighUpformRequest = new F_F_SighUp_form_Request( UserNum, UserPwd, UserName, UserClass, UserSex, responseListener);
                RequestQueue queue = Volley.newRequestQueue( F_F_SighUp_form_Activity.this );
                queue.add(FFSighUpformRequest);

            }
        });
    }
}