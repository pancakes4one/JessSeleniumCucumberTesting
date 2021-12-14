package renastech.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =   "src/test/resources",                  // "@target/rerun.txt",
        glue = "renastech/Steps_Definitions",
        tags = "@Parallel",
        dryRun = false
)



public class FailedRunner {
}
