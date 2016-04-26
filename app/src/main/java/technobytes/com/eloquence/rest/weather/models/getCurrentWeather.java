
package technobytes.com.eloquence.rest.weather.models;


import technobytes.com.eloquence.rest.weather.models.CurrentObservations.current_observation;
import technobytes.com.eloquence.rest.weather.models.Response.response;
import technobytes.com.eloquence.rest.weather.models.forecast.forecast;
import technobytes.com.eloquence.rest.weather.models.hourly_forecast.hourly_forecast;

/**
 * Created by Michael Leffert on 11/12/2015.
 */
public class getCurrentWeather {

    response response;
    current_observation current_observation;
    forecast forecast;
    hourly_forecast[] hourly_forecast;

    public technobytes.com.eloquence.rest.weather.models.Response.response getResponse() {
        return response;
    }

    public void setResponse(technobytes.com.eloquence.rest.weather.models.Response.response response) {
        this.response = response;
    }

    public technobytes.com.eloquence.rest.weather.models.CurrentObservations.current_observation getCurrent_observation() {
        return current_observation;
    }

    public void setCurrent_observation(technobytes.com.eloquence.rest.weather.models.CurrentObservations.current_observation current_observation) {
        this.current_observation = current_observation;
    }

    public technobytes.com.eloquence.rest.weather.models.forecast.forecast getForecast() {
        return forecast;
    }

    public void setForecast(technobytes.com.eloquence.rest.weather.models.forecast.forecast forecast) {
        this.forecast = forecast;
    }

    public technobytes.com.eloquence.rest.weather.models.hourly_forecast.hourly_forecast[] getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(technobytes.com.eloquence.rest.weather.models.hourly_forecast.hourly_forecast[] hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }
}
