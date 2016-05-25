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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
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
    private AnchorPane pnData;
    @FXML
    private TextField tfieldID;
    @FXML
    private TextField tfieldName;
    @FXML
    private TextField tfieldAdress;
    @FXML
    private TextField tfieldCity;
    @FXML
    private TextField tfieldCEP;
    @FXML
    private TextField tfieldCountry;
    @FXML
    private TextField tfieldEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LayoutOriginal();
        // TODO
    }    
    
    private void LayoutOriginal() 
    {
        pnSearch.setDisable(false);
        pnData.setDisable(true);

        btnConfirm.setDisable(true);
        btnCancel.setDisable(false);
        btnDelete.setDisable(true);
        btnModify.setDisable(true);
        btnNew.setDisable(false);

        ObservableList<Node> componentes = pnData.getChildren(); //”limpa” os componentes
        for (Node n : componentes) {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
        }

        //carregaTabela("");
    }
    
    private void LayoutEditing()
    {     // carregar os componentes da tela (listbox, combobox, ...)
          // p.e. : carregaEstados();
          tfieldID.setEditable(false);
          pnSearch.setDisable(true);
          pnData.setDisable(false);
          btnConfirm.setDisable(false);
          btnDelete.setDisable(true);
          btnModify.setDisable(true);
          tfieldName.requestFocus();  
     }
    
    @FXML
    private void evtBtnNew(ActionEvent event) {
        LayoutEditing();
    }

    @FXML
    private void evtBtnModify(ActionEvent event) {
        LayoutEditing();
    }

    @FXML
    private void evtBtnDelete(ActionEvent event) {
    }

    @FXML
    private void evtBtnConfirm(ActionEvent event) {
    }

    @FXML
    private void evtBtnCancel(ActionEvent event) {
        LayoutOriginal();
    }

    @FXML
    private void btnSearch_Action(ActionEvent event) {
    }

    @FXML
    private void tviewResult_MouseClicked(MouseEvent event) {
    }
    
}
