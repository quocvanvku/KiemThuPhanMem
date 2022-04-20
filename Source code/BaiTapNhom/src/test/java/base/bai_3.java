package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class bai_3 {

    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        List<WebElement> listInput = driver.findElements(By.tagName("input"));
        System.out.println(listInput.size());

        for (WebElement element:listInput) {
            System.out.println("Name: " + element.getAttribute("name"));
        }

    }



    public static void main(String[] args) {
        bai_3 bai3 = new bai_3();
        bai3.setUp();
    }

}

















