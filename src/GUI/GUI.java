package GUI;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI/ui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


//import javax.swing.JOptionPane;
//
//public class GUI {
//    public static void main(String[] args){
//
//        String name = JOptionPane.showInputDialog("What is your name?");
//        String input = JOptionPane.showInputDialog("What would you like to do?");
//
//
//
//    }
//}