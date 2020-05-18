package com.propine.tests;
import com.propine.page.PropinePage;
import common.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PropineDateTest extends Base {
    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver ();
    }

    @Test(dataProvider = "getData")
    public void validDateTest (String date, String format)throws ParseException{
        driver.get (prop.getProperty ("url"));
        PropinePage page = new PropinePage (driver);
        WebElement dateBox=page.getDateInputBox ();
        dateBox.sendKeys (date);
        WebElement submitBtn=page.getSubmitButton ();
        submitBtn.click();
        WebElement result=page.getResult ();
        Date outDate= parseDate (result.getText (),"EEE MMM dd yyyy HH:mm:ss");
        Date inDate =parseDate (date, format);
        System.out.println ("outdate"+outDate);
        System.out.println ("inDate"+inDate);
        Assert.assertEquals (inDate, outDate);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[15][2];
        //data_set1
        data[0][0] = "05/16/2020";
        data[0][1] = "MM/dd/yyyy";
        //data_set2
        data[1][0] = "2020/05/16";
        data[1][1] = "yyyy/MM/dd";
        //data_set3
        data[2][0] = "05/01/20";
        data[2][1] = "MM/dd/yy";
        //data_set4
        data[3][0] = "80/01/20";
        data[3][1] = "yy/MM/dd";
        //data_set5
        data[4][0] = "Jun 20,2020";
        data[4][1] = "MMM dd,yyyy";
        //data_set6
        data[5][0] = "Mon May 18,2020";
        data[5][1] = "EEE MMM dd,yyyy";
        //data_set7
        data[6][0] = "Saturday May 16,2020";
        data[6][1] ="EEEE MMM dd,yyyy";
        //data_set8
        data[7][0] = "10-01-20";
        data[7][1] = "MM-dd-yy";
        //data_set9
        data[8][0] = "5/1/20";
        data[8][1] = "M/d/yy";
        //data_set10
        data[9][0] = "2020-05-16";
        data[9][1] = "yyyy-MM-dd";
        //data_set11
        data[10][0]= "Feb 29,2020";
        data[10][1]= "MMM dd,yyyy";
        //data_set12
        data[11][0]= "Feb 01";
        data[11][1]= "MMM dd";
        //data_set13
        data[12][0]= "12/31/2020";
        data[12][1]= "MM/dd/yyyy";
        //data_set14
        data[13][0]= "05/10";
        data[13][1]= "MM/dd";
        //data_set15
        data[14][0]= "10 Jan,2020";
        data[14][1]= "dd MMM,yyyy";
        return data;
    }
    @Test(dataProvider = "getInvalidData")
    public void invalidDateTest (String date)throws ParseException{
        driver.get (prop.getProperty ("url"));
        PropinePage page = new PropinePage (driver);
        WebElement dateBox=page.getDateInputBox ();
        dateBox.sendKeys (date);
        WebElement submitBtn=page.getSubmitButton ();
        submitBtn.click();
        WebElement result=page.getResult ();
        String output = result.getText ();
        Assert.assertEquals (output, "Invalid date");
    }

    @DataProvider
    public Object[][] getInvalidData() {
        Object[][] data = new Object[9][1];
        //data_set1
        data[0][0] = " ";
        //data_set2
        data[1][0] = "0000/00/00";
        //data_set3
        data[2][0] = "-05/16/2020";
        //data_set4
        data[3][0] = "15/15/2020";
        //data_set5
        data[4][0] = "Jun 31,2020";
        //data_set6
        data[5][0] = "Sun May 18,2020";
        //data_set7
        data[6][0] = "Feb 30,2020";
        //data_set8
        data[7][0] = "2020/31/12";
        //data_set9
        data[8][0] = "September";
        return data;
    }
    public Date parseDate(String date, String format) throws  ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
          Date  pdate = sdf.parse(date);
          return pdate;
    }
    @AfterTest
    public void teardown() {
        driver.close ();
        driver = null;

    }
}

