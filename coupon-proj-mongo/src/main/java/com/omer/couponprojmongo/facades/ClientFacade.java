package com.omer.couponprojmongo.facades;

import com.omer.couponprojmongo.exceptions.WrongCredentialsException;

public interface ClientFacade {
    ClientFacade login(String email, String password) throws WrongCredentialsException;
}
