package technobytes.com.eloquence.utils.eventbus;

/**
 * Created by seisan on 5/5/16.
 */
public class ClickedCheckIn {

    String date, month, year, roomType;

    public ClickedCheckIn(String date, String month, String year, String roomType) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.roomType = roomType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
