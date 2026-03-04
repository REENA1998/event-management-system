# 🚀 HOW TO RUN & TEST EVENT AI LOCALLY

## ⚡ QUICK START (3 Simple Steps)

### Step 1: Setup Database
```bash
# Open Terminal and run:
psql -U postgres

# Inside psql, run:
CREATE DATABASE eventdb;

# Exit psql:
\q
```

### Step 2: Start the Application
```bash
# Navigate to your project folder:
cd /Users/REEVICT/Downloads/event-managment

# Run the application:
mvn spring-boot:run
```

**Wait for this message in terminal:**
```
Started EventApplication in X.XXX seconds
```

### Step 3: Open Browser
Open: **http://localhost:8088/index.html**

---

## 🎯 HOW IT WORKS - COMPLETE FLOW

### 1️⃣ FIRST TIME SETUP (Create Admin)

**Step 1: Create First User**
- Open browser: `http://localhost:8088/index.html`
- Click **"Sign Up"**
- Enter:
  - Name: `Admin`
  - Email: `admin@test.com`
  - Password: `admin123`
  - Role: `Event Planner / User`
- Click **"Sign Up"**

**Step 2: Make User an Admin**
```bash
# Open new terminal window
psql -U postgres -d eventdb

# Run this command:
UPDATE users SET role = 'ADMIN' WHERE email = 'admin@test.com';

# Verify:
SELECT name, email, role FROM users;

# Exit:
\q
```

**Step 3: Login as Admin**
- Go back to browser
- Refresh page or go to: `http://localhost:8088/index.html`
- Email: `admin@test.com`
- Password: `admin123`
- Click **"Login"**
- You'll see **Admin Dashboard** ⚙️

---

### 2️⃣ VENDOR REGISTRATION (Add Services)

**Step 1: Register as Vendor**
- Open **new browser tab** or **incognito window**
- Go to: `http://localhost:8088/index.html`
- Click **"Sign Up"**
- Enter:
  - Name: `Royal Caterers`
  - Email: `vendor@test.com`
  - Password: `vendor123`
  - Role: **`Vendor / Service Provider`**
- Click **"Sign Up"**
- You'll see **Vendor Dashboard** 🏪

**Step 2: Add First Service**
- Click **"Add New Service"** button
- Fill form:
  - Business Name: `Royal Caterers Premium`
  - Category: `Catering`
  - Description: `Premium catering with international cuisine for weddings and events`
  - Price: `40000`
  - Location: `Mumbai, Maharashtra`
  - Contact: `+91 9876543210`
  - Email: `contact@royal.com`
  - Image URL: `https://images.unsplash.com/photo-1555244162-803834f70033?w=500`
- Click **"Save Service"**
- Status shows: **PENDING** (yellow)

**Step 3: Add More Services (Different Categories)**

**Venue:**
- Business Name: `Grand Palace Hall`
- Category: `Venue`
- Price: `80000`
- Image: `https://images.unsplash.com/photo-1519167758481-83f29da8ae8d?w=500`

**Photography:**
- Business Name: `Studio Moments`
- Category: `Photography`
- Price: `25000`
- Image: `https://images.unsplash.com/photo-1542038784456-1ea8e935640e?w=500`

**Decorations:**
- Business Name: `Elegant Decor`
- Category: `Decorations`
- Price: `20000`
- Image: `https://images.unsplash.com/photo-1511795409834-ef04bbd61622?w=500`

**Sound/DJ:**
- Business Name: `Beat Masters`
- Category: `Sound/DJ`
- Price: `15000`
- Image: `https://images.unsplash.com/photo-1493225457124-a3eb161ffa5f?w=500`

---

### 3️⃣ ADMIN APPROVAL (Approve Vendors)

**Step 1: Switch to Admin Tab**
- Go to admin browser tab
- You'll see **"Pending Approval"** count updated

**Step 2: Approve Vendors**
- Click **"Pending"** tab
- You'll see all pending services
- For each vendor:
  - Review details
  - Click **"✓ Approve"** button
- Status changes to **APPROVED** (green)

**What Admin Can Do:**
- ✓ Approve vendors
- ✗ Reject vendors
- ✎ Edit vendor details (price, description, etc.)
- 🗑 Delete vendors
- View statistics (total vendors, users, orders)

---

### 4️⃣ USER BOOKING (Browse & Order)

**Step 1: Register as User**
- Open **new browser tab**
- Go to: `http://localhost:8088/index.html`
- Click **"Sign Up"**
- Enter:
  - Name: `John Doe`
  - Email: `user@test.com`
  - Password: `user123`
  - Role: **`Event Planner / User`**
- Click **"Sign Up"**
- You'll see **User Dashboard** 🎉

**Step 2: Use AI Budget Planner**
- In the purple "AI Budget Planner" section
- Enter budget: `150000` (₹1.5 lakhs)
- Click **"Get Recommendations"**
- AI shows which categories you can afford:
  ```
  ✅ Venue
  ✅ Catering
  ✅ Photography
  ✅ Decorations
  ✅ Sound/DJ
  💰 Total: ₹180,000
  ```

**Step 3: Browse Vendors**
- Scroll down to "Browse Vendors"
- Click category tabs: **All**, **Venue**, **Catering**, etc.
- Only **APPROVED** vendors show up
- Each card shows:
  - Image
  - Category badge
  - Business name
  - Description
  - Location
  - Price
  - **"Add to Cart"** button

**Step 4: Add to Cart**
- Click **"Add to Cart"** on any vendor
- Cart badge (🛒) updates: shows item count
- Add multiple vendors from different categories

**Step 5: View Cart**
- Click **cart icon** (🛒) in top-right
- Modal popup shows:
  - All added items
  - Each item's price
  - **Total amount**
  - **Remove** button for each item

