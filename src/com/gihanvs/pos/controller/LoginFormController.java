package com.gihanvs.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane context;
    public Label lblCompany;
    public Label lblVersion;

    public void navigateToForgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ForgotPassword");
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoard");
    }

    public void backToScreenOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MainForm");
    }
    private void setUi(String location) throws IOException {
        URL resource = getClass().getResource("/com/gihanvs/pos/view/+"+location+".fxml");
        Parent fxmlLoader = FXMLLoader.load(resource);
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader));

    }
}
