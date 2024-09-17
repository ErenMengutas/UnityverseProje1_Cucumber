package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/e2eRapor.html",
                    "json:target/json-reports/e2eRapor.json",
                    "junit:target/xml-report/e2eRapor.xml"},

        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@e2e", //e2e testinde sistemin sirali bir şekilde çaliştigi test edilir.Alış veri sitesi olduğu için
                       //sirasi ile kayıt olma,sisteme giriş yapma ve sepete eklenen ürünün siparişinin verilmesi scriptleri calistirilmistir.
        dryRun = false


)



public class Runner {

}
