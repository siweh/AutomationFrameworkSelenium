package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Cart extends BaseTest {
    By cartProduct = By.cssSelector("td[class='product-name'] a");
    public static boolean match = true;

    @Test
    public boolean getCartProduct(String productName) throws InterruptedException {
//        HomePage.Login("mihle@gmail.com", "mihle@gmail.com");
        List<WebElement> cartProductList = driver.findElements(cartProduct);
        match = cartProductList.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    @Test
    public void deleteProductOnCart(){
        if(match){
            driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();
        }else {
            driver.findElement(By.cssSelector(".icon_close_alt2")).click();
        }
    }

    @Test
    public int updateQuantityOfProduct() {
        int updatedQuantity = 0;
        if (match) {
            //Update by adding more quantity of that product because the update button is not working
            // Locate the quantity input field
            WebElement quantityInput = driver.findElement(By.id("noo-quantity-6259"));
            // Get the initial quantity value
            int initialQuantity = Integer.parseInt(quantityInput.getAttribute("value"));
            // Locate the quantity increase button and click on it
            WebElement increaseButton = driver.findElement(By.id("qty-increase"));
            increaseButton.click();
            // Get the updated quantity value
            updatedQuantity = Integer.parseInt(quantityInput.getAttribute("value"));
        }
        return updatedQuantity;
    }
}
