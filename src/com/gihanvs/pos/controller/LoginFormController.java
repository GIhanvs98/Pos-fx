package com.gihanvs.pos.controller;

import com.gihanvs.pos.bo.BoFactory;
import com.gihanvs.pos.bo.custom.UserBo;
import com.gihanvs.pos.dto.response.ResponseUserDto;
import com.gihanvs.pos.model.LoginData;
import com.gihanvs.pos.utill.BoType;
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

    private UserBo userBo=BoFactory.getInstance().getBoFactory(BoType.USER);
    public void navigateToForgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ForgotPasswordFrom");

    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        try {
            ResponseUserDto loginStatus = userBo.login(txtEmail.getText(), txtPassword.getText());
            if (loginStatus!=null) {
                if (loginStatus.getStatusCode()==200) {
                    new Alert(Alert.AlertType.INFORMATION, "Welcome "+loginStatus.getDisplayName()).show();
                    setUi("DashboardForm");
                }else  {
                    new Alert(Alert.AlertType.ERROR, loginStatus.getMsg()+" :"+loginStatus.getStatusCode()).show();
                }
            }else {
                new Alert(
                        Alert.AlertType.ERROR,
                        "User not found").show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


    public void backToScreenOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MainForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml"))));
    }

}
