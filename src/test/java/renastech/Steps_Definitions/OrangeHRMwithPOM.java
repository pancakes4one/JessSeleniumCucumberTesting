package renastech.Steps_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import renastech.pages.Admin;
import renastech.pages.HomePage;
import renastech.pages.LoginPage;
import renastech.utils.CommonUtils;

import javax.print.DocFlavor;
import java.io.FileInputStream;
import java.io.IOException;


public class OrangeHRMwithPOM{

    HomePage homePage = new HomePage();
    Admin admin = new Admin();
    //makes global

    private static final Logger logger = Logger.getLogger(OrangeHRMwithPOM.class);

    @Given("The user wants to login as admin")
    public void the_user_wants_to_login_as_admin() {
        logger.info("The user wants to login as admin");
        LoginPage loginpage = new LoginPage();

        loginpage.setUsername();
        loginpage.setPassword();
        loginpage.setLoginBtn();
        logger.debug("The user is logged into the applicaton");
    }
    @Then("The user wants to verify dashboard")
    public void the_user_wants_to_verify_dashboard() {
        CommonUtils.hardWait(3000);
        Assert.assertTrue(homePage.getDashboard().isDisplayed());
        logger.info("The dashboard is verified");
    }
    @When("The user wants to go to admin")
    public void the_user_wants_to_go_to_admin() {
        homePage.setAdmin();
    }
    @Then("The user wants to go to Nationalities")
    public void the_user_wants_to_go_to_nationalities() {
        admin.setNationality();
    }
    @Then("The user wants to add new Nationalities")
    public void the_user_wants_to_add_new_nationalities() {
        admin.setAddBtn();
    }
    @Then("The user wants to add Nationalities as {string}")
    public void the_user_wants_to_add_nationalities_as(String name) {
        admin.setNationalityName(name);    }
    @Then("The user wants to click save Nationality")
    public void the_user_wants_to_click_save_nationality() {
        admin.setSaveBtn();
    }
    @And("The user should be able to see {string} in Nationality Page")
    public void the_user_should_be_able_to_see_in_nationality_page(String nationality) {
        admin.verifyNationality(nationality);
    }
    @Then("The user wants to click all checkboxes")
    public void the_user_wants_to_click_all_checkboxes() {
        admin.clickAllCheckboxes();
    }

    @When("The user wants to login with excel")
    public void the_user_wants_to_login_with_excel() throws IOException {
        String filePath="/Users/jessicca/IdeaProjects/SeleniumCucumberTesting/src/test/resources/ExcelSheet.xls";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("sheet1");

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(1);

        switch (cell.getCellType()){
            case STRING:
                System.out.println();
            case NUMERIC:
                System.out.println();


        }



        System.out.println(row.getCell(0));
        System.out.println(row.getCell(1));
    }

}
