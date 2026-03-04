package com.sample.event.repository;

import com.sample.event.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);

    @Transactional
    void deleteByUserId(Long userId);

    long countByUserId(Long userId);
}