**Step 6: Place Order**
- Click **"Place Order"** button
- Success alert: `✅ Order placed successfully! Total: ₹XXX,XXX`
- Cart clears automatically

---

## 🧪 TESTING SCENARIOS

### Test 1: Budget Testing
Try different budgets in AI Planner:
- **₹50,000** → Shows 2-3 categories
- **₹100,000** → Shows 5-6 categories
- **₹200,000** → Shows all 10 categories

### Test 2: Category Filtering
- Click each category tab
- Verify only vendors of that category appear
- "All" tab shows all vendors

### Test 3: Vendor Status
- Vendor adds service → Status: PENDING
- Admin approves → Status: APPROVED
- Admin rejects → Status: REJECTED
- Only APPROVED vendors visible to users

### Test 4: Cart Operations
- Add 3-4 items to cart
- Check cart count badge
- Remove one item
- Verify total recalculates
- Place order
- Cart empties

### Test 5: Multiple Users
- Open 3 browser tabs/windows:
  1. Admin dashboard
  2. Vendor dashboard
  3. User dashboard
- Test real-time workflow:
  - Vendor adds → Admin approves → User sees it

---

## 📊 HOW THE SYSTEM WORKS

### Database Tables Created Automatically:
1. **users** - Stores all users (USER, VENDOR, ADMIN)
2. **vendors** - Stores all vendor services
3. **cart_items** - Stores user cart items
4. **orders** - Stores placed orders

### Data Flow:

```
VENDOR REGISTRATION:
Vendor Signs Up → Adds Service → Status: PENDING
     ↓
Admin Reviews → Approves → Status: APPROVED
     ↓
Service Visible to Users

USER BOOKING:
User Browses → Filters Category → Adds to Cart
     ↓
Views Cart → Places Order → Cart Clears → Order Saved

AI RECOMMENDATIONS:
User Enters Budget → System Queries DB → Gets Min Price per Category
     ↓
Algorithm Calculates → Returns Affordable Categories
```

### Backend APIs:
- **Auth**: `/api/auth/signup`, `/api/auth/login`
- **Vendors**: `/api/vendor/register`, `/api/vendor/approved`
- **Cart**: `/api/cart/add`, `/api/cart/items`
- **Orders**: `/api/order/place`
- **Admin**: `/api/admin/vendors`, `/api/admin/vendors/approve/{id}`
- **AI**: `/api/ai/suggest?budget=X`

---

## 🔍 VERIFY EVERYTHING WORKS

### Check Database:
```bash
psql -U postgres -d eventdb

# View all users:
SELECT id, name, email, role FROM users;

# View all vendors:
SELECT id, business_name, category, price, status FROM vendors;

# View cart items:
SELECT * FROM cart_items;

# View orders:
SELECT * FROM orders;

# Exit:
\q
```

### Check Backend Logs:
Look at the terminal where `mvn spring-boot:run` is running:
- See HTTP requests: `GET /api/vendor/approved`
- See database queries: `Hibernate: select...`
- See any errors in red

### Check Browser Console:
- Press **F12** in browser
- Go to **Console** tab
- Should see no red errors
- See API calls in **Network** tab

---

## ❌ TROUBLESHOOTING

### Problem: Can't connect to database
```bash
# Check PostgreSQL is running:
brew services list

# Start if not running:
brew services start postgresql
```

### Problem: "Port 8088 already in use"
```bash
# Find and kill process:
lsof -i :8088
kill -9 <PID>

# Or change port in application.yml:
server:
  port: 8089
```

### Problem: "USER_ALREADY_EXISTS"
Email must be unique. Use different email or delete from database:
```sql
DELETE FROM users WHERE email = 'test@test.com';
```

### Problem: Vendors not showing
- Check vendor status is APPROVED
- Check backend logs for errors
- Verify browser console for API errors

### Problem: Can't login
- Check email/password are correct
- Check user exists in database
- Clear browser cache/cookies

---

## 📱 ACCESS URLS

| What | URL |
|------|-----|
| Login Page | http://localhost:8088/index.html |
| User Dashboard | http://localhost:8088/user-dashboard.html |
| Vendor Dashboard | http://localhost:8088/vendor-dashboard.html |
| Admin Dashboard | http://localhost:8088/admin-dashboard.html |

**Note:** You'll be auto-redirected based on your role after login.

---

## ✅ SUCCESS CHECKLIST

- [ ] PostgreSQL running
- [ ] Database `eventdb` created
- [ ] `mvn spring-boot:run` shows "Started EventApplication"
- [ ] Can open http://localhost:8088/index.html
- [ ] Admin account created and promoted
- [ ] Vendor account created
- [ ] Vendor added services (5+ in different categories)
- [ ] Admin approved all services
- [ ] User account created
- [ ] AI budget planner gives recommendations
- [ ] Can browse vendors by category
- [ ] Can add to cart and see count
- [ ] Can place order successfully

---

## 🎬 5-MINUTE DEMO FLOW

1. **Minute 1**: Create admin, promote role in database
2. **Minute 2**: Create vendor, add 3 services
3. **Minute 3**: Admin approves all services
4. **Minute 4**: Create user, use AI planner with ₹150k
5. **Minute 5**: Add items to cart, place order

---

## 🎉 YOU'RE READY!

Just run these 3 commands and you're live:

```bash
# 1. Create database
psql -U postgres -c "CREATE DATABASE eventdb;"

# 2. Start app
cd /Users/REEVICT/Downloads/event-managment
mvn spring-boot:run

# 3. Open browser
open http://localhost:8088/index.html
```

**That's it! Your Event AI system is running! 🚀**

