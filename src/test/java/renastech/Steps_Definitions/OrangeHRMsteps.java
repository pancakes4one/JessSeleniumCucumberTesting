package renastech.Steps_Definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import renastech.utils.CommonUtils;
import renastech.utils.ConfigurationsReader;
import renastech.utils.Driver;

import java.util.List;
import java.util.Map;

public class OrangeHRMsteps {


    @Given("The user wants to go to orangeHRM application")
    public void the_user_wants_to_go_to_orange_hrm_application() {
        System.out.println("This is a Login Step");
        Driver.getDriver().get("https://renastech-osondemand.orangehrm.com/");

    }

    @When("The user wants to enter username and password")
    public void the_user_wants_to_enter_username_and_password() {
        System.out.println("Enter your username and Password");

        WebElement username = Driver.getDriver().findElement(By.id("txtUsername"));
        WebElement password = Driver.getDriver().findElement(By.id("txtPassword"));

        username.sendKeys("Admin");
        password.sendKeys("Mv@UE0@dR3f@");


    }

    @Then("The user wants to click login")
    public void the_user_wants_to_click_login() {
        System.out.println("Click Login Button");
        WebElement loginButton = Driver.getDriver().findElement(By.id("btnLogin"));
        loginButton.click();

    }

    @Then("The user should be able to navigate dashboard")
    public void the_user_should_be_able_to_navigate_dashboard() {
        System.out.println("The user should be able to see dashboard");

        WebElement dashboard = Driver.getDriver().findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));

        CommonUtils.hardWait(5000);
        Assert.assertTrue(dashboard.isDisplayed());

//        Driver.getDriver().close();

    }


    @When("The user wants to enter username as {string} and the password as {string}")
    public void the_user_wants_to_enter_username_as_and_the_password_as(String username, String password) {

        System.out.println("This is a username:  " + username);
        System.out.println("This is a password:  " + password);

        CommonUtils.hardWait(3000);
        WebElement userName = Driver.getDriver().findElement(By.id("txtUsername"));
        WebElement passWord = Driver.getDriver().findElement(By.id("txtPassword"));

        userName.sendKeys(username);
        passWord.sendKeys(password);

    }

//    @And("The user id should be {int}")
//    public void the_user_id_should_be(Integer employeeID) {
//
//    }

    @Then("The user id number should be {double}")
    public void the_user_id_should_be(Double employeeID) {

    }


    @Then("The user wants to go to PIM page")
    public void the_user_wants_to_go_to_pim_page() {
        WebElement pimPage = Driver.getDriver().findElement(By.xpath("//a[@id='menu_pim_viewPimModule']//b"));
        pimPage.click();

    }

    @Then("The user wants to see add employee page")
    public void the_user_wants_to_see_add_employee_page() {
        WebElement addEmployee = Driver.getDriver().findElement(By.xpath("//a[.='Add Employee']"));
        addEmployee.click();

    }

    @Then("The user wants to add user name as {string}")
    public void the_user_wants_to_add_user_name_as(String name) {
        WebElement usernameBox = Driver.getDriver().findElement(By.id("firstName"));
        usernameBox.sendKeys(name);

    }

    @Then("The user wants to add last name as {string}")
    public void the_user_wants_to_add_last_name_as(String lastname) {
        WebElement lastName = Driver.getDriver().findElement(By.name("lastName"));
        lastName.sendKeys(lastname);

    }

    @Then("The user wants to save the information")
    public void the_user_wants_to_save_the_information() {
        WebElement saveButton = Driver.getDriver().findElement(By.id("btnSave"));
        saveButton.click();
    }

    @Then("The user should be able to see {string}")
    public void the_user_should_be_able_to_see(String headerText) {
        WebElement personalDetails = Driver.getDriver().findElement(By.xpath("//h1[.='Personal Details']"));
        Assert.assertEquals(personalDetails.getText(), headerText);
        Assert.assertTrue(personalDetails.isDisplayed());
        CommonUtils.hardWait(2000);

//        Driver.getDriver().close();
    }

    @Given("The user wants to go to login")
    public void the_user_wants_to_go_to_login() {
        Driver.getDriver().get("https://renastech-osondemand.orangehrm.com/");
        CommonUtils.hardWait(5000);
        WebElement username = Driver.getDriver().findElement(By.id("txtUsername"));
        WebElement password = Driver.getDriver().findElement(By.id("txtPassword"));

        username.sendKeys(ConfigurationsReader.getProperty("username"));
        password.sendKeys(ConfigurationsReader.getProperty("password"));


    }

