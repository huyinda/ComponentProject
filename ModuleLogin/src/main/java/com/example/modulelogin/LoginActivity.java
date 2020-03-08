package com.example.modulelogin;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonmodule.constants.PathConstants;
import com.example.commonmodule.utils.sp.SPUtils;
@Route(path = PathConstants.LOGIN_PATH,extras = 0)
public class LoginActivity extends AppCompatActivity {

    private EditText edit_name;
    private EditText edit_psw;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_name = findViewById(R.id.edit_name);
        edit_psw = findViewById(R.id.edit_psw);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edit_psw.getText().toString())){
                    Toast.makeText(LoginActivity.this,"请输入账号密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                SPUtils.put(LoginActivity.this,"login",true);
                finish();
            }
        });
    }
}
