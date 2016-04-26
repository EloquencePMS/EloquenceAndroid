package technobytes.com.eloquence.rest.responses;

import technobytes.com.eloquence.rest.models.Room;
import technobytes.com.eloquence.rest.models.Stay;

/**
 * Created by seisan on 4/20/16.
 */
public class LoadInitialData {
    Stay [] checkIns, checkOuts, stayOver;
    Room[] rooms;

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Stay[] getCheckIns() {
        return checkIns;
    }

    public void setCheckIns(Stay[] checkIns) {
        this.checkIns = checkIns;
    }

    public Stay[] getCheckOuts() {
        return checkOuts;
    }

    public void setCheckOuts(Stay[] checkOuts) {
        this.checkOuts = checkOuts;
    }

    public Stay[] getStayOver() {
        return stayOver;
    }

    public void setStayOver(Stay[] stayOver) {
        this.stayOver = stayOver;
    }
}
