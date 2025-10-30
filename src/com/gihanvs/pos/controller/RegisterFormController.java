package com.gihanvs.pos.controller;

import com.gihanvs.pos.bo.BoFactory;
import com.gihanvs.pos.bo.custom.impl.UserBoImpl;
import com.gihanvs.pos.dto.request.RequestUserDto;
import com.gihanvs.pos.model.User;
import com.gihanvs.pos.utill.BoType;
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
    
    UserBoImpl userBoImple=BoFactory.getInstance().getBoFactory(BoType.USER);
    

    public void backToScreenOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MainForm");
    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        try {
            boolean isRegister = userBoImple.registeruser(
                    new RequestUserDto(txtEmail.getText(),
                            txtName.getText(),
                            txtContact.getText(),
                            txtPW.getText()));
            if (isRegister) {
                new Alert(Alert.AlertType.INFORMATION,"User registered successfully").show();
                setUi("LoginForm");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
      /*  try {
          boolean isSaved = DatabaseCode.registerUser(
                    new User(
                            UUID.randomUUID().toString(),
                            txtEmail.getText(),
                            txtName.getText(),
                            txtContact.getText(),
                            PasswordHash.hashPassword(txtPW.getText())
                            ));
          if (isSaved) {
              setUi("LoginForm");
              new Alert(Alert.AlertType.INFORMATION, "Register Successfully").show();
              return;
          }
          new Alert(Alert.AlertType.WARNING, "Register Failed").show();

        } catch (ClassNotFoundException | SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong..").show();
        }*/
        


    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml"))));
    }
}
