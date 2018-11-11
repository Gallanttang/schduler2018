package GUI;


import javafx.application.Application;
import javafx.stage.Stage;

import static GUI.HandleSchedule.generateSchedule;
import static GUI.HandleSchedule.printOutSchedule;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        generateSchedule();
        printOutSchedule();

//        Parent root = FXMLLoader.load(getClass().getResource("GUI/ui.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
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
