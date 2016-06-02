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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import theordersystem.db.controlers.CategoriasController;
import theordersystem.db.entities.Categoria;
import theordersystem.db.util.Database;

/**
 * FXML Controller class
 *
 * @author titan
 */
public class FXMLMainController implements Initializable {

    @FXML
    private MenuItem miCategories;
    @FXML
    private MenuItem miCustomers;
    @FXML
    private MenuItem miProd;
    @FXML
    private MenuItem NewOrder;
    @FXML
    private MenuItem SearchOrder;
    @FXML
    private MenuItem SearchCat;
    @FXML
    private MenuItem SearchCli;
    @FXML
    private MenuItem SearchProd;
    @FXML
    private MenuItem RelatProd;
    @FXML
    private MenuItem RelatCliente;
    @FXML
    private MenuItem miConfigs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        checkConnectionDB();
    }    
    
    private void checkConnectionDB(){
        
        if(!Database.openConnectionDB()){
            System.out.println("Erro: "+Database.getCon().getErrorMessage());
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Ocorreu ume erro na conexão com banco, deseja configura-lo?");
            
            if (a.showAndWait().get() == ButtonType.OK) 
            {
                try
                {
                   Stage stage = new Stage();
                   Parent root = FXMLLoader.load(getClass().getResource("/theordersystem/ui/FXMLConfigs.fxml"));

                   Scene scene = new Scene(root);
                   stage.setScene(scene); 
                   stage.setResizable(false);
                   stage.showAndWait();
                }catch(Exception e){System.out.println(e);}
            }
        }
        
    };
    
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
    private void miCustomers_Action(ActionEvent event) 
    {
        try
        {
           Stage stage = new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("/theordersystem/ui/FXMLCustomerManager.fxml"));
        
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
        }catch(Exception e){System.out.println(e);}
    }

    @FXML
    private void miProd_Action(ActionEvent event) {
        try
        {
           Stage stage = new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("/theordersystem/ui/FXMLProductManager.fxml"));
        
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
        }catch(Exception e){System.out.println(e);}
    }
    
    @FXML
    private void miConfigs_Action(ActionEvent event) {
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
    
    @FXML
    private void P_nprod(ActionEvent event) {
    }

    @FXML
    private void P_pprod(ActionEvent event) {
    }

    @FXML
    private void alt_cat(ActionEvent event) {
    }

    @FXML
    private void alt_cli(ActionEvent event) {
    }

    @FXML
    private void alt_prod(ActionEvent event) {
    }

    @FXML
    private void relat_prod(ActionEvent event) {
    }

    @FXML
    private void relat_cli(ActionEvent event) {
    }

    
    
}
