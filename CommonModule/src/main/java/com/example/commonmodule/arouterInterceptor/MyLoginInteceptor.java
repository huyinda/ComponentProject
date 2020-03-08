package com.example.commonmodule.arouterInterceptor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.constants.PathConstants;
import com.example.commonmodule.utils.sp.SPUtils;

/**
 * 登录拦截器
 */
@Interceptor(priority = 100)
public class MyLoginInteceptor implements IInterceptor {
    private Context mContext;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        int extra = postcard.getExtra();
        if(extra == 1){
            boolean isLogin = (boolean) SPUtils.get(mContext, "login", false);
            if(isLogin){
                callback.onContinue(postcard);
            }else {
                ARouter.getInstance().build(PathConstants.LOGIN_PATH).navigation();
                callback.onInterrupt(null);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mContext,"请先登录",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
    }
}
