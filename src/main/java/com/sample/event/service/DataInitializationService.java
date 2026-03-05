package com.sample.event.service;

import com.sample.event.model.Vendor;
import com.sample.event.repository.VendorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInitializationService {

    @Autowired
    private VendorRepository vendorRepository;

    @PostConstruct
    public void initializeData() {
        // Only initialize if database is empty
        if (vendorRepository.count() > 0) {
            return;
        }

        List<Vendor> sampleVendors = Arrays.asList(
                // VENUE - 5 items
                createVendor(null, "Grand Palace Banquet", "Venue",
                        "Luxurious banquet hall with capacity of 500 guests, state-of-the-art lighting, central AC, and premium amenities. Perfect for weddings and corporate events.",
                        150000.0, "Mumbai, Maharashtra", "+91-9876543210", "grandpalace@example.com",
                        "https://images.unsplash.com/photo-1519167758481-83f29da8c8b0?w=800", "APPROVED", 4.8),

                createVendor(null, "Royal Gardens Resort", "Venue",
                        "Beautiful outdoor venue with lush gardens, gazebo, and indoor backup. Capacity: 300 guests. Ideal for destination weddings and intimate celebrations.",
                        120000.0, "Bangalore, Karnataka", "+91-9876543211", "royalgardens@example.com",
                        "https://images.unsplash.com/photo-1464366400600-7168b8af9bc3?w=800", "APPROVED", 4.9),

                createVendor(null, "Skyline Convention Center", "Venue",
                        "Modern convention center with panoramic city views. Capacity: 1000 guests. Full audio-visual setup, VIP lounges, and ample parking space.",
                        250000.0, "Delhi NCR", "+91-9876543212", "skyline@example.com",
                        "https://images.unsplash.com/photo-1540575467063-178a50c2df87?w=800", "APPROVED", 4.7),

                createVendor(null, "Beachside Paradise Resort", "Venue",
                        "Stunning beachfront venue with sunset views. Capacity: 200 guests. Private beach access, water sports, and accommodation available.",
                        180000.0, "Goa", "+91-9876543213", "beachside@example.com",
                        "https://images.unsplash.com/photo-1510076857177-7470076d4098?w=800", "APPROVED", 4.9),

                createVendor(null, "Heritage Mansion", "Venue",
                        "Historical mansion with vintage charm and modern facilities. Capacity: 150 guests. Perfect for elegant weddings and exclusive events.",
                        100000.0, "Jaipur, Rajasthan", "+91-9876543214", "heritage@example.com",
                        "https://images.unsplash.com/photo-1478146896981-b80fe463b330?w=800", "APPROVED", 4.6),

                // DECORATIONS - 5 items
                createVendor(null, "Dream Decorators", "Decorations",
                        "Premium decoration services specializing in floral arrangements, stage setup, mandap decoration, and themed decor. Custom designs available.",
                        75000.0, "Mumbai, Maharashtra", "+91-9876543215", "dreamdeco@example.com",
                        "https://images.unsplash.com/photo-1511795409834-ef04bbd61622?w=800", "APPROVED", 4.7),

                createVendor(null, "Elegant Events Decor", "Decorations",
                        "Specialized in traditional and contemporary wedding decorations. Includes lighting, draping, centerpieces, and complete venue transformation.",
                        60000.0, "Bangalore, Karnataka", "+91-9876543216", "elegantevents@example.com",
                        "https://images.unsplash.com/photo-1464366400600-7168b8af9bc3?w=800", "APPROVED", 4.8),

                createVendor(null, "Royal Touch Decorators", "Decorations",
                        "Luxury decoration services with custom themes. Specializing in destination wedding decor, floral walls, and ambient lighting designs.",
                        90000.0, "Delhi NCR", "+91-9876543217", "royaltouch@example.com",
                        "https://images.unsplash.com/photo-1505236858219-8359eb29e329?w=800", "APPROVED", 4.9),

                createVendor(null, "Blooming Affairs", "Decorations",
                        "Expert floral designers creating stunning arrangements. From table settings to grand entrance decorations with fresh and artificial flowers.",
                        45000.0, "Pune, Maharashtra", "+91-9876543218", "blooming@example.com",
                        "https://images.unsplash.com/photo-1478146896981-b80fe463b330?w=800", "APPROVED", 4.6),

                createVendor(null, "Magical Moments Decor", "Decorations",
                        "Creating magical ambiances with balloon decorations, themed setups, and creative installations for all types of events.",
                        50000.0, "Chennai, Tamil Nadu", "+91-9876543219", "magical@example.com",
                        "https://images.unsplash.com/photo-1519225421980-715cb0215aed?w=800", "APPROVED", 4.7),

                // DRESSING - 5 items
                createVendor(null, "Bridal Couture Studio", "Dressing",
                        "Designer bridal lehengas, sarees, and gowns. Custom stitching and alterations. Wide range of traditional and contemporary designs.",
                        85000.0, "Mumbai, Maharashtra", "+91-9876543220", "bridalcouture@example.com",
                        "https://images.unsplash.com/photo-1583939003579-730e3918a45a?w=800", "APPROVED", 4.9),

                createVendor(null, "Gentleman's Wardrobe", "Dressing",
                        "Premium sherwanis, suits, and indo-western outfits for grooms. Rental and purchase options with complete accessories.",
                        65000.0, "Bangalore, Karnataka", "+91-9876543221", "gentlemans@example.com",
                        "https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=800", "APPROVED", 4.8),

                createVendor(null, "Royal Attire Boutique", "Dressing",
                        "Exclusive designer collection for brides and grooms. Personalized styling sessions and complete wardrobe planning for all ceremonies.",
                        120000.0, "Delhi NCR", "+91-9876543222", "royalattire@example.com",
                        "https://images.unsplash.com/photo-1515372039744-b8f02a3ae446?w=800", "APPROVED", 4.9),

                createVendor(null, "Ethnic Elegance", "Dressing",
                        "Traditional ethnic wear for all family members. Bridal trousseau, guest outfits, and festive collections with latest trends.",
                        55000.0, "Jaipur, Rajasthan", "+91-9876543223", "ethnic@example.com",
                        "https://images.unsplash.com/photo-1617019114583-affb34d1b3cd?w=800", "APPROVED", 4.7),

                createVendor(null, "Designer Dreams", "Dressing",
                        "Contemporary designer wear with fusion styles. Custom embroidery, luxury fabrics, and personalized designs for modern couples.",
                        95000.0, "Hyderabad, Telangana", "+91-9876543224", "designerdreams@example.com",
                        "https://images.unsplash.com/photo-1594633313593-bab3825d0caf?w=800", "APPROVED", 4.8),

                // LIGHTING - 5 items
                createVendor(null, "Illuminate Pro", "Lighting",
                        "Professional lighting solutions including LED walls, moving heads, laser shows, and ambient lighting. Complete technical support.",
                        45000.0, "Mumbai, Maharashtra", "+91-9876543225", "illuminate@example.com",
                        "https://images.unsplash.com/photo-1492684223066-81342ee5ff30?w=800", "APPROVED", 4.8),

                createVendor(null, "Sparkle Lights & Effects", "Lighting",
                        "Specialized in wedding lighting, fairy lights, uplighting, and special effects. Creating romantic and vibrant atmospheres.",
                        38000.0, "Bangalore, Karnataka", "+91-9876543226", "sparkle@example.com",
                        "https://images.unsplash.com/photo-1478146896981-b80fe463b330?w=800", "APPROVED", 4.7),

                createVendor(null, "Lumina Events", "Lighting",
                        "Cutting-edge lighting technology with intelligent lights, DMX control, and custom programming. Perfect for concerts and large events.",
                        65000.0, "Delhi NCR", "+91-9876543227", "lumina@example.com",
                        "https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3?w=800", "APPROVED", 4.9),

                createVendor(null, "Glow Masters", "Lighting",
                        "Creative lighting designs with color themes, pattern projections, and architectural lighting for venues of all sizes.",
                        42000.0, "Pune, Maharashtra", "+91-9876543228", "glowmasters@example.com",
                        "https://images.unsplash.com/photo-1501612780327-45045538702b?w=800", "APPROVED", 4.6),

                createVendor(null, "Radiance Lighting Solutions", "Lighting",
                        "Complete lighting packages including stage lighting, dance floor effects, and outdoor illumination with backup power systems.",
                        50000.0, "Ahmedabad, Gujarat", "+91-9876543229", "radiance@example.com",
                        "https://images.unsplash.com/photo-1459749411175-04bf5292ceea?w=800", "APPROVED", 4.8),

                // OTHER CATEGORIES - 1 each
                createVendor(null, "Spice & Delight Caterers", "Catering",
                        "Multi-cuisine catering services with live counters, traditional and contemporary menus. Veg and non-veg options with chef on-site.",
                        80000.0, "Mumbai, Maharashtra", "+91-9876543230", "spicedelight@example.com",
                        "https://images.unsplash.com/photo-1555244162-803834f70033?w=800", "APPROVED", 4.8),

                createVendor(null, "Lens & Frames Photography", "Photography",
                        "Professional photography and videography with cinematic wedding films, pre-wedding shoots, candid photography, and same-day editing.",
                        55000.0, "Bangalore, Karnataka", "+91-9876543231", "lensframes@example.com",
                        "https://images.unsplash.com/photo-1542038784456-1ea8e935640e?w=800", "APPROVED", 4.9),

                createVendor(null, "Beat Masters DJ", "Sound/DJ",
                        "Professional DJ services with latest sound systems, lighting sync, and custom playlists. Experienced in all types of events and music genres.",
                        35000.0, "Delhi NCR", "+91-9876543232", "beatmasters@example.com",
                        "https://images.unsplash.com/photo-1571266028243-d220c677a2c6?w=800", "APPROVED", 4.7),

                createVendor(null, "Glamour Makeover Studio", "Makeup",
                        "Bridal makeup, hairstyling, and complete makeover services. Using premium products with trial sessions and on-location service.",
                        25000.0, "Mumbai, Maharashtra", "+91-9876543233", "glamour@example.com",
                        "https://images.unsplash.com/photo-1487412947147-5cebf100ffc2?w=800", "APPROVED", 4.8),

                createVendor(null, "Luxury Wheels Rentals", "Car Rentals",
                        "Premium car rentals including vintage cars, luxury sedans, and decorated vehicles for weddings. Professional chauffeurs available.",
                        40000.0, "Bangalore, Karnataka", "+91-9876543234", "luxurywheels@example.com",
                        "https://images.unsplash.com/photo-1549317661-bd32c8ce0db2?w=800", "APPROVED", 4.8),

                createVendor(null, "Voice of Events", "MC/Anchor",
                        "Professional anchors and emcees for weddings and corporate events. Bilingual hosting with entertainment and crowd engagement.",
                        18000.0, "Delhi NCR", "+91-9876543235", "voiceevents@example.com",
                        "https://images.unsplash.com/photo-1475721027785-f74eccf877e2?w=800", "APPROVED", 4.7)
        );

        vendorRepository.saveAll(sampleVendors);
        System.out.println("✅ Sample vendor data initialized successfully!");
    }

    private Vendor createVendor(Long userId, String businessName, String category, String description,
                                Double price, String location, String contactNumber, String email,
                                String imageUrl, String status, Double rating) {
        Vendor vendor = new Vendor();
        vendor.setUserId(userId);
        vendor.setBusinessName(businessName);
        vendor.setCategory(category);
        vendor.setDescription(description);
        vendor.setPrice(price);
        vendor.setLocation(location);
        vendor.setContactNumber(contactNumber);
        vendor.setEmail(email);
        vendor.setImageUrl(imageUrl);
        vendor.setStatus(status);
        vendor.setRating(rating);
        return vendor;
    }
}

