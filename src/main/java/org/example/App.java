package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver", "C:\\work\\WebDrivers\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    }
}
