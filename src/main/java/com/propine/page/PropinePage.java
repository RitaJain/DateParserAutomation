package com.propine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PropinePage {
    public WebDriver driver ;
    private By dateInputBox = By.cssSelector ("input[placeholder='date']");
    //private By submitButton= By.cssSelector ("input.btn.btn-default]");
    private By submitButton=By.xpath ("//input[@class='btn btn-default']");
    private By result= By.cssSelector ("div.col-md-6>div");

    public PropinePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDateInputBox() {
        return driver.findElement (dateInputBox);
    }

    public WebElement getSubmitButton() {
        return driver.findElement (submitButton);
    }

    public WebElement getResult() {
        return driver.findElement (result);
    }
}
