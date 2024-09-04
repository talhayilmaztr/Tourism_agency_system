package comm;

import java.util.Arrays;
import view.*;

public class Main {
    public static void main(String[] args) {

        Admin admin1 = new Admin("Talha", "123" , Role.ADMIN);
        Employee emp2 = new Employee("emp2", "1234" , Role.EMPLOYEE);
        Employee emp3 = new Employee("emp3", "1234" , Role.EMPLOYEE);
        Employee emp4 = new Employee("emp4", "1234" , Role.EMPLOYEE);
        Admin admin2 = new Admin("Yılmaz", "1234" , Role.ADMIN);
        System.out.println(PensionType.ALCOHOL_EXCLUDED_FULL_CREDIT.getDescription());
        Admin.addEmployee(admin1);
        Employee.addEmployee(emp4);
        Employee.addEmployee(emp2);
        Employee.addEmployee(emp3);
        Admin.addEmployee(admin2);
        Admin.printAdmins();
        Employee.removeEmployee(emp2);
        Employee.removeEmployee(emp3);
        System.out.println("--- new employees ---");

        Employee.printEmployees();
        emp2.HotelList();
        Hotel hotel1 = new Hotel(
                "Kodluyoruz Life İstanbul",
                "Şahkulu, Şişhane Metro Durağı, Meşrutiyet Cd. No:125, 34421",
                "İstanbul",
                "Beyoğlu",
                "0212 xxx xx xx",
                "info@kodluyoruz.org",
                5,
                Arrays.asList(Facilities.FREE_PARKING, Facilities.ROOM_SERVICE, Facilities.SWIMMING_POOL),
                Arrays.asList(PensionType.ALCOHOL_EXCLUDED_FULL_CREDIT,PensionType.BED_AND_BREAKFAST)
        );

        Hotel hotel2 = new Hotel(
                "Grand Palace Hotel",
                "123 Luxury Street, Downtown",
                "New York",
                "Manhattan",
                "123-456-7890",
                "contact@grandpalace.com",
                4,
                Arrays.asList(Facilities.HOTEL_CONCIERGE, Facilities.SWIMMING_POOL),
                Arrays.asList(PensionType.ALCOHOL_EXCLUDED_FULL_CREDIT,PensionType.ALL_INCLUSIVE,PensionType.BED_AND_BREAKFAST)


        );


        Hotel hotel3 = new Hotel(
                "Sea View Resort",
                "456 Beachside Avenue",
                "Miami",
                "South Beach",
                "987-654-3210",
                "info@seaviewresort.com",
                3,
                Arrays.asList(Facilities.FREE_PARKING, Facilities.ROOM_SERVICE, Facilities.SWIMMING_POOL, Facilities.FREE_WIFI),
                Arrays.asList(PensionType.ALCOHOL_EXCLUDED_FULL_CREDIT,PensionType.ULTRA_ALL_INCLUSIVE,PensionType.ALL_INCLUSIVE,PensionType.BED_AND_BREAKFAST)

        );
        System.out.println(hotel3.getFacilities());
        System.out.println(hotel2.getPension_types());
        System.out.println(hotel1.getHotel_address());

        Login login = new Login();
        login.setVisible(true);
    }

}