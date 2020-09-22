package com.omer.couponprojmongo.services;

import com.omer.couponprojmongo.exceptions.NotExistsException;
import com.omer.couponprojmongo.model.Coupon;
import com.omer.couponprojmongo.repositories.CouponRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class CouponService implements EntityService<Coupon> {

    private CouponRepository repository;

    @Override
    public Coupon save(Coupon coupon) {
        return repository.save(coupon);
    }

    @Override
    public Optional<Coupon> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Coupon> findAll() {
        return repository.findAll();
    }

    public String getIdByTitle(String title) throws NotExistsException{
        return repository.findByTitle(title)
                .map(Coupon::getId)
                .orElseThrow(()->
                        new NotExistsException("A coupon with the title " + title + " doesnt exist"));
    }

    public Coupon updateCoupon(Function<Coupon, Coupon> mapper, String couponId) throws NotExistsException {
        return findById(couponId)
                .map(byId -> mapper
                        .andThen(repository::save)
                        .apply(byId))
                .orElseThrow(() -> new NotExistsException(
                        "A coupon with the ID " + couponId + " doesnt exist"));
    }

    public Coupon deleteCoupon(String couponId) throws NotExistsException {
        return findById(couponId)
                .map(coupon -> {
                    repository.delete(coupon);
                    return coupon;
                }).orElseThrow(() -> new NotExistsException("A coupon with the ID " + couponId + " doesnt exist"));
    }
}
