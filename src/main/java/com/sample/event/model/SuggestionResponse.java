package com.sample.event.model;

import lombok.Data;

import java.util.List;
@Data
public class SuggestionResponse {
    private List<String> selectedCategories;
    private Double totalEstimatedCost;
}