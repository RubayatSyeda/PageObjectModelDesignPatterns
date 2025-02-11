package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reusables.basePage;

public class AccountPage extends basePage {

    private final By usernameTextBoxLocator = By.xpath("(//input[contains(@placeholder,'Username / Email')])[1]");
    private final By passwordTextBoxLocator = By.xpath("(//input[contains(@placeholder,'Password')])[1]");
    private final By signInButtonLocator = By.xpath("(//button[contains(@type,'submit')][normalize-space()='Sign in'])[1]");

    private static final Logger logger = LogManager.getLogger(AccountPage.class);
    public AccountPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username) {
        WebElement usernameTextBox = driver.findElement(usernameTextBoxLocator);
        logger.info("Inserting username");
        try {
            usernameTextBox.sendKeys(username);
        } catch (Exception e) {
            take_screenshot();
            System.out.println(e.getMessage());
        }
    }

    public void enterPassword(String password) {
        WebElement passwordTextBox = driver.findElement(passwordTextBoxLocator);
        logger.info("Inserting password");
        try {
            passwordTextBox.sendKeys(password);
        } catch (Exception e) {
            take_screenshot();
            System.out.println(e.getMessage());
        }
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(signInButtonLocator);
        Assert.assertTrue(signInButton.isEnabled());
        logger.info("Clicking on sign in button");
        try {
            signInButton.click();
        } catch (Exception e) {
            take_screenshot();
            System.out.println(e.getMessage());
        }
    }

}
