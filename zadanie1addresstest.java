package zadanie1address;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/zadanie1address.feature",
        plugin = {"pretty","html:out"})

public class zadanie1addresstest {
}
