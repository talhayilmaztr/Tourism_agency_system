package comm;

import java.util.List;

public class Hotel {
    private String hotel_name;
    private String hotel_address;
    private String hotel_city;
    private String region;
    private String hotel_phone;
    private String hotel_email;
    private int stars;
    public List<Facilities> facilities;
    public List<PensionType> pension_types;

    public Hotel(String hotel_name, String hotel_address, String hotel_city, String region, String hotel_phone, String hotel_email, int stars, List<Facilities> facilities, List<PensionType> pension_types) {
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.region = region;
        this.hotel_phone = hotel_phone;
        this.hotel_email = hotel_email;
        this.stars = stars;
        this.facilities = facilities;
        this.pension_types = pension_types;
    }

    public List<PensionType> getPension_types() {
        System.out.println("Pension Types\n");
        return pension_types;
    }

    public void setPension_types(List<PensionType> pension_types) {
        this.pension_types = pension_types;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHotel_phone() {
        return hotel_phone;
    }

    public void setHotel_phone(String hotel_phone) {
        this.hotel_phone = hotel_phone;
    }

    public String getHotel_email() {
        return hotel_email;
    }

    public void setHotel_email(String hotel_email) {
        this.hotel_email = hotel_email;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Facilities> getFacilities() {
        System.out.println("Facilities");
        return facilities;
    }

    public void setFacilities(List<Facilities> facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_name='" + hotel_name + '\'' +
                ", hotel_address='" + hotel_address + '\'' +
                ", hotel_city='" + hotel_city + '\'' +
                ", region='" + region + '\'' +
                ", hotel_phone='" + hotel_phone + '\'' +
                ", hotel_email='" + hotel_email + '\'' +
                ", stars=" + stars +
                ", facilities=" + facilities +
                ", pension_types=" + pension_types +
                '}';
    }

}
