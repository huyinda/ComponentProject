package debug;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.constants.PathConstants;
import com.example.modulea.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = (Fragment) ARouter.getInstance().build(PathConstants.MINE_HOME_PATH).navigation();
        transaction.add(R.id.relative_fragment,fragment);
        transaction.commitAllowingStateLoss();
    }
}
