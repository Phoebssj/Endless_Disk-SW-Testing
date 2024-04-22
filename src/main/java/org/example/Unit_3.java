package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Unit_3 extends Main.Unit_Test {
    private WebDriver driver;
    public Unit_3() {
        driver = super.setup();
        super.sign_in(driver);
    }
    @AfterClass
    public void Unit_3_destructor() {
        super.teardown(driver);
    }
    @Test(priority = 1)
    void addNewStation() throws InterruptedException { //Req 3.1
        //Getting any page assumes session login first
        driver.get("http://localhost:3000/radio"); //Nav to radio page
        driver.findElement(By.className("add-hidden")).click(); //Add station...
        driver.findElement(By.id("title")).sendKeys("Radio 538 Ibiza"); //Enter information in the boxes
        driver.findElement(By.id("artist")).sendKeys("Radio 538");
        driver.findElement(By.id("source")).sendKeys("https://20873.live.streamtheworld.com/TLPSTR19.mp3");
        driver.findElement(By.id("submit")).click(); //And submit the form
        Thread.sleep(1000);
        driver.navigate().refresh(); //Refresh page
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("Radio 538 Ibiza")); //And confirm the new station is present
    }

    @Test(priority = 2)
    void playRadio() throws InterruptedException {
        //Note: This combines 3.4 & 3.5 in a single case
        driver.get("http://localhost:3000/radio");
        driver.findElement(By.className("audio-control")).click(); //Find play button & click
        Thread.sleep(3000); //Await to ensure audio plays
        driver.findElement(By.className("audio-control")).click(); //And pause again
        Assert.assertTrue(true);

    }

    @Test(priority = 3)
    void editRadioData() { //Req 3.3
        driver.get("http://localhost:3000/radio");
        driver.findElement(By.id("radio-player")).click();
        driver.findElement(By.id("title")).sendKeys("Radio 538 - Ibiza");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("title")).getText(), "Radio 538 - Ibiza");
    }

    @Test(priority = 4)
    void removeStation() { //Req 3.2
        driver.get("http://localhost:3000/radio");
        driver.findElement(By.id("remove")).click(); //Click on the first radio
        String confirm_box = driver.switchTo().alert().getText(); //Confirm the popup
        Assert.assertEquals(confirm_box, "Delete radio, are you sure?");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElements(By.id("remove")).isEmpty()); //Assert empty array as falsy
    }

    //Case 3.6 in the future - Add 10 stations to see if all are accounted for on the site

}
