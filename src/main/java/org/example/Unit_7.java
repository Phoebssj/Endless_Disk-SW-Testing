package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.Global.driver;

public class Unit_7 {
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
