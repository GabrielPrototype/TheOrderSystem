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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        try
        {
           Stage stage = new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("/theordersystem/ui/FXMLCustomerManager.fxml"));
        
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
        }catch(Exception e){System.out.println(e);}
    }
    
}
