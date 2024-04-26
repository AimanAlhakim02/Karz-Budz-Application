package karzbudz;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ArticleONEController {

    @FXML
    private WebView webView;
    
    @FXML
    private Button homebutton;  // Ensure this button has an action event in FXML, if needed
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        // If homebutton is meant to reload the home.fxml view, otherwise change to the correct view file
        navigateToScene("home.fxml", event);
    }

    public void initialize() {
        // You can load any web page by replacing the URL below
        webView.getEngine().load("https://autobuzz.my/2024/04/22/2024-honda-city-hatchback-facelift-open-for-booking-in-malaysia-launching-soon/");
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
        }
    }
}