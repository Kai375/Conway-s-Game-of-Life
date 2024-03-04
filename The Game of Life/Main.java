
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;
/**
 * This is the main Application, it will create a main scene in which the matrix that represent the game of life will be printed upon.
 *
 * @author Kai Toledano.
 */
public class Main extends Application
{   
    /**
    * This is the start method, when take a class and extends it using the Appilcation interface, we most use this method.
    * From here the program will load the fxml file and create a scene based on it's data.
    *
    * @param Stage stage
    */
    public void start(Stage stage) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Board.fxml")); // Fetch the fxml file.
       
        Scene scene = new Scene(root);  // Create the scene.
        
        stage.setTitle("Game of Life.");
        stage.setScene(scene);
        stage.show();
    }
       
    public static void main(String[] args) 
    {
        launch();
    }
}
