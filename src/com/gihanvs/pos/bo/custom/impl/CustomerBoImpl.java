package com.gihanvs.pos.bo.custom.impl;

import com.gihanvs.pos.bo.custom.CustomerBo;
import com.gihanvs.pos.dao.DaoFactory;
import com.gihanvs.pos.dao.custom.CustomerDao;
import com.gihanvs.pos.dto.request.RequestCustomerDto;
import com.gihanvs.pos.dto.response.ResponseCustomerDto;
import com.gihanvs.pos.entity.Customer;
import com.gihanvs.pos.utill.DaoType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao= DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
    @Override
    public boolean saveCustomer(RequestCustomerDto requestCustomerDto) throws SQLException, ClassNotFoundException {
       return  customerDao.save(toCustomer(requestCustomerDto));
    }

    @Override
    public boolean updateCustomer(RequestCustomerDto requestCustomerDto) throws SQLException, ClassNotFoundException {
      return customerDao.update(toCustomer(requestCustomerDto));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
      return   customerDao.delete(id);
    }

    @Override
    public ResponseCustomerDto findCustomerById(String id) throws SQLException, ClassNotFoundException {
       return toResponseCustomerDto(customerDao.findById(id));

    }

    @Override
    public List<ResponseCustomerDto> findCustomerByName(String text) throws SQLException, ClassNotFoundException {
        List<ResponseCustomerDto> responseCustomerDtos = new ArrayList<>();
        List<Customer> customerListByName = customerDao.findByName(text);

        for (Customer customer : customerListByName) {
            responseCustomerDtos.add(toResponseCustomerDto(customer));
        }
        return responseCustomerDtos;

    }

    @Override
    public List<ResponseCustomerDto> findAllCustomers() throws SQLException, ClassNotFoundException {
        List<Customer> set = customerDao.findAll();
        List<ResponseCustomerDto> responseCustomerDtos = new ArrayList<>();
       for (Customer customer : set) {
           responseCustomerDtos.add(toResponseCustomerDto(customer));
       }
       return responseCustomerDtos;
    }

    private ResponseCustomerDto toResponseCustomerDto(Customer customer) {
        if(customer == null) return null;
        return new ResponseCustomerDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
    }
    private Customer toCustomer(RequestCustomerDto requestCustomerDto) {
        if(requestCustomerDto == null) {
            return null;
        } else if (requestCustomerDto.getId()!=null) {
            return new Customer(requestCustomerDto.getId(),requestCustomerDto.getName(),requestCustomerDto.getSalary(),requestCustomerDto.getAddress());

        }
        return new Customer(UUID.randomUUID().toString(),requestCustomerDto.getName(),requestCustomerDto.getSalary(),requestCustomerDto.getAddress());
    }
}
