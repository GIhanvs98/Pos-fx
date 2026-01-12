package com.gihanvs.pos.dao.custom.impl;

import com.gihanvs.pos.dao.CrudUtill;
import com.gihanvs.pos.dao.custom.CustomerDao;
import com.gihanvs.pos.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> findByName(String name) throws SQLException, ClassNotFoundException {
        name="%"+name+"%";
        List<Customer>list=new ArrayList();
        ResultSet set = CrudUtill.execute("SELECT * FROM customer WHERE name Like ? OR address LIKE ?",
                name,name);
        while (set.next()) {
            list.add(toCustomer(set));
        }
        return list;
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
      return  CrudUtill.execute("INSERT INTO customer VALUES(?,?,?,?)",
              customer.getId(),
              customer.getName(),
              customer.getSalary(),
              customer.getAddress()
              );
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        System.out.println(customer.getId());
      return  CrudUtill.execute("UPDATE customer SET name=?,salary=?,address=? WHERE customer_id=?",
         customer.getName(),
         customer.getSalary(),
         customer.getAddress(),
          customer.getId()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
      return   CrudUtill.execute("DELETE FROM customer WHERE customer_id=?",id);
    }

    @Override
    public Customer findById(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtill.execute("SELECT * FROM customer WHERE customer_id=?", id);
        return toCustomer(set);
    }

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        List<Customer>customerList=new ArrayList();
        ResultSet set = CrudUtill.execute("SELECT * FROM customer");
       while (set.next()) {
           toCustomer(set);
       }
       return customerList;
    }
    private Customer toCustomer(ResultSet set) throws SQLException {

            return
                    new Customer(
                            set.getString(1),
                            set.getString(2),
                            set.getDouble(3),
                            set.getString(4)

            );



    }
}
