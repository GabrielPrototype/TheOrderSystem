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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author titan
 */
public class FXMLOrderManagerController implements Initializable {

    @FXML
    private Button btnNew;
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
    private TableColumn<?, ?> colCustomerName;
    @FXML
    private AnchorPane pnData;
    @FXML
    private AnchorPane pnData2;
    @FXML
    private TextField tfieldCustomerID;
    @FXML
    private TextField tfieldCustomerName;
    @FXML
    private TextField tfieldCustomerCity;
    @FXML
    private Button btnSearchCustomer;
    @FXML
    private TitledPane tviewProducts;
    @FXML
    private TextField tfieldID;
    @FXML
    private DatePicker dtpData;
    @FXML
    private TextField tfieldFCost;
    @FXML
    private AnchorPane pnData1;
    @FXML
    private ComboBox<?> cbCategory;
    @FXML
    private ComboBox<?> cbProduct;
    @FXML
    private TextField tfieldPrice;
    @FXML
    private TextField tfieldQuant;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tfieldOrderID;
    @FXML
    private Button btnModify;

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
        
        // o confirmar tem fazer loop para adicionar todos os itens da table view de produtos também
    }

    @FXML
    private void btnCancel_Action(ActionEvent event) {
    }

    @FXML
    private void btnSearch_Action(ActionEvent event) {
    }

    @FXML
    private void tviewResult_MouseClicked(MouseEvent event) {
    }

    @FXML
    private void tviewProducts_MouseClicked(MouseEvent event) {
    }

    @FXML
    private void cbCategory_Action(ActionEvent event) {
    }

    @FXML
    private void btnAddModify_Action(ActionEvent event) {
    }
    
}
