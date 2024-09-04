package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class
AddEmloyee extends JFrame {
    private JTextField ıd;
    private JTextField us;
    private JTextField role;
    private JTextField first_name;
    private JPasswordField pass;
    private JTextField last_name;
    private javax.swing.JPanel JPanel;
    private JButton addButton;

    public AddEmloyee() {
        setTitle("Add Employee");

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPanel);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "INSERT INTO user values(?,?,?,?,?,?)";
                String last = last_name.getText();
                String first = first_name.getText();
                int id = Integer.parseInt(ıd.getText());
                String username = us.getText();
                String password = pass.getText();
                String rol = role.getText();

                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente","root","342196328Mm");
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setInt(1,id);
                    ps.setString(2,username);
                    ps.setString(3,password);
                    ps.setString(4,rol);
                    ps.setString(5,first);
                    ps.setString(6,last);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("hata");
                }


            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddEmloyee addEmployee = new AddEmloyee();
            addEmployee.setVisible(true);
        });
    }
}
