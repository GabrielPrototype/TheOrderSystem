/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.ui.controlers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static theordersystem.TheOrderSystem.databaseConfigs;
import theordersystem.db.util.DatabaseConfigs;

/**
 * FXML Controller class
 *
 * @author titan
 */
public class FXMLConfigsController implements Initializable {

    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField tfieldURL;
    @FXML
    private TextField tfieldDataBase;
    @FXML
    private TextField tfieldUser;
    @FXML
    private TextField tfieldPassword;
    @FXML
    private Button btnClean;
    @FXML
    private Button btnRestore;
    @FXML
    private AnchorPane inputArea;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadConfigs();
    }    
    
    private void loadConfigs(){
        tfieldURL.setText(databaseConfigs.getLocal());
        tfieldDataBase.setText(databaseConfigs.getDatabase());
        tfieldUser.setText(databaseConfigs.getUser());
        tfieldPassword.setText(databaseConfigs.getPassword());
    }
    
    @FXML
    private void btnConfirm_Action(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        
        
        //try{
            databaseConfigs = new DatabaseConfigs(    tfieldURL.getText(), tfieldDataBase.getText(), 
                                                    tfieldUser.getText(), tfieldPassword.getText());
            
        if(!databaseConfigs.writeConfigs("/Files/conf/UserConfigs.ordersys")){
           Alert a = new Alert(Alert.AlertType.INFORMATION);
           a.setContentText("Ocorreu um erro ao salvar as configurações!");
           a.showAndWait();
        } 
        stage.close();
    }

    @FXML
    private void btnCancel_Action(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        
        stage.close();
    }

    @FXML
    private void btnClean_Action(ActionEvent event) {
        ObservableList<Node> componentes = inputArea.getChildren(); //”limpa” os componentes
        for (Node n : componentes) {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
        }
    }

    @FXML
    private void btnRestore_Action(ActionEvent event) {
        loadConfigs();
    }
    
}
