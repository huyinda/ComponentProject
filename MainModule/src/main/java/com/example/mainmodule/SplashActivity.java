package com.example.mainmodule;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.constants.PathConstants;

/**
 * 整个项目的启动页面
 */
@Route(path = PathConstants.SPLASH_ACTIVITY_PATH)
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build(PathConstants.MAIN_ACTIVITY_PATH).navigation();
                finish();
            }
        },2000);
    }
}
