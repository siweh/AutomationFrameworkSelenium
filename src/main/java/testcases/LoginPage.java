package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.ReadExcelData;

public class LoginPage extends BaseTest {
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.name("login");
    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "bvtdata")
    public boolean validUserlogin(String username, String password){
        HomePage.HomePageScreen();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        driver.findElement(By.linkText("ToolsQA Demo Site")).click();
        return true;
    }

    @Test
    public boolean InvalidUserLogin(String username, String password){
        HomePage.HomePageScreen();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        driver.findElement(By.linkText("ToolsQA Demo Site")).click();
        return false;
    }
}
