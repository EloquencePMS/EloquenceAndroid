package technobytes.com.eloquence.rest.models;

/**
 * Created by seisan on 5/5/16.
 */
public class Guest {

    String fName, lNmae, street, city, state, zipcode, email, phone;
    int compId, guestId;

    public Guest(String fName, String lNmae, String street, String city, String state, String zipcode, String email, String phone, int compId) {
        this.fName = fName;
        this.lNmae = lNmae;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        this.phone = phone;
        this.compId = compId;


    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlNmae() {
        return lNmae;
    }

    public void setlNmae(String lNmae) {
        this.lNmae = lNmae;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }
}
