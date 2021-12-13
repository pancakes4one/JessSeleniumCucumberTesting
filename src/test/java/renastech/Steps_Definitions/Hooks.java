package renastech.Steps_Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.log4j.Logger;  // comes from Apache Log4J
import renastech.utils.ConfigurationsReader;
import renastech.utils.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
private static final Logger logger = Logger.getLogger(Hooks.class);

    //this is Base class
    //must be in step definitions package

    @Before
    public void setup(Scenario scenario){
        Driver.getDriver().manage().window().maximize();
        logger.info("Logger example  :  :::::TEST EXECUTION START:::::");
        Driver.getDriver().get(ConfigurationsReader.getProperty("url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){ Driver.closeDriver(); }
}
