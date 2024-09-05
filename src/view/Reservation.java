package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reservation extends JFrame {
    private JButton createB;
    private JTextField sumT;
    private JComboBox<String> hotelT;
    private JComboBox<String> roomT;
    private JComboBox<String> pensionT;
    private JComboBox<String> seasonT;
    private JPanel panel23;
    private JList<String> list1;
    private JComboBox<String> comboBox1;
    private JButton fiyatıGösterButton;

    int adult_price = 0;
    int pension_price = 0;
    int season_price = 0;
    int child_price = 0;

    double initialSum = 0.0;

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
                String selected_hotel = (String) hotelT.getSelectedItem();

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
                sum += adult_price + pension_price + season_price;
                initialSum = sum;
                sumT.setText(String.valueOf(sum));

                String p = (String) comboBox1.getSelectedItem();
                int person = Integer.parseInt(p);
                double new_sum = person * initialSum;
                sumT.setText(String.valueOf(new_sum));
            }
        });

        roomT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedRoom = (String) roomT.getSelectedItem();
                    if (selectedRoom != null) {
                        // Odaların ID'lerini ve fiyatlarını almak için uygun işlemleri yap
                        int selectedRoomId = extractId(selectedRoom);

                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
                        PreparedStatement psRoom = conn.prepareStatement("SELECT adult_price, child_price FROM room WHERE id = ?");
                        psRoom.setInt(1, selectedRoomId);
                        ResultSet rsRoom = psRoom.executeQuery();

                        if (rsRoom.next()) {
                            adult_price = rsRoom.getInt("adult_price");
                            child_price = rsRoom.getInt("child_price");
                            System.out.println("Selected room adult price: " + adult_price);
                            System.out.println("Selected room child price: " + child_price);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });

        pensionT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedPension = (String) pensionT.getSelectedItem();
                    if (selectedPension != null) {
                        int selectedPensionId = extractId(selectedPension);

                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
                        PreparedStatement psPension = conn.prepareStatement("SELECT price FROM pension_type WHERE id = ?");
                        psPension.setInt(1, selectedPensionId);
                        ResultSet rsPension = psPension.executeQuery();

                        if (rsPension.next()) {
                            pension_price = rsPension.getInt("price");
                            System.out.println("Selected pension type price: " + pension_price);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });

        seasonT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedSeason = (String) seasonT.getSelectedItem();
                    if (selectedSeason != null) {
                        int selectedSeasonId = extractId(selectedSeason);

                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
                        PreparedStatement psSps = conn.prepareStatement("SELECT price FROM season WHERE id = ?");
                        psSps.setInt(1, selectedSeasonId);
                        ResultSet rssss = psSps.executeQuery();

                        if (rssss.next()) {
                            season_price = rssss.getInt("price");
                            System.out.println("Selected season price: " + season_price);
                        }
                    }
                } catch (Exception w) {
                    System.out.println("Error: " + w.getMessage());
                }
            }
        });
        createB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sumT.getText().isEmpty() || hotelT.getSelectedItem() == null ||
                        roomT.getSelectedItem() == null || pensionT.getSelectedItem() == null ||
                        seasonT.getSelectedItem() == null) {

                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Rezervasyon başarıyla oluşturuldu!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
    }

    public void loadOtherData(String selected_hotel_name) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
            int hotel_idd = 0;

            PreparedStatement ps = conn.prepareStatement("SELECT id FROM hotel WHERE name = ?");
            ps.setString(1, selected_hotel_name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hotel_idd = rs.getInt("id");
            }

            roomT.removeAllItems();
            PreparedStatement psR = conn.prepareStatement("SELECT * FROM room WHERE hotel_id = ?");
            psR.setInt(1, hotel_idd);
            ResultSet rsR = psR.executeQuery();
            while (rsR.next()) {
                int id = rsR.getInt("id");
                int bed_count = rsR.getInt("bed_count");
                int stock = rsR.getInt("stock");
                adult_price = rsR.getInt("adult_price");
                child_price = rsR.getInt("child_price");
                String info = ("ID: " + id + " bed_count: " + bed_count + " stock: " + stock + " adult_price: " + adult_price + " child_price: " + child_price);
                roomT.addItem(info);
            }

            pensionT.removeAllItems();
            PreparedStatement psP = conn.prepareStatement("SELECT * FROM pension_type WHERE hotel_id = ?");
            psP.setInt(1, hotel_idd);
            ResultSet rsP = psP.executeQuery();
            while (rsP.next()) {
                int id = rsP.getInt("id");
                int price = rsP.getInt("price");
                String type = rsP.getString("description");
                String info = ("ID: " + id + " " + type + " price: " + price);
                pensionT.addItem(info);
            }

            seasonT.removeAllItems();
            PreparedStatement psS = conn.prepareStatement("SELECT * FROM season WHERE hotel_id = ?");
            psS.setInt(1, hotel_idd);
            ResultSet rsS = psS.executeQuery();
            while (rsS.next()) {
                int id = rsS.getInt("id");
                season_price = rsS.getInt("price");
                String start_date = rsS.getString("start_date");
                String end_date = rsS.getString("end_date");
                String info = ("ID: " + id + " " + start_date + " " + end_date + " price: " + season_price);
                seasonT.addItem(info);
            }

            DefaultListModel<String> model = new DefaultListModel<>();
            list1.setModel(model);
            PreparedStatement psF = conn.prepareStatement("SELECT * FROM hotel WHERE id = ?");
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

    public void hotel() {
        hotelT.removeAllItems();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/turizm_acente", "root", "342196328Mm");
            PreparedStatement ps = conn.prepareStatement("SELECT name FROM hotel");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hotelT.addItem(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int extractId(String text) {
        try {
            String[] parts = text.split("ID: ");
            if (parts.length > 1) {
                return Integer.parseInt(parts[1].split(" ")[0].trim());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Reservation reserv = new Reservation();
            reserv.setVisible(true);
        });
    }
}
