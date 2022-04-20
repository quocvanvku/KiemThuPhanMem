package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArePage {

    private WebDriver driver;
    private By statusAlert = By.id("flash");

    public SecureArePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }


}
