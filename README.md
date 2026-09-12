# Rental Room Management (RRM) 🏠

A simple and lightweight Java CLI console application for managing rental rooms, tenants, and bookings with JSON data persistence.

---

## 🌟 Key Features

- **🔑 Authentication**: Admin registration and login system.
- **🏠 Room Management (CRUD)**: Create, view details, edit fields dynamically using Reflection, and delete rooms.
- **👥 Tenant Management (CRUD)**: Manage tenant profiles (Name, Age, Gender, Phone).
- **🚪 Check-in & Check-out**: Assign tenants to rooms with capacity check and automatic status updates (`Available` ↔ `Full`).
- **🔍 Search & Filter**: Find available rooms or budget rooms (under 2,500,000 VND).
- **📊 Sort Rooms**: Sort by Name (A-Z / Z-A), Price (Low-High / High-Low), or Area.
- **💾 JSON Persistence**: Automatic data saving and loading using Google Gson (`data/RoomsData.json`, `data/TenantsData.json`, `data/AdminData.json`).

---

## 🛠️ Project Structure

```text
com.ersikthy.rentalroom
├── Main.java                # Application Entry Point
├── model                    # Data Entities (RentalRoom, Tenant, Admin)
└── controller
    ├── auth                 # Login & Sign-up logic
    ├── data                 # DataManager (JSON File I/O via Gson)
    ├── log                  # Output colors & Input helper utilities
    ├── menu                 # Dynamic CLI Menu engine (Menu & MainNav)
    ├── rentalroom           # Room CRUD & Sub-actions
    │   └── inroom           # Room Check-in / Check-out actions
    ├── tenant               # Tenant CRUD actions
    └── uxfunc               # Search & Sort functions
```

---

## 🚀 Getting Started

### Prerequisites

- **Java JDK**: Version 17 or higher
- **Gradle**: Build tool (included via wrapper or Gradle plugin)

### How to Run

1. **Clone or Download** the project repository.
2. Open the project in your favorite IDE (IntelliJ IDEA, VS Code, Eclipse).
3. Run `Main.java` located at:
   ```text
   src/main/java/com/ersikthy/rentalroom/Main.java
   ```

---

## 📖 Usage Guide

1. **Register / Login**: Sign up an Admin account and log in.
2. **Main Menu Options**:
   - **`RentalRoom List`**: View rooms, sort, search, add rooms, or view detailed room options.
   - **`Tenant List`**: Manage global tenant records.
   - **`Setting`**: System configuration.
3. **Room Options**:
   - Select a room to view details, edit fields, delete, or manage occupants (**Check-in / Check-out**).

---

## ⚙️ Dependencies

- **Google Gson** (`2.14.0`): JSON Serialization / Deserialization.
