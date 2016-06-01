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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author titan
 */
public class FXMLProductManagerController implements Initializable {

    @FXML
    private Button btnNew;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private BorderPane pnSearch;
    @FXML
    private TextField tfieldSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView<?> tviewResult;
    @FXML
    private TableColumn<?, ?> colCod;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private AnchorPane pnInfos;
    @FXML
    private TextField tfieldID;
    @FXML
    private TextField tfieldName;
    @FXML
    private TextField tfieldCategoryID;
    @FXML
    private TextField tfieldPrice;
    @FXML
    private TextField tfieldEst;
    @FXML
    private TableColumn<?, ?> colPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnNew_Action(ActionEvent event) {
    }

    @FXML
    private void btnModify_Action(ActionEvent event) {
    }

    @FXML
    private void btnDelete_Action(ActionEvent event) {
    }

    @FXML
    private void btnConfirm_Action(ActionEvent event) {
    }

    @FXML
    private void btnCancel_Action(ActionEvent event) {
    }

    @FXML
    private void tfieldSearch_Action(ActionEvent event) {
    }

    @FXML
    private void btnSearch_Action(ActionEvent event) {
    }

    @FXML
    private void tviewResult_MouseClicked(MouseEvent event) {
    }
    
}
