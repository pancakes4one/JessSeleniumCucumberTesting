package renastech.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import renastech.utils.CommonUtils;
import renastech.utils.ConfigurationsReader;
import renastech.utils.Driver;

public class LoginPage {

    public LoginPage(){ PageFactory.initElements(Driver.getDriver(), this); }
    // Webdriver this page
    // ability to FindBy

    //good example of encapsulation for interviews
    @FindBy(id = "txtUsername")
    private WebElement username;

    @FindBy(id = "txtPassword")
    private WebElement password;

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;
    //set for an object you want to put something in
    //get for an object you may want to check the title of
    // don't need parameter because you can call direct from config properties
    public void setUsername(){ username.sendKeys(ConfigurationsReader.getProperty("username"));}

    public void setPassword(){
    password.sendKeys(ConfigurationsReader.getProperty("password"));
    }

    public void setLoginBtn(){
    CommonUtils.clickWithWait(loginBtn);
}




}
