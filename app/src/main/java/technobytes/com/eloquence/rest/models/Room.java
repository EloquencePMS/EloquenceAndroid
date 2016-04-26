package technobytes.com.eloquence.rest.models;

/**
 * Created by seisan on 4/20/16.
 */
public class Room {
    HousekeepingStatus houseeepingStatus;
    int roomNumber,houseKeepingStatusId;
    String roomType;

    public HousekeepingStatus getHouseeepingStatus() {
        return houseeepingStatus;
    }

    public void setHouseeepingStatus(HousekeepingStatus houseeepingStatus) {
        this.houseeepingStatus = houseeepingStatus;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getHouseKeepingStatusId() {
        return houseKeepingStatusId;
    }

    public void setHouseKeepingStatusId(int houseKeepingStatusId) {
        this.houseKeepingStatusId = houseKeepingStatusId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
