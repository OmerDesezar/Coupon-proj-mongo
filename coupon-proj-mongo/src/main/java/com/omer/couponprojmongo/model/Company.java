package com.omer.couponprojmongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company extends UserEntity {

    private String name;
    @DBRef
    private List<Coupon> coupons = new ArrayList<>();

    public Company(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Company(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Company:\n" +
                "\t-Id       : " + id + "\n" +
                "\t-Name     : " + name + "\n" +
                "\t-Email    : " + email + "\n" +
                "\t-Password : " + password + "\n" +
                "\t-Coupons  : " + coupons + "\n";
    }
}
