package com.omer.couponprojmongo;

import com.omer.couponprojmongo.exceptions.AlreadyExistsException;
import com.omer.couponprojmongo.exceptions.NotExistsException;
import com.omer.couponprojmongo.model.Customer;
import com.omer.couponprojmongo.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
class CustomerTests {

    @Autowired
    private CustomerService service;

    @Test
    void contextLoads() {
    }

    @Test
    void saveCustomer(){
        Customer customer = new Customer("freddy", "kruger", "fred@derf", "777888");
        try {
            System.out.println(service.save(customer));
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAll(){
        service.findAll().forEach(System.out::println);
    }

    @Test
    void update(){
        Function<Customer, Customer> mapper = customer -> {
            customer.setEmail("fred@krug");
            return customer;
        };
        try {
            System.out.println(service.updateCustomer(mapper, service.getIdByName("freddy", "kruger")));
        } catch (NotExistsException e) {
            e.printStackTrace();
        }
    }

}
