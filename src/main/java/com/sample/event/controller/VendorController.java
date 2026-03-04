package com.sample.event.controller;

import com.sample.event.model.Vendor;
import com.sample.event.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendor")
@CrossOrigin
public class VendorController {

    @Autowired
    private VendorRepository vendorRepo;

    // Register/Create vendor
    @PostMapping("/register")
    public ResponseEntity<?> registerVendor(@RequestBody Vendor vendor) {
        vendor.setStatus("PENDING"); // Default status
        vendor.setRating(0.0);
        Vendor savedVendor = vendorRepo.save(vendor);
        return ResponseEntity.ok(savedVendor);
    }

    // Get all vendors by category (for users)
    @GetMapping("/category/{category}")
    public ResponseEntity<?> getVendorsByCategory(@PathVariable String category) {
        List<Vendor> vendors = vendorRepo.findByCategoryAndStatus(category, "APPROVED");
        return ResponseEntity.ok(vendors);
    }

    // Get all approved vendors
    @GetMapping("/approved")
    public ResponseEntity<?> getApprovedVendors() {
        List<Vendor> vendors = vendorRepo.findByStatus("APPROVED");
        return ResponseEntity.ok(vendors);
    }

    // Get vendors by budget and category
    @GetMapping("/budget")
    public ResponseEntity<?> getVendorsByBudget(
            @RequestParam String category,
            @RequestParam Double maxPrice) {
        List<Vendor> vendors = vendorRepo.findByCategoryAndStatusAndPriceLessThanEqual(
                category, "APPROVED", maxPrice);
        return ResponseEntity.ok(vendors);
    }

    // Get vendor by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getVendorById(@PathVariable Long id) {
        Optional<Vendor> vendor = vendorRepo.findById(id);
        if (vendor.isPresent()) {
            return ResponseEntity.ok(vendor.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Get vendors by user ID (for vendor dashboard)
    @GetMapping("/my-vendors/{userId}")
    public ResponseEntity<?> getMyVendors(@PathVariable Long userId) {
        List<Vendor> vendors = vendorRepo.findByUserId(userId);
        return ResponseEntity.ok(vendors);
    }

    // Update vendor
    @PutMapping("/update/{id}")
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
            vendorRepo.save(updated);
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete vendor
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVendor(@PathVariable Long id) {
        vendorRepo.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Vendor deleted successfully");
        return ResponseEntity.ok(response);
    }

    // Get all categories
    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(List.of(
                "Venue", "Catering", "Photography", "Decorations",
                "Sound/DJ", "Makeup", "Car Rentals", "Dressing",
                "MC/Anchor", "Lighting"
        ));
    }
}

