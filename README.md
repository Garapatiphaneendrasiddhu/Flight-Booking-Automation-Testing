# Expedia Flight Booking Automation

## Overview
This project automates the flight booking process on **Expedia** using **Java and Selenium WebDriver**. The script dynamically selects departure and destination locations, sets travel dates, configures traveler details, and performs flight searches.

## Features
- **Automated Flight Search:** Selects departure and destination cities.
- **Dynamic Date Selection:** Picks a departure date one month from today.
- **Traveler Configuration:** Sets the number of passengers (e.g., 2 adults).
- **XPath Optimization:** Uses reliable locators for UI elements.
- **Explicit Waits & Exception Handling:** Ensures stability and robustness.

## Technologies Used
- **Java** – Primary programming language
- **Selenium WebDriver** – Automates browser interaction
- **ChromeDriver** – Controls Chrome browser
- **XPath & CSS Selectors** – Locates elements dynamically
- **WebDriverWait** – Handles dynamic page loads

## Setup & Installation
### Prerequisites:
1. Install **Java (JDK 8 or later)**
2. Install **Chrome Browser**
3. Download **ChromeDriver** (compatible with your Chrome version)
4. Add ChromeDriver path to system environment variables
5. Install **Selenium WebDriver** dependencies

### Steps to Run the Script:
1. Clone this repository:
   ```sh
   git clone https://github.com/your-repo/expedia-flight-booking.git
   ```
2. Open the project in an IDE (e.g., IntelliJ, Eclipse)
3. Update the **ChromeDriver path** in the script
4. Run the Java file:
   ```sh
   javac ExpediaFlightBookingAutomation.java
   java ExpediaFlightBookingAutomation
   ```

## Notes
- Ensure that Expedia’s UI structure hasn't changed, as it may require updating XPath locators.
- You may need to modify `WebDriverWait` timing based on network speed.
- The script currently selects **one-way flights only**; return flights can be added as an enhancement.

## Future Enhancements
- Support for **round-trip bookings**
- Integration with **data-driven testing** frameworks (e.g., TestNG, JUnit)
- Multi-browser support (Firefox, Edge, etc.)

## License
This project is open-source and available under the **MIT License**.

---


