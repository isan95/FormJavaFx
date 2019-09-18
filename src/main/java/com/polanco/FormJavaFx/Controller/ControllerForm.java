/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.FormJavaFx.Controller;

import com.polanco.FormJavaFx.Data.Client;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 *
 * @author POLANCO
 */
public class ControllerForm {
    private ArrayList clients = new ArrayList<Client>();
    ObservableList<String> options = FXCollections.observableArrayList(
            "Soltero",
            "Casado",
            "Divorciado",
            "Viudo"
            );
    private boolean buttonEditClicked = false;
    @FXML
    private TextField txtCod;
    
    @FXML
    private TextField txtName;
    
    @FXML
    private TextField txtLastName;
    
    @FXML
    private TextField txtMotherLastName;
    
    @FXML
    private TextField txtDNI;
    
    @FXML
    private TextField txtMail;
    
    @FXML
    private TextField txtUser;
    
    @FXML
    private DatePicker chooserCalendar;
    
    @FXML
    private  ComboBox <String> cbbStatus;
   
    
    @FXML
    private PasswordField txtPass;
    
    @FXML
    private RadioButton radBtnMale;
    
    @FXML
    private RadioButton radBtnFemale;
    
    @FXML
    private ToggleGroup sexGroup;
    
    @FXML
    private Button btnNew;
    
    @FXML
    private Button btnQuit;
    
    @FXML
    private Button btnDel;
    
    @FXML
    private Button btnEdit;
    
    @FXML
    private Button  btnSave;
    
    @FXML
    private Button btnSearch;
    
    public void initialize(){
       cbbStatus.setItems(options);
    }
    
    @FXML
    public void newClient(ActionEvent e){
        txtCod.setText("");
        txtName.setText("");
        txtLastName.setText("");
        txtMotherLastName.setText("");
        txtMail.setText("");
        txtDNI.setText("");
        txtUser.setText("");
        sexGroup.selectToggle(null);
        chooserCalendar.setValue(null);
        cbbStatus.setValue("");
        txtPass.setText("");
    }
    
    @FXML 
    public void saveClient(ActionEvent e){
        boolean encontrado = false;
        int indexAux = 0; //posicion del objecto encontrado
        for(int i = 0;i<clients.size();i++){
            Client aux = (Client)clients.get(i);
            if(aux.getCod().equals(txtCod.getText())){
                encontrado = true;
                indexAux = i;
                break;
            }
        }
        if(encontrado && !buttonEditClicked){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText("Existe un cliente registrado con este codigo");
            alert.showAndWait();
        }
        else if(!encontrado && !buttonEditClicked){
            clients.add(new Client(txtCod.getText(),txtName.getText(),txtLastName.getText(),txtMotherLastName.getText(),txtDNI.getText(),chooserCalendar.getValue(),cbbStatus.getValue(),txtMail.getText(),txtUser.getText(),txtPass.getText(), (RadioButton)sexGroup.getSelectedToggle()));
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText("Cliente registrado");
            alert.showAndWait();
        }
        else if(encontrado && buttonEditClicked){
            clients.remove(indexAux);
            clients.add(new Client(txtCod.getText(),txtName.getText(),txtLastName.getText(),txtMotherLastName.getText(),txtDNI.getText(),chooserCalendar.getValue(),cbbStatus.getValue(),txtMail.getText(),txtUser.getText(),txtPass.getText(), (RadioButton)sexGroup.getSelectedToggle()));
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText("Cliente editado");
            buttonEditClicked = false;
            alert.showAndWait();
        }
        
    }
    
    @FXML
    public void del(ActionEvent e){
        boolean deleted = false;
        for(int i = 0;i<clients.size();i++){
            Client aux = (Client)clients.get(i);
            if(aux.getCod().equals(txtCod.getText())){
                clients.remove(i);
                deleted = true;
                break;
            }
        }
        if(deleted){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText("Cliente eliminado");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText("Cliente inexistente");
            alert.showAndWait();
        }
    }
    
    @FXML
    public void edit(ActionEvent e){
        boolean encontrado = false;
        Client aux = new Client();
        for(int i = 0;i<clients.size();i++){
            aux = (Client)clients.get(i);
            if(aux.getCod().equals(txtCod.getText())){
                encontrado = true;
                break;
            }
        }
        if(encontrado){
                txtCod.setText(aux.getCod());
                txtName.setText(aux.getName());
                txtLastName.setText(aux.getLastName());
                txtMotherLastName.setText(aux.getMotherLastName());
                txtMail.setText(aux.getMail());
                txtDNI.setText(aux.getDNI());
                txtUser.setText(aux.getUser());
                sexGroup.selectToggle(aux.getSex());
                chooserCalendar.setValue(aux.getfNacimiento());
                cbbStatus.setValue(aux.getStatus());
                buttonEditClicked = true;
           
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText("Cliente inexistente");
        }
    }
    
    @FXML
    public void quit(ActionEvent e){
        System.exit(0);
    }
    
    @FXML
    public void search(ActionEvent e){
        boolean encontrado = false;
        for(int i = 0;i<clients.size();i++){
            Client aux = (Client)clients.get(i);
            if(aux.getCod().equals(txtCod.getText())){
                
                txtCod.setText(aux.getCod());
                txtName.setText(aux.getName());
                txtLastName.setText(aux.getLastName());
                txtMotherLastName.setText(aux.getMotherLastName());
                txtMail.setText(aux.getMail());
                txtDNI.setText(aux.getDNI());
                txtUser.setText(aux.getUser());
                sexGroup.selectToggle(aux.getSex());
                chooserCalendar.setValue(aux.getfNacimiento());
                cbbStatus.setValue(aux.getStatus());
                encontrado = true;
                break;

            }
            
        }
        if(encontrado){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText("Cliente encontrado");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText("Cliente no existe");
            alert.showAndWait();
        }
    
    }
    
    @FXML
    void selectFemale(ActionEvent event) {
         
    }

    @FXML
    void selectMale(ActionEvent event) {
        
    }

    
}
