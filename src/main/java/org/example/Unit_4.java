package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Global.driver;

public class Unit_4 {
    public boolean isItemInLocalStorage(String item) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Returns true as long as specified item is in session storage
        return !(js.executeScript(String.format(
                "return window.localStorage.getItem('%s');", item)) == null);
    }

    @Test(priority=10)
    public void isLoggedOut() throws InterruptedException {
        boolean isLoggedOut = false;
        // Use driver close to log out as no logout functionality exists yet
        driver.close();
        // Should be kicked out of lib page bc we are signed out
        driver.get("http://localhost:3000/library");
        // Endless Disc should redirect to login page within 3 secs for invalid session
        Thread.sleep(3000);
        // If the login-box is on the page, the user has been logged out
        try {
            WebElement login_box = driver.findElement(By.className("login-box"));
            System.out.println("login-box Element found on the page.");
            isLoggedOut = true;
        }
        // Otherwise, the user has not been logged out properly
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("No login-box Element found on the page.");
        }
        // This approach could fail if the login-box does not appear on the login page
        Assert.assertTrue(isLoggedOut);
    }

    @Test
    public void isTokenSet() {
        boolean isTokenSet = false;
        String str_token = "Placeholder";
        //Assuming class constructor signs in first
        driver.get("http://localhost:3000/notices");
        isTokenSet = isItemInLocalStorage(str_token);
        Assert.assertTrue(isTokenSet);
    }

    @Test(priority=11)
    public void InvalidUser() throws InterruptedException {
        String user_field_id = "Placeholder";
        String pass_field_id = "Placeholder";
        boolean userErrorAppeared  = false;
        driver.get("http://localhost:3000");
        WebElement user_field = driver.findElement(By.id(user_field_id));
        WebElement pass_field = driver.findElement(By.id(pass_field_id));
        // Only valid username is IntrixTheName
        user_field.sendKeys("BadUsername");
        Thread.sleep(750);
        // Note: this is a placeholder, password checking is not implemented
        pass_field.sendKeys("Qwerty");
        Thread.sleep(750);
        // Complete sign-in
        pass_field.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        //Check if Invalid User pop-up appears
        try {
            WebElement user_error = driver.findElement(By.id("user_error"));
            System.out.println("Login Error Element found on the page.");
            userErrorAppeared = true;
        }
        // Otherwise, the user has not been logged out properly
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("No Login Error Element found on the page.");
        }
        Assert.assertTrue(userErrorAppeared);
    }

    @Test(priority=12)
    public void InvalidPassword() throws InterruptedException {
        String user_field_id = "Placeholder";
        String pass_field_id = "Placeholder";
        boolean passErrorAppeared  = false;
        driver.get("http://localhost:3000");
        WebElement user_field = driver.findElement(By.id(user_field_id));
        WebElement pass_field = driver.findElement(By.id(pass_field_id));
        // Valid username
        user_field.sendKeys("IntrixTheName");
        Thread.sleep(750);
        // Valid password
        pass_field.sendKeys("BadPassword");
        Thread.sleep(750);
        // Complete sign-in
        pass_field.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        //Check if Invalid Password pop-up appears
        try {
            WebElement password_error = driver.findElement(By.id("password_error"));
            System.out.println("Login Error Element found on the page.");
            passErrorAppeared = true;
        }
        // Otherwise, the user has not been logged out properly
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("No Login Error Element found on the page.");
        }
        Assert.assertTrue(passErrorAppeared);
    }
}
