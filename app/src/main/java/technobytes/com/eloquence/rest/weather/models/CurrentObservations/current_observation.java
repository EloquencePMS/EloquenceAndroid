package technobytes.com.eloquence.rest.weather.models.CurrentObservations;

/**
 * Created by Michael Leffert on 11/12/2015.
 */


public class current_observation {

    image image;
    display_location display_location;
    observation_location observation_location;
    estimated estimated;
    double  temp_f, temp_c, wind_degrees, wind_mph, wind_kph, dewpoint_f, dewpoint_c;
    String station_id, observation_time, observation_time_rfc822, observation_epoch, local_time_rfc822,
            local_epoch, local_tz_short, local_tz_long, local_tz_offset, weather, temperature_string,
            relative_humidity, wind_string, wind_dir, wind_gust_mph, wind_gust_kph, pressure_mb, pressure_in,
            pressure_trend, dewpoint_string, heat_index_string, heat_index_f, heat_index_c, windchill_string,
            windchill_f, windchill_c, feelslike_string, feelslike_f, feelslike_c, visibility_mi, visibility_km,
            solarradiation, UV, precip_1hr_string, precip_1hr_in, precip_1hr_metric, precip_today_string, precip_today_in,
            precip_today_metric, icon, icon_url, forecast_url, history_url, ob_url;

    public current_observation(image image, display_location display_location, observation_location observation_location, estimated estimated, double temp_f, double temp_c, double wind_degrees, double wind_mph, double wind_kph, double dewpoint_f, double dewpoint_c, String station_id, String observation_time, String observation_time_rfc822, String observation_epoch, String local_time_rfc822, String local_epoch, String local_tz_short, String local_tz_long, String local_tz_offset, String weather, String temperature_string, String relative_humidity, String wind_string, String wind_dir, String wind_gust_mph, String wind_gust_kph, String pressure_mb, String pressure_in, String pressure_trend, String dewpoint_string, String heat_index_string, String heat_index_f, String heat_index_c, String windchill_string, String windchill_f, String windchill_c, String feelslike_string, String feelslike_f, String feelslike_c, String visibility_mi, String visibility_km, String solarradiation, String UV, String precip_1hr_string, String precip_1hr_in, String precip_1hr_metric, String precip_today_string, String precip_today_in, String precip_today_metric, String icon, String icon_url, String forecast_url, String history_url, String ob_url) {
        this.image = image;
        this.display_location = display_location;
        this.observation_location = observation_location;
        this.estimated = estimated;
        this.temp_f = temp_f;
        this.temp_c = temp_c;
        this.wind_degrees = wind_degrees;
        this.wind_mph = wind_mph;
        this.wind_kph = wind_kph;
        this.dewpoint_f = dewpoint_f;
        this.dewpoint_c = dewpoint_c;
        this.station_id = station_id;
        this.observation_time = observation_time;
        this.observation_time_rfc822 = observation_time_rfc822;
        this.observation_epoch = observation_epoch;
        this.local_time_rfc822 = local_time_rfc822;
        this.local_epoch = local_epoch;
        this.local_tz_short = local_tz_short;
        this.local_tz_long = local_tz_long;
        this.local_tz_offset = local_tz_offset;
        this.weather = weather;
        this.temperature_string = temperature_string;
        this.relative_humidity = relative_humidity;
        this.wind_string = wind_string;
        this.wind_dir = wind_dir;
        this.wind_gust_mph = wind_gust_mph;
        this.wind_gust_kph = wind_gust_kph;
        this.pressure_mb = pressure_mb;
        this.pressure_in = pressure_in;
        this.pressure_trend = pressure_trend;
        this.dewpoint_string = dewpoint_string;
        this.heat_index_string = heat_index_string;
        this.heat_index_f = heat_index_f;
        this.heat_index_c = heat_index_c;
        this.windchill_string = windchill_string;
        this.windchill_f = windchill_f;
        this.windchill_c = windchill_c;
        this.feelslike_string = feelslike_string;
        this.feelslike_f = feelslike_f;
        this.feelslike_c = feelslike_c;
        this.visibility_mi = visibility_mi;
        this.visibility_km = visibility_km;
        this.solarradiation = solarradiation;
        this.UV = UV;
        this.precip_1hr_string = precip_1hr_string;
        this.precip_1hr_in = precip_1hr_in;
        this.precip_1hr_metric = precip_1hr_metric;
        this.precip_today_string = precip_today_string;
        this.precip_today_in = precip_today_in;
        this.precip_today_metric = precip_today_metric;
        this.icon = icon;
        this.icon_url = icon_url;
        this.forecast_url = forecast_url;
        this.history_url = history_url;
        this.ob_url = ob_url;
    }

