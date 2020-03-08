package com.example.modulelogin;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonmodule.arouterIService.MyLoginService;
@Route(path = "/login/service")
public class LoginService implements MyLoginService {

    @Override
    public String getName(String name) {
        return name + "自定义的名称";
    }

    @Override
    public void init(Context context) {

    }
}
