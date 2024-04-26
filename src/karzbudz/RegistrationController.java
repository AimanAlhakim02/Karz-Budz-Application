/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package karzbudz;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import java.sql.*;

public class RegistrationController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private RadioButton maleRadio;
    @FXML private RadioButton femaleRadio;
    @FXML private RadioButton otherRadio;
    private ToggleGroup genderToggleGroup;
    
    @FXML
    public void initialize() {
        // Initialize the ToggleGroup for gender radio buttons
        genderToggleGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderToggleGroup);
        femaleRadio.setToggleGroup(genderToggleGroup);
        otherRadio.setToggleGroup(genderToggleGroup);
    }

    @FXML
    private void handleRegister() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        RadioButton selectedGender = (RadioButton) genderToggleGroup.getSelectedToggle();
    String gender = selectedGender != null ? selectedGender.getText() : "";
        
        String query = "INSERT INTO users (name, email, password, gender) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, gender);
            pstmt.executeUpdate();
            
            showSuccessDialog();
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    private void showSuccessDialog() {
        Alert alert = new Alert(AlertType.INFORMATION, "Registration Successful. Click OK to proceed to login.", ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                switchToLogin();
            }
        });
    }

    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR, "Registration Failed: " + errorMessage, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    private void switchToLogin() {
        try {
            KarzBudz.setRoot("Login.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to switch to the login screen.");
        }
    }
}
