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

# Clean build and run:
mvn clean spring-boot:run
```

**Wait for this message in terminal:**
```
✅ Sample vendor data initialized successfully!
Started EventApplication in X.XXX seconds
```

### Step 3: Open Browser
Open: **http://localhost:8088/index.html**

**Note:** The system automatically creates 27 sample vendors on first run!

---

## 🎯 HOW IT WORKS - COMPLETE FLOW

### 1️⃣ FIRST TIME SETUP (Create Admin)

**Step 1: Create Admin User**
- Open browser: `http://localhost:8088/index.html`
- Click **"Sign Up"**
- Enter:
  - Name: `Admin`
  - Email: `admin@test.com`
  - Password: `admin123`
  - Role: **`Administrator`** ⬅️ Select this!
- Click **"Sign Up"**

**Step 2: Login as Admin**
- You'll be automatically logged in
- You'll see **Admin Dashboard** ⚙️
- Dashboard shows:
  - **27 pre-loaded sample vendors** (all approved!)
  - 5 Venue options
  - 5 Decorations options
  - 5 Dressing options
  - 5 Lighting options
  - 7 other category vendors

**No manual database commands needed!**

---

### 2️⃣ VENDOR REGISTRATION (Optional - Add More Services)

**Note:** The system already has 27 sample vendors loaded! You can skip this section for testing, or add your own.

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

**Step 2: Add Your Service**
- Click **"Add New Service"** button
- Fill form with your service details
- Click **"Save Service"**
- Status shows: **PENDING** (yellow)

**Step 3: Admin Approval**
- Switch to admin dashboard
- Click **"Pending"** tab
- Review and click **"✓ Approve"**
- Status changes to **APPROVED** (green)

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
  ✅ Catering
  ✅ Decorations
  ✅ Photography
  ✅ Sound/DJ
  ✅ Makeup
  ...
  💰 Total Estimated: ₹XXX,XXX
  ```

**Step 3: Browse by Category**
- Scroll to "Browse Vendors by Category"
- You'll see **10 category cards** with images:
  - 🏛️ Venue
  - 🍽️ Catering
  - 📸 Photography
  - 🎨 Decorations
  - 🎵 Sound/DJ
  - 💄 Makeup
  - 🚗 Car Rentals
  - 👗 Dressing
  - 🎤 MC/Anchor
  - 💡 Lighting
- Click any category card (e.g., **Venue**)

**Step 4: Browse Vendors in Category**
- Opens new page: `browse-vendors.html?category=Venue`
- Shows all **approved** Venue vendors (5 samples)
- Each vendor card shows:
  - High-quality image
  - Business name
  - Category badge
  - Description
  - Location
  - Price
  - Rating
  - **"Add to Cart"** button

**Step 5: Use Filters**
- **Price Range**: Enter max price (e.g., 120000)
- **Location**: Filter by city (e.g., Mumbai)
- **Sort By**: Rating, Price (Low/High)
- Click **"Apply Filters"**

**Step 6: Add to Cart**
- Click **"Add to Cart"** on any vendor
- Success message: `✅ Added to cart!`
- Cart badge (🛒) updates with item count
- Browse more categories and add items

**Step 7: View Cart**
- Click **cart icon** (🛒) in top-right
- Modal shows:
  - All added items with images
  - Each item's price
  - **Total amount**
- Items are automatically saved in database

**Step 8: Place Order**
- Click **"Place Order"** button in cart (from user dashboard)
- Success alert with styled message
- Order saved in `orders` table
- Individual items saved in `order_items` table
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
2. **vendors** - Stores all vendor services with details and images
3. **cart_items** - Stores user cart items (vendorName, category, price, imageUrl)
4. **orders** - Stores placed orders with total amount
5. **order_items** - Stores individual items in each order

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

# View order items:
SELECT * FROM order_items;

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
- [ ] `mvn spring-boot:run` shows "✅ Sample vendor data initialized successfully!"
- [ ] `mvn spring-boot:run` shows "Started EventApplication"
- [ ] Can open http://localhost:8088/index.html
- [ ] Admin account created (via signup with Administrator role)
- [ ] Admin dashboard shows 27 pre-loaded vendors
- [ ] Vendor account created (optional)
- [ ] Vendor can add services (optional)
- [ ] Admin can approve vendor services
- [ ] User account created
- [ ] AI budget planner gives recommendations
- [ ] Can browse vendors by category (10 category cards visible)
- [ ] Can view category-specific vendors on browse page
- [ ] Can filter vendors by price and location
- [ ] Can add to cart and see count
- [ ] Can place order successfully
- [ ] Order items saved in database

---

## 🎬 5-MINUTE DEMO FLOW

1. **Minute 1**: Create admin account (select Administrator role in signup)
2. **Minute 2**: View admin dashboard - see 27 pre-loaded vendors
3. **Minute 3**: Create user account, use AI planner with ₹150k
4. **Minute 4**: Browse category cards, click Venue, view 5 venue options
5. **Minute 5**: Add items to cart from different categories, place order

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

