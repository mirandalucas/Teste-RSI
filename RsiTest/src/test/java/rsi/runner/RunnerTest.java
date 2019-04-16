package rsi.runner; /**
 * Created by Lucas on 16/04/2019
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		plugin = {"json:target/reports/CucumberReport.json"},
		glue = "rsi/steps", tags = {"@RsiTest"})
public class RunnerTest {
}