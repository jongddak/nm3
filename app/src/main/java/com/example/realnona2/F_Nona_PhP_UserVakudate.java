package com.example.realnona2;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class F_Nona_PhP_UserVakudate extends StringRequest {
    //서버 url 설정(php파일 연동)
    final static  private String URL="http://nonaphp.dothome.co.kr/UserValidate.php";
    private final Map<String, String> map;

    public F_Nona_PhP_UserVakudate(String UserEmail, Response.Listener<String> listener){
        super(Method.POST, URL, listener,null);

        map = new HashMap<>();
        map.put("UserEmail", UserEmail);
    }

    @Override
    protected Map<String, String> getParams()throws AuthFailureError {
        return map;
    }
}