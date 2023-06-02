package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.ReadExcelData;

import java.util.List;

public class HomePage extends BaseTest {
    public By username = By.id("username");
    public By password = By.id("password");
    private static boolean isLoggedIn = true;
    private static boolean isLoggedOut = true;
    public static boolean match;

//    @Test
    public static void HomePageScreen() {
        driver.findElement(By.xpath("//a[normalize-space()='Dismiss']")).click();
        driver.findElement(By.linkText("My Account")).click();
    }

    @Test
    public static boolean ValidUserLogin() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Dismiss']")).click();
//        driver.findElement(By.xpath("//a[normalize-space()='My Account']")).click();
//        driver.findElement(By.linkText("ToolsQA Demo Site")).click();
        List<WebElement> links = driver.findElements(By.cssSelector(".noo-product-item"));
//        System.out.println(links.size());
        links.get(3).click();
        //Select a dropdown with select tag
        WebElement 	colorDropdown = driver.findElement(By.id("color"));
        WebElement 	sizeDropdown = driver.findElement(By.id("size"));

        Select dropdownColor = new Select(colorDropdown);
        Select dropdownSize = new Select(sizeDropdown);
        dropdownColor.selectByIndex(1);
        dropdownSize.selectByIndex(1);

        WebElement addToCartBtn = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
        addToCartBtn.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]")).click();
        return true;
    }

    @Test
    public static String SuccessfullAddedToCartMessage() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Dismiss']")).click();
//        driver.findElement(By.xpath("//a[normalize-space()='My Account']")).click();
//        driver.findElement(By.linkText("ToolsQA Demo Site")).click();
        List<WebElement> links = driver.findElements(By.cssSelector(".noo-product-item"));
//        System.out.println(links.size());
        links.get(3).click();
        //Select a dropdown with select tag
        WebElement 	colorDropdown = driver.findElement(By.id("color"));
        WebElement 	sizeDropdown = driver.findElement(By.id("size"));

        Select dropdownColor = new Select(colorDropdown);
        Select dropdownSize = new Select(sizeDropdown);
        dropdownColor.selectByIndex(1);
        dropdownSize.selectByIndex(1);

        WebElement addToCartBtn = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
        addToCartBtn.click();
        Thread.sleep(2000);

        String addToCartText = driver.findElement(By.cssSelector(".woocommerce-message")).getText();
        addToCartText.trim();
        System.out.println(addToCartText);
        return addToCartText;
    }

    @Test
    public static boolean UserCompletesOrder(){
        driver.findElement(By.linkText("Dismiss")).click();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("ToolsQA Demo Site")).click();
        List<WebElement> links = driver.findElements(By.cssSelector(".noo-product-item"));
        System.out.println(links.size());
        links.get(3).click();
        //Select a dropdown with select tag
        WebElement 	colorDropdown = driver.findElement(By.id("color"));
        WebElement 	sizeDropdown = driver.findElement(By.id("size"));

        Select dropdownColor = new Select(colorDropdown);
        Select dropdownSize = new Select(sizeDropdown);
        dropdownColor.selectByIndex(1);
        dropdownSize.selectByIndex(1);

        WebElement addToCartBtn = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
        addToCartBtn.click();
        driver.findElement(By.linkText("View cart")).click();
        List<WebElement> cartProductList = driver.findElements(By.cssSelector("td[class='product-name'] a"));
        System.out.println(cartProductList);
        match = cartProductList.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase("Tokyo Talkies"));

        driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();
        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_first_name")).sendKeys("Lisakhanya");
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys("Sam");
        WebElement countryDropdown = driver.findElement(By.id("billing_country"));

        Select dropdownCountry = new Select(countryDropdown);
        dropdownCountry.selectByVisibleText("Albania");
        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_address_1")).sendKeys("556 Nyala Street");
        driver.findElement(By.id("billing_address_2")).clear();
        driver.findElement(By.id("billing_address_2")).sendKeys("Ext 3 Orlando West");
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys("Johannesburg");

        WebElement billingState = driver.findElement(By.id("billing_state"));
        Select dropdownState = new Select(billingState);
        dropdownState.selectByIndex(2);

        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys("6688");
        driver.findElement(By.id("billing_phone")).clear();
        driver.findElement(By.id("billing_phone")).sendKeys("0750793053");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='terms and conditions']"))).click();
        WebElement termAndConditions = driver.findElement(By.xpath("//a[normalize-space()='terms and conditions']"));
        termAndConditions.click();
        if(termAndConditions.isSelected()){
            System.out.println("Checkbox selected");
        }else {
            System.out.println("Checkbox is not selected");
        }
        driver.findElement(By.id("place_order")).click();
        return true;
    }
    public static void Register(){
        driver.findElement(By.linkText("Dismiss")).click();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.id("reg_username")).sendKeys("Mihlelihle");
        driver.findElement(By.id("reg_email")).sendKeys("mihle@gmail.com");
        driver.findElement(By.id("reg_password")).sendKeys("Mihlelihle123");
        driver.findElement(By.name("register")).click();
    }

    @Test
    public static Boolean Login(String username, String password) throws InterruptedException{
        HomePageScreen();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.findElement(By.linkText("ToolsQA Demo Site")).click();
        return true;
    }

    public static boolean isLoggedIn(){
        return isLoggedIn;
    }

    public static boolean isLoggedOut(){
        return isLoggedOut;
    }

    //Invalid User login with incorrect username
//    @Test
    public static void InvalidUserLogin(){
        driver.findElement(By.linkText("Dismiss")).click();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.id("username")).sendKeys("12233445");
        driver.findElement(By.id("password")).sendKeys("Mihlelihle123");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.linkText("Dashboard")).click();

    }

    //Invalid User login with incorrect password
//        @Test
    public static void InvalidUser(){
        driver.findElement(By.linkText("Dismiss")).click();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.id("username")).sendKeys("m@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Mi");
        driver.findElement(By.name("login")).click();
    }

    public static void LoginWithNoPassword(){
       HomePageScreen();
        driver.findElement(By.id("username")).sendKeys("m@gmail.com");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.name("login")).click();
        //Get an error sayiing password input field is empty then click on the lost password button
        driver.findElement(By.linkText("Lost your password?")).click();
        driver.findElement(By.id("user_login")).sendKeys("mihle@gmail.com");
        driver.findElement(By.cssSelector(".woocommerce-Button")).click();
    }

    public static String getTitle() {
        String expectedtitle = "My Account – ToolsQA Demo Site";
        String actualTitle = driver.getTitle();
        return actualTitle;
    }
}
