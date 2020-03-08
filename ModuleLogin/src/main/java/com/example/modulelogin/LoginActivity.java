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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = PathConstants.LOGIN_PATH,extras = 0)
public class LoginActivity extends AppCompatActivity {
    @BindView(R2.id.edit_name)
    EditText edit_name;
    @BindView(R2.id.edit_psw)
    EditText edit_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R2.id.btn_login)
    public void onClick(View view){
        if(TextUtils.isEmpty(edit_psw.getText().toString())){
            Toast.makeText(LoginActivity.this,"请输入账号密码",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(LoginActivity.this,edit_name.getText().toString(),Toast.LENGTH_SHORT).show();
        SPUtils.put(LoginActivity.this,"login",true);
        finish();
    }
}
