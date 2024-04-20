package org.example;

import org.testng.annotations.Test;

import static org.example.Global.driver;

public class Unit_0 {
    //check if the browser Window can load (depending on where it should run)
    @Test
    void checkWindow() throws InterruptedException {
        driver.get("https://www.google.com");
        // Provide a small delay to test the browser opening
        Thread.sleep(1250);
    }

    @Test
    void checkApp() throws InterruptedException {
        driver.get("http://localhost:5000/connection-test/web-server");
        //check the connection of the site works if it does work it doesn't throw a fail for the site
        //If it doesn't it does not open and the test fails.
        Thread.sleep(1250);
    }

    @Test
    void checkDatabase() throws InterruptedException {
        driver.get("http://localhost:5000/connection-test/database-server");
        //I'm unsure to how the data is defined within the database so I'm aiming for the site
        Thread.sleep(1250);
    }

    //String pageSource = driver.getPageSource(); //Initalize the variable of getting a page source.
    // but if the page source contains a specific item,
    //pageSource.contentEquals("");//print the source data and return true
    //print the source out here
    //Thread.sleep(1250);
    //System.out.println(pageSource);
    //Thread.sleep(1250);


    //driver.close();
}
