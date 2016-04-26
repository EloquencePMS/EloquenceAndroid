package technobytes.com.eloquence.rest.weather.models.forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class txt_forecast {
    String date;
    txtforecastday [] forecastday;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public txtforecastday[] getForecastday() {
        return forecastday;
    }

    public void setForecastday(txtforecastday[] forecastday) {
        this.forecastday = forecastday;
    }
}
