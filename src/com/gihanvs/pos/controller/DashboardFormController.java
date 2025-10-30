package com.gihanvs.pos.controller;

import com.gihanvs.pos.env.StaticResource;
import com.gihanvs.pos.env.SystemVariables;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DashboardFormController {
    public Label lblCompany;
    public Label lblVersion;
    public Label lblDate;
    public Label lblTime;
    public AnchorPane context;
    public Label lblUser;

    public void initialize() {
        try{
            if(SystemVariables.responseUserDto==null) logout();

        }catch(Exception e){
            throw  new RuntimeException(e);
        }
        setSystemUserDetails();

        setStaticData();
        setDateAndTime();
    }

    private void setSystemUserDetails() {
        lblUser.setText(SystemVariables.responseUserDto.getDisplayName());
    }

    private void logout() throws IOException {
        if (SystemVariables.responseUserDto==null) {

            setUi("LoginForm");
        }
    }

    private void setDateAndTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE-yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm:ss a", Locale.ENGLISH);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),event -> {
            LocalDateTime now=LocalDateTime.now();
            lblDate.setText(dateFormatter.format(now));
            lblTime.setText(timeFormatter.format(now));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void setStaticData() {
        lblCompany.setText(StaticResource.getCOMPANY());
        lblVersion.setText(StaticResource.getVERSION());

    }

    public void logoutOnAction(ActionEvent actionEvent)  {
        SystemVariables.responseUserDto=null;
      try{
          logout();
      }catch(Exception e){
          throw  new RuntimeException(e);
      }

    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml"))));
    }
}
