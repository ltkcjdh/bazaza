package com.example.bazaza;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private TableColumn<Basa, Integer> ClId;

    @FXML
    private TextField ClId_text;

    @FXML
    private TableView<Basa> Table;

    @FXML
    private TableColumn<Basa, String> categ;

    @FXML
    private TextField categ_text;

    @FXML
    private TableColumn<Basa, Date> date;

    @FXML
    private TextField date_text;
    ObservableList<Basa> listM;
    ObservableList<Basa> dataList;

    Connection conn1 =null;
    ResultSet rs = null;
    PreparedStatement pst1 = null;

    @FXML
    private TableColumn<Basa, Integer> id;
    public void UpdateTable(){
        id.setCellValueFactory(new PropertyValueFactory<Basa,Integer>("id"));
        ClId.setCellValueFactory(new PropertyValueFactory<Basa,Integer>("ClId"));
        date.setCellValueFactory(new PropertyValueFactory<Basa,Date>("date"));
        categ.setCellValueFactory(new PropertyValueFactory<Basa,String>("categ"));

        listM = mySqlConnector.getBazaATS();
        Table.setItems(listM);
    }
    @FXML
    void getSelected (MouseEvent event){
        index = Table.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        //id.setText(id.getCellData(index).toString());
        ClId_text.setText(ClId.getCellData(index).toString());
        date_text.setText(date.getCellData(index).toString());
        categ_text.setText(categ.getCellData(index).toString());


    }

    public void OnAdd(ActionEvent event) {
        conn1 = mySqlConnector.ConnectDb();
        String sql = "insert into Basa (ClId,date,categ)values(?,?,? )";
        try {
            assert conn1 != null;
            pst1 = conn1.prepareStatement(sql);
            pst1.setString(1, ClId_text.getText());
            pst1.setString(2, date_text.getText());
            pst1.setString(3, categ_text.getText());
            pst1.execute();

            //  JOptionPane.showMessageDialog(null, "Пользователь добавлен");
            UpdateTable();
            //search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        //search_user();

    }

    public void OnObn(ActionEvent event) {
        id.setCellValueFactory(new PropertyValueFactory<Basa,Integer>("id"));
        ClId.setCellValueFactory(new PropertyValueFactory<Basa,Integer>("ClId"));
        date.setCellValueFactory(new PropertyValueFactory<Basa,Date>("date"));
        categ.setCellValueFactory(new PropertyValueFactory<Basa,String>("categ"));

        listM = mySqlConnector.getBazaATS();
        Table.setItems(listM);
    }

    public void OnRed(ActionEvent event) {
        try {
            conn1 = mySqlConnector.ConnectDb();
            //String value1 = txt_id.getText();
            String value2 = ClId_text.getText();
            String value3 = date_text.getText();
            String value4 = categ_text.getText();
            //String value5 = txt_type.getText();
            String sql = "update Basa set ClId= '"+value2+"',date= '"+
                    value3+"',categ= '"+value4+"' where ClId='"+value2+"' ";
            pst1= conn1.prepareStatement(sql);
            pst1.execute();
            JOptionPane.showMessageDialog(null, "Обновление");
            UpdateTable();
            //search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void OnDel(ActionEvent event) {
        conn1 = mySqlConnector.ConnectDb();
        String sql = "delete from Base where ClId = ?";
        try {
            assert conn1 != null;
            pst1 = conn1.prepareStatement(sql);
            pst1.setString(1, ClId_text.getText());
            pst1.execute();
            JOptionPane.showMessageDialog(null, "Запись удалена");
            UpdateTable();
            //search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    int index = -1;


}
