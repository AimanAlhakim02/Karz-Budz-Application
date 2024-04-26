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
import javafx.scene.control.CheckBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class JumpStartController {
    
    @FXML
    private Button homebutton;  // Ensure this button has an action event in FXML, if needed
    
    @FXML
    private CheckBox checkBox1;
    
    @FXML
    private CheckBox checkBox2;
    
    @FXML
    private CheckBox checkBox3;
    
    @FXML
    private CheckBox checkBox4;
    
    @FXML
    private CheckBox checkBox5;
    
    @FXML
    private CheckBox checkBox6;
    
    @FXML
    private CheckBox checkBox7;
    
    @FXML
    private CheckBox checkBox8;
    
    @FXML
    private CheckBox checkBox9;
    
    @FXML
    private CheckBox checkBox10;
    
    @FXML
    private Button resetButton;

    @FXML
    private void resetChecklist() {
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
        checkBox5.setSelected(false);
        checkBox6.setSelected(false);
        checkBox7.setSelected(false);
        checkBox8.setSelected(false);
        checkBox9.setSelected(false);
        checkBox10.setSelected(false);
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        // If homebutton is meant to reload the home.fxml view, otherwise change to the correct view file
        navigateToScene("home.fxml", event);
    }

    public void initialize() {
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