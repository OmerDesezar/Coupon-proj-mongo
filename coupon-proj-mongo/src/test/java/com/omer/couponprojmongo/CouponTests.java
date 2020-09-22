package com.omer.couponprojmongo;

import com.omer.couponprojmongo.exceptions.NotExistsException;
import com.omer.couponprojmongo.model.CategoryType;
import com.omer.couponprojmongo.model.Coupon;
import com.omer.couponprojmongo.services.CategoryService;
import com.omer.couponprojmongo.services.CompanyService;
import com.omer.couponprojmongo.services.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.function.Function;

@SpringBootTest
class CouponTests {

    @Autowired
    private CouponService couponService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CategoryService categoryService;

    @Test
    void contextLoads() {
    }

    @Test
    void findAll(){
        couponService.findAll().forEach(System.out::println);
    }

    @Test
    void saveCoupon(){
        try {
            Coupon coupon = new Coupon(
                   companyService.findByName("apple"),
                    categoryService.createOrGet(CategoryType.LIFESTYLE),
                    "cheap iphone ",
                    "cheappyyy",
                    LocalDate.now(),
                    LocalDate.now().plusMonths(3),
                    315,
                    301,
                    "img.jps");
            System.out.println(couponService.save(coupon));
        } catch (NotExistsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteCoupon(){
        try {
            System.out.println(couponService.deleteCoupon(couponService.getIdByTitle("cheap iphone ")));
        } catch (NotExistsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateCoupon(){
        Function<Coupon, Coupon> mapper = coupon -> {
            coupon.setEndDate(LocalDate.now().minusMonths(1));
            return coupon;
        };
        try {
            couponService.updateCoupon(mapper, couponService.getIdByTitle("cheap iphone "));
        } catch (NotExistsException e) {
            e.printStackTrace();
        }
    }

}
