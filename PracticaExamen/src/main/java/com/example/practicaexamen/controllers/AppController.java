package com.example.practicaexamen.controllers;

import com.example.practicaexamen.model.Contacto;
import com.example.practicaexamen.services.ContactoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private ComboBox<String> cbParentesco;

    @FXML
    private ListView<Contacto> listView;

    @FXML
    private Label lblMsg;

    private ObservableList<Contacto> data = FXCollections.observableArrayList();
    private ContactoService service = new ContactoService();

    @FXML
    public void initialize() {
        listView.setItems(data);

        cbParentesco.getItems().addAll(service.parentescos);

        refresh();

        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> cargarFormulario(newVal)
        );
    }

    private void refresh() {
        data.setAll(service.getAll());
    }

    private void cargarFormulario(Contacto c) {
        if (c == null) return;

        txtNombre.setText(c.getNombre());
        txtTelefono.setText(c.getTelefono());
        cbParentesco.setValue(c.getParentesco());
    }

    @FXML
    public void onAgregar() {
        try {
            service.agregar(txtNombre.getText(), txtTelefono.getText(), cbParentesco.getValue());

            lblMsg.setText("Contacto agregado");
            lblMsg.setStyle("-fx-text-fill: green");

            limpiar();
            refresh();

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onBuscar() {
        Contacto c = service.buscar(txtNombre.getText());

        if (c != null) {
            cargarFormulario(c);
            lblMsg.setText("Contacto encontrado");
        } else {
            lblMsg.setText("No encontrado");
        }
    }

    @FXML
    public void onActualizar() {
        try {
            service.actualizar(txtNombre.getText(), txtTelefono.getText(), cbParentesco.getValue());
            lblMsg.setText("Actualizado");
            lblMsg.setStyle("-fx-text-fill: green");
            refresh();
            limpiar();

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onEliminar() {
        try {
            service.eliminar(txtNombre.getText());
            lblMsg.setText("Eliminado");
            lblMsg.setStyle("-fx-text-fill: green");

            refresh();
            limpiar();

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onLimpiar() {
        limpiar();
    }

    private void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }
}