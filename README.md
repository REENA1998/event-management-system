# Event AI - Intelligent Event Management System

An intelligent event management platform that connects event planners with vendors, featuring AI-powered budget recommendations and role-based dashboards.

## Features

### 🎯 Core Features
- **Role-Based Access Control**: Separate dashboards for Users, Vendors, and Admins
- **AI Budget Planner**: Smart recommendations based on your budget
- **Vendor Management**: Complete CRUD operations for vendor services
- **Real-Time Cart System**: Add/remove services with live updates
- **Order Management**: Place and track orders
- **Admin Approval System**: Vendors require admin approval before listing

### 👥 User Roles

#### 1. **User/Event Planner**
- Browse approved vendors by category
- Get AI-powered budget recommendations
- Add services to cart
- Place orders
- View cart with total calculation

#### 2. **Vendor**
- Register and add business services
- Upload service details with images
- Set pricing and availability
- View service status (Pending/Approved/Rejected)
- Edit and delete services

#### 3. **Admin**
- View dashboard statistics
- Approve/Reject vendor registrations
- Edit vendor details
- Delete vendors
- View all users and orders

## Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.2**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**

### Frontend
- **HTML5**
- **CSS3** (Modern gradient designs)
- **Vanilla JavaScript**
- **RESTful API integration**

## Getting Started

### Database Setup

1. Install PostgreSQL
2. Create database:
```sql
CREATE DATABASE eventdb;
```

3. Update database credentials in `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/eventdb
    username: postgres
    password: postgres
```

### Run Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8088`

## Usage

### First Time Setup

1. **Create Admin Account**
   - Open `http://localhost:8088/index.html`
   - Click "Sign Up"
   - Register with role "Event Planner / User"
   - Manually update the user's role to "ADMIN" in the database

2. **Register as Vendor**
   - Sign up with role "Vendor / Service Provider"
   - Add your services in the vendor dashboard
   - Wait for admin approval

3. **Browse as User**
   - Sign up as a regular user
   - Browse approved vendors
   - Use AI budget planner for recommendations
   - Add services to cart and place orders

## API Endpoints

### Authentication
- `POST /api/auth/signup` - Register new user
- `POST /api/auth/login` - User login

### Vendor Management
- `POST /api/vendor/register` - Register new vendor service
- `GET /api/vendor/approved` - Get all approved vendors
- `GET /api/vendor/category/{category}` - Get vendors by category
- `GET /api/vendor/my-vendors/{userId}` - Get vendor's services
- `PUT /api/vendor/update/{id}` - Update vendor service
- `DELETE /api/vendor/delete/{id}` - Delete vendor service

### Cart Operations
- `POST /api/cart/add` - Add item to cart
- `GET /api/cart/items?userId={id}` - Get cart items
- `GET /api/cart/count?userId={id}` - Get cart count
- `DELETE /api/cart/remove/{id}` - Remove item from cart
- `DELETE /api/cart/clear?userId={id}` - Clear cart

### Order Management
- `POST /api/order/place?userId={id}` - Place order
- `GET /api/order/user/{userId}` - Get user's orders

### AI Suggestions
- `GET /api/ai/suggest?budget={amount}` - Get AI recommendations

### Admin Operations
- `GET /api/admin/vendors` - Get all vendors
- `GET /api/admin/vendors/pending` - Get pending vendors
- `PUT /api/admin/vendors/approve/{id}` - Approve vendor
- `PUT /api/admin/vendors/reject/{id}` - Reject vendor
- `PUT /api/admin/vendors/update/{id}` - Update vendor
- `DELETE /api/admin/vendors/delete/{id}` - Delete vendor
- `GET /api/admin/stats` - Get dashboard statistics

## Service Categories

- Venue
- Catering
- Photography
- Decorations
- Sound/DJ
- Makeup
- Car Rentals
- Dressing
- MC/Anchor
- Lighting

## Project Structure

```
event-managment/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/sample/event/
│       │       ├── controller/
│       │       │   ├── AdminController.java
│       │       │   ├── AuthController.java
│       │       │   ├── CartController.java
│       │       │   ├── OrderController.java
│       │       │   ├── SuggestionController.java
│       │       │   └── VendorController.java
│       │       ├── model/
│       │       │   ├── CartItem.java
│       │       │   ├── Order.java
│       │       │   ├── User.java
│       │       │   └── Vendor.java
│       │       ├── repository/
│       │       │   ├── CartRepository.java
│       │       │   ├── OrderRepository.java
│       │       │   ├── UserRepository.java
│       │       │   └── VendorRepository.java
│       │       └── service/
│       │           └── UserService.java
│       └── resources/
│           └── application.yml
├── index.html
├── user-dashboard.html
├── vendor-dashboard.html
├── admin-dashboard.html
└── pom.xml
```

## Features Highlights

### Dynamic Vendor System
- No hardcoded vendor data
- Real-time vendor registration
- Image support for services
- Location-based filtering

### Smart AI Recommendations
- Budget-based suggestions
- Category prioritization
- Real-time price calculations

### Modern UI/UX
- Gradient designs
- Responsive layout
- Smooth animations
- Custom alerts and modals
- Mobile-friendly

## Notes

- All vendor listings require admin approval
- Users can only see approved vendors
- Vendors can manage their own services
- Admin has full control over the platform
- Email validation with regex pattern
- Secure password handling

---

**Built with ❤️ for efficient event management**

