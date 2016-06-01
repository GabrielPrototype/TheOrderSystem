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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import theordersystem.db.controlers.ProdutosController;
import theordersystem.db.entities.Produto;

/**
 * FXML Controller class
 *
 * @author Ale
 */
public class FXMLProd implements Initializable {

    @FXML
    private Button btNovo;
    @FXML
    private Button btAlterar;
    @FXML
    private Button btApagar;
    @FXML
    private Button btConfirmar;
    @FXML
    private Button btCancelar;
    @FXML
    private BorderPane painelBusca;
    @FXML
    private TextField txPesquisar;
    @FXML
    private Button btPesquisar;
    @FXML
    private TableView<?> tbProdutos;
    @FXML
    private TableColumn<?, ?> colCod;
    @FXML
    private TableColumn<?, ?> colDescr;
    @FXML
    private TableColumn<?, ?> colPreco;
    @FXML
    private AnchorPane painelDados;
    @FXML
    private TextField txCodigo;
    @FXML
    private TextField txDescr;
    @FXML
    private TextField txPreco;
    @FXML
    private ComboBox<?> cbUnidade;
    @FXML
    private ListView<?> ltTipoProd;

    /**
     * Initializes the controller class.
     */
    public void estadoOriginal() 
    {
        painelBusca.setDisable(false);
        painelDados.setDisable(true);

        btConfirmar.setDisable(true);
        btCancelar.setDisable(false);
        btApagar.setDisable(true);
        btAlterar.setDisable(true);
        btNovo.setDisable(false);

        ObservableList<Node> componentes = painelDados.getChildren(); //”limpa” os componentes
        for (Node n : componentes) 
        {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
            if (n instanceof ComboBox) {
                ((ComboBox) n).getSelectionModel().select(0);
            }
            if (n instanceof ListView){
                ((ListView) n).getSelectionModel().select(0);
            }
        }
        LoadTableView("");
    }
    private void LoadTableView(String filtro)
    {  
       ProdutosController ctr = new ProdutosController();
       ArrayList <Produto> res = ctr.getProdutos(filtro);
       ObservableList<Produto> modelo;
       modelo = FXCollections.observableArrayList(res);
     //  tbProdutos.setItems(modelo);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clkNovo(ActionEvent event) {
    }

    @FXML
    private void clkAlterar(ActionEvent event) {
    }

    @FXML
    private void clkApagar(ActionEvent event) {
    }

    @FXML
    private void clkConfirmar(ActionEvent event) {
    }

    @FXML
    private void clkCancelar(ActionEvent event) {
    }

    @FXML
    private void clkPesquisar(ActionEvent event) {
    }

    @FXML
    private void clkClickTabela(MouseEvent event) {
    }

    @FXML
    private void clkTipoProd(MouseEvent event) {
    }
    
}
