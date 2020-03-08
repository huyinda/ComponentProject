package com.android.componentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.constants.PathConstants;

import java.nio.file.Path;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().build(PathConstants.SPLASH_ACTIVITY_PATH).navigation();
        finish();
}
}
