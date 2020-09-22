package com.omer.couponprojmongo;

import com.omer.couponprojmongo.exceptions.AlreadyExistsException;
import com.omer.couponprojmongo.exceptions.NotExistsException;
import com.omer.couponprojmongo.model.Company;
import com.omer.couponprojmongo.services.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
class CompanyTests {

    @Autowired
    private CompanyService service;

    @Test
    void contextLoads() {
    }

    @Test
    void saveCompany(){
        Company company = new Company("yogastore", "yoga@store", "333333");
        try {
            System.out.println(service.save(company));
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void update(){
        Function<Company, Company> mapper = company -> {
            company.setEmail("coffee@coffee");
            return company;
        };
        try {
            System.out.println(service.updateCompany(mapper, service.getIdByName("kafekafe")));
        } catch (NotExistsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findall(){
        service.findAll().forEach(System.out::println);
    }

    @Test
    void delete(){
        try {
            System.out.println(service.deleteCompany(service.getIdByName("yogastore")));
        } catch (NotExistsException e) {
            e.printStackTrace();
        }
    }



}
