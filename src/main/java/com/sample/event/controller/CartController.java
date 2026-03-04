package com.sample.event.controller;

import com.sample.event.model.CartItem;
import com.sample.event.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    // Vendor pricing
    private static final Map<Long, Map<String, Object>> VENDORS = new HashMap<>();

    static {
        Map<String, Object> vendor1 = new HashMap<>();
        vendor1.put("name", "Catering");
        vendor1.put("price", 40000.0);
        VENDORS.put(1L, vendor1);

        Map<String, Object> vendor2 = new HashMap<>();
        vendor2.put("name", "Decorations");
        vendor2.put("price", 20000.0);
        VENDORS.put(2L, vendor2);

        Map<String, Object> vendor3 = new HashMap<>();
        vendor3.put("name", "Photography");
        vendor3.put("price", 15000.0);
        VENDORS.put(3L, vendor3);

        Map<String, Object> vendor4 = new HashMap<>();
        vendor4.put("name", "Sound/DJ");
        vendor4.put("price", 12000.0);
        VENDORS.put(4L, vendor4);

        Map<String, Object> vendor5 = new HashMap<>();
        vendor5.put("name", "Car Rentals");
        vendor5.put("price", 12000.0);
        VENDORS.put(5L, vendor5);

        Map<String, Object> vendor6 = new HashMap<>();
        vendor6.put("name", "Dressing");
        vendor6.put("price", 10000.0);
        VENDORS.put(6L, vendor6);

        Map<String, Object> vendor7 = new HashMap<>();
        vendor7.put("name", "Makeup");
        vendor7.put("price", 8000.0);
        VENDORS.put(7L, vendor7);

        Map<String, Object> vendor8 = new HashMap<>();
        vendor8.put("name", "MC/Anchor");
        vendor8.put("price", 7000.0);
        VENDORS.put(8L, vendor8);

        Map<String, Object> vendor9 = new HashMap<>();
        vendor9.put("name", "Lighting");
        vendor9.put("price", 5000.0);
        VENDORS.put(9L, vendor9);

        Map<String, Object> vendor10 = new HashMap<>();
        vendor10.put("name", "Venue");
        vendor10.put("price", 60000.0);
        VENDORS.put(10L, vendor10);
    }

    @PostMapping("/add")
    public String addToCart(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Long vendorId = request.get("vendorId");

        Map<String, Object> vendor = VENDORS.get(vendorId);

        CartItem item = new CartItem();
        item.setUserId(userId);
        item.setVendorId(vendorId);
        item.setItemName((String) vendor.get("name"));
        item.setPrice((Double) vendor.get("price"));

        cartRepo.save(item);
        return "Item added";
    }

    @GetMapping("/count")
    public long getCartCount(@RequestParam Long userId) {
        return cartRepo.countByUserId(userId);
    }

    @GetMapping("/items")
    public ResponseEntity<?> getCartItems(@RequestParam Long userId) {
        return ResponseEntity.ok(cartRepo.findByUserId(userId));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long id) {
        cartRepo.deleteById(id);
        return ResponseEntity.ok("Item removed");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart(@RequestParam Long userId) {
        cartRepo.deleteByUserId(userId);
        return ResponseEntity.ok("Cart cleared");
    }
}
