package technobytes.com.eloquence.rest;

import android.util.Log;

import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.RequiresHeader;
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
import org.springframework.util.LinkedMultiValueMap;

import java.io.IOException;

import technobytes.com.eloquence.rest.responses.AuthenticateLogin;
import technobytes.com.eloquence.rest.responses.LoadCalendarAvailability;
import technobytes.com.eloquence.rest.responses.LoadInitialData;


/**
 * Created by Michael Leffert on 12/8/2015.
 */


@Rest(rootUrl = "http://ec2-52-36-222-216.us-west-2.compute.amazonaws.com:5000", converters = { FormHttpMessageConverter.class, GsonHttpMessageConverter.class, ByteArrayHttpMessageConverter.class}, interceptors = {HTTPLoggingInterceptor.class})
public interface Data extends RestClientHeaders, RestClientErrorHandling, RestClientRootUrl {
        void setRootUrl(String rootUrl);

    void setHeader(String name, String value);
    String getHeader(String name);

      @Post("/authenticate/")
      AuthenticateLogin authenticateLogin(@Body LinkedMultiValueMap<String, String> formData);

      @Get("/loadCalendar/{year}/{month}/{date}")
      @RequiresHeader("x-access-token")
      LoadCalendarAvailability getCalendarAvailability(@Path String year, @Path String month, @Path String date);

      @Get("/loadInitialData")
      @RequiresHeader("x-access-token")
      LoadInitialData loadInitialData();

}

class HTTPLoggingInterceptor implements ClientHttpRequestInterceptor {
    public static final String TAG = "CALL_RESTCLIENT";

    public HTTPLoggingInterceptor() {
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] data, ClientHttpRequestExecution execution) throws IOException {
        Log.v(TAG, request.getMethod() + " [URI] => " + request.getURI());
        Log.v(TAG, request.getMethod() + " [DATA] =>" + data);
        Log.v(TAG, request.getMethod() + " [HEADERS] => " + request.getHeaders());

        return execution.execute(request, data);
    }
}
