package com.gihanvs.pos.controller;

import com.gihanvs.pos.env.StaticResource;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {
    public Label lblCompany;
    public Label lblVersion;
    public AnchorPane context;

    public void initialize() {
        setStaticData();
    }

    private void setStaticData() {
        lblCompany.setText(StaticResource.getCOMPANY());
        lblVersion.setText(StaticResource.getVERSION());
    }

    public void openLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    public void openRegisterFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RegisterForm");
    }
    private void setUi(String location) throws IOException {
        URL resource = getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml");
        Parent fxmlLoader = FXMLLoader.load(resource);
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader));

    }
}
