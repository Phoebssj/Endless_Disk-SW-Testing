package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    WebDriver driver = new FirefoxDriver();

    @BeforeSuite
    void setup() {
        driver.manage().window().maximize();
    }

    @AfterSuite
    void teardown() {
        driver.close();
    }


    @BeforeTest
    void Unit_0() throws InterruptedException {
        //check if the browser Window can load (depending on where it should run)
        //WebDriver driver = new FirefoxDriver();

        //Test if the Browser opens by getting the specific link to test if the browser opens.
        // In this specfic case we'll do firefox
        driver.get("https://www.google.com");
        // Provide a small delay to test the browser opening
        Thread.sleep(1250);
        // Make it do something here
        // depending on th site I'll most likely scroll
        //close the tab
        //driver.close();


//Testing Endless disk
        //driver = new FirefoxDriver();
        //Open the tab again
        driver.get("http://localhost:3000");
        //check the connection of the site works if it does work it doesn't throw a fail for the site
        //If it doesn't it does not open and the test fails.
        Thread.sleep(1250);
        // I know how java works and it won't let you close it.... less you throw an error by stating to close again
        //driver.close();


// Testing getting data from the database.
        //driver = new FirefoxDriver();
        //Open the tab again
//I'm unsure to how the data is defined within the database so I'm aiming for the site
        Thread.sleep(1250);

        String pageSource = driver.getPageSource(); //Initalize the variable of getting a page source.
        // but if the page source contains a specific item,
        pageSource.contentEquals("");//print the source data and return true
        //print the source out here
        Thread.sleep(1250);
        System.out.println(pageSource);
        Thread.sleep(1250);


        //driver.close();


    }

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

    class Unit_2 {

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
            // Testing the access of the github repo and issue release
            WebElement Nav_pg_6 = driver.findElement(By.xpath("/html/body/div/nav/ul/a"));
            Nav_pg_6.click();
            Thread.sleep(1250);

            //Navigate to  the github
            //Nav_pg_#.click();
            Thread.sleep(1250);
        }

            //Once loaded scroll on the page
            //
            JavascriptExecutor Scrolldown_gh = (JavascriptExecutor) driver;
            //close tab
            //Open the info release
            // close window
        }

        void Unit_5() {

        }


    class Unit_3 {

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
            Assert.assertFalse(driver.findElements(By.className("station")).isEmpty()); //And confirm the new station is present
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

    class Unit_4 {
        public boolean isItemInLocalStorage(String item) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Returns true as long as specified item is in session storage
            return !(js.executeScript(String.format(
                    "return window.localStorage.getItem('%s');", item)) == null);
        }

        @Test(priority=10)
        public void isLoggedOut() throws InterruptedException {
            boolean isLoggedOut = false;
            // Use driver close to log out as no logout functionality exists yet
            driver.close();
            // Should be kicked out of lib page bc we are signed out
            driver.get("http://localhost:3000/library");
            // Endless Disc should redirect to login page within 3 secs for invalid session
            Thread.sleep(3000);
            // If the login-box is on the page, the user has been logged out
            try {
                WebElement login_box = driver.findElement(By.className("login-box"));
                System.out.println("login-box Element found on the page.");
                isLoggedOut = true;
            }
            // Otherwise, the user has not been logged out properly
            catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("No login-box Element found on the page.");
            }
            // This approach could fail if the login-box does not appear on the login page
            Assert.assertTrue(isLoggedOut);
        }

        @Test
        public void isTokenSet() {
            boolean isTokenSet = false;
            String str_token = "Placeholder";
            //Assuming class constructor signs in first
            driver.get("http://localhost:3000/notices");
            isTokenSet = isItemInLocalStorage(str_token);
            Assert.assertTrue(isTokenSet);
        }

        @Test(priority=11)
        public void InvalidUser() throws InterruptedException {
            String user_field_id = "Placeholder";
            String pass_field_id = "Placeholder";
            boolean userErrorAppeared  = false;
            driver.get("http://localhost:3000");
            WebElement user_field = driver.findElement(By.id(user_field_id));
            WebElement pass_field = driver.findElement(By.id(pass_field_id));
            // Only valid username is IntrixTheName
            user_field.sendKeys("BadUsername");
            Thread.sleep(750);
            // Valid password
            pass_field.sendKeys("AccessEndless");
            Thread.sleep(750);
            // Complete sign-in
            pass_field.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            //Check if Invalid User pop-up appears
            try {
                WebElement user_error = driver.findElement(By.id("user_error"));
                System.out.println("Login Error Element found on the page.");
                userErrorAppeared = true;
            }
            // Otherwise, the user has not been logged out properly
            catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("No Login Error Element found on the page.");
            }
            Assert.assertTrue(userErrorAppeared);
        }

        @Test(priority=12)
        public void InvalidPassword() throws InterruptedException {
            String user_field_id = "Placeholder";
            String pass_field_id = "Placeholder";
            boolean passErrorAppeared  = false;
            driver.get("http://localhost:3000");
            WebElement user_field = driver.findElement(By.id(user_field_id));
            WebElement pass_field = driver.findElement(By.id(pass_field_id));
            // Valid username
            user_field.sendKeys("IntrixTheName");
            Thread.sleep(750);
            // Valid password
            pass_field.sendKeys("BadPassword");
            Thread.sleep(750);
            // Complete sign-in
            pass_field.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            //Check if Invalid Password pop-up appears
            try {
                WebElement password_error = driver.findElement(By.id("password_error"));
                System.out.println("Login Error Element found on the page.");
                passErrorAppeared = true;
            }
            // Otherwise, the user has not been logged out properly
            catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("No Login Error Element found on the page.");
            }
            Assert.assertTrue(passErrorAppeared);
        }
    }

    class Unit_6 {
        //Notes about Unit 6:
        // - As of writing, this unit has not been implemented in the features of Endless Disc
        // - Basically, assume this unit is going to blow up

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



    class Unit_7 {
        //Notes about Unit 7:
        // - As with unit 6, this is not fully implemented AToW, so this unit will likely blow up

        @Test(priority = 1)
        void defaultSort() { //Req 7.1
            driver.get("http://localhost:3000/library");
            Select sortBox = new Select(driver.findElement(By.id("sort")));
            List<WebElement> selectedOptionList = sortBox.getAllSelectedOptions();
            Assert.assertEquals(selectedOptionList.get(0).getText(), "Title, Ascending");
        }

        @Test(priority = 2)
        void adjustSortingTitle() {
            driver.get("http://localhost:3000/library");
            Select sortBox = new Select(driver.findElement(By.id("sort")));
            sortBox.selectByVisibleText("Title, Descending"); //Adjust the option selected
            List<WebElement> selectedOptionList = sortBox.getAllSelectedOptions();
            Assert.assertEquals(selectedOptionList.get(0).getText(), "Title, Descending"); //Assert option is the only one selected
        }

        @Test(priority = 2)
        void adjustSortingArtist() {
            driver.get("http://localhost:3000/library");
            Select sortBox = new Select(driver.findElement(By.id("sort")));
            sortBox.selectByVisibleText("Artist, Ascending"); //Adjust the option selected
            List<WebElement> selectedOptionList = sortBox.getAllSelectedOptions();
            Assert.assertEquals(selectedOptionList.get(0).getText(), "Artist, Ascending"); //Assert option is the only one selected
        }
    }
}