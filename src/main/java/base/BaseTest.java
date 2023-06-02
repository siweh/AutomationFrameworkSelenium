package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties property = new Properties();
    public static FileReader fileReader;

    @BeforeMethod
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
            //Mazimize current window
            driver.manage().window().maximize();
            // Set implicit wait to 2 seconds
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get(property.getProperty("testurl"));
        } else if (property.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            //Mazimize current window
            driver.manage().window().maximize();
            // Set implicit wait to 2 seconds
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get(property.getProperty("testurl"));
        }
    }

    @AfterMethod
    public void closingBrowser() {
        driver.close();
//        System.out.println("browser closed");
    }
}
