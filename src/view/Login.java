package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Helper.DBConnector;
import comm.*;

public class Login extends JFrame {
    private JPanel panel1;
    private JButton loginButton;
    private JTextField textField1;
    private JTextField textField2;


    private JLabel label1;
    private JLabel label2;

    Admin admin1 = new Admin("Talha", "123", Role.ADMIN);
    Employee emp2 = new Employee("emp2", "1234", Role.EMPLOYEE);
    Employee emp3 = new Employee("emp3", "1234", Role.EMPLOYEE);

    public Login() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = textField2.getText();
                adminCheck(username ,password);
            }
        });
    }
    public void createUIComponents() {

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
    public void adminCheck(String username, String password){
        String query = "SELECT * FROM turizm_acente.user WHERE username=? AND password=?";
        try {
            Connection conn = DBConnector.getInstance();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String role = rs.getString("role");
                if (role.equals("admin")){
                    System.out.println("admin girişi yapıldı");
                }else
                    System.out.println("işçi girişi yapıldı");
                System.out.println("username or password are correct");

            }else
                    System.out.println("username or password are incorrect");
            }

        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
        }


    }
}
