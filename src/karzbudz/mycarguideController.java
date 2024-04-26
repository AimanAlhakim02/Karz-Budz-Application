package karzbudz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class mycarguideController implements Initializable {
    
    @FXML
    private Button homebutton; // Ensure this button has an fx:id="homebutton" in your FXML
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic here (if needed)
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        navigateToScene("home.fxml", event);
    }
    
    @FXML
    private void goToJumpStartPage(ActionEvent event) {
        // Change "mycarguide.fxml" to the correct path if necessary
        navigateToScene("jumpstart.fxml", event);
    }
    
    @FXML
    private void goToChangeTyrePage(ActionEvent event) {
        // Change "mycarguide.fxml" to the correct path if necessary
        navigateToScene("changetyre.fxml", event);
    }
    
    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR, errorMessage, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void navigateToScene(String fxmlFile, ActionEvent event) {
        try {
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
