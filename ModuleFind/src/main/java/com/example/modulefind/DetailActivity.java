package com.example.modulefind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.constants.PathConstants;

/**
 * 详情页面----需要登录
 * extras=1代表此页面需要登录
 */
@Route(path = PathConstants.FIND_DETAIL_PATH,extras = 1)
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        findViewById(R.id.tv_go_min).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConstants.MAIN_ACTIVITY_PATH)
                        .withInt("index",3)
                        .withBoolean("isExit",false)
                        .navigation();
            }
        });
    }
}
