package org.it_academy.cucumber_study.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/CucumberTestRunner.html",
                "json:target/cucumber-reports/CucumberTestRunner.json",
                "junit:target/cucumber-reports/CucumberTestRunner.xml"},
        monochrome = true,
        glue = "org/it_academy/cucumber_study",
        features = "src/test/resources/SearchTest.feature"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
