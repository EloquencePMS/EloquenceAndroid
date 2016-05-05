package technobytes.com.eloquence.rest.models;

/**
 * Created by seisan on 5/5/16.
 */
public class RoomCollection {
        HousekeepingStatus houseeepingStatus;
        int roomNumber,houseKeepingStatusId;
        RoomType roomType;

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

        public RoomType getRoomType() {
            return roomType;
        }

        public void setRoomType(RoomType roomType) {
            this.roomType = roomType;
        }

}
