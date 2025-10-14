package com.gihanvs.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ResetPassWordFormController {
    public AnchorPane context;
    public Label lblCompany;
    public Label lblVersion;

    public void backToScreenOnAction(ActionEvent actionEvent) throws IOException {
    setUi("VerifyContactForm");
    }

    public void resetPasswordOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");

    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml"))));
    }

}