    public estimated getEstimated() {
        return estimated;
    }

    public void setEstimated(estimated estimated) {
        this.estimated = estimated;
    }

    public image getImage() {
        return image;
    }

    public void setImage(image image) {
        this.image = image;
    }

    public display_location getDisplay_location() {
        return display_location;
    }

    public void setDisplay_location(display_location display_location) {
        this.display_location = display_location;
    }

    public observation_location getObservation_location() {
        return observation_location;
    }

    public void setObservation_location(observation_location observation_location) {
        this.observation_location = observation_location;
    }

    public double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(double temp_f) {
        this.temp_f = temp_f;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public double getWind_degrees() {
        return wind_degrees;
    }

    public void setWind_degrees(double wind_degrees) {
        this.wind_degrees = wind_degrees;
    }

    public double getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(double wind_mph) {
        this.wind_mph = wind_mph;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public double getDewpoint_f() {
        return dewpoint_f;
    }

    public void setDewpoint_f(double dewpoint_f) {
        this.dewpoint_f = dewpoint_f;
    }

    public double getDewpoint_c() {
        return dewpoint_c;
    }

    public void setDewpoint_c(double dewpoint_c) {
        this.dewpoint_c = dewpoint_c;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public String getObservation_time_rfc822() {
        return observation_time_rfc822;
    }

    public void setObservation_time_rfc822(String observation_time_rfc822) {
        this.observation_time_rfc822 = observation_time_rfc822;
    }

    public String getObservation_epoch() {
        return observation_epoch;
    }

    public void setObservation_epoch(String observation_epoch) {
        this.observation_epoch = observation_epoch;
    }

    public String getLocal_time_rfc822() {
        return local_time_rfc822;
    }

    public void setLocal_time_rfc822(String local_time_rfc822) {
        this.local_time_rfc822 = local_time_rfc822;
    }

    public String getLocal_epoch() {
        return local_epoch;
    }

    public void setLocal_epoch(String local_epoch) {
        this.local_epoch = local_epoch;
    }

    public String getLocal_tz_short() {
        return local_tz_short;
    }

    public void setLocal_tz_short(String local_tz_short) {
        this.local_tz_short = local_tz_short;
    }

    public String getLocal_tz_long() {
        return local_tz_long;
    }

    public void setLocal_tz_long(String local_tz_long) {
        this.local_tz_long = local_tz_long;
    }

    public String getLocal_tz_offset() {
        return local_tz_offset;
    }

    public void setLocal_tz_offset(String local_tz_offset) {
        this.local_tz_offset = local_tz_offset;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature_string() {
        return temperature_string;
    }

    public void setTemperature_string(String temperature_string) {
        this.temperature_string = temperature_string;
    }

    public String getRelative_humidity() {
        return relative_humidity;
    }

    public void setRelative_humidity(String relative_humidity) {
        this.relative_humidity = relative_humidity;
    }

    public String getWind_string() {
        return wind_string;
    }

    public void setWind_string(String wind_string) {
        this.wind_string = wind_string;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getWind_gust_mph() {
        return wind_gust_mph;
    }

    public void setWind_gust_mph(String wind_gust_mph) {
        this.wind_gust_mph = wind_gust_mph;
    }

    public String getWind_gust_kph() {
        return wind_gust_kph;
    }

    public void setWind_gust_kph(String wind_gust_kph) {
        this.wind_gust_kph = wind_gust_kph;
    }

    public String getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(String pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public String getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(String pressure_in) {
        this.pressure_in = pressure_in;
    }

    public String getPressure_trend() {
        return pressure_trend;
    }

    public void setPressure_trend(String pressure_trend) {
        this.pressure_trend = pressure_trend;
    }

    public String getDewpoint_string() {
        return dewpoint_string;
    }

    public void setDewpoint_string(String dewpoint_string) {
        this.dewpoint_string = dewpoint_string;
    }

    public String getHeat_index_string() {
        return heat_index_string;
    }

    public void setHeat_index_string(String heat_index_string) {
        this.heat_index_string = heat_index_string;
    }

    public String getHeat_index_f() {
        return heat_index_f;
    }

    public void setHeat_index_f(String heat_index_f) {
        this.heat_index_f = heat_index_f;
    }

    public String getHeat_index_c() {
        return heat_index_c;
    }

    public void setHeat_index_c(String heat_index_c) {
        this.heat_index_c = heat_index_c;
    }

    public String getWindchill_string() {
        return windchill_string;
    }

    public void setWindchill_string(String windchill_string) {
        this.windchill_string = windchill_string;
    }

    public String getWindchill_f() {
        return windchill_f;
    }

    public void setWindchill_f(String windchill_f) {
        this.windchill_f = windchill_f;
    }

    public String getWindchill_c() {
        return windchill_c;
    }

    public void setWindchill_c(String windchill_c) {
        this.windchill_c = windchill_c;
    }

    public String getFeelslike_string() {
        return feelslike_string;
    }

    public void setFeelslike_string(String feelslike_string) {
        this.feelslike_string = feelslike_string;
    }

    public String getFeelslike_f() {
        return feelslike_f;
    }

    public void setFeelslike_f(String feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public String getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(String feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public String getVisibility_mi() {
        return visibility_mi;
    }

    public void setVisibility_mi(String visibility_mi) {
        this.visibility_mi = visibility_mi;
    }

    public String getVisibility_km() {
        return visibility_km;
    }

    public void setVisibility_km(String visibility_km) {
        this.visibility_km = visibility_km;
    }

    public String getSolarradiation() {
        return solarradiation;
    }

    public void setSolarradiation(String solarradiation) {
        this.solarradiation = solarradiation;
    }

    public String getUV() {
        return UV;
    }

    public void setUV(String UV) {
        this.UV = UV;
    }

    public String getPrecip_1hr_string() {
        return precip_1hr_string;
    }

    public void setPrecip_1hr_string(String precip_1hr_string) {
        this.precip_1hr_string = precip_1hr_string;
    }

    public String getPrecip_1hr_in() {
        return precip_1hr_in;
    }

    public void setPrecip_1hr_in(String precip_1hr_in) {
        this.precip_1hr_in = precip_1hr_in;
    }

    public String getPrecip_1hr_metric() {
        return precip_1hr_metric;
    }

    public void setPrecip_1hr_metric(String precip_1hr_metric) {
        this.precip_1hr_metric = precip_1hr_metric;
    }

    public String getPrecip_today_string() {
        return precip_today_string;
    }

    public void setPrecip_today_string(String precip_today_string) {
        this.precip_today_string = precip_today_string;
    }

    public String getPrecip_today_in() {
        return precip_today_in;
    }

    public void setPrecip_today_in(String precip_today_in) {
        this.precip_today_in = precip_today_in;
    }

    public String getPrecip_today_metric() {
        return precip_today_metric;
    }

    public void setPrecip_today_metric(String precip_today_metric) {
        this.precip_today_metric = precip_today_metric;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getForecast_url() {
        return forecast_url;
    }

    public void setForecast_url(String forecast_url) {
        this.forecast_url = forecast_url;
    }

    public String getHistory_url() {
        return history_url;
    }

    public void setHistory_url(String history_url) {
        this.history_url = history_url;
    }

    public String getOb_url() {
        return ob_url;
    }

    public void setOb_url(String ob_url) {
        this.ob_url = ob_url;
    }



}
