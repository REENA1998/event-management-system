package com.sample.event.controller;

import com.sample.event.model.Vendor;
import com.sample.event.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin
public class SuggestionController {

    @Autowired
    private VendorRepository vendorRepo;

    @GetMapping("/suggest")
    public Map<String, Object> suggest(@RequestParam double budget) {

        // Get all approved vendors
        List<Vendor> allVendors = vendorRepo.findByStatus("APPROVED");

        // Group by category and get the minimum price vendor for each category
        Map<String, Double> categoryMinPrices = new LinkedHashMap<>();

        // Define the order of categories
        List<String> categoryOrder = Arrays.asList(
            "Venue", "Catering", "Decorations", "Photography",
            "Sound/DJ", "Car Rentals", "Dressing", "Makeup",
            "MC/Anchor", "Lighting"
        );

        for (String category : categoryOrder) {
            List<Vendor> categoryVendors = allVendors.stream()
                .filter(v -> v.getCategory().equals(category))
                .collect(Collectors.toList());

            if (!categoryVendors.isEmpty()) {
                double minPrice = categoryVendors.stream()
                    .mapToDouble(Vendor::getPrice)
                    .min()
                    .orElse(0.0);
                categoryMinPrices.put(category, minPrice);
            }
        }

        List<String> selected = new ArrayList<>();
        double total = 0;

        for (Map.Entry<String, Double> entry : categoryMinPrices.entrySet()) {
            if (total + entry.getValue() <= budget) {
                selected.add(entry.getKey());
                total += entry.getValue();
            }
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("selectedCategories", selected);
        response.put("totalEstimate", total);

        return response;
    }
}
