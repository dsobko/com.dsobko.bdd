import courgette.api.CourgetteOptions
import courgette.api.CourgetteRunLevel
import courgette.api.junit.Courgette
import cucumber.api.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Courgette::class)
@CourgetteOptions(threads = 4,
        runLevel = CourgetteRunLevel.FEATURE,
        rerunFailedScenarios = false,
        showTestOutput = true,
        cucumberOptions = CucumberOptions(features = arrayOf("src/test/resources/features"),
                glue = arrayOf("com.dsobko.test"),
                tags = arrayOf("~@Bug"),
                plugin = arrayOf("pretty", "json:build/courgette.json", "json:build/cucumber.json", "html:build/cucumber-report")))
object CucumberFeaturesRunner
