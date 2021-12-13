package renastech.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import renastech.utils.CommonUtils;
import renastech.utils.Driver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Admin {

    public Admin(){
        PageFactory.initElements(Driver.getDriver(), this);
        // calling constructor of this page, the page class itself
    }

    private static final Logger logger = Logger.getLogger(Admin.class);

    @FindBy(id = "menu_admin_nationality")
    private WebElement nationality;

    @FindBy(id = "btnAdd")
    private WebElement addBtn;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement nationalityName;

    @FindBy(id = "btnSave")
    private WebElement saveBtn;

    public void setNationality(){ CommonUtils.clickWithWait(nationality); }

    public void setAddBtn(){
        CommonUtils.clickWithWait(addBtn);
    }

    public void setSaveBtn(){
        CommonUtils.clickWithWait(saveBtn);
        logger.info("Clicked save button");
    }

    public void setNationalityName(String name){ CommonUtils.enterText(nationalityName, name);
    logger.info("Added new Nationality");}

    public void verifyNationality(String name){
        CommonUtils.hardWait(4000);
        // dynamic web element
        // without this I would have to store with Array and find through the list
        // to see if contained in the list
        WebElement element = Driver.getDriver().findElement(By.xpath("//table[@id='resultTable']//a[contains(text(),'"+name+"')]"));
        Assert.assertTrue(element.isDisplayed());
    }


    public void clickAllCheckboxes(){
        List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement each : allCheckboxes){
        if (!each.isSelected()) {
            CommonUtils.clickWithWait(each);
        }
        logger.info("Checked all Nationalities");
    }

}
}
