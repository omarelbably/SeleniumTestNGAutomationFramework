[![GitHub Project](https://img.shields.io/badge/GitHub-Project-blue?logo=github)](https://github.com/omarelbably/SeleniumTestNGAutomationFramework)

# 🚀 Selenium TestNG Automation Framework

A top-notch, scalable, and extensible Java automation framework powered by **Selenium WebDriver** and **TestNG**!  
Designed for robust, maintainable, and data-driven web application testing.

---

## ✨ Features

- 🖥️ **Cross-Browser Support**  
  Run tests on Chrome, Firefox, and Edge with custom driver options and profiles.

- 🗂️ **Page Object Model (POM)**  
  Clean separation of test logic and page interactions for maintainable, reusable code.

- 🧪 **TestNG Integration**  
  Flexible test configuration, parallel execution, and rich reporting.

- 📊 **Data-Driven Testing**  
  Externalize test data in JSON for dynamic, comprehensive coverage.

- 🛠️ **Powerful Utilities**  
  Custom actions, checks, waits, and configuration management for robust automation.

- ✈️🏪 **Realistic End-to-End Scenarios**  
  Includes real-world flows like Flight Reservation and Vendor Portal workflows.

---

## 🗂️ Project Structure

```plaintext
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

## ⚡ Quick Start

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/omarelbably/SeleniumTestNGAutomationFramework.git
cd SeleniumTestNGAutomationFramework
```

### 2️⃣ Install Dependencies

- Requires **Java 17+**, **Maven**, and browser drivers (ChromeDriver, GeckoDriver, EdgeDriver) in your `PATH`.
- Download dependencies:
  ```bash
  mvn clean install
  ```

### 3️⃣ Configure Properties

- Set your preferred browser and config values in `config.properties` (usually under `src/main/resources`).

### 4️⃣ Run the Tests

- **All TestNG tests:**
  ```bash
  mvn test
  ```
- **Specific suite:**
  ```bash
  mvn -DsuiteXmlFile=flight-reservation-suite.xml test
  ```

---

## 🧑‍💻 Example Workflows

### ✈️ Flight Reservation Test Flow

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

### 🏪 Vendor Portal Workflow

1. **Vendor Login**  
   Enter vendor credentials and login.
2. **Dashboard Assertions**  
   Validate metrics, order history, and search features.
3. **Logout**  
   Securely log out and verify login page state.

> See: [`VendorPortalTest.java`](src/test/java/com/ElbablyAcademy/tests/vendorportal/VendorPortalTest.java)

---

## 🏗️ Core Components

### 🧬 Test Base & WebDriver Management

- `AbstractTest.java` manages driver setup/teardown, supports local or Selenium Grid runs, and handles browser selection.
- Integrates with TestNG listeners for enhanced reporting.

### 🗂️ Page Objects

- Located in `src/main/java/com/ElbablyAcademy/pages/`
- Each screen/flow is abstracted into a PageObject, following POM for maintainability.
- Base class: `AbstractPage.java`

### 🛠️ Utilities

- **Actions:** Smart wrappers for clicks, typing, dropdowns, and random selection.
- **Checks:** Assertions for element visibility and presence.
- **Waits:** Robust explicit waits for UI stability.
- **ConfigManager:** Centralized property and environment management.

### ⚙️ Configuration Management

- All test and driver configuration is managed in `config.properties`.
- `ConfigManager` abstracts property loading and access.
- Supports toggling between browsers, grid/local, and dynamic environments.

---

## 💡 Best Practices

- 📦 **Modularize** your test data and configs for easy adaptation.
- 🗂️ **Use POM** for all new pages and flows.
- 🔁 **Add new utilities** to `/utils` for code reuse.
- 🏷️ **Use TestNG annotations** for setup/teardown and flow orchestration.
- 📊 **Externalize test data** for easier maintenance and richer coverage.

---

## 🧑‍🔬 Extending the Framework

### ➕ Add New Test Flows

1. Create PageObject(s) for new screens in `pages/`.
2. Write your test class in `tests/`, extending `AbstractTest`.
3. Model your test data (JSON) and load via utility.
4. Add new utilities to `utils/` if needed.
5. Update `config.properties` for new parameters.

### 🌐 Run on Different Browsers/Environments

- Change the `browser` property in `config.properties`.
- Toggle `grid.enabled` for Grid/Local runs.
- Set `grid.urlFormat` and `grid.hubHost` as required.

---

## 🛡️ Troubleshooting

- Ensure browser drivers are on your `PATH`.
- Double-check `config.properties` for typos.
- Use TestNG reports and logs to debug failures.

---

## 👤 Maintainer

[![Omar Elbably](https://avatars.githubusercontent.com/u/117082933?v=4&s=64)](https://github.com/omarelbably)  
**Omar Elbably**

---

## 🤝 Contributing

Pull requests, issues, and suggestions are welcome!  
Fork, branch, and submit your improvements.

---

## ⭐ Show your support

If you like this project, leave a ⭐ on [GitHub](https://github.com/omarelbably/SeleniumTestNGAutomationFramework)!
