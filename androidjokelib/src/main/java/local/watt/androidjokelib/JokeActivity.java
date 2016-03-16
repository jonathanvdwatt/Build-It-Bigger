package local.watt.androidjokelib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


/**
 * Created by f4720431 on 2016/03/13.
 */
public class JokeActivity extends AppCompatActivity {
    private static final String TAG = JokeActivity.class.getSimpleName();
    public static final String INCOMING_JOKE = "local.watt.androidjokelib.joke";
    private Intent mIntent;
    private String mJoke;
    private TextView mJokeTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity_main);

        Log.d(TAG, "onCreate()");

        mIntent = this.getIntent();
        mJoke = mIntent.getStringExtra(JokeActivity.INCOMING_JOKE);
        mJokeTextview = (TextView) findViewById(R.id.tv_joke);
        mJokeTextview.setText(mJoke);
    }
}
