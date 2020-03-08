package com.example.modulea;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.arouterIService.MyLoginService;
import com.example.commonmodule.constants.PathConstants;
/**
 * 首页
 */
@Route(path = PathConstants.HOME_PATH)
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mLayout = inflater.inflate(R.layout.fragment_home, container, false);
        Button btn_go_detail = mLayout.findViewById(R.id.btn_go_detail);
        Button btn_get_login_info = mLayout.findViewById(R.id.btn_get_login_info);
        Button btn_location_min = mLayout.findViewById(R.id.btn_location_min);

        btn_go_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConstants.FIND_DETAIL_PATH).navigation(getActivity());
            }
        });
        btn_get_login_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyLoginService loginService = (MyLoginService) ARouter.getInstance().build("/login/service").navigation();
                String name = loginService.getName("我是测试");
                Log.e("测试",name);
                Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT).show();
            }
        });
        btn_location_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConstants.MAIN_ACTIVITY_PATH)
                        .withInt("index",1)
                        .withBoolean("isExit",false)
                        .navigation(getActivity());
            }
        });

        return mLayout;
    }

}
