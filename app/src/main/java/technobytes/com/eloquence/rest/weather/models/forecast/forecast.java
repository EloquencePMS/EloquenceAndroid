package technobytes.com.eloquence.rest.weather.models.forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class forecast {

    simpleforecast simpleforecast;
    txt_forecast txt_forecast;


    public simpleforecast getSimpleforecast() {
        return simpleforecast;
    }

    public void setSimpleforecast(simpleforecast simpleforecast) {
        this.simpleforecast = simpleforecast;
    }

    public txt_forecast getTxt_forecast() {
        return txt_forecast;
    }

    public void setTxt_forecast(txt_forecast txt_forecast) {
        this.txt_forecast = txt_forecast;
    }

}
