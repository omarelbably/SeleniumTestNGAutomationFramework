# 🚀 Selenium TestNG Automation Framework

[![GitHub](https://img.shields.io/badge/GitHub-Project-blue?logo=github)](https://github.com/omarelbably/SeleniumTestNGAutomationFramework)

A top-notch, scalable, and extensible Java automation framework powered by **Selenium WebDriver** and **TestNG**!  
Designed for robust, maintainable, and data-driven web application testing.

![Automation](https://user-images.githubusercontent.com/117082933/234567890-automation-banner.png) <!-- Replace with an actual image if available -->

---

## ✨ Features

- **Cross-Browser Support** 🖥️  
  Run tests easily on Chrome, Firefox, and Edge with custom driver options and profiles.

- **Page Object Model (POM)** 🗂️  
  Clean separation of test logic and page interactions for maintainable, reusable code.

- **TestNG Integration** 🧪  
  Flexible test configuration, parallel execution, and rich reporting.

- **Data-Driven Testing** 📊  
  Externalize test data in JSON for dynamic, comprehensive coverage.

- **Powerful Utilities** 🛠️  
  Custom actions, checks, waits, and configuration management for robust automation.

- **Sample End-to-End Scenarios** ✈️🏪  
  Includes real-world flows like Flight Reservation and Vendor Portal workflows.

---

## 🗂️ Project Structure

```
src
├── main
│   └── java/com/ElbablyAcademy
│       ├── pages/           # PageObjects for app under test
│       └── utils/           # Utility classes (Actions, Checks, Waits, Config)
└── test
    └── java/com/ElbablyAcademy
        └── tests/           # TestNG test classes (e.g., FlightReservationTest, VendorPortalTest)
```

---

## 🚦 Getting Started

### 1. **Clone the Repository**
```bash
git clone https://github.com/omarelbably/SeleniumTestNGAutomationFramework.git
cd SeleniumTestNGAutomationFramework
```

### 2. **Install Dependencies**
- Ensure you have **Java 17+**, **Maven**, and the appropriate browser drivers installed and on your PATH.
- Download required dependencies via Maven:
  ```bash
  mvn clean install
  ```

### 3. **Configure Properties**
- Set your desired browser and config values in `config.properties` (typically under `src/main/resources`).

### 4. **Run Tests**
- To execute all TestNG tests:
  ```bash
  mvn test
  ```
- Example for a specific suite or test:
  ```bash
  mvn -DsuiteXmlFile=flight-reservation-suite.xml test
  ```

---

## 🧑‍💻 Example: Flight Reservation Test Flow

1. **User Registration**  
   Enter user details, credentials, and address, then submit registration.
2. **Registration Confirmation**  
   Validate registration and navigate to flight search.
3. **Flight Search & Selection**  
   Choose number of passengers, search for flights, select random flights, and confirm booking.
4. **Reservation Confirmation**  
   Validate reservation success.

> See: [`FlightReservationTest.java`](src/test/java/com/ElbablyAcademy/tests/flightreservation/FlightReservationTest.java)

---

## 🏪 Example: Vendor Portal Workflow

1. **Vendor Login**  
   Enter vendor credentials and login.
2. **Dashboard Assertions**  
   Validate metrics, order history, and search features.
3. **Logout**  
   Securely log out and verify login page state.

> See: [`VendorPortalTest.java`](src/test/java/com/ElbablyAcademy/tests/vendorportal/VendorPortalTest.java)

---

## 🏗️ Core Utilities

- **Actions:** Smart wrappers for clicks, typing, dropdowns, and random selection.
- **Checks:** Assertions for element visibility and presence.
- **Waits:** Robust explicit waits for UI stability.
- **ConfigManager:** Centralized property and environment management.

---

## 🛡️ Best Practices

- Modularize your test data and configs for easy adaptation.
- Use the POM structure for all new pages and flows.
- Add new utilities to `/utils` for code reuse.
- Use TestNG's annotations for setup/teardown and test orchestration.

---

## 👤 Maintainer

[![Omar Elbably](https://avatars.githubusercontent.com/u/117082933?v=4&s=64)](https://github.com/omarelbably)  
**Omar Elbably**

---

## 🤝 Contributing

Pull requests, issues, and suggestions are welcome!  
Fork this repo, branch out, and submit your improvements.

---

## ⭐ Show your support

If you like this project, leave a ⭐ on [GitHub](https://github.com/omarelbably/SeleniumTestNGAutomationFramework)!
