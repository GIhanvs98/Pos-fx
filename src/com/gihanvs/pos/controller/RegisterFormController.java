package com.gihanvs.pos.controller;

import com.gihanvs.pos.DatabaseCode;
import com.gihanvs.pos.model.User;
import com.gihanvs.pos.utill.PasswordHash;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

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
        try {
            DatabaseCode.registerUser(
                    new User(
                            UUID.randomUUID().toString(),
                            txtEmail.getText(),
                            txtName.getText(),
                            txtContact.getText(),
                            PasswordHash.hashPassword(txtPW.getText())
                            ));
            setUi("LoginForm");
            new Alert(Alert.AlertType.INFORMATION, "Register Successfully").show();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml"))));
    }
}
