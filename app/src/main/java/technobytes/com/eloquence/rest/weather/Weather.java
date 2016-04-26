package technobytes.com.eloquence.rest.weather;

import android.util.Log;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.RestClientErrorHandling;
import org.androidannotations.rest.spring.api.RestClientHeaders;
import org.androidannotations.rest.spring.api.RestClientRootUrl;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.io.IOException;

import technobytes.com.eloquence.rest.weather.models.getCurrentWeather;

/**
 * Created by seisan on 4/20/16.
 */

@Rest(rootUrl = "http://api.wunderground.com/api/c80219bfc61f264a/", converters = { FormHttpMessageConverter.class, GsonHttpMessageConverter.class, ByteArrayHttpMessageConverter.class}, interceptors = {HTTPLoggingInterceptorWeather.class})
public interface Weather extends RestClientHeaders, RestClientErrorHandling, RestClientRootUrl {
    void setRootUrl(String rootUrl);

    @Get("conditions/forecast10day/hourly10day/q/{location}.json")
    getCurrentWeather GetCurrentWeather(@Path String location);


}

class HTTPLoggingInterceptorWeather implements ClientHttpRequestInterceptor {
    public static final String TAG = "CALL_RESTCLIENT";

    public HTTPLoggingInterceptorWeather() {
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] data, ClientHttpRequestExecution execution) throws IOException {
        Log.v(TAG, request.getMethod() + " [URI] => " + request.getURI());
        Log.v(TAG, request.getMethod() + " [DATA] =>" + data);
        Log.v(TAG, request.getMethod() + " [HEADERS] => " + request.getHeaders());

        return execution.execute(request, data);
    }
}