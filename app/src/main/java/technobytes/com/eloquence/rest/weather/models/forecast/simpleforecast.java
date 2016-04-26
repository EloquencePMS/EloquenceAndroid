package technobytes.com.eloquence.rest.weather.models.forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class simpleforecast {

    simpleforecastday [] forecastday;

    public simpleforecastday[] getForecastday() {
        return forecastday;
    }

    public void setForecastday(simpleforecastday[] forecastday) {
        this.forecastday = forecastday;
    }
}
