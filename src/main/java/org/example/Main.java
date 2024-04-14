package org.example;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
     Disk_Status.get("http://localhost:3000");
    // Provide a small delay to test the browser opening
     Thread.sleep(1250);
     // Make it do something here
        // depending on th site I'll most likely scroll
        //close the tab




//Testing Endless disk
        Disk_Status = new FirefoxDriver();
        //Open the tab again
        Disk_Status.get("");
        //check the connection of the site works if it does work it doesn't throw a fail for the site
        //If it doesn't it does not open and the test fails.
        Thread.sleep(1250);
        // I know how java works and it won't let you close it.... less you throw an error by stating to close again


// Testing getting data from the database.
        Disk_Status = new FirefoxDriver();
        //Open the tab again
//I'm unsure to how the data is defined within the database so I'm aiming for the site
        Thread.sleep(1250);

        String pageSource = Disk_Status.getPageSource(); //Initalize the variable of getting a page source.
        // but if the page source contains a specific item,
        pageSource.contentEquals('');//print the source data and return true
        //print the source out here
        Thread.sleep(1250);
        System.out.println(pageSource);
        Thread.sleep(1250);


        Disk_Status.close();


    }

    public class unit1 {
        public static WebDriver press_disc_play(WebDriver driver, String url, String play_id) {
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

    void Unit_5(){

    }
}



class Unit_3 {
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
        driver.findElement(By.id("login")).click();
    }


    @Test(priority = 2)
    void addNewStation() {
        //Getting any page assumes session login first
        driver.get("http://localhost:3000/radio");
        driver.findElement(By.id("add")).click();
        driver.findElement(By.id("title")).sendKeys("Radio 538 Ibiza");
        driver.findElement(By.id("artist")).sendKeys("Radio 538");
        driver.findElement(By.id("source")).sendKeys("https://20873.live.streamtheworld.com/TLPSTR19.mp3")
        driver.findElement(By.id("submit")).click()
        Thread.sleep(1000)
        driver.navigate().refresh();
        Assert.assertEqual(,)
    }

    @Test(priority = 2)
    void removeStation() {
        
    }
}