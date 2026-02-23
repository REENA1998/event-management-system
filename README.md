# 🎉 Event Management System

A full-stack event management application with **Spring Boot backend** and **HTML/JavaScript frontend** featuring AI-powered budget recommendations.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.2-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14+-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

## 📋 Table of Contents
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Frontend Features](#frontend-features)
- [Database Schema](#database-schema)
- [Screenshots](#screenshots)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

### 🎯 Core Features
- ✅ **User Authentication** - Email-based registration and login system
- ✅ **AI Budget Assistant** - Smart recommendations based on budget constraints
- ✅ **Dynamic Vendor Display** - Shows only vendors within budget
- ✅ **Shopping Cart** - Add/remove event services
- ✅ **Order Management** - Place and track orders
- ✅ **Real-time Cart Count** - Live updates of cart items
- ✅ **Beautiful UI/UX** - Modern gradient design with smooth animations
- ✅ **Custom Modal Dialogs** - Professional confirmation and success messages
- ✅ **Responsive Design** - Works seamlessly on desktop, tablet, and mobile

### 🤖 AI Budget Features
- Intelligent vendor recommendations based on budget
- Prioritizes essential services first
- Shows estimated total cost
- Dynamically updates vendor availability
- Supports budgets from ₹5,000 to unlimited

### 🏪 Available Vendors (10 Services)
1. 🏛️ **Venue** - ₹60,000 - Premium event venue
2. 🍽️ **Catering** - ₹40,000 - Delicious food for guests
3. 🎨 **Decorations** - ₹20,000 - Beautiful event decorations
4. 📸 **Photography** - ₹15,000 - Professional photography
5. 🎵 **Sound/DJ** - ₹12,000 - Amazing sound and DJ services
6. 🚗 **Car Rentals** - ₹12,000 - Luxury car rental services
7. 👔 **Dressing** - ₹10,000 - Professional styling
8. 💄 **Makeup** - ₹8,000 - Expert makeup artists
9. 🎤 **MC/Anchor** - ₹7,000 - Professional event host
10. 💡 **Lighting** - ₹5,000 - Stunning lighting setup

## 🛠 Technology Stack

### Backend
- **Java 17** - Programming language
- **Spring Boot 3.2.2** - Application framework
- **Spring Data JPA** - Database ORM
- **PostgreSQL** - Relational database
- **Maven** - Build tool
- **Lombok** - Reduce boilerplate code

### Frontend
- **HTML5** - Structure
- **CSS3** - Styling with gradients and animations
- **Vanilla JavaScript** - Client-side logic
- **Fetch API** - RESTful API communication
- **Responsive Design** - Mobile-first approach

### Architecture
- **RESTful API** - Clean REST endpoints
- **MVC Pattern** - Separation of concerns
- **Repository Pattern** - Data access layer
- **DTO Pattern** - Data transfer objects
- **Service Layer** - Business logic separation

## 📁 Project Structure

```
event-managment/
├── src/
│   ├── main/
│   │   ├── java/com/sample/event/
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java       # Authentication endpoints
│   │   │   │   ├── CartController.java       # Cart management
│   │   │   │   ├── OrderController.java      # Order processing
│   │   │   │   └── SuggestionController.java # AI recommendations
│   │   │   ├── dto/
│   │   │   │   ├── LoginRequest.java         # Login payload
│   │   │   │   └── SignupRequest.java        # Signup payload
│   │   │   ├── model/
│   │   │   │   ├── User.java                 # User entity
│   │   │   │   ├── CartItem.java             # Cart item entity
│   │   │   │   └── Order.java                # Order entity
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java       # User data access
│   │   │   │   ├── CartRepository.java       # Cart data access
│   │   │   │   └── OrderRepository.java      # Order data access
│   │   │   ├── service/
│   │   │   │   └── UserService.java          # User business logic
│   │   │   └── EventApplication.java         # Main application
│   │   └── resources/
│   │       └── application.yml               # Configuration
│   └── test/
│       └── java/                             # Test files
├── frontendsample07.html                     # Frontend application
├── pom.xml                                   # Maven configuration
├── README.md                                 # This file
├── CHANGES_SUMMARY.md                        # Detailed changes log
└── FIXES_COMPLETED.md                        # Bug fixes documentation

```

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK) 17** or higher
  ```bash
  java -version
  ```

- **Maven 3.6+**
  ```bash
  mvn -version
  ```

- **PostgreSQL 14+**
  ```bash
  psql --version
  ```

- **Git** (for cloning)
  ```bash
  git --version
  ```

- **Modern Web Browser** (Chrome, Firefox, Safari, Edge)

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/REENA1998/event-management-system.git
cd event-management-system
```

### 2. Setup PostgreSQL Database

**Option A: Using psql command line**
```bash
# Login to PostgreSQL
psql -U postgres

# Create database
CREATE DATABASE eventdb;

# Exit psql
\q
```

**Option B: Using createdb command**
```bash
createdb -U postgres eventdb
```

**Option C: Using pgAdmin** (GUI)
1. Open pgAdmin
2. Right-click on "Databases"
3. Select "Create" → "Database"
4. Name: `eventdb`
5. Click "Save"

### 3. Configure Database Connection

Edit `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/eventdb
    username: postgres          # Change if needed
    password: postgres          # Change to your password
```

### 4. Build the Project
```bash
mvn clean install
```

## 🏃 Running the Application

### Method 1: Using Maven (Recommended for Development)
```bash
mvn spring-boot:run
```

### Method 2: Using JAR File
```bash
# Build JAR
mvn clean package

# Run JAR
java -jar target/event-managment-1.0-SNAPSHOT.jar
```

### Method 3: Using Startup Script
```bash
chmod +x start.sh
./start.sh
```

### Access the Application

**Backend API:** http://localhost:8088

**Frontend:** Open `frontendsample07.html` in your browser
```bash
# macOS
open frontendsample07.html

# Linux
xdg-open frontendsample07.html

# Windows
start frontendsample07.html
```

## 📡 API Documentation

### Base URL
```
http://localhost:8088
```

### Authentication Endpoints

#### Register User
```http
POST /api/auth/signup
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

#### Login User
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

### Cart Endpoints

#### Add to Cart
```http
POST /api/cart/add
Content-Type: application/json

{
  "userId": 1,
  "vendorId": 1
}
```

#### Get Cart Count
```http
GET /api/cart/count?userId=1
```

**Response:** `3`

### Order Endpoints

#### Place Order
```http
POST /api/order/place?userId=1
```

**Response:** `"Order placed successfully. Total: ₹40000.0"`

### AI Suggestion Endpoint

#### Get Budget Recommendations
```http
GET /api/ai/suggest?budget=100000
```

**Response:**
```json
{
  "selectedCategories": ["Venue", "Catering", "Decorations", "Photography"],
  "totalEstimate": 135000
}
```

## 🎨 Frontend Features

### User Interface Components

#### 1. Authentication Section
- **Signup Form** - Name, email, password
- **Login Form** - Email, password
- Auto-fill login after signup

#### 2. AI Budget Assistant
- Budget input field
- AI suggestion button
- Chat-style recommendations display
- Clears previous results automatically

#### 3. Dynamic Vendor Grid
- Shows only recommended vendors
- Displays vendor icon, name, price, description
- "Add to Cart" button for each vendor
- Responsive grid layout

#### 4. Shopping Cart
- Large cart count display
- Real-time updates
- "Place Order" button
- Visual feedback

#### 5. Custom Modal Dialogs
- Success messages with celebration theme
- Confirmation dialogs with Yes/Cancel buttons
- Error messages with helpful guidance
- Smooth animations

### Design Features
- **Gradient Backgrounds** - Purple to violet theme
- **Card-Based Layout** - Clean, organized sections
- **Smooth Animations** - Fade-in, slide-in effects
- **Hover Effects** - Interactive button states
- **Responsive Design** - Mobile, tablet, desktop support

## 🗄 Database Schema

### Users Table
```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

### Cart Items Table
```sql
CREATE TABLE cart_item (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    vendor_id BIGINT NOT NULL,
    item_name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL
);
```

### Orders Table
```sql
CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    total_amount DOUBLE PRECISION NOT NULL
);
```

**Note:** Tables are created automatically by Hibernate on first run.

## 📸 Screenshots

### Home Page (Authentication)
Beautiful gradient background with side-by-side signup and login forms.

### AI Budget Assistant
Enter your budget and get instant recommendations with total estimated cost.

### Dynamic Vendor Display
Vendors appear based on your budget - only affordable options shown.

### Shopping Cart & Order
Track items in cart and place orders with beautiful confirmation dialogs.

## 🐛 Troubleshooting

### Issue: Backend won't start

**Check PostgreSQL is running:**
```bash
# macOS
brew services list

# Linux
sudo systemctl status postgresql

# Start PostgreSQL
brew services start postgresql  # macOS
sudo systemctl start postgresql # Linux
```

**Verify database exists:**
```bash
psql -U postgres -c "\l" | grep eventdb
```

### Issue: Port 8088 already in use

**Change port in `application.yml`:**
```yaml
server:
  port: 8089  # Use different port
```

**Update frontend `BASE_URL`:**
```javascript
const BASE_URL = "http://localhost:8089";
```

### Issue: CORS errors in browser

Backend has `@CrossOrigin` enabled. If issues persist:
```java
@CrossOrigin(origins = "http://localhost:3000") // Specific origin
```

### Issue: Database connection refused

**Check PostgreSQL is listening:**
```bash
psql -U postgres -h localhost -p 5432
```

**Verify credentials in `application.yml`**

### Issue: Vendors not showing after AI suggestion

**Make sure backend is restarted** after adding Venue to `SuggestionController.java`

## 🧪 Testing the Application

### 1. Test User Registration
- Open `frontendsample07.html`
- Fill in name, email, password
- Click "Create Account"
- Should show success modal

### 2. Test Login
- Enter email and password
- Click "Sign In"
- Should see welcome modal and main content

### 3. Test AI Budget Assistant
- Enter budget: `₹100,000`
- Click "Get AI Suggestions"
- Should see vendor recommendations
- Vendors should appear in grid below

### 4. Test Add to Cart
- Click "Add to Cart" on any vendor
- Should see success modal
- Cart count should increase

### 5. Test Place Order
- Click "Place Order Now"
- Confirm in modal
- Should see success with total amount
- Cart should reset to 0

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

- **REENA** - [GitHub Profile](https://github.com/REENA1998)

## 🙏 Acknowledgments

- Spring Boot Team for the excellent framework
- PostgreSQL Community
- All contributors and testers

## 📞 Support

For support, email reena@example.com or open an issue on GitHub.

## 🔮 Future Enhancements

- [ ] Email verification for signup
- [ ] Password encryption (BCrypt)
- [ ] Order history page
- [ ] Payment gateway integration
- [ ] Admin dashboard
- [ ] Vendor management system
- [ ] Real-time notifications
- [ ] Multiple event types
- [ ] Social media integration
- [ ] Mobile app version

---

**Made with ❤️ by REENA**

**Star ⭐ this repository if you found it helpful!**

