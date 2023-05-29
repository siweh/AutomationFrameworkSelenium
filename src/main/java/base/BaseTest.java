package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static Properties property = new Properties();
    public static FileReader fileReader;

    @BeforeTest
    public void setUpBrowsers() throws IOException {
        if(driver == null){
            System.out.println(System.getProperty("user.dir"));
            FileReader fileReader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\configfiles\\config.properties");
            property.load(fileReader);
        }

        //Check if the browser is equal to chrome/firefox
        if(property.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(property.getProperty("testurl"));
            //Mazimize current window
            driver.manage().window().maximize();
        } else if (property.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(property.getProperty("testurl"));
            //Mazimize current window
            driver.manage().window().maximize();
        }
    }

    @AfterTest
    public void closingBrowser() {
        driver.close();
//        System.out.println("browser closed");
    }
}
