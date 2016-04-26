package technobytes.com.eloquence.rest.weather.models.forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class simpleforecastday {

    date date;
    double period, pop;
    String conditions, icon, icon_url, skyicon, avehumidity, maxhumidity, minhumidity;
    temp high, low;
    percipitation qpf_allday, qpf_day, qpf_night, snow_allday, snow_day, snow_night;
    wind maxwind, avewind;

    public technobytes.com.eloquence.rest.weather.models.forecast.date getDate() {
        return date;
    }

    public void setDate(technobytes.com.eloquence.rest.weather.models.forecast.date date) {
        this.date = date;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
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

    public String getSkyicon() {
        return skyicon;
    }

    public void setSkyicon(String skyicon) {
        this.skyicon = skyicon;
    }

    public String getAvehumidity() {
        return avehumidity;
    }

    public void setAvehumidity(String avehumidity) {
        this.avehumidity = avehumidity;
    }

    public String getMaxhumidity() {
        return maxhumidity;
    }

    public void setMaxhumidity(String maxhumidity) {
        this.maxhumidity = maxhumidity;
    }

    public String getMinhumidity() {
        return minhumidity;
    }

    public void setMinhumidity(String minhumidity) {
        this.minhumidity = minhumidity;
    }

    public temp getHigh() {
        return high;
    }

    public void setHigh(temp high) {
        this.high = high;
    }

    public temp getLow() {
        return low;
    }

    public void setLow(temp low) {
        this.low = low;
    }

    public percipitation getQpf_allday() {
        return qpf_allday;
    }

    public void setQpf_allday(percipitation qpf_allday) {
        this.qpf_allday = qpf_allday;
    }

    public percipitation getQpf_day() {
        return qpf_day;
    }

    public void setQpf_day(percipitation qpf_day) {
        this.qpf_day = qpf_day;
    }

    public percipitation getQpf_night() {
        return qpf_night;
    }

    public void setQpf_night(percipitation qpf_night) {
        this.qpf_night = qpf_night;
    }

    public percipitation getSnow_allday() {
        return snow_allday;
    }

    public void setSnow_allday(percipitation snow_allday) {
        this.snow_allday = snow_allday;
    }

    public percipitation getSnow_day() {
        return snow_day;
    }

    public void setSnow_day(percipitation snow_day) {
        this.snow_day = snow_day;
    }

    public percipitation getSnow_night() {
        return snow_night;
    }

    public void setSnow_night(percipitation snow_night) {
        this.snow_night = snow_night;
    }

    public wind getMaxwind() {
        return maxwind;
    }

    public void setMaxwind(wind maxwind) {
        this.maxwind = maxwind;
    }

    public wind getAvewind() {
        return avewind;
    }

    public void setAvewind(wind avewind) {
        this.avewind = avewind;
    }
}
