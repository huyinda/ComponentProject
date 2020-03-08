package com.example.mainmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.base.BaseActivity;
import com.example.commonmodule.constants.PathConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * 整个项目的首页----在此页面，将各个业务模块集中起来
 */
@Route(path = PathConstants.MAIN_ACTIVITY_PATH,extras = 0)
public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private LinearLayout linear_bottom;
    private List<Fragment> list_fragment = new ArrayList<>();
    private CustomViewPagerAdapter mCustomViewPagerAdapter;

    @Autowired(name = "index")
    protected int mIndex;
    @Autowired(name = "isExit")
    protected boolean mIsExit;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mViewPager.setCurrentItem(mIndex);
        if(mIsExit){
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        mViewPager = findViewById(R.id.viewPager);
        linear_bottom = findViewById(R.id.linear_btn);
        mCustomViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mCustomViewPagerAdapter);
        setTabClick();
        setTabState(mIndex);
        if(mIsExit){
            finish();
        }
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setTabState(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });
    }

    /**
     * 初始化获取4个片段
     */
    private void initFragment() {
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(PathConstants.HOME_PATH).navigation();
        Fragment findFragment = (Fragment) ARouter.getInstance().build(PathConstants.FIND_HOME_PATH).navigation();
        Fragment mineFragment = (Fragment) ARouter.getInstance().build(PathConstants.MINE_HOME_PATH).navigation();
        list_fragment.add(homeFragment);
        list_fragment.add(findFragment);
        list_fragment.add(mineFragment);
    }

    private void setTabClick() {
        for (int position = 0;position < linear_bottom.getChildCount();position++){
            TextView tv_tab = (TextView) linear_bottom.getChildAt(position);
            final int finalPosition = position;
            tv_tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(finalPosition);
                }
            });
        }
    }

    private void setTabState(int selectPosition){
        for (int position = 0;position < linear_bottom.getChildCount();position++){
            TextView tv_tab = (TextView) linear_bottom.getChildAt(position);
            tv_tab.setSelected(selectPosition == position);
        }
    }

    class CustomViewPagerAdapter extends FragmentPagerAdapter {

        public CustomViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list_fragment.get(position);
        }

        @Override
        public int getCount() {
            return list_fragment.size();
        }
    }
}
