package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai_2 {

    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();

        driver.manage().window().setSize(new Dimension(800, 600));

    }

    public static void main(String[] args) {
        bai_2 bai2 = new bai_2();
        bai2.setUp();
    }

}


















