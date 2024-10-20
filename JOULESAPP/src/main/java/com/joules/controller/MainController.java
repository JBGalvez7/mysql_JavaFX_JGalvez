package com.joules.controller;

import com.joules.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField middleName;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private TextField number;
    @FXML
    private RadioButton genderMale;
    @FXML
    private RadioButton genderFemale;

    private DatabaseConnection connection;

    private void initialize(){
        connection = new DatabaseConnection();
    }

    @FXML
    private void save() throws SQLException {
        String sql = "INSERT INTO students(first_name, last_name, middle_name, address, email, phone_number, gender) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.connection.prepareStatement(sql);
        stmt.setString(1, firstName.getText());
        stmt.setString(2, lastName.getText());
        stmt.setString(3, middleName.getText());
        stmt.setString(4, address.getText());
        stmt.setString(5, email.getText());
        stmt.setString(6, number.getText());
        stmt.setString(7, genderMale.getText());
        stmt.setString(7, genderFemale.getText());
        stmt.execute();
    }
}
