package karzbudz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class cartionaryController implements Initializable {

    @FXML
    private Button homebutton;  // Ensure this button has an action event in FXML, if needed
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        // If homebutton is meant to reload the home.fxml view, otherwise change to the correct view file
        navigateToScene("home.fxml", event);
    }
    
    
    @FXML
    private void switchToProton() {
        try {
            KarzBudz.setRoot("proton.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to view proton page.");
        }
    }
    
    @FXML
    private void switchToPerodua() {
        try {
            KarzBudz.setRoot("perodua.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to view perodua page.");
        }
    }
    
     private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR, errorMessage, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
}
    
    
    private void navigateToScene(String fxmlFile, ActionEvent event) {
        try {
            // Use getResource to load the FXML file relative to the current classloader
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent sceneRoot = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(sceneRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Here you may want to show an alert dialog to the user
        }
    }
}