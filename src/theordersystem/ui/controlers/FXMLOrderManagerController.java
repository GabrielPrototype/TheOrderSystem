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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import theordersystem.db.controlers.ClienteController;
import theordersystem.db.controlers.ItemPedidoController;
import theordersystem.db.controlers.PedidoController;
import theordersystem.db.entities.Categoria;
import theordersystem.db.entities.Cliente;
import theordersystem.db.entities.ItemPedido;
import theordersystem.db.entities.Pedido;
import theordersystem.db.entities.Produto;

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
    private TableView<Pedido> tviewResult;
    @FXML
    private TableColumn colCod;
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
    private TextField tfieldID;
    @FXML
    private DatePicker dtpData;
    @FXML
    private TextField tfieldFCost;
    @FXML
    private ComboBox<Categoria> cbCategory;
    @FXML
    private ComboBox<Produto> cbProduct;
    @FXML
    private TextField tfieldPrice;
    @FXML
    private TextField tfieldQuant;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tfieldOrderID;
    @FXML
    private Button btnModify;
    @FXML
    private TableView<ItemPedido> tviewProds;
    @FXML
    private Button btnAddProd;
    @FXML
    private Button btnDeleteProd;
    @FXML
    private Button btnModifyProd;
    @FXML
    private TabPane tabpaneOrder;
    @FXML
    private Tab tabInfo;
    @FXML
    private Tab tabProd;
    @FXML
    private Button btnLoadCustomer;
    @FXML
    private TableColumn<?, ?> colDate;
    @FXML
    private TableColumn<?, ?> colPrice;
    @FXML
    private TitledPane tpaneClient;
    @FXML
    private AnchorPane apaneInfoClient;
    @FXML
    private TitledPane tpanaInfo;
    @FXML
    private AnchorPane apaneInfo;
    
    /*
        not FX atributes
    */
    private ArrayList<ItemPedido> ItensPedidos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        LayoutOriginal();
    }    
    
    private void LayoutOriginal() 
    {
        pnSearch.setDisable(false);
        pnData.setDisable(true);
        pnData2.setDisable(true);
        btnConfirm.setDisable(true);
        btnCancel.setDisable(false);
        btnDelete.setDisable(true);
        btnModify.setDisable(true);
        btnNew.setDisable(false);

        ObservableList<Node> componentes = apaneInfo.getChildren(); //”limpa” os componentes
        for (Node n : componentes) {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
        }
        
        componentes = apaneInfoClient.getChildren(); //”limpa” os componentes
        for (Node n : componentes) {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
        }
        
        componentes = pnData2.getChildren(); //”limpa” os componentes
        for (Node n : componentes) {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
        }
        ItensPedidos = new ArrayList();
        LoadTableView("");
    }
    
    private void LoadTableView(String filtro)
    {  PedidoController ctr = new PedidoController();
       ArrayList <Pedido> res = ctr.getPedidos(filtro);  
       ObservableList<Pedido> modelo;
       modelo = FXCollections.observableArrayList(res);
       tviewResult.setItems(modelo);
       
    }
    
    private void LoadTableViewProducts(ObservableList<ItemPedido> modelo)
    {  
        // use this http://stackoverflow.com/questions/35436199/casting-arraylist-to-observablelist-for-tableview
        tviewProds.setItems(modelo);
        
      
    }
    
    private void LayoutEditing()
    {    
          tfieldID.setEditable(false);
          pnSearch.setDisable(true);
          pnData.setDisable(false);
          pnData2.setDisable(false);
          btnConfirm.setDisable(false);
          btnDelete.setDisable(true);
          btnModify.setDisable(true);
          tfieldID.requestFocus();  
     }
    
    @FXML
    private void btnNew_Action(ActionEvent event) {
        LayoutEditing();
    }

    @FXML
    private void btnModify_Action(ActionEvent event) {
        LayoutEditing();
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
        LayoutOriginal();
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
    private void btnAddProd_Action(ActionEvent event) {
    }

    @FXML
    private void btnDeleteProd_Action(ActionEvent event) {
    }

    @FXML
    private void btnModifyProd_Action(ActionEvent event) {
    }

    @FXML
    private void tabInfo_Changed(Event event) {
    }

    @FXML
    private void tabProd_Changed(Event event) {
    }
    
}
