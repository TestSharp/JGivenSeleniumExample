package jbehave_Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;

public class TestSharp_Articles_Steps extends Stage<TestSharp_Articles_Steps> {
	
	@ExpectedScenarioState(required = true)
    WebDriver driver;
	
	public void I_visit_site(@Quoted String url) {
		driver.get(url);
	}
	
	public void I_check_the_logo() {
		driver.findElement(By.xpath("//img[@alt='testsharp']"));
	}

	public void I_click_the_articles_link() {
		driver.findElement(By.xpath("//a[contains(@href,'http://testsharp.net')]")).click();
	}

	public void I_should_see_the_articles() {
		driver.findElements(By.xpath("//article"));
	}
}