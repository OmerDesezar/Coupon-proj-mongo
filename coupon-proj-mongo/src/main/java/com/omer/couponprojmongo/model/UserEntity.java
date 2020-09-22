package com.omer.couponprojmongo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    protected String email;
    protected String password;
}
