package com.example.realnona2;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.realnona2.fragment.FragmentShare;
import com.example.realnona2.fragment.FragmentWith;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class test_ShareActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentShare fragmentShare;

    private FragmentWith fragmentWith;
    private Animation fab_open, fab_close,fab_oanim,fab_canim;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;
    private ListView M_V_board_share_list;


    String mTitle[]={"브리또","상호명","상호명","상호명","상호명","상호명","상호명","상호명","상호명"};//listview에 title부분 설정
    String mDescription[]={"2시에 브리또 드실 분","글 내용","글 내용","글 내용","글 내용","글 내용","글 내용","글 내용","글 내용"};//listview에 설명부분
    int images[]={R.drawable.ic_food,R.drawable.ic_food,R.drawable.ic_food,R.drawable.ic_food,R.drawable.ic_food,R.drawable.ic_food,R.drawable.ic_food,R.drawable.ic_food,R.drawable.ic_food};
    //listview에 들어가는 사진
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_f_decorate_share_form);


        M_V_board_share_list =(ListView)findViewById(R.id.M_V_board_shear_list);

       MyAdapter adapter=new MyAdapter(this,mTitle,mDescription,images);
        M_V_board_share_list.setAdapter(adapter);//리스트에 어뎁터 설정


        /*fragmentShare = new FragmentShare();
        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.fragmentFrame, fragmentShare);
        ft1.commit();*/
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar(toolbar); //액티비티의 앱바(App Bar)로 지정

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

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.l_f_activity_board_sample, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //앞에서 만든 row xml파일을 view 객체로 만들기 위해서는 layoutInflater를 이용
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View board=layoutInflater.inflate(R.layout.l_f_activity_board_sample,parent,false);

            ImageView images=board.findViewById(R.id.image);
            TextView myTitle=board.findViewById(R.id.textView1);
            TextView myDescription=board.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return board;//앞에서 만든 xml 파일..
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.l_f_menu_toolbar, menu);

        return true;
    }

    //앱바(App Bar)에 표시된 액션 또는 오버플로우 메뉴가 선택되면
    //액티비티의 onOptionsItemSelected() 메서드가 호출
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.item1:
                startActivity (new Intent(this, F_F_main_form_Activity.class));
                overridePendingTransition(R.anim.l_f_act_chg_slide_right_enter,R.anim.l_f_act_chg_slide_right_exit);
                return true;
            case R.id.item2:
                Intent intent =new Intent(this, M_F_party_prod_Activity.class);
                test_ShareActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.l_f_act_chg_slide_right_enter,R.anim.l_f_act_chg_slide_right_exit);
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }

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
                /*fram();*/
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
        Intent intent = new Intent(test_ShareActivity.this, test_userActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.l_f_act_chg_slide_right_enter,R.anim.l_f_act_chg_slide_right_exit);
    }

    private void fram() {
        fragmentWith = new FragmentWith();
        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.fragmentFrame, fragmentWith);
        ft1.commit();
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
                Toast t= Toast.makeText(test_ShareActivity.this, "OK", Toast.LENGTH_SHORT);
                t.show();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast t= Toast.makeText(test_ShareActivity.this, "CANCEL", Toast.LENGTH_SHORT);
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