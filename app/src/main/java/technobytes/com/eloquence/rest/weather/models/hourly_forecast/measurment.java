package technobytes.com.eloquence.rest.weather.models.hourly_forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class measurment {
    String english, metric;

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}
