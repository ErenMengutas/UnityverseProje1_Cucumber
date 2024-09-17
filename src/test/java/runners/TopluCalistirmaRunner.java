package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/TopluCalistirma.html",
                "json:target/json-reports/TopluCalistirma.json",
                "junit:target/xml-report/TopluCalistirma.xml"},

        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "",      //regression testi oldugu için tüm test scriptleri baştan sona calistirilmistir.
        dryRun = false


)




public class TopluCalistirmaRunner {
}

