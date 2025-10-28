package com.gihanvs.pos.controller;

import com.gihanvs.pos.model.LoginData;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane context;
    public Label lblCompany;
    public Label lblVersion;
    public TextField txtEmail;
    public PasswordField txtPassword;

    public void navigateToForgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ForgotPasswordFrom");

    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
      /*  try {
            LoginData loginData = DatabaseCode.loginUser(txtEmail.getText().toLowerCase(), txtPassword.getText());
            if (loginData.isStatus()){
                new Alert(Alert.AlertType.INFORMATION, "Welcome "+loginData.getDisplayName(), ButtonType.OK).show();
                setUi("DashboardForm");
            } else {
                new Alert(Alert.AlertType.ERROR, loginData.getMsg()).show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }*/

    }

    public void backToScreenOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MainForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml"))));
    }

}
