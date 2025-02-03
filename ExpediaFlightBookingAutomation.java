package flight_booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ExpediaFlightBookingAutomation {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium web\\chromedriver\\chromedriver-win64\\chromedriver.exe"); // Replace with your chromedriver path

        // Initialize Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Initialize the Chrome WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Expedia
            driver.get("https://www.expedia.com/");

            // Verify landing on the correct page
            String currentUrl = driver.getCurrentUrl();
            String title = driver.getTitle();
            System.out.println("URL: " + currentUrl);
            System.out.println("Title: " + title);

            // Click on “English” beside the globe icon
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement languageSelector = wait.until(ExpectedConditions.elementToBeClickable(By.id("language-selector")));
            languageSelector.click();

            // Choose the Region as “India” and language as “English”
            WebElement region = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'India')]")));
            region.click();

            // Click on "Flights"
            WebElement flightsTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("tab-flight-tab-hp")));
            flightsTab.click();

            // Enter the departure city: Kolkata
            WebElement departureCity = driver.findElement(By.id("flight-origin-hp-flight"));
            departureCity.clear();
            departureCity.sendKeys("Kolkata, West Bengal, India (CCU-Netaji Subhash Chandra Bose Intl.)");

            // Enter the destination city: Hyderabad
            WebElement destinationCity = driver.findElement(By.id("flight-destination-hp-flight"));
            destinationCity.clear();
            destinationCity.sendKeys("Hyderabad, Telangana, India (HYD-Rajiv Gandhi Intl.)");

            // Click on the departure date
            WebElement departureDate = driver.findElement(By.id("flight-departing-hp-flight"));
            departureDate.click();

            // Select a date: 1 Month after the day of your assignment submission
            LocalDate currentDate = LocalDate.now();
            LocalDate oneMonthLater = currentDate.plus(1, ChronoUnit.MONTHS);
            String formattedDate = oneMonthLater.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            WebElement dateElement = driver.findElement(By.xpath("//button[@data-day='" + formattedDate + "']"));
            dateElement.click();

            // Click on the “Travellers”
            WebElement travelersButton = driver.findElement(By.id("traveler-selector-hp-flight"));
            travelersButton.click();

            // Select the number of travelers from the dropdown: “2 Adults"
            WebElement adultsSelector = driver.findElement(By.xpath("//input[@aria-label='Adults']"));
            adultsSelector.clear();
            adultsSelector.sendKeys("2");

            // Click on the Done button
            WebElement doneButton = driver.findElement(By.xpath("//button[@class='close btn-text']"));
            doneButton.click();

            // Click on the SEARCH Button
            WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'search-btn')]"));
            searchButton.click();

            // Wait for the results to load and click on the first flight available
            WebElement firstFlight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-test-id,'select-button')]")));
            firstFlight.click();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
