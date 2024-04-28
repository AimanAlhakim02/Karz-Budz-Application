package karzbudz;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import java.sql.*;

public class LoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText(); // You should hash this password before comparing it with the database value
        
        String query = "SELECT name FROM users WHERE email = ? AND password = ?"; // Ideally, you should only select the user if the password hashes match
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, email);
            pstmt.setString(2, password); // In a real application, compare hashed passwords
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String name = rs.getString("name");
                showSuccessDialog(name);
            } else {
                showErrorDialog("Login failed. Please check your credentials and try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorDialog("An error occurred: " + e.getMessage());
        }
    }

    private void showSuccessDialog(String userName) {
        Alert alert = new Alert(AlertType.INFORMATION, "Login Successful. Welcome, " + userName + "!", ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                switchToDashboard();
            }
        });
    }

    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR, errorMessage, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    
    private void switchToDashboard() {
        try {
            KarzBudz.setRoot("home.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to switch to the dashboard screen.");
        }
    }

    @FXML
    private void switchToRegister() {
        try {
            KarzBudz.setRoot("Registration.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to switch to the registration screen.");
        }
    }
}