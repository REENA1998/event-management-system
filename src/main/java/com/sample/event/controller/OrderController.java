package com.sample.event.controller;

import com.sample.event.model.CartItem;
import com.sample.event.model.Order;
import com.sample.event.model.OrderItem;
import com.sample.event.repository.CartRepository;
import com.sample.event.repository.OrderRepository;
import com.sample.event.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @PostMapping("/place")
    @Transactional
    public ResponseEntity<?> placeOrder(@RequestParam Long userId) {

        List<CartItem> items = cartRepo.findByUserId(userId);

        if (items.isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Cart is empty");
            return ResponseEntity.badRequest().body(error);
        }

        double total = items.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();

        // Create and save order
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(total);
        order.setItemCount(items.size());
        Order savedOrder = orderRepo.save(order);

        // Save order items
        for (CartItem cartItem : items) {
            OrderItem orderItem = new OrderItem();
            orderItem.setUserId(userId);
            orderItem.setOrderId(savedOrder.getId());
            orderItem.setVendorId(cartItem.getVendorId());
            orderItem.setVendorName(cartItem.getVendorName());
            orderItem.setCategory(cartItem.getCategory());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setImageUrl(cartItem.getImageUrl());
            orderItemRepo.save(orderItem);
        }

        // Clear cart
        cartRepo.deleteByUserId(userId);

        // Return JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Order placed successfully");
        response.put("orderId", savedOrder.getId());
        response.put("totalAmount", total);
        response.put("itemCount", items.size());

        return ResponseEntity.ok(response);
    }
}
