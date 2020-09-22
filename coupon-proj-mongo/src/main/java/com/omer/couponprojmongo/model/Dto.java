package com.omer.couponprojmongo.model;

import org.springframework.stereotype.Component;

@Component
public class Dto<T> {

    private Boolean success;
    private T content;

}
