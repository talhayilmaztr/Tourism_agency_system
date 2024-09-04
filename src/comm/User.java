package comm;

public class User {
    private String user_name;
    private String password;
    private Role role;

    public User(String user_name, String password, Role role) {
        this.user_name = user_name;
        this.password = password;
        this.role = role;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  user_name + " -" + " " + role;
    }
}
