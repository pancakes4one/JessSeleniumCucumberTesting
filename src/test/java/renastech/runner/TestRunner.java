package renastech.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =   "src/test/resources",                  // "@target/rerun.txt",
        glue = "renastech/Steps_Definitions",
        tags = "@Smoke_Test",
        dryRun = false,
        plugin = { "pretty",
                "html:target/default-cucumber-reports.html",  //define location and name it
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }

)
public class TestRunner {
}

        // 2 things
        // RunWith --> JUnit (similar to TestNG)  -- Cucumber works w/ JUnit by default
        // a management tool to organize test cases
        // for unit testing mostly
        // Cucumber options
