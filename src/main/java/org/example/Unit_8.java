package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unit_8 extends Main.Unit_Test{
    private WebDriver driver;
    private WebDriver driver1;
    private WebDriver driver2;

    public Unit_8() {
        this.driver = super.setup();
        this.driver1 = super.setup();
        this.driver2 = super.setup();
        super.sign_in(driver);
        super.sign_in(driver1);
        super.sign_in(driver2);
    }
    @AfterClass
    public void Unit_8_destructor() {
        super.teardown(driver);
    }

    public void play_radio(WebDriver driver){
        String radio_play_id = "Placeholder";
        WebElement radio_play = driver.findElement(By.id(radio_play_id));
        radio_play.click();
    }

    public boolean isTimeout(String import_id, String test_url){
        boolean isTimeout = true;
        try {
            driver.get(test_url);
            WebElement import_btn = driver.findElement(By.id(import_id));
            // Wait 3 seconds for driver to visit new page
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            isTimeout = false;
        }
        catch (TimeoutException e){
            // If we cannot change pages, assume page unresponsive
            System.out.println("Page is unresponsive AFTER stress test. ");
        }
        return isTimeout;
    }

    public boolean isClickResponsive(WebElement pause_btn, WebElement play_btn) {
        // 5 cps * 5 seconds
        int correct_click_count = 25;
        int click_count = 0;
        long initial_time = System.currentTimeMillis();
        // Spam pause and play for 5 times/second for 5 seconds
        while (System.currentTimeMillis() - initial_time < 5000){
            if (System.currentTimeMillis() - initial_time % 200 == 0){
                pause_btn.click();
                play_btn.click();
                click_count += 1;
            }
        }
        return (click_count == correct_click_count);
    }

    public long get_load_time(String page_url) {
        long initial_time = System.currentTimeMillis();
        driver.get(page_url);
        long final_time = System.currentTimeMillis();
        return final_time - initial_time;
    }
    // ENSURE this test is last in Unit_8 as it closes all windows
    @Test(priority=10)
    public void multiple_connections() throws InterruptedException {
        // ADD A TIMEOUT FOR THIS TEST
        // SET CONDITION TO FALSE IF PAGE TIMES OUT
        List<WebDriver> drivers = new ArrayList<>();
        // Open 3 windows and log into Endless Dial
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

    public boolean isConnectionStable() {
        String hostname = "http://localhost:3000";
        InetAddress ip = null;
        boolean contactedHost = false;
        boolean pingedHost = false;
        boolean isConnectionStable = false;
        try {
            ip = InetAddress.getByName(hostname);
            contactedHost = true;
        }
        catch (UnknownHostException e){
            System.err.println("Hostname Error: Cannot find hostname "+hostname);
        }
        try{
            // Ping should be less than 3000 ms
            pingedHost = ip.isReachable(3000);
        }
        catch (IOException e) {
            System.err.println("Network Error: cannot reach "+hostname+" before timeout.");
        }
        // If host can be contacted and returns ping, connection is stable
        return (contactedHost && pingedHost);
    }

    @Test
    public void pause_test_dial() {
        String pause_id = "Placeholder";
        String play_id = "Placeholder";
        driver.get("http://localhost:3000/radio");
        WebElement pause_btn = driver.findElement(By.id(pause_id));
        WebElement play_btn = driver.findElement(By.id(play_id));
        // Always start by playing radio
        play_btn.click();
        // Test if page is responsive during & after stress test
        boolean responsive_during = isClickResponsive(pause_btn, play_btn);
        boolean responsive_after = !isTimeout("Placeholder", "http://localhost:3000/import");
        boolean isResponsive = (responsive_during && responsive_after);
        Assert.assertTrue(isResponsive);
    }

    @Test
    public void pause_test_disc() {
        String pause_id = "Placeholder";
        String play_id = "Placeholder";
        driver.get("http://localhost:3000/library");
        WebElement pause_btn = driver.findElement(By.id(pause_id));
        WebElement play_btn = driver.findElement(By.id(play_id));
        // Always start by playing song
        play_btn.click();
        // Test if page is responsive during & after stress test
        boolean responsive_during = isClickResponsive(pause_btn, play_btn);
        boolean responsive_after = !isTimeout("Placeholder", "http://localhost:3000/export");
        boolean isResponsive = (responsive_during && responsive_after);
        Assert.assertTrue(isResponsive);
    }

    @Test
    public void endless_load_time() {
        List<String> pages = Arrays.asList("/library","/import","/export","/radio","/notices");
        boolean connection_stable = isConnectionStable();
        boolean under_1_second = true;
        if (connection_stable){
            for (String page : pages) {
                long load_time = get_load_time("http://localhost:3000"+page);
                System.out.println(page+"'s load time is "+(load_time*1000)+" secs.");
                // if load time of any page > 1s, test fails
                if (load_time <= 1000) {
                    under_1_second = false;
                }
            }
        }
        // Test failure is only meaningful given stable connection
        else {
           under_1_second = false;
           System.err.println("Error: Network Connection unstable. Test failed automatically.");
        }
        Assert.assertTrue(under_1_second);
    }
}
