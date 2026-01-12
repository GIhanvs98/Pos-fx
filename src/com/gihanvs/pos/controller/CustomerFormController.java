package com.gihanvs.pos.controller;

import com.gihanvs.pos.bo.BoFactory;
import com.gihanvs.pos.bo.custom.CustomerBo;
import com.gihanvs.pos.dto.request.RequestCustomerDto;
import com.gihanvs.pos.dto.response.ResponseCustomerDto;
import com.gihanvs.pos.utill.BoType;
import com.gihanvs.pos.view.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerFormController {

    public TextField txtName;
    public TextField txtSalary;
    public TextField txtAddress;
    public TextField txtSearch;
    public TableView <CustomerTm>tblCustomer;
    public TableColumn<CustomerTm, Long> colId;
    public TableColumn<CustomerTm,String> colName;
    public TableColumn <CustomerTm,Double> colSalary;
    public TableColumn <CustomerTm,String> colAddress;
    public TableColumn <CustomerTm,Button> colOption;
    public Button btnSave;
    public AnchorPane context;
    String searchText="";
    CustomerTm selectedCustomerTm;
    CustomerBo customerBo= BoFactory.getInstance().getBoFactory(BoType.CUSTOMER);
    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText = newValue;
            setTableData(searchText);
        });
        setTableData(searchText);
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    this.selectedCustomerTm = newValue;
                    setFormData(selectedCustomerTm);

                }
        });
    }

    private void setFormData(CustomerTm tm) {
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtSalary.setText(Double.toString(tm.getSalary()));
        btnSave.setText("Update Customer");
    }

    private void setTableData(String searchText) {
        try {
            List<ResponseCustomerDto> customerByName = customerBo.findCustomerByName(searchText);
            ObservableList<CustomerTm> customerOblist= FXCollections.observableArrayList();
            for (ResponseCustomerDto customerDto : customerByName) {
                Button btn=new Button("Delete");

                customerOblist.add(new CustomerTm(
                       customerDto.getId(),
                        customerDto.getName(),
                        customerDto.getAddress(),
                        customerDto.getSalary(),
                        btn


                ));
                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Customer", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {
                        try {
                            boolean isDeleted = customerBo.deleteCustomer(customerDto.getId());
                            if (isDeleted){
                                setTableData(searchText);
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                tblCustomer.setItems(customerOblist);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashboardForm");
    }

    public void newCustomerOnAction(ActionEvent actionEvent) {
        clearFields();

    }

    private void clearFields() {
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();
    }

    public void saveOnAction(ActionEvent actionEvent) {
        try {
            if(btnSave.getText().equals("Save Customer")){
                boolean isSaved = customerBo.saveCustomer(
                        new RequestCustomerDto(
                                null,
                                txtName.getText(),
                                txtAddress.getText(),
                                Double.parseDouble(txtSalary.getText())

                        )
                );
                if(isSaved){
                    new Alert(Alert.AlertType.INFORMATION, "Customer Saved").show();
                    clearFields();
                    setTableData(searchText);
                }
            }else {
                System.out.println("update");
                boolean isUpdated = customerBo.updateCustomer(
                        new RequestCustomerDto(
                                selectedCustomerTm.getId(),
                                txtName.getText(),
                                txtAddress.getText(),
                                Double.parseDouble(txtSalary.getText())

                        )
                );
                if(isUpdated){
                    new Alert(Alert.AlertType.INFORMATION, "Customer Updated").show();
                    clearFields();
                    setTableData(searchText);
                }
            }
        }catch (ClassNotFoundException| SQLException e){

        }
    }
    public void setUi(String location) throws IOException {
        Stage stage=(Stage)  context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(
                getClass().getResource("/com/gihanvs/pos/view/"+location+".fxml")
        )));
    }
}
