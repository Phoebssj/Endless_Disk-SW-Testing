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


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static class Unit_Test{
        protected WebDriver setup(){
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        }
        protected void sign_in(WebDriver driver){
            driver.get("http://localhost:3000");
            driver.findElement(By.id("username")).sendKeys("IntrixTheName");
            driver.findElement(By.id("password")).sendKeys("Qwerty");
            driver.findElement(By.id("login-button")).click();
        }
        protected void teardown(WebDriver driver) {
            driver.close();
        }
    }
}



