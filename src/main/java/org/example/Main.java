package org.example;

import net.bytebuddy.build.Plugin;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

import static org.example.Global.driver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Refactored constructor so driver can be passed as param
    public static void driver_init(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
        driver.findElement(By.id("username")).sendKeys("IntrixTheName");
        driver.findElement(By.id("password")).sendKeys("Qwerty"); //Note: Not the real password, just for testing
        driver.findElement(By.id("login-button")).click();
    }

    @BeforeSuite
    public void setup(){
        driver_init(driver);
    }

    @AfterSuite
    public void teardown() {
        driver.close();
    }
}



