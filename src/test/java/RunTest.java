import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/java/features/visualizarCalendarioUsuario.feature",

		features="src/test/java/features/Logearse.feature",
		glue="pasos",
		plugin=	{"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}	
)


public class RunTest extends AbstractTestNGCucumberTests {
	
}