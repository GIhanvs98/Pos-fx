package com.gihanvs.pos.controller;

import com.gihanvs.pos.env.StaticResource;
import javafx.scene.control.Label;

public class MainFormController {
    public Label lblCompany;
    public Label lblVersion;

    public void initialize() {
        setStaticData();
    }

    private void setStaticData() {
        lblCompany.setText(StaticResource.getCOMPANY());
        lblVersion.setText(StaticResource.getVERSION());
    }
}
