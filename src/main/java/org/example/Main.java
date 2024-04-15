package org.example;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Unit_0 {
    private WebDriver Disk_Status;// intialize the webdriver load page.

    @BeforeTest
    void Open_Driver() throws InterruptedException {
        //check if the browser Window can load (depending on where it should run)
        WebDriver Disk_Status = new FirefoxDriver();

        //Test if the Browser opens by getting the specific link to test if the browser opens.
        // In this specfic case we'll do firefox
        Disk_Status.get("");
        // Provide a small delay to test the browser opening
        Thread.sleep(1250);
        // Make it do something here
        // depending on th site I'll most likely scroll
        //close the tab


        Thread.sleep(2000);
    }

    void Open_EndlessDisk() throws InterruptedException {
        //Testing Endless disk
        Disk_Status = new FirefoxDriver();
        //Open the tab again
        Disk_Status.get("");
        //check the connection of the site works if it does work it doesn't throw a fail for the site
        //If it doesn't it does not open and the test fails.
        Thread.sleep(1250);
        // I know how java works and it won't let you close it.... less you throw an error by stating to close again
    }

    void GetPageSource() throws InterruptedException {
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
        ;


    }

}
class Unit_2 {
    private WebDriver Disk_Status = new FirefoxDriver();
        //Testing all the buttons and scrolling if viable
        // First open a new driver and get the site
    void Nav_bar() throws InterruptedException {
        WebDriver Disk_Status = new FirefoxDriver();

        //I'll have to define the window handles and look at the two tabs
        //Meaning I need to make a loop.... I'm Lazy....

        Disk_Status.get("");
        // Provide a small delay to test the browser opening
        // Login into the site....
        //Disk_Status.findElement(By.id("")).sendKeys("");
        //Disk_Status.findElement(By.id("")).sendKeys("");

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
    }




    void Open_Github() throws InterruptedException {
        WebDriver Disk_Status = new FirefoxDriver();

        Disk_Status.get("");
        // Provide a small delay to test the browser opening
        Thread.sleep(1250);
        //WebElement Nav_pg_# = Disk_Status.findElement(By.id(""));
        //Navigate to  the github
        //Nav_pg_#.click();
        Thread.sleep(1250);
        //Once loaded scroll on the page
        JavascriptExecutor Scroll_gh = (JavascriptExecutor) Disk_Status;
        Thread.sleep(1250);
        //scroll down
        Scroll_gh.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1250);
        //scroll up
        Scroll_gh.executeScript("window.scrollTo(0,0)");
        Thread.sleep(1250);

        //close tab
        //Need to ask Bradley on that
        // for now Disk_Status.close()
        // Disk_Status.switchTo().window(EndlessDisk_tab);
        Disk_Status.close();





        //Open the info release



        // close window
    }

    void Open_InfoPg() throws InterruptedException {
        WebDriver Disk_Status = new FirefoxDriver();


//Login in
        //Disk_Status.findElement(By.id("")).sendKeys("");
        //Disk_Status.findElement(By.id("")).sendKeys("");

        Disk_Status.get("");
        // Provide a small delay to test the browser opening
        Thread.sleep(1250);
        //Open the info release
        //WebElement Nav_pg_# = Disk_Status.findElement(By.id(""));
        //Navigate to the infopg
        //Nav_pg_#.click();

        // close window

    }






    }
class Unit_5{
    private WebDriver driver = new FirefoxDriver();
    void FetchingData_MongoDb() throws InterruptedException {
        //I'm leaving two version as Mongo db has it's fighitng niche here....
        //Define a new driver
        WebDriver driver = new FirefoxDriver();
        //get the admin for the mongodb
        driver.get("");
        Thread.sleep(1250);
        // Find an account in the database
        WebElement queryAccount = driver.findElement(By.id(""));
//store the string from the account
        String accountInfo = queryAccount.getText();
//print the account info
        System.out.println(accountInfo);
        Thread.sleep(1250);
        driver.close();

    }

    void emptyEntry() throws InterruptedException {

        //Define a new driver
        WebDriver driver = new FirefoxDriver();
        //get the admin for the mongodb
        driver.get("");
        // get account/ track entry
        WebElement Entry = driver.findElement(By.id(""));
        Thread.sleep(1250);
        // get the attributes of the entry
        String EntryContent = Entry.getAttribute("value");
        //check if it's empty
        if(EntryContent.isEmpty()){// ifi empty print entry and it's output result
            Thread.sleep(1250);
            System.out.println(EntryContent);
            Thread.sleep(1250);
            //Also print it's empty
            System.out.println("Content is Empty");
        }
        else{
            System.out.println("Content is not Empty");
            Thread.sleep(1250);
            System.out.println(EntryContent);
        }
        Thread.sleep(1250);
        driver.close();



    }

    void MismatchEntry_Error() throws InterruptedException {
        //Define a new driver
        WebDriver driver = new FirefoxDriver();
        //get the admin for the mongodb

        driver.get("");
        // get account/ track entry
        Thread.sleep(1250);
        WebElement Entry_1 = driver.findElement(By.id(""));
        Thread.sleep(1250);
        //get the content of it
        String Content_1 = Entry_1.getTagName();
        Thread.sleep(1250);
        //Entry content needed
        Thread.sleep(1250);
        WebElement Entry_2 = driver.findElement(By.id(""));
        String Content_2 = Entry_2.getTagName();
        Thread.sleep(1250);

        //Check if the data does not have the correct entry within the account
        Assert.assertNotEquals(Content_1,Content_2,"Mismatch entries");
        Thread.sleep(1250);

        driver.close();
    }


    void NewEntry() throws InterruptedException {
        //Define a new driver
        WebDriver driver = new FirefoxDriver();
        //get the admin for the mongodb

        driver.get("");
        // get ther content of the new song/ radio
        Thread.sleep(1250);
        WebElement Song_Entry = driver.findElement(By.id(""));

        // Get the content of the current song/ radio
        Thread.sleep(1250);
        WebElement Current_Entry = driver.findElement(By.id(""));

            Thread.sleep(1250);
        // Check if the data is new entry by comparing it to the current.
        Assert.assertNotSame(Song_Entry,Current_Entry, "New Entry Detected");
        Thread.sleep(1250);

        driver.close();





    }



}


