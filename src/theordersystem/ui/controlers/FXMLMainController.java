/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.ui.controlers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import static theordersystem.TheOrderSystem.databaseConfigs;
import theordersystem.db.util.Database;

/**
 * FXML Controller class
 *
 * @author Gabriel Longo P. Abreu
 * @author Aleksander Silva
 */
public class FXMLMainController implements Initializable {

    @FXML
    private Button btNewOrder;
    @FXML
    private Button btSearchOrder;
    @FXML
    private MenuItem miCategories;
    @FXML
    private MenuItem miCustomers;
    @FXML
    private MenuItem miConfig;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (!Database.openConnectionDB())
        {
            System.out.println("Erro: "+Database.getCon().getErrorMessage());
        }
    }    

    @FXML
    private void miCategories_Action(ActionEvent event) {
        try
        {
           Stage stage = new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("/theordersystem/ui/FXMLCategoryManager.fxml"));
        
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
        }catch(Exception e){System.out.println(e);}
    }

    @FXML
    private void miCustomers_Action(ActionEvent event) {
        
    }

    @FXML
    private void miConfig_Action(ActionEvent event) {
        try
        {
           Stage stage = new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("/theordersystem/ui/FXMLConfigs.fxml"));
        
           Scene scene = new Scene(root);
           stage.setScene(scene); 
//           dialog.setMinWidth(computeMinWidth(getHeight()) + (dialog.getWidth() - scene.getWidth()));
//           dialog.setMinHeight(computeMinHeight(getWidth()) + (dialog.getHeight() - scene.getHeight())
//           stage.setMinWidth(stage.getWidth());
//           stage.setMinHeight(stage.getHeight());
           stage.setResizable(false);
           stage.show();
        }catch(Exception e){System.out.println(e);}
    }
    
}
