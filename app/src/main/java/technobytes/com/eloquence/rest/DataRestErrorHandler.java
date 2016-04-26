package technobytes.com.eloquence.rest;

import android.util.Log;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.api.RestErrorHandler;
import org.springframework.core.NestedRuntimeException;

/**
 * Created by Michael Leffert on 12/8/2015.
 */
@EBean
public class DataRestErrorHandler  implements RestErrorHandler {
    public static final String TAG = "CALLS_RESTCLIENT_ERROR";


    @Override
    public void onRestClientExceptionThrown(NestedRuntimeException e) {
        Log.v(TAG, "Rest Error => " + e.getMessage());
    }

}