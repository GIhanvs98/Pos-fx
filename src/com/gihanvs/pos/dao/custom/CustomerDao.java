package com.gihanvs.pos.dao.custom;

import com.gihanvs.pos.dao.CrudDao;
import com.gihanvs.pos.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao extends CrudDao<Customer,String> {
    public List<Customer> findByName(String name) throws SQLException, ClassNotFoundException;
}
