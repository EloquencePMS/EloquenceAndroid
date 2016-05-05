package technobytes.com.eloquence.rest.models;

/**
 * Created by seisan on 4/20/16.
 */
public class Stay {
    int stayId,rateId,marketId,folioId,guestId,empId,locationId, roomNumber, taxProfile;
    String checkInDate, checkOutDate;
    String   status, roomType;

    public Stay(int stayId, int rateId, int marketId, int folioId, int guestId, int empId, int locationId, int roomNumber, int taxProfile, String checkInDate, String checkOutDate, String status, String roomType) {
        this.stayId = stayId;
        this.rateId = rateId;
        this.marketId = marketId;
        this.folioId = folioId;
        this.guestId = guestId;
        this.empId = empId;
        this.locationId = locationId;
        this.roomNumber = roomNumber;
        this.taxProfile = taxProfile;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.roomType = roomType;
    }

    public int getStayId() {
        return stayId;
    }

    public void setStayId(int stayId) {
        this.stayId = stayId;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public int getFolioId() {
        return folioId;
    }

    public void setFolioId(int folioId) {
        this.folioId = folioId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getTaxProfile() {
        return taxProfile;
    }

    public void setTaxProfile(int taxProfile) {
        this.taxProfile = taxProfile;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
