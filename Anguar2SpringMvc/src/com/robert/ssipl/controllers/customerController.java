package com.robert.ssipl.controllers;

import com.robert.ssipl.model.Country;
import com.robert.ssipl.model.Customer;
import com.robert.ssipl.services.countryServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.robert.ssipl.services.customerServices;

/**
 * Created by robert on 26/10/16.
 */
@RestController
public class customerController {
    customerServices customerServices = new customerServices();

    @RequestMapping(value = "/customers", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Customer> getCustomers() {
        List<Customer> listofCustomer = customerServices.getAllCustomers();
        return listofCustomer;
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Customer getCustomerById(@PathVariable int id) {
        return customerServices.getCustomer(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST, headers = "Accept=application/json")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return customerServices.addCustomer(customer);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerServices.updateCustomer(customer);

    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteCustomer(@PathVariable("id") int id) {
        customerServices.deleteCustomer(id);

    }
}
