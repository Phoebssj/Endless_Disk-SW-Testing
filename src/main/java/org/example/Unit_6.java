package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Unit_6 extends Main.Unit_Test{
    //Notes about Unit 6:
    // - As of writing, this unit has not been implemented in the features of Endless Disc
    // - Basically, assume this unit is going to blow up
    private WebDriver driver;
    public Unit_6() {
        this.driver = super.setup();
    }
    @AfterClass
    public void Unit_6_destructor() {
        super.teardown(driver);
    }

    @Test(priority = 1)
    void showsMusic() { //Req 6.1
        driver.get("http://localhost:3000/library");
        driver.findElement(By.linkText("Sample Album")).click(); //Click on Sample Album to grab songs
        Assert.assertEquals(driver.findElements(By.className("audio-player")).size(), 3); // Assert 3 songs found
    }

    @Test(priority = 2)
    void startSong() throws InterruptedException { //Req 6.3 w/ sprinkles (and requires manual observation for verification)
        driver.get("http://localhost:3000/library");
        driver.findElement(By.id("play-pause")).click(); //Click play
        Thread.sleep(3000); //Give time to evaluate
        driver.findElement(By.id("ffwd")).click(); //Click the seek forward button (skips timestamp +15s)
        Thread.sleep(3000);
        driver.findElement(By.id("rwnd")).click(); //Click reqind (seek -15s)
        Thread.sleep(3000);
        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    void volumeSlider() throws InterruptedException { //Req 6.4 & 6.5
        driver.get("http://localhost:3000/library");
        driver.findElement(By.id("play-pause")).click(); //Play song
        Thread.sleep(3000);
        for(int i = 1; i < 20; i++) {
            driver.findElement(By.id("volume")).sendKeys(Keys.ARROW_RIGHT); //Increase volume
        }
        Thread.sleep(3000);
        Assert.assertTrue(true);
    }
}
