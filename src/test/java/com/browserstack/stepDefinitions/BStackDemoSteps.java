package com.browserstack.stepDefinitions;

import com.browserstack.SeleniumTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class BStackDemoSteps extends SeleniumTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Given("I am on the BrowserStack demo website")
    public void iAmOnTheBStackDemoWebsite() {
        driver.get("https://bstackdemo.com");
        try {
            Thread.sleep(3000); // Wait 3 seconds to see the page load
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @When("I add a product to the cart")
    public void iAddProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        // Wait for products to load and click the first buy button
        WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shelf-item__buy-btn")));
        
        try {
            Thread.sleep(2000); // Wait 2 seconds to see the products loaded
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        buyButton.click();
        
        try {
            Thread.sleep(2000); // Wait 2 seconds to see the button click action
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Wait for the cart to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".float-cart__content")));
        
        try {
            Thread.sleep(2000); // Wait 2 seconds to see the cart appear
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("I should see the product in the cart")
    public void iShouldSeeProductInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        // Check if product is in cart
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".float-cart__content .shelf-item")));
        
        try {
            Thread.sleep(3000); // Wait 3 seconds to see the verification
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Assert.assertTrue(cartItem.isDisplayed(), "Product should be visible in cart");
        
        try {
            Thread.sleep(2000); // Wait 2 seconds before test completes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
