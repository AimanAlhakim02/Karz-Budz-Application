package karzbudz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KarzBudz extends Application {
    
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Karz Budz App By AZ");
        primaryStage.setScene(new Scene(root, 500, 800));
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws Exception {
        Parent root = FXMLLoader.load(KarzBudz.class.getResource(fxml));
        primaryStage.getScene().setRoot(root);
    }

    public static void main(String[] args) {    
        launch(args);
    }
}   