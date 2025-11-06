package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']");
    private By mobile = By.id("userNumber");
    private By hobbyMusic = By.xpath("//label[text()='Music']");
    private By upload = By.id("uploadPicture");
    private By address = By.id("currentAddress");
    private By stateDropdown = By.id("react-select-3-input");
    private By cityDropdown = By.id("react-select-4-input");
    private By submitButton = By.id("submit");
    private By successModal = By.id("example-modal-sizes-title-lg");

    // Actions
    public void navigate() {
        driver.get("https://demoqa.com/automation-practice-form");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
    }

    public void fillForm(String fName, String lName, String mail, String phone, String addr) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(genderMale).click();
        driver.findElement(mobile).sendKeys(phone);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        driver.findElement(hobbyMusic).click();

        // upload ảnh (đảm bảo có file sample.jpg trong resources)
        driver.findElement(upload).sendKeys(System.getProperty("user.dir") + "/src/test/resources/sample.jpg");

        driver.findElement(address).sendKeys(addr);

        WebElement state = driver.findElement(stateDropdown);
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(cityDropdown);
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successModal));
            return driver.findElement(successModal).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
