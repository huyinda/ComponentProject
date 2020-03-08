package debug;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonmodule.constants.PathConstants;

public class LaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().build(PathConstants.SPLASH_ACTIVITY_PATH).navigation();
        finish();
    }
}
