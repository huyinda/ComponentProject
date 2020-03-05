package com.example.commonmodule.base;
import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.BuildConfig;
/**
 * 整个项目公共的application,处理统一的初始化
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    /**
     * 初始化ARouter相关配置
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {    // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
