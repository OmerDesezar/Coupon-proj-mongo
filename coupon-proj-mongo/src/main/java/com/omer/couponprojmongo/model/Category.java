package com.omer.couponprojmongo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity {

    private CategoryType type;

    public Category(CategoryType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category:\n" +
                "\t\t-Id   : " + id + "\n" +
                "\t\t-Type : " + type;
    }
}
