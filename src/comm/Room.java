package comm;

import java.util.List;

public class Room {
    private String roomType;
    private int bedCount;
    private int size; // metrekare
    private List<String> features;
    private Hotel hotel;
    private Season season;
    private PensionType pensionType;

    // Constructor
    public Room(String roomType, int bedCount, int size, List<String> features, Hotel hotel, Season season, PensionType pensionType) {
        this.roomType = roomType;
        this.bedCount = bedCount;
        this.size = size;
        this.features = features;
        this.hotel = hotel;
        this.season = season;
        this.pensionType = pensionType;
    }

    // Getters and Setters
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public PensionType getPensionType() {
        return pensionType;
    }

    public void setPensionType(PensionType pensionType) {
        this.pensionType = pensionType;
    }
}
