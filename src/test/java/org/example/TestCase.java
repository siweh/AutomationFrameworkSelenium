package org.example;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testcases.*;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class TestCase extends BaseTest
{

    LoginPage loginPage = new LoginPage();
    Products product = new Products();
    Cart productsInCart = new Cart();
    Checkout checkout = new Checkout();

    WebElement quantityInput = driver.findElement(By.id("noo-quantity-6259"));
    // Get the initial quantity value
    int initialQuantity = Integer.parseInt(quantityInput.getAttribute("value"));

    String expectedConfirmationMessage = "Your order has been placed successfully.";

    @Test
    public void testLogintitle()
    {
        String expectedTitle = "My Account – ToolsQA Demo Site";
        String actualTitle = HomePage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "The login page title is incorrect");
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        String username = "mihle@gmail.com";
        String password = "mihle@gmail.com";
        Assert.assertTrue(loginPage.validUserlogin(username, password), "User is logged in");
    }

    @Test
    public void testInvalidPasswordLogin() throws InterruptedException {
        String username = "mihle@gmail.com";
        String password = "Mi";
        Assert.assertFalse(loginPage.InvalidUserLogin(username, password), "User is not logged in");
    }

    @Test
    public void testInvalidUsernameLogin() throws InterruptedException {
        String username = "mihl";
        String password = "mihle@gmail.com";
        Assert.assertFalse(loginPage.InvalidUserLogin(username, password), "User is not logged in");
    }

    @Test
    public void testAddToCartSuccessText() throws InterruptedException {
         Assert.assertEquals(HomePage.SuccessfullAddedToCartMessage(),"View cart 'Tokyo Talkies' has been added to your cart.", "Item is not added to cart");
    }

    @Test
    public void testValidUserLogin() throws InterruptedException {
        boolean loginResult = HomePage.ValidUserLogin();
        Assert.assertTrue(loginResult, "Login was not successful");
        Assert.assertTrue(HomePage.isLoggedOut(), "User is not logged out");
    }

    @Test
    public void testCompleteOrderForUser(){
        Assert.assertTrue(HomePage.UserCompletesOrder());
    }

    @Test
    public void testProducts() throws InterruptedException {
        Assert.assertEquals(product.getProductlist(), 6);
    }

    @Test
    public void testProductInCartAvailable() throws InterruptedException {
        Assert.assertTrue(productsInCart.getCartProduct("Tokyo Talkies"), "Product not available");
    }

    @Test
    public void testProductQuantityIncreased(){
        Assert.assertEquals(productsInCart.updateQuantityOfProduct(), initialQuantity + 1, "Quantity did not increase by one");
    }

    @Test
    public void testCheckoutFunctionality() throws InterruptedException {
        Assert.assertEquals(checkout.checkoutFunctionality(), expectedConfirmationMessage, "Checkout was not successful");
    }
}
