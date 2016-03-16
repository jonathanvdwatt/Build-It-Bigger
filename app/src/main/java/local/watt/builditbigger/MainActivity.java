package local.watt.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;

import local.watt.androidjokelib.JokeActivity;
import local.watt.builditbigger.interfaces.OnTaskCompleted;
import local.watt.builditbigger.tasks.FetchJokeTask;
import local.watt.javajokelib.JokeBook;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements OnTaskCompleted<JokeBook> {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Intent mIntent;

    @InjectView(R.id.button) Button mButton;
    @InjectView(R.id.progessbar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        Log.d(TAG, "onCreate");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.VISIBLE);
                tellJoke(v);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        mProgressBar.setVisibility(View.GONE);
        mButton.setVisibility(View.VISIBLE);
    }

    private void tellJoke(View v) {
        Log.d(TAG, "tellJoke()");
        new FetchJokeTask().execute(new Pair<Context, OnTaskCompleted<JokeBook>>(this, this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onComplete(String result) {
        Log.d(TAG, result);
        mIntent = new Intent(this, JokeActivity.class);
        mIntent.putExtra(JokeActivity.INCOMING_JOKE, result);
        startActivity(mIntent);
    }

    @Override
    public void onError(Throwable error) {

    }
}
