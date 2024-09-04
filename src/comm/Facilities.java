package comm;

public enum Facilities {
    FREE_PARKING("Ücretsiz Otopark"),
    FREE_WIFI("Ücretsiz WiFi"),
    SWIMMING_POOL("Yüzme Havuzu"),
    FITNESS_CENTER("Fitness"),
    HOTEL_CONCIERGE("Otel Kapıcı"),
    SPA("Masaj"),
    ROOM_SERVICE("7/24 Oda Servisi");

    public final String description;

    Facilities(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
