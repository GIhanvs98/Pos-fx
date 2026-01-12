package com.gihanvs.pos.bo.custom;

import com.gihanvs.pos.dto.request.RequestCustomerDto;
import com.gihanvs.pos.dto.response.ResponseCustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo {
    public boolean saveCustomer(RequestCustomerDto requestCustomerDto) throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(RequestCustomerDto requestCustomerDto) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public ResponseCustomerDto findCustomerById(String id) throws SQLException, ClassNotFoundException;
    public List<ResponseCustomerDto> findCustomerByName(String text) throws SQLException, ClassNotFoundException;
    public List<ResponseCustomerDto> findAllCustomers() throws SQLException, ClassNotFoundException;
}
