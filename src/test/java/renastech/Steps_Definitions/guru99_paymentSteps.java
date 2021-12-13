package renastech.Steps_Definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import renastech.utils.CommonUtils;
import renastech.utils.Driver;

import java.util.Map;

public class guru99_paymentSteps extends CommonUtils {
    @Given("The user wants to see payment gateway website")
    public void the_user_wants_to_see_payment_gateway_website() {
        Driver.getDriver().get("http://demo.guru99.com/payment-gateway/index.php");
        Driver.getDriver().manage().window().maximize();
    }

    @When("The user wants buy Elephant toy")
    public void the_user_wants_buy_elephant_toy() {
        WebElement buyBtn = Driver.getDriver().findElement(By.xpath("//input[@class='button special']"));
        buyBtn.click();

    }

    @Then("The user wants to enter payment information as")
    public void the_user_wants_to_enter_payment_information_as(Map<String,String> userPayInfo) {

//        Map<String,String> paymentInfo=userPayInfo.asMap(String.class,String.class);
//        only needs to be declared in the parameters and using userPayInfo below

        WebElement cardNumber=Driver.getDriver().findElement(By.id("card_nmuber"));
        cardNumber.sendKeys(userPayInfo.get("CNumber"));

        Select select=new Select(Driver.getDriver().findElement(By.id("month")));
        select.selectByVisibleText(userPayInfo.get("EMonth"));

        select=new Select(Driver.getDriver().findElement(By.id("year")));
        select.selectByVisibleText(userPayInfo.get("EYear"));

        WebElement cvvCode=Driver.getDriver().findElement(By.id("cvv_code"));
        cvvCode.sendKeys(userPayInfo.get("CVVCode"));
}
    @Then("The user wants to pay now")
    public void the_user_wants_to_pay_now() {
        WebElement submitBtn = Driver.getDriver().findElement(By.name("submit"));
        submitBtn.click();
    }
    @Then("The user wants to verify message as {string}")
    public void the_user_wants_to_verify_message_as(String paySuccessMsg) {
        WebElement headerMsg = Driver.getDriver().findElement(By.xpath("//h2[.='Payment successfull!']"));
        Assert.assertEquals(paySuccessMsg,headerMsg.getText());
    }
}
