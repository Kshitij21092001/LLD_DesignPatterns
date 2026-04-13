package CarRentalSystem;

public class Location {
    public int buildingNo;
    public String area;
    public String city;
    public String state;
    public int pinCode;

    public Location(int buildingNo, String area, String city, String state, int pinCode) {
        this.buildingNo = buildingNo;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }
}
