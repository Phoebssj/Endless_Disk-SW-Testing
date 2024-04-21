package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Global.driver;
import static org.example.Global.driver1;
import static org.example.Global.driver2;

public class Unit_8 {
    @Test(priority=10)
    public void multiple_connections() {
        // Open 3 windows and log into Endless Dial
        driver.get("http://localhost:3000/radio");
        // ADD SIGN-IN FOR NEW INSTANCES
        driver1.get("http://localhost:3000/radio");
        driver2.get("http://localhost:3000/radio");
        // PLAY 1ST RADIO LISTED ON EACH INSTANCE
    }
}
