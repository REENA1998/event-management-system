package com.sample.event.repository;

import com.sample.event.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findByUserId(Long userId);
    List<Vendor> findByCategory(String category);
    List<Vendor> findByCategoryAndStatus(String category, String status);
    List<Vendor> findByStatus(String status);
    List<Vendor> findByCategoryAndStatusAndPriceLessThanEqual(String category, String status, Double price);
}

