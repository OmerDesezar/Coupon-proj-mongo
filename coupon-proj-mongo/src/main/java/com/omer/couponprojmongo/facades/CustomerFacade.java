package com.omer.couponprojmongo.facades;

import com.omer.couponprojmongo.exceptions.WrongCredentialsException;
import com.omer.couponprojmongo.model.Customer;
import com.omer.couponprojmongo.services.CustomerService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ToString
@Service
public class CustomerFacade implements ClientFacade {

    @Autowired
    private CustomerService service;
    private Customer customer;
    private Boolean isLoggedIn = false;


    @Override
    public CustomerFacade login(String email, String password)throws WrongCredentialsException {
        if (service.isCustomerExists(email, password)){
            customer = service.findByEmail(email).get();
            isLoggedIn = true;
        }else {
            throw new WrongCredentialsException();
        }
        return this;
    }
}
