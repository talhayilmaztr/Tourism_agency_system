package comm;

public class Employee extends User {
    public Employee(String user_name, String password, Role role) {
        super(user_name, password, role);
    }

    public void HotelList(){
        System.out.println("Hotel List");
    }


    public static void addEmployee(Employee employee) {
        Admin.users.add(employee);
    }
    public static void removeEmployee(Employee employee) {
        Admin.users.remove(employee);
    }
    public static void printEmployees() {
        for (int i = 0; i<Admin.users.size(); i++) {
            if (Role.EMPLOYEE.equals(Admin.users.get(i).getRole())) {}
            System.out.println(Admin.users.get(i).toString());
        }
    }
}
