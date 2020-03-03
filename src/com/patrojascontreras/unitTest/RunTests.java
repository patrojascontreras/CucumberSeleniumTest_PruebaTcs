package com.patrojascontreras.unitTest;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"JunitTestPruebaDefinition"})

public class RunTests {
	
}
