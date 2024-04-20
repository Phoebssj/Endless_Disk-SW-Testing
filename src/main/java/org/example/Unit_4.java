package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Global.driver;

public class Unit_4 {
    public boolean isLoggedOut() {
        try {
            WebElement login_box = driver.findElement(By.className("login-box"));
            System.out.println("login-box Element found on the page.");
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("No login-box Element found on the page.");
            return false;
        }
    }

    @Test
    public void redirect_login() throws InterruptedException {
        String landing_url = "http://localhost:3000/radio";
        String logout_url = "http://localhost:3000";
        String redirected_url = "";
        driver.get("landing_url");
        boolean isAuth = isLoggedOut();
        if (!isAuth) {
            Thread.sleep(3000);
            redirected_url = driver.getCurrentUrl();
            Assert.assertEquals(redirected_url, logout_url);
        } else {
            System.out.println("User authorized; do not redirect");
        }
    }
}
