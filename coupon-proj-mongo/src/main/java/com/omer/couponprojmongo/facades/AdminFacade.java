package com.omer.couponprojmongo.facades;

import com.omer.couponprojmongo.exceptions.WrongCredentialsException;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@ToString
@Service
public class AdminFacade implements ClientFacade {

    private boolean isLoggedIn = false;

    @Override
    public AdminFacade login(String email, String password) throws WrongCredentialsException {
        if(email.equals("admin") && password.equals("admin")) {
            isLoggedIn = true;
        }else {
            throw new WrongCredentialsException();
        }
        return this;
    }
}
