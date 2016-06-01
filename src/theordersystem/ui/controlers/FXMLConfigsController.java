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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnConfirm_Action(ActionEvent event) {
    }

    @FXML
    private void btnCancel_Action(ActionEvent event) {
    }
    
}
