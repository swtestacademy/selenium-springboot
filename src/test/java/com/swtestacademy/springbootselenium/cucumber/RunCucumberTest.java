package com.swtestacademy.springbootselenium.cucumber;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/swtestacademy/springbootselenium/cucumber/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.swtestacademy.springbootselenium.cucumber")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@google or @author")
public class RunCucumberTest {
}