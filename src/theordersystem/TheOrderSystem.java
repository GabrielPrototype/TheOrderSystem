
package theordersystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import theordersystem.db.util.DatabaseConfigs;

/**
 *
 * @author Gabriel Longo P. Abreu
 * @author Aleksander Silva
 */
public class TheOrderSystem extends Application {
    
    public static DatabaseConfigs databaseConfigs;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/FXMLMain.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        databaseConfigs = new DatabaseConfigs("jdbc:postgresql://localhost:5432/","theorderdata","postgres","postgres1234");
        launch(args);
    }
    
}
