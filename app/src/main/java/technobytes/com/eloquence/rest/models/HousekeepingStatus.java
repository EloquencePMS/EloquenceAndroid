package technobytes.com.eloquence.rest.models;

/**
 * Created by seisan on 4/20/16.
 */
public class HousekeepingStatus {
    int houseKeepingStatusId;
    String name, description;

    public int getHouseKeepingStatusId() {
        return houseKeepingStatusId;
    }

    public void setHouseKeepingStatusId(int houseKeepingStatusId) {
        this.houseKeepingStatusId = houseKeepingStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
