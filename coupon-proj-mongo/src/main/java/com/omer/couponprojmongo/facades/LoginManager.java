package com.omer.couponprojmongo.facades;


import com.omer.couponprojmongo.exceptions.WrongCredentialsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoginManager {

    public static ClientFacade getFacade(String email, String password, ClientType type) throws WrongCredentialsException {
        switch (type) {
            case COMPANY:
                CompanyFacade companyFacade = new CompanyFacade();
                return companyFacade.login(email, password);
            case CUSTOMER:
                CustomerFacade customerFacade = new CustomerFacade();
                return customerFacade.login(email, password);
            case ADMIN:
                AdminFacade adminFacade = new AdminFacade();
                return adminFacade.login(email, password);
            default:
                return null;
        }
    }
}
