package com.browserstack.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.browserstack.stepDefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/html-report",
        "json:target/cucumber-reports/cucumber-report.json",
        "junit:target/cucumber-reports/cucumber-report.xml"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
