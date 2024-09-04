package comm;

public enum PensionType {
        ULTRA_ALL_INCLUSIVE("Ultra Her Şey Dahil"),
        ALL_INCLUSIVE("Her Şey Dahil"),
        BED_AND_BREAKFAST("Oda Kahvaltı"),
        FULL_BOARD("Tam Pansiyon"),
        HALF_BOARD("Yarım Pansiyon"),
        ROOM_ONLY("Sadece Yatak"),
        ALCOHOL_EXCLUDED_FULL_CREDIT("Alkol Hariç Full Credit");

        private final String description;

        PensionType(String description) {
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

