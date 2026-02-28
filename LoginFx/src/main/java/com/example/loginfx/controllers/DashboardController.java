package com.example.loginfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML
    private Label lblBIENVENIDA;

    public void setCorreo(String correo){
        String nombre = correo.split("@")[0];
        lblBIENVENIDA.setText("Bienvenido " + nombre);
    }
}
