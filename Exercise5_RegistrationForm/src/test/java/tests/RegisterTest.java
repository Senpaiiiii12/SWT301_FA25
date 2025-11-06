package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;
import utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Practice Form Test - DemoQA")
public class RegisterTest {
    static WebDriver driver;
    static RegisterPage registerPage;

    @BeforeAll
    static void setUp() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
    }

    @ParameterizedTest(name = "Test Case {index}: {0} {1}, {2}, {3}, expected={5}")
    @CsvFileSource(resources = "/register-data.csv", numLinesToSkip = 1)
    @DisplayName("Test Practice Form with CSV Data")
    @Order(1)
    void testRegister(String fName, String lName, String email, String phone, String address, String expected) {
        registerPage.navigate();
        registerPage.fillForm(fName, lName, email, phone, address);
        registerPage.submitForm();

        boolean success = registerPage.isSuccessModalDisplayed();

        if (expected.equalsIgnoreCase("success")) {
            assertTrue(success, "Expected SUCCESS but got FAIL");
        } else {
            assertTrue(!success, "Expected FAIL but got SUCCESS");
        }
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
