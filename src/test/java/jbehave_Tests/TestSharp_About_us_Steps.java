package jbehave_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.Quoted;

public class TestSharp_About_us_Steps extends Stage<TestSharp_About_us_Steps> {
	
	@ExpectedScenarioState(required = true)
    WebDriver driver;
	
	public void I_visit_site(@Quoted String url) {
		driver.get(url);
	}

	public void I_check_the_logo() {
		driver.findElement(By.xpath("//img[@alt='testsharp']"));
	}

	public void I_click_on_the_about_us_button() {
		if(driver.getCurrentUrl() == "http://testsharp.net/en/")
		{
			driver.findElement(By.xpath("//a[@href='http://testsharp.net/en/about-us/']")).click();
		}
		else
		{
			driver.findElement(By.xpath("//a[@href='http://testsharp.net/rolunk/']")).click();
		}
	}
}