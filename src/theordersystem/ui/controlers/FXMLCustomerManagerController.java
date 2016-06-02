/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.ui.controlers;

import java.net.URL;
import java.util.ArrayList;
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
import theordersystem.db.controlers.CategoriasController;
import theordersystem.db.controlers.ClienteController;
import theordersystem.db.entities.Categoria;
import theordersystem.db.entities.Cliente;

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
    private TableView<Cliente> tviewResult;
    @FXML
    private TableColumn<?, ?> colCod;
    @FXML
    private AnchorPane pnData;
    @FXML
    private TextField tfieldID;
    @FXML
    private TextField tfieldName;
    @FXML
    private TableColumn<?, ?> colName;
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
    private void LoadTableView(String filtro)
    {  ClienteController ctr = new ClienteController();
       //classe ClienteController está vazia!
       //ArrayList <Cliente> res = ctr.getClientes(filtro);  
       ObservableList<Cliente> modelo;
       //modelo = FXCollections.observableArrayList(res);
       //tviewResult.setItems(modelo);
       
       CategoriasController catCtrl = new CategoriasController();
       ArrayList <Categoria> cats = catCtrl.getCategorias("");
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
    private void btnSearch_Action(ActionEvent event)
    {
        LoadTableView("upper(nome) like '%"+tfieldSearch.getText().toUpperCase()+"%'");
    }

    @FXML
    private void tviewResult_MouseClicked(MouseEvent event)
    {
        
    }

    @FXML
    private void btnNew_Action(ActionEvent event) 
    {
        LayoutEditing();
    }

    @FXML
    private void btnModify_Action(ActionEvent event) 
    {
        LayoutEditing();
    }

    @FXML
    private void btnDelete_Action(ActionEvent event) 
    {
        
    }

    @FXML
    private void btnConfirm_Action(ActionEvent event) 
    {
        
    }

    @FXML
    private void btnCancel_Action(ActionEvent event) 
    {
        LayoutOriginal();
    }

    
}
