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
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class homeController implements Initializable {
    
    @FXML
    private Button homebutton;  // Ensure this button has an action event in FXML, if needed
    
    @FXML
    private Button carguidebutton; // Ensure this button has the correct fx:id in your FXML and is linked to goToCarGuide
    
    @FXML
    private Button carcarebutton;
    
    @FXML
    private Button cartionarybutton;
    
    @FXML
    private ScrollPane scrollPane; // Ensure this ScrollPane has the correct fx:id in your FXML

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Ensure this matches the fx:id of your ScrollPane in the FXML file
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        // If homebutton is meant to reload the home.fxml view, otherwise change to the correct view file
        navigateToScene("home.fxml", event);
    }
    
    @FXML
    private void goToCarGuide(ActionEvent event) {
        // Change "mycarguide.fxml" to the correct path if necessary
        navigateToScene("mycarguide.fxml", event);
    }
    
    @FXML
    private void goToCarCare(ActionEvent event) {
        // Change "mycarguide.fxml" to the correct path if necessary
        navigateToScene("mycarcare.fxml", event);
    }
    
    @FXML
    private void goToCartionary(ActionEvent event) {
        // Change "mycarguide.fxml" to the correct path if necessary
        navigateToScene("cartionary.fxml", event);
    }
    
    @FXML
    private void readNews1() {
        try {
            KarzBudz.setRoot("articleONE.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to view page.");
        }
    }
    
    @FXML
    private void readNews2() {
        try {
            KarzBudz.setRoot("articleTWO.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to view page.");
        }
    }
    
    @FXML
    private void readNews3() {
        try {
            KarzBudz.setRoot("articleTHREE.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to view page.");
        }
    }
    
    @FXML
    private void directAutoBuzz() {
        try {
            KarzBudz.setRoot("articleTHREE.fxml");
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