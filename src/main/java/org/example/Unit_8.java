package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static org.example.Global.driver;
import static org.example.Global.driver1;
import static org.example.Global.driver2;

public class Unit_8 {
    public void play_radio(WebDriver driver){
        String radio_play_id = "Placeholder";
        WebElement radio_play = driver.findElement(By.id(radio_play_id));
        radio_play.click();
    }
    // ENSURE this test is last in Unit_8 as it closes all windows
    @Test(priority=10)
    public void multiple_connections() throws InterruptedException {
        // ADD A TIMEOUT FOR THIS TEST
        // SET CONDITION TO FALSE IF PAGE TIMES OUT
        List<WebDriver> drivers = new ArrayList<>();
        // Open 3 windows and log into Endless Dial
        Main.driver_init(driver1);
        Main.driver_init(driver2);
        drivers.add(driver);
        drivers.add(driver1);
        drivers.add(driver2);
        // Open radio and play song with each driver
        for (WebDriver driver : drivers){
            driver.get("http://localhost:3000/radio");
            // Play 1st song in radios list
            play_radio(driver);
        }
        // Close all drivers after 5 seconds
        Thread.sleep(5000);
        for (WebDriver driver : drivers){
            driver.close();
        }

    }
}
