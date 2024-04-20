package org.example;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Global.driver;

public class Unit_1 {
    // Throw exception exists in case Thread.sleep fails
    public void press_and_wait(WebElement target_btn, int wait_time) throws InterruptedException{
        target_btn.click();
        Thread.sleep(wait_time);
    }

    public double get_current_time(WebElement playback_elem) {
        String get_curr_time = "return arguments[0].currentTime;";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        double current_time = (Double) js.executeScript(get_curr_time, playback_elem);
        return current_time;
    }

    public double[] get_time_diff(WebElement playback_bar, String btn_id){
        double[] time_diff = new double[2];
        double initial_time = get_current_time(playback_bar);
        time_diff[0] = initial_time;
        // Find the seek button and click it
        WebElement seek_btn = driver.findElement(By.id(btn_id));
        double final_time = get_current_time(playback_bar);
        time_diff[1] = final_time;
        return time_diff;
    }

    @Test
    public void test_pause() throws InterruptedException {
        String url = "http://localhost:3000/library";
        String pause_id = "Placeholder";
        driver.get(url);
        Thread.sleep(2000);
        WebElement pause_btn = driver.findElement(By.id(pause_id));
        press_and_wait(pause_btn, 2000);
    }

    @Test
    public void test_play() throws InterruptedException {
        String url = "http://localhost:3000/library";
        String play_id = "Placeholder";
        driver.get(url);
        Thread.sleep(2000);
        WebElement pause_btn = driver.findElement(By.id(play_id));
        press_and_wait(pause_btn, 2000);
    }

    @Test
    public void forward_check() {
        String url = "http://localhost:3000/library";
        driver.get(url);
        String forward_id = "Placeholder";
        boolean forward_worked = false;
        // Find seek bar and get time change from seek forward
        WebElement playback_bar = driver.findElement(By.tagName("audio"));
        double[] time_diff = get_time_diff(playback_bar, forward_id);
        double initial_time = time_diff[0];
        double final_time = time_diff[1];
        // Lag time added to account for loading or slow code execution
        double lag_time = 0.35;
        // Final minus init time ensures result is pos
        double time_skipped = final_time - initial_time;
        if (time_skipped < 15+lag_time && time_skipped > 15-lag_time) {
            forward_worked = true;
        }
        Assert.assertTrue(forward_worked);
    }

    @Test
    public void rewind_check() {
        String url = "http://localhost:3000/library";
        driver.get(url);
        String backward_id = "Placeholder";
        boolean backward_worked = false;
        // Find seek bar and get time change from seek back
        WebElement playback_bar = driver.findElement(By.tagName("audio"));
        double[] time_diff = get_time_diff(playback_bar, backward_id);
        double initial_time = time_diff[0];
        double final_time = time_diff[1];
        // Lag time added to account for loading or slow code execution
        double lag_time = 0.35;
        // Init minus final time ensures result is pos
        double time_skipped = initial_time - final_time;
        if (time_skipped < 15+lag_time && time_skipped > 15-lag_time) {
            backward_worked = true;
        }
        Assert.assertTrue(backward_worked);
    }
}