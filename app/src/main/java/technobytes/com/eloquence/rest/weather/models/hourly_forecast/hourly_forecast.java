package technobytes.com.eloquence.rest.weather.models.hourly_forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class hourly_forecast {

    FCTTIME FCTTIME;
    measurment temp, dewpoint, wspd, windchill, heatindex, feelslike, qpf, snow, mslp;
    direction wdir;
    String condition, icon, icon_url, fctcode, sky, wx, uvi, humidity, pop;

    public FCTTIME getFCTTIME() {
        return FCTTIME;
    }

    public void setFCTTIME(FCTTIME FCTTIME) {
        this.FCTTIME = FCTTIME;
    }

    public measurment getTemp() {
        return temp;
    }

    public void setTemp(measurment temp) {
        this.temp = temp;
    }

    public measurment getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(measurment dewpoint) {
        this.dewpoint = dewpoint;
    }

    public measurment getWspd() {
        return wspd;
    }

    public void setWspd(measurment wspd) {
        this.wspd = wspd;
    }

    public measurment getWindchill() {
        return windchill;
    }

    public void setWindchill(measurment windchill) {
        this.windchill = windchill;
    }

    public measurment getHeatindex() {
        return heatindex;
    }

    public void setHeatindex(measurment heatindex) {
        this.heatindex = heatindex;
    }

    public measurment getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(measurment feelslike) {
        this.feelslike = feelslike;
    }

    public measurment getQpf() {
        return qpf;
    }

    public void setQpf(measurment qpf) {
        this.qpf = qpf;
    }

    public measurment getSnow() {
        return snow;
    }

    public void setSnow(measurment snow) {
        this.snow = snow;
    }

    public measurment getMslp() {
        return mslp;
    }

    public void setMslp(measurment mslp) {
        this.mslp = mslp;
    }

    public direction getWdir() {
        return wdir;
    }

    public void setWdir(direction wdir) {
        this.wdir = wdir;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public String getFctcode() {
        return fctcode;
    }

    public void setFctcode(String fctcode) {
        this.fctcode = fctcode;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getUvi() {
        return uvi;
    }

    public void setUvi(String uvi) {
        this.uvi = uvi;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }
}
