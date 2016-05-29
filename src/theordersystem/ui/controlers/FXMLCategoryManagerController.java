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
import javafx.scene.control.TextArea;
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
public class FXMLCategoryManagerController implements Initializable {

    private Button btnNew;
    private Button btnModify;
    private Button btnDelete;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    private BorderPane pnSearch;
    private AnchorPane pnInfos;
    private TextField tfieldCod;
    private TextArea tareaDescription;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LayoutOriginal();
    }    

    private void LayoutOriginal() 
    {
        pnSearch.setDisable(false);
        pnInfos.setDisable(true);

        btnConfirm.setDisable(true);
        btnCancel.setDisable(false);
        btnDelete.setDisable(true);
        btnModify.setDisable(true);
        btnNew.setDisable(false);

        ObservableList<Node> componentes = pnInfos.getChildren(); //”limpa” os componentes
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
          tfieldCod.setEditable(false);
          pnSearch.setDisable(true);
          pnInfos.setDisable(false);
          btnConfirm.setDisable(false);
          btnDelete.setDisable(true);
          btnModify.setDisable(true);
          tareaDescription.requestFocus();  
     }
    
    private void btnNew_Action(ActionEvent event) {
        LayoutEditing();
    }

    private void btnModify_Action(ActionEvent event) {
        LayoutEditing();
    }


    @FXML
    private void btnConfirm_Action(ActionEvent event) {
    }

    @FXML
    private void btnCancel_Action(ActionEvent event) {
        LayoutOriginal();
    }
    
}
