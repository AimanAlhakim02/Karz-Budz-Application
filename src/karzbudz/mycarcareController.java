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

public class mycarcareController implements Initializable {

    @FXML
    private Button homebutton; // Ensure this button has an fx:id="homebutton" in your FXML

    @FXML
    private void handleButtonAction(ActionEvent event) {
        navigateToScene("home.fxml", event);
    }
    
    @FXML
    private void goCarCareONE() {
        try {
            KarzBudz.setRoot("carcareONE.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to view page.");
        }
    }
    
     private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR, errorMessage, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void navigateToScene(String fxmlFile, ActionEvent event) {
        try {
            // Ensure the fxml file path is correct and that the file exists in the resources
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent sceneRoot = loader.load();
            
            // Use the action event to find the current stage and set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(sceneRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, show an error message to the user
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization logic here
        // Remove the UnsupportedOperationException and implement any setup required
    }
}