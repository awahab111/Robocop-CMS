package CMS;

public class PoliceStation {
    private int policeStation_ID;
    private String name;
    private String location;
    private String phone;

    public PoliceStation(int stationId, String name2, String location2, String phone2) {
        policeStation_ID = stationId;
        name = name2;
        location = location2;
        phone = phone2;
    }

    public int getPoliceStation_ID() {
        return policeStation_ID;
    }

    public void setPoliceStation_ID(int policeStation_ID) {
        this.policeStation_ID = policeStation_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String policeStationName) {
        this.name = policeStationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String policeStationLocation) {
        this.location = policeStationLocation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String policeStationPhone) {
        this.phone = policeStationPhone;
    }


}
