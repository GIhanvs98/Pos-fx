package com.gihanvs.pos.controller;

import com.gihanvs.pos.env.StaticResource;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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

    public void openLoginFormOnAction(ActionEvent actionEvent) {
    }

    public void openRegisterFormOnAction(ActionEvent actionEvent) {
    }
    private void setUi(String location){

    }
}
