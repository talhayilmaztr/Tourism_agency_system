package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HotelManagment extends javax.swing.JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton listeleButton;
    private JTextArea textArea1;

    public HotelManagment() {
        setTitle("Hotel Management");
        setSize(1000, 1800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("ADDRESS");
        model.addColumn("CITY");
        model.addColumn("REGION");
        model.addColumn("PHONE");
        model.addColumn("EMAIL");
        model.addColumn("STARS");
        model.addColumn("FACILITIES");
        model.addColumn("PENSION TYPES");
        table1.setModel(model);


        TableColumn column;
        for (int i = 0; i < model.getColumnCount(); i++) {
            column = table1.getColumnModel().getColumn(i);
            column.setPreferredWidth(10000);
        }

        table1.setIntercellSpacing(new Dimension(1, 1));
        table1.setCellSelectionEnabled(true);
        table1.setShowGrid(true);
        table1.setGridColor(Color.GRAY);
        table1.setRowHeight(25);

        listeleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchDataHotel("hotel", table1);
            }
        });
    }

    public void fetchDataHotel(String data, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        PreparedStatement ps = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
            ps = conn.prepareStatement("SELECT * FROM " + data.toUpperCase());
            ResultSet rs = ps.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                String id = rs.getString("id");
                String namee = rs.getString("name");
                String addresss = rs.getString("address");
                String cityy = rs.getString("city");
                String regionn = rs.getString("region");
                String phonee = rs.getString("phone");
                String emaill = rs.getString("email");
                String stars = rs.getString("stars");
                String facilities = rs.getString("facilities");
                String PensionTypes = rs.getString("pension_types");
                model.addRow(new String[]{id, namee, addresss, cityy, regionn, phonee, emaill, stars, facilities, PensionTypes});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fetchDataHotel(String data, JTextArea area) {
        PreparedStatement ps = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
            ps = conn.prepareStatement("SELECT * FROM " + data.toUpperCase());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String namee = rs.getString("name");
                String addresss = rs.getString("address");
                String cityy = rs.getString("city");
                String regionn = rs.getString("region");
                String phonee = rs.getString("phone");
                String hepisi = namee + " " + addresss + " " + cityy + " " + regionn + " " + phonee + "\n";
                textArea1.append(hepisi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HotelManagment hotel = new HotelManagment();
            hotel.setVisible(true);
        });
    }
}
