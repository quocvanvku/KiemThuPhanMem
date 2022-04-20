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

public class bai_4 {

    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");

        driver.manage().window().maximize();

    }



    public static void main(String[] args) {
        bai_4 bai4 = new bai_4();
        bai4.setUp();
    }

}


















