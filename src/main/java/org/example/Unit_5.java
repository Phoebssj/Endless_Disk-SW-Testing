package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Unit_5 extends Main.Unit_Test {
    private WebDriver driver;
    public Unit_5() {
        this.driver = super.setup();
    }
    @AfterClass
    public void Unit_5_destructor() {
        super.teardown(driver);
    }
    void FetchingData_MongoDb() throws InterruptedException {
        //I'm leaving two version as Mongo db has it's fighitng niche here....
        driver.get("http://localhost:3000/notices");
        Thread.sleep(1250);
        // Find an account in the database
        WebElement queryAccount = driver.findElement(By.className("notice"));
        Assert.assertNotNull(queryAccount);
//store the string from the account
        //String accountInfo = queryAccount.getText();
//print the account info
        //System.out.println(accountInfo);
        Thread.sleep(1250);

    }

    void emptyEntry() throws InterruptedException {

        //Define a new driver
        //WebDriver driver = new FirefoxDriver();
        //get the admin for the mongodb
        driver.get("http://localhost:5000/get-notices/8675309");
        WebElement Entry = driver.findElement(By.tagName("body"));
        Thread.sleep(1250);
        Assert.assertEquals(Entry.getText(), "Something went wrong");
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
        //WebDriver driver = new FirefoxDriver();
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
        //WebDriver driver = new FirefoxDriver();
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
    }
}
