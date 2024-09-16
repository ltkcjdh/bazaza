package com.example.bazaza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;

public class mySqlConnector {
        public static Connection ConnectDb() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.103:3306/toor15", "toor15", "toor15");
                JOptionPane.showMessageDialog(null, "Соединение установлено");
                return conn;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
            }
        }

    public static ObservableList<Basa> getBazaATS() {
        Connection conn1 = ConnectDb();
        ObservableList<Basa> list = FXCollections.observableArrayList();
        try {
            assert conn1 != null;
            PreparedStatement ps1 = conn1.prepareStatement("select * from Baza");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                list.add(new Basa(Integer.parseInt(rs1.getString("id")), Integer.parseInt(rs1.getString("ClId")), rs1.getDate("date"), rs1.getString("categ")));
            }
        } catch (Exception ignored) {
        }
        return list;
    }
}
