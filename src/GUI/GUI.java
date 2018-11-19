package GUI;


import Final.HandleSchedule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class GUI extends Application {
    private JFrame frame = new JFrame("Health Planner - Gallant");
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        HandleSchedule hs = new HandleSchedule();
        JTabbedPane tabs = new JTabbedPane();

    }
}



