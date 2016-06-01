/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.ui.controlers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import theordersystem.db.controlers.CategoriasController;
import theordersystem.db.controlers.ProdutosController;
import theordersystem.db.entities.Categoria;
import theordersystem.db.entities.Produto;

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
    private TableView<Produto> tviewResult;
    @FXML
    private TableColumn colCod;
    @FXML
    private TableColumn colName;
    @FXML
    private AnchorPane pnInfos;
    @FXML
    private TextField tfieldID;
    @FXML
    private TextField tfieldName;
    @FXML
    private TextField tfieldPrice;
    @FXML
    private TextField tfieldEst;
    @FXML
    private TableColumn colPrice;
    @FXML
    private ComboBox<Categoria> cbCategory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCod.setCellValueFactory(new PropertyValueFactory("produtoID"));
        colName.setCellValueFactory(new PropertyValueFactory("nome"));
        colPrice.setCellValueFactory(new PropertyValueFactory("preco"));
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
            
            if (n instanceof ComboBox) {
                ((ComboBox) n).getItems().clear();
            }
        }

        LoadTableView("");
    }
    
    private void LayoutEditing()
    {     // carregar os componentes da tela (listbox, combobox, ...)
          // p.e. : carregaEstados();
          tfieldID.setEditable(false);
          pnSearch.setDisable(true);
          pnInfos.setDisable(false);
          btnConfirm.setDisable(false);
          btnDelete.setDisable(true);
          btnModify.setDisable(true); 
     }
    
    private void LoadTableView(String filtro)
    {  ProdutosController ctr = new ProdutosController();
       ArrayList <Produto> res = ctr.getProdutos(filtro);
       ObservableList<Produto> modelo;
       modelo = FXCollections.observableArrayList(res);
       tviewResult.setItems(modelo);
       
       CategoriasController catCtrl = new CategoriasController();
       ArrayList <Categoria> cats = catCtrl.getCategorias("");
       cbCategory.setItems(FXCollections.observableArrayList(cats));
    }
    
    @FXML
    private void btnNew_Action(ActionEvent event) {
        LayoutEditing();
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
