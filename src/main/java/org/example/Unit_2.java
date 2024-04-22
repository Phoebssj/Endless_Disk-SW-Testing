package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Unit_2 extends Main.Unit_Test {
    private WebDriver driver;
    public Unit_2() {
        driver = super.setup();
        super.sign_in(driver);
    }
    @AfterClass
    public void Unit_2_destructor() {
        super.teardown(driver);
    }
    @Test(priority = 1)
    void navButtons() throws InterruptedException {
        //Testing all the buttons and scrolling if viable
        // First open a new driver and get the site
        driver.get("http://localhost:3000");
        // Provide a small delay to test the browser opening
        Thread.sleep(1250);
        // Find the button to select
        WebElement Nav_pg_1 = driver.findElement(By.id("library"));
        Nav_pg_1.click();
        Thread.sleep(2250);
        // Find the button to select
        WebElement Nav_pg_2 = driver.findElement(By.id("radio"));
        //Click it
        Nav_pg_2.click();
        Thread.sleep(2250);

        // Find the button to select
        WebElement Nav_pg_3 = driver.findElement(By.id("import"));
        //Click it
        Nav_pg_3.click();
        Thread.sleep(2250);

        // Find the button to select
        WebElement Nav_pg_4 = driver.findElement(By.id("export"));
        //Click it
        Nav_pg_4.click();

        // Find the button to select
        WebElement Nav_pg_5 = driver.findElement(By.id("notices"));
        //Click it
        Nav_pg_5.click();
        Thread.sleep(1250);

    }

    @Test
    void navGitHub() throws InterruptedException {
        // Testing the access of the github repo and issue release
        WebElement Nav_pg_6 = driver.findElement(By.xpath("/html/body/div/nav/ul/a"));
        Nav_pg_6.click();
        Thread.sleep(1250);
    }

    @Test
    void expandNotice() throws InterruptedException {
        driver.get("http://localhost:3000/notices");
        driver.findElement(By.id("notice")).click();
        Thread.sleep(1000);
    }

    //Once loaded scroll on the page
    //
    //JavascriptExecutor Scrolldown_gh = (JavascriptExecutor) driver;
    //close tab
    //Open the info release
    // close window
}
