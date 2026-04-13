package CarRentalSystem;

public class User {
    public int userId;
    public String userName;
    public String drivingLicense;

    public User(int userId, String userName, String drivingLicense) {
        this.userId = userId;
        this.userName = userName;
        this.drivingLicense = drivingLicense;
    }

     public int  getUserId() {
        return userId;
     }

     public String getUserName() {
        return userName;
     }

     public String getDrivingLicense() {
        return drivingLicense;
     }

     public void setUserId(int userId) {
        this.userId = userId;
     }

     public void setUserName(String userName) {
        this.userName = userName;
     }

     public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
     }
}
