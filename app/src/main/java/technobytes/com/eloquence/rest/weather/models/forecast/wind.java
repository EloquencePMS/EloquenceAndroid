package technobytes.com.eloquence.rest.weather.models.forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class wind {

    String dir;
    double mph, kph, degrees;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public double getMph() {
        return mph;
    }

    public void setMph(double mph) {
        this.mph = mph;
    }

    public double getKph() {
        return kph;
    }

    public void setKph(double kph) {
        this.kph = kph;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }
}
