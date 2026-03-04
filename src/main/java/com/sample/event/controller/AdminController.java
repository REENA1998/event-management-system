package com.sample.event.controller;

import com.sample.event.model.Vendor;
import com.sample.event.model.User;
import com.sample.event.model.Order;
import com.sample.event.repository.VendorRepository;
import com.sample.event.repository.UserRepository;
import com.sample.event.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private VendorRepository vendorRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OrderRepository orderRepo;

    // Get all vendors (pending, approved, rejected)
    @GetMapping("/vendors")
    public ResponseEntity<?> getAllVendors() {
        List<Vendor> vendors = vendorRepo.findAll();
        return ResponseEntity.ok(vendors);
    }

    // Get pending vendors
    @GetMapping("/vendors/pending")
    public ResponseEntity<?> getPendingVendors() {
        List<Vendor> vendors = vendorRepo.findByStatus("PENDING");
        return ResponseEntity.ok(vendors);
    }

    // Approve vendor
    @PutMapping("/vendors/approve/{id}")
    public ResponseEntity<?> approveVendor(@PathVariable Long id) {
        Optional<Vendor> vendor = vendorRepo.findById(id);
        if (vendor.isPresent()) {
            Vendor v = vendor.get();
            v.setStatus("APPROVED");
            vendorRepo.save(v);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Vendor approved successfully");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // Reject vendor
    @PutMapping("/vendors/reject/{id}")
    public ResponseEntity<?> rejectVendor(@PathVariable Long id) {
        Optional<Vendor> vendor = vendorRepo.findById(id);
        if (vendor.isPresent()) {
            Vendor v = vendor.get();
            v.setStatus("REJECTED");
            vendorRepo.save(v);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Vendor rejected");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete vendor
    @DeleteMapping("/vendors/delete/{id}")
    public ResponseEntity<?> deleteVendor(@PathVariable Long id) {
        vendorRepo.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Vendor deleted successfully");
        return ResponseEntity.ok(response);
    }

    // Update vendor
    @PutMapping("/vendors/update/{id}")
    public ResponseEntity<?> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        Optional<Vendor> existingVendor = vendorRepo.findById(id);
        if (existingVendor.isPresent()) {
            Vendor updated = existingVendor.get();
            updated.setBusinessName(vendor.getBusinessName());
            updated.setCategory(vendor.getCategory());
            updated.setDescription(vendor.getDescription());
            updated.setPrice(vendor.getPrice());
            updated.setLocation(vendor.getLocation());
            updated.setContactNumber(vendor.getContactNumber());
            updated.setEmail(vendor.getEmail());
            updated.setImageUrl(vendor.getImageUrl());
            updated.setStatus(vendor.getStatus());
            updated.setRating(vendor.getRating());
            vendorRepo.save(updated);
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepo.findAll();
        return ResponseEntity.ok(users);
    }

    // Get all orders
    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        return ResponseEntity.ok(orders);
    }

    // Dashboard statistics
    @GetMapping("/stats")
    public ResponseEntity<?> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalVendors", vendorRepo.count());
        stats.put("pendingVendors", vendorRepo.findByStatus("PENDING").size());
        stats.put("approvedVendors", vendorRepo.findByStatus("APPROVED").size());
        stats.put("totalUsers", userRepo.count());
        stats.put("totalOrders", orderRepo.count());
        return ResponseEntity.ok(stats);
    }
}

