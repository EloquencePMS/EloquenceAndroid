package technobytes.com.eloquence.rest.weather.models.CurrentObservations;

/**
 * Created by Michael Leffert on 12/8/2015.
 */
public class observation_location {

    String full, city, state,country, country_iso3166, latitude, longitude, elevation;

    public observation_location(String full, String city, String state, String country, String country_iso3166, String latitude, String longitude, String elevation) {
        this.full = full;
        this.city = city;
        this.state = state;
        this.country = country;
        this.country_iso3166 = country_iso3166;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_iso3166() {
        return country_iso3166;
    }

    public void setCountry_iso3166(String country_iso3166) {
        this.country_iso3166 = country_iso3166;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }
}
