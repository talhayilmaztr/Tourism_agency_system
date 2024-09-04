package comm;

import java.util.ArrayList;

public class Admin extends User {
    public static ArrayList<User> users = new ArrayList<>();

    public Admin(String user_name, String password, Role role) {
        super(user_name, password, role);
    }



    public static void addEmployee(Admin admin) {
        users.add(admin);
    }
    public static void removeEmployee(Admin admin) {
        users.remove(admin);
    }
    public void filter(User user){
        if(user.getRole() == Role.ADMIN){
            System.out.println(user.getUser_name() + " has admin role");
        }
        else if(user.getRole() == Role.EMPLOYEE){
            System.out.println(user.getUser_name() + " has employee role");
        }

    }
    public static void printAdmins() {
        for (int i = 0; i<users.size(); i++) {
            if (Role.ADMIN == users.get(i).getRole()) {
                System.out.println(users.get(i).getUser_name());
            }

            }

        }

}
