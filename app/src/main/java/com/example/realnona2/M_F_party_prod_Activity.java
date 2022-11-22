package com.example.realnona2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class M_F_party_prod_Activity extends AppCompatActivity {

    EditText M_V_pp_store, M_V_pp_name, M_V_pp_openchat; // 가게명, 파티명, 채팅방 링크
    RadioButton M_V_pp_pf_radio_bm, M_V_pp_pf_radio_yo, M_V_pp_pf_radio_cu, M_V_pp_pay1_gather, M_V_pp_pay2_meet, M_V_pp_pay3_first; // 플랫폼, 결제수단
    Button M_V_pp_create_btn; // 생성버튼
    Button M_V_pp_pn_1, M_V_pp_pn_2, M_V_pp_pn_3, M_V_pp_pn_4, M_V_pp_pn_5, M_V_pp_pn_6; // 인원
    Button M_V_pp_date_today, M_V_pp_date_tomorrow; // 오늘, 내일
    TimePicker M_V_pp_date_TimePicker; // 시간
    TextView M_V_pp_order; // 선택내역 표시

    String M_V_pp_pt_store = "가게명";
    String options1 = "배달업체";
    String options2 = "인원";
    String options3 = "주문일";
    String options4 = "주문시간";
    String options5 = "위치";
    String options6 = "결제방법";
    String M_V_pp_pt_title = "파티명";
    String M_V_pp_pt_link = "링크";
    String[] category = {"음식 카테고리를 선택해주세요.", "고기", "도시락", "양식", "일식", "중식", "치킨", "카페", "피자", "패스트푸드", "한식"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_f_activity_party_prod);

        M_V_pp_store = findViewById(R.id.M_V_pp_store);
        M_V_pp_name = findViewById(R.id.M_V_pp_name);
        M_V_pp_openchat = findViewById(R.id.M_V_pp_openchat);
        M_V_pp_pf_radio_bm = findViewById(R.id.M_V_pp_pf_radio_bm);
        M_V_pp_pf_radio_yo = findViewById(R.id.M_V_pp_pf_radio_yo);
        M_V_pp_pf_radio_cu = findViewById(R.id.M_V_pp_pf_radio_cu);
        M_V_pp_pay1_gather = findViewById(R.id.M_V_pp_pay_gather);
        M_V_pp_pay2_meet = findViewById(R.id.M_V_pp_pay2_meet);
        M_V_pp_pay3_first = findViewById(R.id.pay_3);
        M_V_pp_create_btn = findViewById(R.id.M_V_pp_create_btn);
        M_V_pp_pn_1 = findViewById(R.id.M_V_pp_pn_1);
        M_V_pp_pn_2 = findViewById(R.id.M_V_pp_pn_2);
        M_V_pp_pn_3 = findViewById(R.id.M_V_pp_pn_3);
        M_V_pp_pn_4 = findViewById(R.id.M_V_pp_pn_4);
        M_V_pp_pn_5 = findViewById(R.id.M_V_pp_pn_5);
        M_V_pp_pn_6 = findViewById(R.id.M_V_pp_pn_6);
        M_V_pp_date_today = findViewById(R.id.M_V_pp_date_today);
        M_V_pp_date_tomorrow = findViewById(R.id.M_V_pp_date_tomorrow);
        M_V_pp_date_TimePicker = findViewById(R.id.M_V_pp_date_TimePicker);
        M_V_pp_order = findViewById(R.id.M_V_pp_order);
    }
}