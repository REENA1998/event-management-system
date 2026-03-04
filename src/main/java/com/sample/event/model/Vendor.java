package com.sample.event.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendors")
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId; // Reference to the user who is the vendor

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "category")
    private String category; // Catering, Venue, Photography, etc.

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "location")
    private String location;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "status")
    private String status; // PENDING, APPROVED, REJECTED

    @Column(name = "rating")
    private Double rating;
}

