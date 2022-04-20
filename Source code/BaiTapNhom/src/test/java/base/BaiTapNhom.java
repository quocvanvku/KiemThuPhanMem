package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaiTapNhom {

    private WebDriver driver;

//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/");
//
//        //driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(375, 812));
//        System.out.println(driver.getTitle());
//
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
//        driver.quit();
//    }

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.manage().window().maximize();

        WebElement userNameElement = driver.findElement(By.id("username"));
        userNameElement.sendKeys("tomsmith");
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("SuperSecretPassword!");

        System.out.println("Name attribute if userName button: " + userNameElement.getAttribute("name"));

        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        driver.navigate().back();

        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println(inputList.size());

        for (WebElement element:inputList) {
            System.out.println("Element: " + element.getAttribute("name"));
        }

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println("Element: " + inputList.get(i).getAttribute("name"));
        }

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.quit();

    }

    public void Login(String userName, String passWord, String Location) {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        driver.manage().window().maximize();

        WebElement userNameElement = driver.findElement(By.id("username"));
        userNameElement.sendKeys(userName);
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(passWord);

        driver.findElement(By.xpath("//li[contains(text(),'"+Location+"')]")).click();

        driver.findElement(By.id("loginButton")).click();

    }

    public void Logout() {

          driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

    }

    public void RegisterPatient(String givenName, String middleName, String familyName, String chooseMale, String birthdateDay,
                                String birthdateMonth, String birthdateYear, String address1, String address2, String cityVillage,
                                String stateProvince, String country, String postalCode, String phoneNumber, String relationshipType,
                                String personName) {

        driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();

        WebElement givenElement = driver.findElement(By.name("givenName"));
        givenElement.sendKeys(givenName);

        WebElement middleElement = driver.findElement(By.name("middleName"));
        middleElement.sendKeys(middleName);

        WebElement familyNameElement = driver.findElement(By.name("familyName"));
        familyNameElement.sendKeys(familyName);

        driver.findElement(By.id("next-button")).click();

        Select selectGender = new Select(driver.findElement(By.id("gender-field")));
        selectGender.selectByVisibleText(chooseMale);

        driver.findElement(By.id("next-button")).click();

        WebElement dayElement = driver.findElement(By.name("birthdateDay"));
        dayElement.sendKeys(birthdateDay);

        Select selectMonth = new Select(driver.findElement(By.id("birthdateMonth-field")));
        selectMonth.selectByVisibleText(birthdateMonth);

        WebElement yearElement = driver.findElement(By.name("birthdateYear"));
        yearElement.sendKeys(birthdateYear);

        driver.findElement(By.id("next-button")).click();

        WebElement addressElement = driver.findElement(By.id("address1"));
        addressElement.sendKeys(address1);

        WebElement address2Element = driver.findElement(By.id("address2"));
        address2Element.sendKeys(address2);

        WebElement cityElement = driver.findElement(By.id("cityVillage"));
        cityElement.sendKeys(cityVillage);

        WebElement provinceElement = driver.findElement(By.id("stateProvince"));
        provinceElement.sendKeys(stateProvince);

        WebElement countryElement = driver.findElement(By.id("country"));
        countryElement.sendKeys(country);

        WebElement postalCodeElement = driver.findElement(By.id("postalCode"));
        postalCodeElement.sendKeys(postalCode);

        driver.findElement(By.id("next-button")).click();

        WebElement phoneNumberElement = driver.findElement(By.name("phoneNumber"));
        phoneNumberElement.sendKeys(phoneNumber);

        driver.findElement(By.id("next-button")).click();

        Select selectRelationship = new Select(driver.findElement(By.id("relationship_type")));
        selectRelationship.selectByVisibleText(relationshipType);

        //WebElement nameElement1 = driver.findElement(By.cssSelector("//input[class*=person-typeahead ng-valid ng-touched ng-dirty ng-valid-parse ng-empty]"));

        WebElement nameElement1 = driver.findElement(By.xpath("//input[@placeholder='Person Name']"));
        nameElement1.sendKeys(personName);

        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("submit")).click();

    }

    public void findPatientRecord(String nameElementFind) {

        driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();

        WebElement findPatientElement = driver.findElement(By.id("patient-search"));
        findPatientElement.sendKeys(nameElementFind);

    }

    public void ViewPatientRecord(String fieldSearch) {

        findPatientRecord(fieldSearch);

        driver.findElement(By.xpath("//table[@class='table table-sm dataTable']/tbody/tr[1]")).click();

    }

    public void CaptureVitals(String id, String height, String weight, String temperature, String pulse, String respiratoryRate,
                              String bloodPressure1, String bloodPressure2, String arterialBloodOxygen, String circumference) {
        driver.findElement(By.id("referenceapplication-vitals-referenceapplication-vitals-extension")).click();

        driver.findElement(By.xpath("//td[contains(text(),'"+id+"')]")).click();

        driver.findElement(By.id("coreapps-vitals-confirm")).click();

        WebElement heightElement = driver.findElement(By.name("w8"));
        heightElement.sendKeys(height);
        driver.findElement(By.id("next-button")).click();

        WebElement weightElement = driver.findElement(By.name("w10"));
        weightElement.sendKeys(weight);
        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("next-button")).click();

        WebElement temperatureElement = driver.findElement(By.name("w12"));
        temperatureElement.sendKeys(temperature);
        driver.findElement(By.id("next-button")).click();

        WebElement pulseElement = driver.findElement(By.name("w14"));
        pulseElement.sendKeys(pulse);
        driver.findElement(By.id("next-button")).click();

        WebElement respiratoryRateElement = driver.findElement(By.name("w16"));
        respiratoryRateElement.sendKeys(respiratoryRate);
        driver.findElement(By.id("next-button")).click();

        WebElement bloodPressureElement1 = driver.findElement(By.name("w18"));
        bloodPressureElement1.sendKeys(bloodPressure1);
        WebElement bloodPressureElement2 = driver.findElement(By.name("w20"));
        bloodPressureElement2.sendKeys(bloodPressure2);
        driver.findElement(By.id("next-button")).click();

        WebElement arterialBloodOxygenElement = driver.findElement(By.name("w22"));
        arterialBloodOxygenElement.sendKeys(arterialBloodOxygen);
        driver.findElement(By.id("next-button")).click();

        WebElement circumferenceElement = driver.findElement(By.name("w24"));
        circumferenceElement.sendKeys(circumference);
        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

    }

    public static void main(String[] args) {
        BaiTapNhom baiTapNhom = new BaiTapNhom();
        baiTapNhom.Login("Admin", "Admin123", "Inpatient Ward");


    }

}
















