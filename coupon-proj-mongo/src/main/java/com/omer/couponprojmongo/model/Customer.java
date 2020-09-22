package com.omer.couponprojmongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends UserEntity {

    private String firstName;
    private String lastName;
    @DBRef
    private List<Coupon> coupons = new ArrayList<>();

    public Customer(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Customer(String id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer:\n" +
                "\t-Id         : " + id + "\n" +
                "\t-First name : " + firstName + "\n" +
                "\t-Last name  : " + lastName + "\n" +
                "\t-Email      : " + email + "\n" +
                "\t-Passsword  : " + password + "\n" +
                "\t-Coupons    : " + coupons + "\n";
    }
}
