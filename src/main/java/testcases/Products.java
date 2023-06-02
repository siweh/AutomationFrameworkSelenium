package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Products extends BaseTest {
    By productsBy = By.cssSelector(".noo-product-item");
    By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");

    @Test
    public List<WebElement> getProductlist(){
//        HomePage.Login("mihle@gmail.com", "mihle@gmail.com");
        List<WebElement> products = driver.findElements(productsBy);
        System.out.println("product size: " + products.size());
        return products;
    }


    public WebElement getProductByName(String productName) {
        WebElement item = getProductlist().stream().filter(product -> product.findElement(By.cssSelector("h3 a")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        return item;
    }
    @Test
    public void addProductToCart(String productName){
        WebElement item = getProductByName(productName);
        item.findElement(addToCartBtn).click();
        driver.findElement(By.linkText("View cart")).click();

    }
}
