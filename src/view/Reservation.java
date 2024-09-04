package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reservation extends JFrame {
    private JButton createB;
    private JTextField sumT;
    private JComboBox hotelT;
    private JComboBox roomT;
    private JComboBox pensionT;
    private JComboBox seasonT;
    private JPanel panel23;
    private JList list1;
    private JComboBox comboBox1;
    private JButton fiyatıGösterButton;

    int [] adult_price= new int[1];
    int [] pension_price= new int[1];
    int [] season_price= new int[1];
    int [] child_price= new int[1];

    public Reservation() {
        setTitle("Reservation Management");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel23);
        Helper.DBConnector.getInstance();
        hotel();



        hotelT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected_hotel = String.valueOf(hotelT.getSelectedItem());

                try {
                    loadOtherData(selected_hotel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        fiyatıGösterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sum = 0;
                sum += adult_price[0] + pension_price[0] + season_price[0] ;
                sumT.setText(String.valueOf(sum));
            }
        });
    }
    public void loadOtherData(String selected_hotel_name) throws SQLException {


        try {
            PreparedStatement ps = null;
            int hotel_idd=0;

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
            ps = conn.prepareStatement("SELECT id FROM hotel WHERE name = ?");
            ps.setString(1, selected_hotel_name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 hotel_idd = rs.getInt("id");
            }

            roomT.removeAllItems();
            PreparedStatement psR = conn.prepareStatement("SELECT * FROM room WHERE hotel_id = ?");
            psR.setInt(1, hotel_idd);
            ResultSet rsR = psR.executeQuery();
            while (rsR.next()) {
                int bed_count = rsR.getInt("bed_count");
                int stock = rsR.getInt("stock");
                adult_price[0] = rsR.getInt("adult_price");
                child_price[0] = rsR.getInt("child_price");
                String info =("bed_count: " + bed_count+" "+"stock: "+ stock+" "+ "adult_price: "+ adult_price[0]+ " "+ "child_price: "+ child_price[0]);
                roomT.addItem(info);
            }
            pensionT.removeAllItems();
            PreparedStatement psP = conn.prepareStatement("SELECT * FROM pension_type WHERE hotel_id = ?");
            psP.setInt(1, hotel_idd);
            ResultSet rsP = psP.executeQuery();
            while (rsP.next()) {
                pension_price[0] = rsP.getInt("price");
                String type = rsP.getString("description");
                String info =(type + " price: " + pension_price[0]);
                pensionT.addItem(info);
            }
            seasonT.removeAllItems();
            PreparedStatement psS = conn.prepareStatement("SELECT * FROM season WHERE hotel_id = ?");
            psS.setInt(1, hotel_idd);
            ResultSet rsS = psS.executeQuery();
            while (rsS.next()) {
                season_price[0] = rsS.getInt("price");
                String start_date = rsS.getString("start_date");
                String end_date = rsS.getString("end_date");

                String info =(start_date +" "+ end_date +" price: " + season_price[0]);
                seasonT.addItem(info);

            }
            DefaultListModel<String> model = new DefaultListModel<>() ;
            list1.setModel(model);
            PreparedStatement psF = conn.prepareStatement("SELECT * FROM  hotel WHERE id = ?");
            psF.setInt(1, hotel_idd);
            ResultSet rsF = psF.executeQuery();
            while (rsF.next()) {
                String facility = rsF.getString("facilities");
                model.addElement(facility);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

        public void hotel(){
        hotelT.removeAllItems();
        try{
            PreparedStatement ps = null;

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
            ps = conn.prepareStatement("SELECT name FROM hotel ");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                hotelT.addItem(rs.getString("name"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Reservation reserv = new Reservation();
            reserv.setVisible(true);

        });

    }
}
