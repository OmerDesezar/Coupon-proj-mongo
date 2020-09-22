package com.omer.couponprojmongo.facades;

import com.omer.couponprojmongo.exceptions.WrongCredentialsException;
import com.omer.couponprojmongo.model.Company;
import com.omer.couponprojmongo.services.CompanyService;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@ToString
@Service
public class CompanyFacade implements ClientFacade {

    @Autowired
    private CompanyService service;

    private Company company;
    private boolean isLoggedIn = false;

    @Override
    public CompanyFacade login(String email, String password)throws WrongCredentialsException {
        if (service.isCompanyExists(email, password)){
            company = service.findByEmail(email).get();
            isLoggedIn = true;
        }else {
            throw new WrongCredentialsException();
        }
        return this;
    }
}
