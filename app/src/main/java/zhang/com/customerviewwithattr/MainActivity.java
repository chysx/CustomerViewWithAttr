package zhang.com.customerviewwithattr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLog();
        setContentView(R.layout.activity_main);

    }

    private void initLog(){
        Logger.init(TAG).logLevel(LogLevel.FULL);
    }

}
