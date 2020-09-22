package com.omer.couponprojmongo;

import com.omer.couponprojmongo.exceptions.WrongCredentialsException;
import com.omer.couponprojmongo.facades.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginManagerTest {

    @Test
    void contextLoads() {
    }

    @Test
    void hey(){
        AdminFacade adminFacadeNo = new AdminFacade();
        AdminFacade adminFacade = null;
        try {
            adminFacade = (AdminFacade) LoginManager.getFacade("admin", "admin", ClientType.ADMIN);
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }
        System.out.println(adminFacadeNo);
        System.out.println(adminFacade);
        CustomerFacade customerFacadeNo = new CustomerFacade();
        CustomerFacade customerFacade = null;
        try {
            customerFacade = (CustomerFacade) LoginManager.getFacade("dylan@kar", "5566554", ClientType.CUSTOMER);
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }
        System.out.println(customerFacadeNo);
        System.out.println(customerFacade);
        CompanyFacade companyFacadeNo = new CompanyFacade();
        CompanyFacade companyFacade = null;
        try {
            companyFacade = (CompanyFacade) LoginManager.getFacade("apple@fruit", "112233", ClientType.COMPANY);
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }
        System.out.println(companyFacadeNo);
        System.out.println(companyFacade);
    }

}
