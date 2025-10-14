package com.gihanvs.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class RegisterFormController {
    public AnchorPane context;
    public Label lblCompany;
    public Label lblVersion;
    public TextField txtEmail;
    public PasswordField txtPW;
    public TextField txtContact;
    public TextField txtName;

    public void backToScreenOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MainForm");
    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml"))));
    }
}
