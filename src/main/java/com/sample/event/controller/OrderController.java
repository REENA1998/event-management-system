package com.sample.event.controller;

import com.sample.event.model.CartItem;
import com.sample.event.model.Order;
import com.sample.event.repository.CartRepository;
import com.sample.event.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private OrderRepository orderRepo;

    @PostMapping("/place")
    @Transactional
    public String placeOrder(@RequestParam Long userId) {

        List<CartItem> items = cartRepo.findByUserId(userId);

        if (items.isEmpty()) {
            return "Cart is empty";
        }

        double total = items.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(total);

        orderRepo.save(order);
        cartRepo.deleteByUserId(userId);

        return "Order placed successfully. Total: ₹" + total;
    }
}
