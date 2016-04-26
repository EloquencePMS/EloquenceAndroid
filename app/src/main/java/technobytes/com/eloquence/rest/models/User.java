package technobytes.com.eloquence.rest.models;

/**
 * Created by seisan on 4/7/16.
 */
public class User {

    String userId, userName;
    int empId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }


}
