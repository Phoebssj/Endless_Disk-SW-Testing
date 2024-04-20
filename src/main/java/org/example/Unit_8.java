package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

import static org.example.Global.driver;

public class Unit_8 {
    public void instance_test() throws InterruptedException {
        List<WebDriver> instances = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            WebDriver driver = new FirefoxDriver();
            driver.get("http://localhost:3000/library");
            instances.add(driver);
        }
        Thread.sleep(5000);
        for (WebDriver driver : instances) {
            driver.close();
        }
    }
}
