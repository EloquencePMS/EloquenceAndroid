package technobytes.com.eloquence.rest.weather.models.forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class txtforecastday {

    String period, icon, icon_url, title, fcttext, fcttext_metric, pop;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFcttext() {
        return fcttext;
    }

    public void setFctext(String fctext) {
        this.fcttext = fctext;
    }

    public String getFcttext_metric() {
        return fcttext_metric;
    }

    public void setFcttext_metric(String fcttext_metric) {
        this.fcttext_metric = fcttext_metric;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }
}
