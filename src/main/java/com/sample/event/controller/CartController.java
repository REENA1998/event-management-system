package com.sample.event.controller;

import com.sample.event.model.CartItem;
import com.sample.event.model.Vendor;
import com.sample.event.repository.CartRepository;
import com.sample.event.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private VendorRepository vendorRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody Map<String, Object> request) {
        Long userId = ((Number) request.get("userId")).longValue();
        Long vendorId = ((Number) request.get("vendorId")).longValue();

        // Fetch vendor from database
        Optional<Vendor> vendorOpt = vendorRepo.findById(vendorId);

        if (vendorOpt.isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Vendor not found");
            return ResponseEntity.badRequest().body(error);
        }

        Vendor vendor = vendorOpt.get();

        CartItem item = new CartItem();
        item.setUserId(userId);
        item.setVendorId(vendorId);

        // Use provided values or fallback to vendor data
        item.setVendorName(request.containsKey("vendorName") ?
            (String) request.get("vendorName") : vendor.getBusinessName());
        item.setCategory(request.containsKey("category") ?
            (String) request.get("category") : vendor.getCategory());
        item.setPrice(request.containsKey("price") ?
            ((Number) request.get("price")).doubleValue() : vendor.getPrice());
        item.setImageUrl(request.containsKey("imageUrl") ?
            (String) request.get("imageUrl") : vendor.getImageUrl());

        // Set itemName for backward compatibility
        item.setItemName(item.getVendorName());

        cartRepo.save(item);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Item added to cart");
        return ResponseEntity.ok(response);
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
        Map<String, String> response = new HashMap<>();
        response.put("message", "Item removed from cart");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart(@RequestParam Long userId) {
        cartRepo.deleteByUserId(userId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Cart cleared");
        return ResponseEntity.ok(response);
    }
}
