package org.example;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private WebDriver Disk_Status;// intialize the webdriver load page.

    @BeforeTest
    void Unit_0() throws InterruptedException {
        //check if the browser Window can load (depending on where it should run)
        WebDriver Disk_Status = new FirefoxDriver();

        //Test if the Browser opens by getting the specific link to test if the browser opens.
        // In this specfic case we'll do firefox
        Disk_Status.get("https://www.google.com");
        // Provide a small delay to test the browser opening
        Thread.sleep(1250);
        // Make it do something here
        // depending on th site I'll most likely scroll
        //close the tab
        Disk_Status.close();


//Testing Endless disk
        Disk_Status = new FirefoxDriver();
        //Open the tab again
        Disk_Status.get("http://localhost:3000");
        //check the connection of the site works if it does work it doesn't throw a fail for the site
        //If it doesn't it does not open and the test fails.
        Thread.sleep(1250);
        // I know how java works and it won't let you close it.... less you throw an error by stating to close again
        Disk_Status.close();


// Testing getting data from the database.
        Disk_Status = new FirefoxDriver();
        //Open the tab again
//I'm unsure to how the data is defined within the database so I'm aiming for the site
        Thread.sleep(1250);

        String pageSource = Disk_Status.getPageSource(); //Initalize the variable of getting a page source.
        // but if the page source contains a specific item,
        pageSource.contentEquals("");//print the source data and return true
        //print the source out here
        Thread.sleep(1250);
        System.out.println(pageSource);
        Thread.sleep(1250);


        Disk_Status.close();


    }

    public class unit1 {
        public WebDriver press_disc_play(WebDriver driver, String url, String play_id) throws InterruptedException {
            driver.get(url);
            wait(2000);
            WebElement play_button = driver.findElement(By.id(play_id));
            play_button.click();
            wait(2000);
            return driver;
        }

        void Unit_2() throws InterruptedException {
            //Testing all the buttons and scrolling if viable
            // First open a new driver and get the site

            WebDriver Disk_Status = new FirefoxDriver();

            Disk_Status.get("");
            // Provide a small delay to test the browser opening
            Thread.sleep(1250);
// Find the button to select
            WebElement Nav_pg_1 = Disk_Status.findElement(By.id(""));
            //Click it
            Nav_pg_1.click();
            Thread.sleep(2250);


            // Find the button to select
            WebElement Nav_pg_2 = Disk_Status.findElement(By.id(""));
            //Click it
            Nav_pg_2.click();
            Thread.sleep(2250);

            // Find the button to select
            WebElement Nav_pg_3 = Disk_Status.findElement(By.id(""));
            //Click it
            Nav_pg_3.click();
            Thread.sleep(2250);

            // Find the button to select
            WebElement Nav_pg_4 = Disk_Status.findElement(By.id(""));
            //Click it
            Nav_pg_4.click();

            // Find the button to select
            WebElement Nav_pg_5 = Disk_Status.findElement(By.id(""));
            //Click it
            Nav_pg_5.click();
            // Testing the access of the github repo and issue release

            //Navigate to  the github
            //Nav_pg_#.click();
            Thread.sleep(1250);
            //Once loaded scroll on the page
            //
            JavascriptExecutor Scrolldown_gh = (JavascriptExecutor) Disk_Status;


            //close tab


            //Open the info release

            // close window

        }

        void Unit_5() {

        }
    }
}



class Unit_3 {
    //Notes about Unit 3:
    // - Priority assigned to force cases to occur in an order. Radio edited before deleted to ensure proper test flow
    // - Try/Catch blocks are intended to catch errors for cases that are not yet implemented
    //   - Not all features are implemented, so not all can be found
    //   - Rather than blow up the test suite with an error, provide an assert that fails the test case

    WebDriver driver = new FirefoxDriver();

    @BeforeClass
    void login() throws InterruptedException {
        //Ensure window is logged in when starting a new driver
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
        Thread.sleep(500);
        driver.findElement(By.id("username")).sendKeys("IntrixTheName");
        driver.findElement(By.id("password")).sendKeys("HelloWorld");
        Thread.sleep(500);
        driver.findElement(By.id("login-button")).click();
    }

    @AfterClass
    void teardown() {
        driver.close();
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



class Unit_6 {
    //Notes about Unit 6:
    // - As of writing, this unit has not been implemented in the features of Endless Disc
    // - Basically, assume this unit is going to blow up

    WebDriver driver = new FirefoxDriver();

    @BeforeClass
    void login() throws InterruptedException {
        //Ensure window is logged in when starting a new driver
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
        Thread.sleep(500);
        driver.findElement(By.id("username")).sendKeys("IntrixTheName");
        driver.findElement(By.id("password")).sendKeys("HelloWorld");
        Thread.sleep(500);
        driver.findElement(By.id("login-button")).click();
    }

    @AfterClass
    void teardown() {
        driver.close();
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



class Unit_7 {
    //Notes about Unit 7:
    // - As with unit 6, this is not fully implemented AToW, so this unit will likely blow up
    
    WebDriver driver = new FirefoxDriver();

    @BeforeClass
    void login() throws InterruptedException {
        //Ensure window is logged in when starting a new driver
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
        Thread.sleep(500);
        driver.findElement(By.id("username")).sendKeys("IntrixTheName");
        driver.findElement(By.id("password")).sendKeys("HelloWorld");
        Thread.sleep(500);
        driver.findElement(By.id("login-button")).click();
    }

    @AfterClass
    void teardown() {
        driver.close();
    }

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