package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtBusqueda;
    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service = new PersonService();
    @FXML
    public void initialize(){
        listView.setItems(data);
        loadFromFile();
        txtBusqueda.textProperty().addListener(
                (obs, old, newValue)->{
                    filter(newValue);
                }
        );
        listView.getSelectionModel().selectedItemProperty().addListener( (obs, oldView, newView ) ->{
                    loadDataToForm(newView);
                }

        );
    }
    private void filter(String lines){
        if(lines == null || lines.isEmpty()){
            initialize();
            return;
        }
        ObservableList<String> filList = FXCollections.observableArrayList();
        String lowerCaseFilter = lines.toLowerCase();
        for(String item : data){
            String[] parts = item.split("-");
            String email = parts[1].trim().toLowerCase();
            if(email.contains(lowerCaseFilter)){
                filList.add(item);
            }
            listView.setItems(filList);

        }

    }
    public void onAddPerson(){
        try{
            String name = txtName.getText();
            String email = txtEmail.getText();
            String age = txtAge.getText();

            service.addPerson(name, email, age);
            lblMsg.setText("Persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            loadFromFile();

        }catch (IOException e){
            lblMsg.setText("Hubo un error en el archivo.");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
    @FXML
    public void onUpdate(){
        int index = listView.getSelectionModel().getSelectedIndex();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String age = txtAge.getText();

        try{
            service.updatePerson(index, name, email, age);
            loadFromFile();
            lblMsg.setText("Persona actualizada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();



        } catch (IOException e){
            lblMsg.setText("Hubo un error en el archivo.");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
    @FXML
    public void onReload(){
        loadFromFile();

    }
    @FXML
    public void onDelete(){
        int index = listView.getSelectionModel().getSelectedIndex();
        try{
            service.deletePerson(index);
            loadFromFile();
            lblMsg.setText("Persona eliminada.");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();

        } catch (IOException e) {
            lblMsg.setText("Hubo un error en la eliminacion.");
            lblMsg.setStyle("-fx-text-fill: green");

        }
    }

    private void loadFromFile(){
        try {
            List<String> items = service.loadDataforList();
            data.setAll(items);
            lblMsg.setText("Datos cargados exitosamente!");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }


    private void loadDataToForm(String item){
        if(item == null) return;
        String[] parts = item.split("-");
        txtName.setText(parts[0]);
        txtEmail.setText(parts[1]);
        txtAge.setText(parts[2]);
    }

}