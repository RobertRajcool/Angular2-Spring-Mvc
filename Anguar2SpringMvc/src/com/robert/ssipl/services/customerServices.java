package com.robert.ssipl.services;


/**
 * Created by robert on 26/10/16.
 */
import com.robert.ssipl.model.Country;
import com.robert.ssipl.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class customerServices {
    static HashMap<Integer, Customer> customerIdMap = getcustomerIdMap();


    public customerServices() {
        super();

        if (customerIdMap == null) {
            customerIdMap = new HashMap<Integer, Customer>();
            // Creating some objects of Country while initializing
            Customer customerobj = new Customer(1, "Robert", "doss.cclawrance226@gmail.com","Star123","Star123");
            Customer lawranceobj = new Customer(2, "Lawrance", "doss.cclawrance226@gmail.com","Star123","Star123");
            Customer sathishobj = new Customer(3, "Sathis", "Sathish@gmail.com","Star123","Star123");



            customerIdMap.put(1, customerobj);
            customerIdMap.put(2, lawranceobj);
            customerIdMap.put(3, sathishobj);
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>(customerIdMap.values());
        return customers;
    }

    public Customer getCustomer(int id) {
        Customer customer = customerIdMap.get(id);
        return customer;
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(getMaxId() + 1);
        customerIdMap.put(customer.getId(), customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        if (customer.getId() <= 0)
            return null;
        customerIdMap.put(customer.getId(), customer);
        return customer;

    }

    public void deleteCustomer(int id) {
        customerIdMap.remove(id);
    }

    public static HashMap<Integer, Customer> getcustomerIdMap() {
        return customerIdMap;
    }


    // Utility method to get max id
    public static int getMaxId() {
        int max = 0;
        for (int id : customerIdMap.keySet()) {
            if (max <= id)
                max = id;

        }
        return max;
    }
}
