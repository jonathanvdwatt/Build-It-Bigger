package local.watt.builditbigger.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import com.appspot.jokeapi_1251.jokeapi.Jokeapi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import java.io.IOException;
import local.watt.builditbigger.interfaces.OnTaskCompleted;
import local.watt.javajokelib.JokeBook;

/**
 * Created by f4720431 on 2016/03/13.
 */
public class FetchJokeTask extends AsyncTask<Pair<Context, OnTaskCompleted<JokeBook>>, Void, String> {
    private static final String TAG = FetchJokeTask.class.getSimpleName();
    private static Jokeapi jokeApiService = null;
    private OnTaskCompleted<JokeBook> delegate;

    @Override
    protected String doInBackground(Pair<Context, OnTaskCompleted<JokeBook>>... params) {
        if(jokeApiService == null) {
            Jokeapi.Builder builder = new Jokeapi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokeapi-1251.appspot.com/_ah/api");

            jokeApiService = builder.build();
        }

        delegate = params[0].second;

        try {
            return jokeApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        this.delegate.onComplete(result);
    }
}