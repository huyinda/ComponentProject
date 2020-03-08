package debug;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.constants.PathConstants;
import com.example.modulelogin.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Fragment fragment = (Fragment) ARouter.getInstance().build(PathConstants.FIND_HOME_PATH).navigation();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.relative_fragment,fragment);
        transaction.commitAllowingStateLoss();

    }
}
