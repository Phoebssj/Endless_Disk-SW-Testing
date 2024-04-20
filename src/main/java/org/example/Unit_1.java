package org.example;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Global.driver;

public class Unit_1 {
    // Press either the play or pause button, depending on id passed in
    @Test
    public WebDriver press_play_pause(String url, String btn_id) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        WebElement target_btn = driver.findElement(By.id(btn_id));
        target_btn.click();
        Thread.sleep(2000);
        return driver;
    }
    public double get_current_time(WebDriver driver, WebElement playback_elem) {
        String get_curr_time = "return arguments[0].currentTime;";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        double current_time = (Double) js.executeScript(get_curr_time, playback_elem);
        return current_time;
    }
    public void Invalid_id() {
        try {
            throw new InvalidArgumentException("Please provide ID for correct seek button");
        }
        catch (InvalidArgumentException e){
            System.err.println("InvalidArgumentException: "+e.getMessage());
        }
    }
    @Test
    public void forward_check(String url, String btn_id) {
        driver.get(url);
        String seek_forward = "forward";
        boolean seek_forward_worked = false;
        // Ensure we are testing the seek forward button
        if (btn_id.equals(seek_forward)) {
            // Find seek bar and check the initial time
            WebElement playback_bar = driver.findElement(By.tagName("audio"));
            double initial_time = get_current_time(driver, playback_bar);
            // Find the seek button and click it
            WebElement target_btn = driver.findElement(By.id(seek_forward));
            target_btn.click();
            // Use time diff to verify btn skips fwd 15 secs
            double final_time = get_current_time(driver, playback_bar);
            double lag_time = 0.35;
            // If endless disc has to load, or code takes more than lag_time to exec
            // Test will still pass since the button still skips properly
            if (final_time-initial_time < 15+lag_time || final_time-initial_time > 15-lag_time)
                seek_forward_worked = true;
        }
        // If we are NOT testing the seek forward button, throw error
        else {
            Invalid_id();
        }
        Assert.assertTrue(seek_forward_worked);
    }
    @Test
    public void rewind_check(WebDriver driver, String url, String btn_id) {
        driver.get(url);
        String seek_backward = "rewind";
        boolean seek_backward_worked = false;
        // Ensure we are testing the seek forward button
        if (btn_id.equals(seek_backward)) {
            // Find seek bar and check the initial time
            WebElement playback_bar = driver.findElement(By.tagName("audio"));
            double initial_time = get_current_time(driver, playback_bar);
            // Find the seek button and click it
            WebElement target_btn = driver.findElement(By.id(seek_backward));
            target_btn.click();
            // Use time diff to verify btn skips fwd 15 secs
            double final_time = get_current_time(driver, playback_bar);
            double lag_time = 0.35;
            // If endless disc has to load, or code takes more than lag_time to exec
            // Test will still pass since the button still skips properly
            if (initial_time-final_time < 15+lag_time || initial_time-final_time > 15-lag_time)
                //There may be issues when initial or final time is 0
                seek_backward_worked = true;
        }
        // If we are NOT testing the seek backward button, throw error
        else {
            Invalid_id();
        }
        Assert.assertTrue(seek_backward_worked);
    }
}
