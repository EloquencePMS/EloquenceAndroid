package technobytes.com.eloquence.rest.weather.models.CurrentObservations;

/**
 * Created by Michael Leffert on 12/8/2015.
 */
public class display_location {

    String full, city, state, state_name, country, country_iso3166, zip, magic, wmo, latitude, longitude, elevation;

    public display_location(String full, String city, String state, String state_name, String country, String country_iso3166, String zip, String magic, String wmo, String latitude, String longitude, String elevation) {
        this.full = full;
        this.city = city;
        this.state = state;
        this.state_name = state_name;
        this.country = country;
        this.country_iso3166 = country_iso3166;
        this.zip = zip;
        this.magic = magic;
        this.wmo = wmo;
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

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public String getWmo() {
        return wmo;
    }

    public void setWmo(String wmo) {
        this.wmo = wmo;
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
