package com.sample.event.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin
public class SuggestionController {

    @GetMapping("/suggest")
    public Map<String, Object> suggest(@RequestParam double budget) {

        // Hardcoded pricing (matching frontend)
        Map<String, Double> basePrices = new LinkedHashMap<>();
        basePrices.put("Venue", 60000.0);
        basePrices.put("Catering", 40000.0);
        basePrices.put("Decorations", 20000.0);
        basePrices.put("Photography", 15000.0);
        basePrices.put("Sound/DJ", 12000.0);
        basePrices.put("Car Rentals", 12000.0);
        basePrices.put("Dressing", 10000.0);
        basePrices.put("Makeup", 8000.0);
        basePrices.put("MC/Anchor", 7000.0);
        basePrices.put("Lighting", 5000.0);

        List<String> selected = new ArrayList<>();
        double total = 0;

        for (Map.Entry<String, Double> entry : basePrices.entrySet()) {
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
