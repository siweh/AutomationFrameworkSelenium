package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Checkout extends BaseTest {

    @Test
    public String checkoutFunctionality() throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("billing_first_name"));
        nameInput.sendKeys("Lisakhanya");
        WebElement lastNameInput = driver.findElement(By.id("billing_last_name"));
        lastNameInput.sendKeys("Sam");

        WebElement countryDropdown = driver.findElement(By.id("billing_country"));
        Select dropdownCountry = new Select(countryDropdown);
        dropdownCountry.selectByVisibleText("Albania");

        WebElement addressInput1 = driver.findElement(By.id("billing_address_1"));
        addressInput1.sendKeys("556 Nyala Street");
        WebElement addressInput2 = driver.findElement(By.id("billing_address_2"));
        addressInput2.sendKeys("Ext 3 Orlando West");
        WebElement cityInput = driver.findElement(By.id("billing_city"));
        cityInput.sendKeys("Johannesburg");

        WebElement billingState = driver.findElement(By.id("billing_state"));
        Select dropdownState = new Select(billingState);
        dropdownState.selectByIndex(2);

        driver.findElement(By.id("billing_postcode")).sendKeys("1234");
        driver.findElement(By.id("billing_phone")).sendKeys("0750793053");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='terms and conditions']"))).click();

        driver.findElement(By.id("place_order")).click();
        Thread.sleep(2000);
        String successOrderMessage = driver.findElement(By.cssSelector(".woocommerce-thankyou-order-received")).getText();
        return successOrderMessage;
    }

}
