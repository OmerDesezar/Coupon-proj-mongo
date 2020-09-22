package com.omer.couponprojmongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coupon extends BaseEntity {

    private Company company;
    private Category category;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int amount;
    private double price;
    private String image;
    @DBRef
    private List<Customer> customers = new ArrayList<>();

    public Coupon(Company company, Category category, String title, String description, LocalDate startDate, LocalDate endDate, int amount, double price, String image) {
        this.company = company;
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

    public Coupon(Category category, String title, String description, LocalDate startDate, LocalDate endDate, int amount, double price, String image) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

    public Coupon(String id, Company company, Category category, String title, String description, LocalDate startDate, LocalDate endDate, int amount, double price, String image) {
        this.id = id;
        this.company = company;
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Coupon:\n" +
                "\t-Id          : " + id + "\n" +
                "\t-Company_name: " + company.getName() + "\n" +
                "\t-Company_id  : " + company.getId() + "\n" +
                "\t-" + category + "\n" +
                "\t-Title       : " + title + "\n" +
                "\t-Description : " + description + "\n" +
                "\t-StartDate   : " + startDate + "\n" +
                "\t-EndDate     : " + endDate + "\n" +
                "\t-Amount      : " + amount + "\n" +
                "\t-Price       : " + price + "\n" +
                "\t-Image       : " + image + "\n";
    }
}