// Candidate

    @Then("The user wants to navigate to Recruitment")
    public void the_user_wants_to_navigate_recruitment() {
        WebElement recruitment = Driver.getDriver().findElement(By.id("menu_recruitment_viewRecruitmentModule"));
        CommonUtils.clickWithWait(recruitment);

    }

    @Then("The user wants to see candidates")
    public void the_user_wants_to_see_candidates() {
        WebElement candidates = Driver.getDriver().findElement(By.id("menu_recruitment_viewCandidates"));
        CommonUtils.clickWithWait(candidates);
    }

    @Then("The user wants to add a candidate")
    public void the_user_wants_to_add_a_candidate() {
        WebElement add = Driver.getDriver().findElement(By.id("btnAdd"));
        CommonUtils.clickWithWait(add);
    }

    @Then("The user wants to enter first name as {string} and last name as {string}")
    public void the_user_wants_to_enter_first_name_as_and_last_name_as(String firstName, String lastName) {
        WebElement name = Driver.getDriver().findElement(By.id("addCandidate_firstName"));
        name.sendKeys(firstName);
        CommonUtils.hardWait(3000);
        WebElement lName = Driver.getDriver().findElement(By.id("addCandidate_lastName"));
        lName.sendKeys(lastName);
        CommonUtils.hardWait(3000);

    }

    @Then("The user wants to enter email as {string}")
    public void the_user_wants_to_enter_email_as(String email) {
        WebElement enterEmail = Driver.getDriver().findElement(By.id("addCandidate_email"));
        enterEmail.sendKeys(email);
        CommonUtils.hardWait(3000);

    }

    @Then("The user wants to Consent to keep data")
    public void the_user_wants_to_consent_to_keep_data() {
        WebElement consentBtn = Driver.getDriver().findElement(By.id("addCandidate_consentToKeepData"));
        consentBtn.click();
        CommonUtils.hardWait(3000);

    }

    @Then("The user wants to verify that the user is created")
    public void the_user_wants_to_verify_that_the_user_is_created() {
        //verify
        WebElement expected = Driver.getDriver().findElement(By.id("resultTable"));
        Assert.assertTrue(expected.isDisplayed());
        Driver.getDriver().close();
    }

    @Then("The user wants to see add an employee")
    public void the_user_wants_to_see_add_an_employee() {
        WebElement addEmployee = Driver.getDriver().findElement(By.xpath("//a[.='Add Employee']"));
        CommonUtils.clickWithWait(addEmployee);
    }

    @Then("The user wants to save")
    public void the_user_wants_to_save() {
        WebElement saveBtn = Driver.getDriver().findElement(By.id("btnSave"));
        CommonUtils.waitForStaleElement(saveBtn);
        CommonUtils.clickWithWait(saveBtn);
        CommonUtils.hardWait(5000);

    }

    @When("The user wants to login to OrangeHRM")
    public void the_user_wants_to_login_to_orange_hrm(Map<String, String> dataTable) {

        System.out.println("This is Username :  " + dataTable.get("Username"));
        System.out.println("This is Password :  " + dataTable.get("Password"));

        WebElement username = Driver.getDriver().findElement(By.id("txtUsername"));
        WebElement password = Driver.getDriver().findElement(By.id("txtPassword"));

        username.sendKeys(dataTable.get("Username"));
        password.sendKeys(dataTable.get("Password"));
    }

    @Then("The user wants to add employee")
    public void the_user_wants_to_add_employee(Map<String, String> dataTable) {

        CommonUtils.waitForPageToLoad(10);
        WebElement usernameBox = Driver.getDriver().findElement(By.id("firstName"));
        usernameBox.sendKeys(dataTable.get("firstName"));

        WebElement lastName = Driver.getDriver().findElement(By.id("firstName"));
        lastName.sendKeys(dataTable.get("LastName"));

//        CommonUtils.waitForPageTitle();


        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }

    @Then("The user wants to add login details")
    public void the_user_wants_to_add_login_details(Map<String, String> dataTable) {
        // if tagname is not input, you cannot send keys
        WebElement checkBox = Driver.getDriver().findElement(By.id("chkLogin"));
        WebElement username = Driver.getDriver().findElement(By.id("user_name"));
        WebElement password = Driver.getDriver().findElement(By.id("user_password"));
        WebElement rePassword = Driver.getDriver().findElement(By.id("re_password"));
        WebElement status = Driver.getDriver().findElement(By.id("status"));

        CommonUtils.clickWithWait(checkBox);
        username.sendKeys(dataTable.get("Username"));
        password.sendKeys(dataTable.get("Password"));
        rePassword.sendKeys(dataTable.get("Password"));

        CommonUtils.selectFromDropDown(status, dataTable.get("Status"));

    }

    @When("The user wants to login to OrangeHRM using List")
    public void the_user_wants_to_login_to_orange_hrm_using_list(List<List<String>> dataTable) {
        System.out.println("Username = " + dataTable.get(0).get(0));
        System.out.println("Password = " + dataTable.get(0).get(1));

        WebElement username = Driver.getDriver().findElement(By.id("txtUsername"));
        WebElement password = Driver.getDriver().findElement(By.id("txtPassword"));

        username.sendKeys(dataTable.get(0).get(0));
        password.sendKeys(dataTable.get(0).get(1));
    }

    @Then("The user wants to add employee using List")
    public void the_user_wants_to_add_employee_using_list(List<List<String>> dataTable) {
        WebElement usernameBox = Driver.getDriver().findElement(By.id("firstName"));
        usernameBox.sendKeys(dataTable.get(0).get(0));
        WebElement lastName = Driver.getDriver().findElement(By.id("lastName"));
        lastName.sendKeys(dataTable.get(0).get(1));
    }

    @Then("The user wants to add login details using List")
    public void the_user_wants_to_add_login_details_using_list(List<List<String>> dataTable) {
        WebElement loginDetailsBox = Driver.getDriver().findElement(By.id("chkLogin"));
        WebElement usernameBox = Driver.getDriver().findElement(By.id("user_name"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("user_password"));
        WebElement rePassword = Driver.getDriver().findElement(By.id("re_password"));
        WebElement status = Driver.getDriver().findElement(By.id("status"));
        CommonUtils.clickWithWait(loginDetailsBox);
        usernameBox.sendKeys(dataTable.get(0).get(0));
        passwordBox.sendKeys(dataTable.get(0).get(1));
        rePassword.sendKeys(dataTable.get(0).get(1));
        CommonUtils.selectFromDropDown(status, dataTable.get(0).get(2));

    }


    @Given("The user wants to login website")
    public void the_user_wants_to_login_website() {
        System.out.println("Test Test");
    }
    @Then("the user wants to verify that we can login")
    public void the_user_wants_to_verify_that_we_can_login() {
        System.out.println("Test Test");

        CommonUtils.hardWait(5000);
    }

}




