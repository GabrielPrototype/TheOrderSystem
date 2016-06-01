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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import theordersystem.db.controlers.CategoriasController;
import theordersystem.db.entities.Categoria;

/**
 * FXML Controller class
 *
 * @author titan
 */
public class FXMLCategoryManagerController implements Initializable {

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
    private AnchorPane pnInfos;
    @FXML
    private TextField tfieldCod;
    @FXML
    private TextArea tareaDescription;
    @FXML
    private TextField tfieldSearch;
    @FXML
    private TableView<Categoria> tviewResult;
    @FXML
    private TableColumn colCod;
    @FXML
    private TableColumn colName;
    @FXML
    private TextField tfieldName;
    @FXML
    private TableColumn colDesc;
    @FXML
    private Button btnSearch;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colCod.setCellValueFactory(new PropertyValueFactory("categoriaID"));
        colName.setCellValueFactory(new PropertyValueFactory("nome"));
        colDesc.setCellValueFactory(new PropertyValueFactory("descricao"));
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

        LoadTableView("");
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
    
    private void LoadTableView(String filtro)
    {  CategoriasController ctr = new CategoriasController();
       ArrayList <Categoria> res = ctr.getCategorias(filtro);
       ObservableList<Categoria> modelo;
       modelo = FXCollections.observableArrayList(res);
       tviewResult.setItems(modelo);
    }
    
    @FXML
    private void btnNew_Action(ActionEvent event) {
        LayoutEditing();
        tfieldCod.setDisable(true);
    }

    @FXML
    private void btnModify_Action(ActionEvent event) {
        Categoria cat = (Categoria) tviewResult.getSelectionModel().getSelectedItem();
        tfieldCod.setText("" + cat.getCategoriaID());
        tfieldName.setText(cat.getNome());
        tareaDescription.setText("" + cat.getDescricao());
        LayoutEditing();   
    }

    @FXML
    private void btnConfirm_Action(ActionEvent event) {
        int cod;
        try {
            cod = Integer.parseInt(tfieldCod.getText());
        } catch (Exception e) {
            cod = 0;
        }
        Categoria cat = new Categoria(cod, tfieldName.getText(), 
                                    tareaDescription.getText());
        
        CategoriasController ctr = new CategoriasController();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        if (cat.getCategoriaID()== 0) // novo cadastro
        {
            if (ctr.save(cat)) {
                a.setContentText("Gravado com Sucesso");
            } else {
                a.setContentText("Problemas ao Gravar");
            }
        } else //alteração de cadastro
        {
            if (ctr.modify(cat)) {
                a.setContentText("Alterado com Sucesso");
            } else {
                a.setContentText("Problemas ao Alterar");
            }
        }
        a.showAndWait();
        LayoutOriginal();
    }

    @FXML
    private void btnCancel_Action(ActionEvent event) {
        LayoutOriginal();
    }

    @FXML
    private void btnDelete_Action(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Confirma a exclusão?");
        if (a.showAndWait().get() == ButtonType.OK) 
        {
            CategoriasController ctr = new CategoriasController();
            Categoria cat;
            cat = tviewResult.getSelectionModel().getSelectedItem();
            ctr.delete(cat);
            LoadTableView("");
        }
    }

    @FXML
    private void tfieldSearch_Action(ActionEvent event) {
        LoadTableView("upper(nome) like '%"+tfieldSearch.getText().toUpperCase()+"%'");
    }

    @FXML
    private void btnSearch_Action(ActionEvent event) {
        LoadTableView("upper(nome) like '%"+tfieldSearch.getText().toUpperCase()+"%'");
    }

    @FXML
    private void tviewResult_MouseClicked(MouseEvent event) {
        if (tviewResult.getSelectionModel().getSelectedIndex() >= 0)
        {
            btnDelete.setDisable(false);
            btnModify.setDisable(false);
        }
    }
    
}
