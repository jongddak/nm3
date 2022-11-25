package com.example.realnona2;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class F_F_SighUp_form_Request extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://nonaphp.dothome.co.kr/Register2.php";
    private Map<String, String> map;
    //private Map<String, String>parameters;

    public F_F_SighUp_form_Request(String UserNum, String UserPwd, String UserName, String UserClass, String UserSex, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("UserNum", UserNum);
        map.put("UserPwd", UserPwd);
        map.put("UserName", UserName);
        map.put("UserClass", UserClass);
        map.put("UserSex", UserSex);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}