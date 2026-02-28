package com.example.loginfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    @FXML
    private TextField txtCORREO;
    @FXML
    private PasswordField txtCONTRASENA;
    @FXML
    private Label lblRESULTADO;


    public void onGoToLogin(ActionEvent event){
        String correo = txtCORREO.getText() == null ? "" : txtCORREO.getText();
        String password = txtCONTRASENA.getText() == null ? "" : txtCONTRASENA.getText();

        List<String> errores = new ArrayList<>();
        if(correo.isBlank() || correo.length() < 4){
            errores.add("El correo es invalido, debe contener minimo 4 caracteres.");
        }
        if(!correo.contains("@") || !correo.contains(".")){
            errores.add("El correo debe contener un @ y un .");
        }
        if(password.length()<6){
            errores.add("La contrasena debe tener minimo 6 caracteres");

        }

        if(errores.isEmpty()){
            lblRESULTADO.setText("Datos validos.");
            lblRESULTADO.setStyle("-fx-text-fill: green");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginfx/views/Dashboard.fxml"));
                Scene dashScene = new Scene(loader.load(), 500,350);
                DashboardController dashboard = loader.getController();
                dashboard.setCorreo(correo);
                Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
                stage.setScene(dashScene);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            lblRESULTADO.setText("Error de: " + String.join("\n", errores));
            lblRESULTADO.setStyle("-fx-text-fill: red");
        }
    }
}
