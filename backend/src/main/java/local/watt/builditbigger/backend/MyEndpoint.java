/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package local.watt.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;


import local.watt.javajokelib.JokeBook;

/**
 * An endpoint class we are exposing
 */

@Api(name="jokeapi", version="v1", description="An API to tell jokes")
public class MyEndpoint {
    private static final String TAG = MyEndpoint.class.getSimpleName();

    @ApiMethod(name="getJoke")
    public MyBean getJoke() {
        JokeBook jokeBook = new JokeBook();
        MyBean response = new MyBean();
        response.setData(jokeBook.getJoke());
        return response;
    }
}


