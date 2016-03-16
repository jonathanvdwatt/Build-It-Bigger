package local.watt.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;
import android.util.Pair;

import local.watt.builditbigger.interfaces.OnTaskCompleted;
import local.watt.builditbigger.tasks.FetchJokeTask;
import local.watt.javajokelib.JokeBook;


/**
 * Created by f4720431 on 2016/03/15.
 */
public class AsyncTaskTest extends AndroidTestCase implements OnTaskCompleted<JokeBook> {
    private static final String TAG = AsyncTaskTest.class.getSimpleName();

    public void verifyAsyncTaskResponse() {
        FetchJokeTask fetchJokeTask = new FetchJokeTask();
        fetchJokeTask.execute(new Pair<Context, OnTaskCompleted<JokeBook>>(getContext(), this));
    }

    @Override
    public void onComplete(String result) {
        Log.d(TAG, "onComplete(" + result + ")");
        assertNotNull(result);
    }

    @Override
    public void onError(Throwable error) {
    }
}