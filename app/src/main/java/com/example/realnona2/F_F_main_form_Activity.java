package com.example.realnona2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.realnona2.fragment.FragmentShare;
import com.example.realnona2.fragment.FragmentWith;
import com.example.realnona2.fragment.FragmentWith;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class F_F_main_form_Activity extends AppCompatActivity implements View.OnClickListener {

    private Animation fab_open, fab_close,fab_oanim,fab_canim;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;
    private TextView F_V_main_share_tx, F_V_main_with_tx;
    private FragmentShare fragmentShare;
    private FragmentWith fragmentWith;

   /* private WebView webView;*/
   /* private String url = "https://m.naver.com";*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_f_activity_main);

        /*fragmentShare = new FragmentShare();
        fragmentWith = new FragmentWith();*/

        F_V_main_share_tx =findViewById(R.id.F_V_main_share_tx);
        F_V_main_with_tx = findViewById(R.id.F_V_main_with_tx);

        F_V_main_share_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F_F_main_form_Activity.this, M_F_Borad_share_Activity.class);
                //건너갈 액티비티를 정해둔 인텐트 객체 선언

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(F_V_main_share_tx,"nonatxTransition");
                //액티비티에서 움직일 뷰와 트랜지션이름을 Pair배열에 담아둔다.

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(F_F_main_form_Activity.this, pairs);
                //액티비티 옵션을 적용하기 위해 ActivityOptions객체를 만들고 트랜지션 에니메이션에 대한 설정을 넣는다

                startActivity(intent,options.toBundle());
                overridePendingTransition(R.anim.l_f_act_chg_slide_right_enter,R.anim.l_f_act_chg_slide_right_exit);
                /*FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.fragmentFrame, fragmentShare);
                ft1.commit();*/
            }
        });
        F_V_main_with_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F_F_main_form_Activity.this, M_F_Borad_with_Activity.class);
                //건너갈 액티비티를 정해둔 인텐트 객체 선언

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(F_V_main_with_tx,"withtxTransition");
                //액티비티에서 움직일 뷰와 트랜지션이름을 Pair배열에 담아둔다.

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(F_F_main_form_Activity.this, pairs);
                //액티비티 옵션을 적용하기 위해 ActivityOptions객체를 만들고 트랜지션 에니메이션에 대한 설정을 넣는다

                startActivity(intent,options.toBundle());
                overridePendingTransition(R.anim.l_f_act_chg_slide_right_enter,R.anim.l_f_act_chg_slide_right_exit);
               /* FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.fragmentFrame, fragmentWith);
                ft1.commit();*/
            }
        });

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.)*/



       /* webView = findViewById(R.id.webView);*/

        /*webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());//크롬에 세팅
        webView.setWebViewClient(new WebViewClient());//웹 뷰에 대한 클라이언트*/
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.l_f_fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.l_f_fab_close);
        fab_oanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.l_f_fab_oanim);
        fab_canim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.l_f_fab_canim);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);


    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //onkeydown 특정 안드로이드 key 값을 입력하게 되면 어떠한 동작을 하라
        if((keyCode== KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }//뒤로가기 동작*/



    /*private class WebViewClientClass extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }*/

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fab:
                anim();

                break;
            case R.id.fab1:
                anim();
                next();
                break;
            case R.id.fab2:
                anim();
                alert();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.l_f_act_chg_slide_left_enter,R.anim.l_f_act_chg_slide_left_exit);
    }

    private void next() {
        Intent intent = new Intent(F_F_main_form_Activity.this, test_userActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.l_f_act_chg_slide_right_enter,R.anim.l_f_act_chg_slide_right_exit);
    }

    private void alert() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        LayoutInflater inflater= getLayoutInflater();
        View view = inflater.inflate(R.layout.l_f_setting_dialog_btn, null);
        //view.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); 어찌쓸지 고민.
        builder.setView(view);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast t= Toast.makeText(F_F_main_form_Activity.this, "OK", Toast.LENGTH_SHORT);
                t.show();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast t= Toast.makeText(F_F_main_form_Activity.this, "CANCEL", Toast.LENGTH_SHORT);
                t.show();
            }
        });
        AlertDialog dialog= builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }


    private void anim() {
        if (isFabOpen) {
            fab.startAnimation(fab_oanim);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
        } else {
            fab.startAnimation(fab_canim);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
        }
    }


}
