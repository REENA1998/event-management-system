# 🎉 Event Management System

A full-stack event management application with **Spring Boot backend** and **HTML/JavaScript frontend** featuring AI-powered budget recommendations.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.2-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14+-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)


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


## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/REENA1998/event-management-system.git
cd event-management-system
```

### 2. Setup PostgreSQL Database
```bash
# Create database
createdb eventdb
```

### 3. Configure Database (Optional)
Edit `src/main/resources/application.yml` if needed:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/eventdb
    username: postgres
    password: postgres
```

### 4. Build the Project
```bash
mvn clean install
```

## 🏃 Running the Application

### Start Backend
```bash
mvn spring-boot:run
```

### Open Frontend
Open `frontendsample07.html` in your browser

**Backend API:** http://localhost:8088

## 📡 API Endpoints

### Base URL
```
http://localhost:8088
```

### User Registration
```http
POST /api/auth/signup
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

### User Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}
```

### Add to Cart
```http
POST /api/cart/add
Content-Type: application/json

{
  "userId": 1,
  "vendorId": 1
}
```

### Get Cart Count
```http
GET /api/cart/count?userId=1
```

### Place Order
```http
POST /api/order/place?userId=1
```

### AI Budget Suggestions
```http
GET /api/ai/suggest?budget=100000
```


## 🎨 Frontend Features

- **Authentication** - Signup and Login forms
- **AI Budget Assistant** - Get smart vendor recommendations
- **Dynamic Vendor Grid** - Shows vendors within budget
- **Shopping Cart** - Real-time cart count updates
- **Custom Modal Dialogs** - Beautiful confirmation and success messages
- **Responsive Design** - Works on all devices

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

## 🧪 How to Use

1. **Start Backend**: Run `mvn spring-boot:run`
2. **Open Frontend**: Open `frontendsample07.html` in browser
3. **Register**: Create account with name, email, password
4. **Login**: Sign in with your credentials
5. **AI Assistant**: Enter budget and get recommendations
6. **Add to Cart**: Click on vendors to add services
7. **Place Order**: Complete your booking

---

**Made with ❤️ by REENA**

**Star ⭐ this repository if you found it helpful!**

