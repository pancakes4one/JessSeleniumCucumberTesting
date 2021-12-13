package renastech.Steps_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import renastech.utils.CommonUtils;
import renastech.utils.ConfigurationsReader;
import renastech.utils.Driver;
import sun.util.resources.cldr.fa.LocaleNames_fa;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeworkSteps extends CommonUtils{
    @Given("The user wants to go to the OrangeHRM app")
    public void the_user_wants_to_go_to_the_orange_hrm_app() {
        System.out.println("Opens web app");
        Driver.getDriver().get(ConfigurationsReader.getProperty("websiteHomework"));

    }

    @When("Clicks login")
    public void clicks_login() {
        WebElement loginButton = Driver.getDriver().findElement(By.id("btnLogin"));
        CommonUtils.clickWithWait(loginButton);
    }
    @Then("Should see the Dashboard")
    public void should_see_the_dashboard() {
        WebElement dashboardMsg = Driver.getDriver().findElement(By.xpath("//h1[.='Dashboard']"));
        Assert.assertTrue(dashboardMsg.isDisplayed());
    }
    @When("The user clicks the PIM section")
    public void the_user_clicks_the_pim_section() {
        WebElement pimBtn = Driver.getDriver().findElement(By.id("menu_pim_viewPimModule"));
        pimBtn.click();
    }

    @When("Clicks on Employee List")
    public void clicks_on_Employee_List() {
        WebElement employeeList = Driver.getDriver().findElement(By.id("menu_pim_viewEmployeeList"));
        employeeList.click();
    }
    @When("Clicks the last employee created")
    public void clicks_the_last_employee_created() {
        WebElement lastEmployee = Driver.getDriver().findElement(By.xpath("//table//tbody//tr[5]//td[2]"));
        // why does it fail if i use //td[3]?
        lastEmployee.click();

    }
//    @Then("The user should be able to see {string}")
//    //what about when it's the same in 2 classes won't let you
//    public void the_user_should_be_able_to_see(String headerText) {
//        WebElement personalDetails = Driver.getDriver().findElement(By.xpath("//h1[.='Personal Details']"));
//        Assert.assertEquals(personalDetails.getText(),headerText);
//        Assert.assertTrue(personalDetails.isDisplayed());
//    }
    @When("The user clicks the edit button")
    public void the_user_clicks_the_edit_button() {
        WebElement editBtn = Driver.getDriver().findElement(By.id("btnSave"));
        CommonUtils.clickWithWait(editBtn);
    }
    @When("Wants to update Driver's License")
    public void wants_to_update_driver_s_license() {
        WebElement driversLicense = Driver.getDriver().findElement(By.id("personal_txtLicenNo"));
        driversLicense.sendKeys(ConfigurationsReader.getProperty("driverLicense"));

    }
    @When("Update License Expiration Date")
    public void update_license_expiration_date() {
        WebElement dateBox = Driver.getDriver().findElement(By.id("personal_txtLicExpDate"));
        dateBox.click();

        Select month = new Select(Driver.getDriver().findElement(By.className("ui-datepicker-month")));
        month.selectByVisibleText(ConfigurationsReader.getProperty("expMonth"));
        Select year = new Select(Driver.getDriver().findElement(By.className("ui-datepicker-year")));
        year.selectByValue(ConfigurationsReader.getProperty("expYear"));
        List<WebElement> days=Driver.getDriver().findElements(By.className("ui-state-default"));
        Integer date = Integer.valueOf(ConfigurationsReader.getProperty("expDay"));
        days.get(date).click();
    }
    @When("Update Marital Status")
    public void update_marital_status() {
        Select maritalStat = new Select(Driver.getDriver().findElement(By.id("personal_cmbMarital")));
        maritalStat.selectByValue("Married");
    }
    @When("Update Nationality")
    public void update_nationality() {
        Select nationality = new Select(Driver.getDriver().findElement(By.id("personal_cmbNation")));
        nationality.selectByVisibleText("Icelander");
    }
    @When("Update Date of Birth")
    public void update_date_of_birth() {
        WebElement datebox = Driver.getDriver().findElement(By.id("personal_DOB"));
        datebox.click();

        Select month = new Select(Driver.getDriver().findElement(By.className("ui-datepicker-month")));
        month.selectByVisibleText(ConfigurationsReader.getProperty("dobMonth"));
        Select year = new Select(Driver.getDriver().findElement(By.className("ui-datepicker-year")));
        year.selectByValue(ConfigurationsReader.getProperty("dobYear"));
        List <WebElement> days = Driver.getDriver().findElements(By.className("ui-state-default"));
        Integer date = Integer.valueOf(ConfigurationsReader.getProperty("dobDay"));
        days.get(date).click();
    }
//    @When("Wants to click save")
//    public void wants_to_click_save() {
//        WebElement saveBtn = Driver.getDriver().findElement(By.id("btnSave"));
//        saveBtn.click();
//    }
    @Then("The user wants to verify save is successful")
    public void the_user_wants_to_verify_save_is_successful() {
        WebElement saveSuccess = Driver.getDriver().findElement(By.className("success"));
        Assert.assertTrue(saveSuccess.isDisplayed());

    }
    @When("The user wants to click add an attachment")
    public void the_user_wants_to_click_add_an_attachment() {
        WebElement addBtn = Driver.getDriver().findElement(By.id("btnAddAttachment"));
        addBtn.click();
    }
    @When("Clicks Choose File")
    public void clicks_choose_file() {
        WebElement chooseFile = Driver.getDriver().findElement(By.id("ufile"));
        chooseFile.sendKeys("/Users/jessicca/Desktop/1635594767408.jpeg");
    }

    @When("Clicks upload button")
    public void clicks_upload_button() {
        System.out.println("Clicks upload button");
        WebElement upldBtn = Driver.getDriver().findElement(By.id("btnSaveAttachment"));
        upldBtn.click();

    }
    @Then("The user verifies file was uploaded successfully")
    public void the_user_verifies_file_was_uploaded_successfully() {
        System.out.println("Save successful");
        WebElement saveSuccess = Driver.getDriver().findElement(By.className("success"));
        Assert.assertTrue(saveSuccess.isDisplayed());
    }
}
