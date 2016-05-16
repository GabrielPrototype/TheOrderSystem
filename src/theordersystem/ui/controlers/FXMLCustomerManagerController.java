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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author titan
 */
public class FXMLCustomerManagerController implements Initializable {

    @FXML
    private Button btnew;
    @FXML
    private Button btmodify;
    @FXML
    private Button btapagar;
    @FXML
    private Button btconfirmar;
    @FXML
    private Button btcancelar;
    @FXML
    private BorderPane pnlateral;
    @FXML
    private TextField txpesquisa;
    @FXML
    private Button btpesquisar;
    @FXML
    private TableView<?> tableCustomers;
    @FXML
    private TableColumn<?, ?> colcod;
    @FXML
    private TableColumn<?, ?> colnome;
    @FXML
    private AnchorPane pndados;
    @FXML
    private TextField txcodigo;
    @FXML
    private TextField txnome;
    @FXML
    private TextField txpeso;
    @FXML
    private DatePicker dtdtnasc;
    @FXML
    private ComboBox<?> cbraca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void evtBtNovo(ActionEvent event) {
    }

    @FXML
    private void evtBtAlterar(ActionEvent event) {
    }

    @FXML
    private void evtBtApagar(ActionEvent event) {
    }

    @FXML
    private void evtBtConfirmar(ActionEvent event) {
    }

    @FXML
    private void evtBtCancelar(ActionEvent event) {
    }

    @FXML
    private void evtBtPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtClickTabela(MouseEvent event) {
    }
    
}
