package test_Features;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tngtech.jgiven.annotation.IsTag;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.SimpleScenarioTest;

import jbehave_Tests.Index_Test_Steps;

public class TestSharp_About_us extends SimpleScenarioTest<TestSharp_About_us_Steps> {
	
	@ProvidedScenarioState
	static WebDriver driver;
	
	@IsTag
	@Retention(RetentionPolicy.RUNTIME)
	public @interface IndexCategory {}
	
	@Rule
	public TestWatcher watchman = new TestWatcher() {

	    @Override
	    protected void failed(Throwable e, Description description) {
	        File screenshot = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(scrFile, new File(
	                    "C:\\Test\\FailedScreenshots\\screenshot.png"));
	        } catch (IOException e1) {
	            System.out.println("Unable to make the screenshot");
	        }
	    }
	};

	@BeforeClass
	public static void SetupTest() {
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void TearDownTest() {
		
		driver.quit();
		driver = null;
	}
		
	@AboutUsCategory
    @Test
    public void goto_testsharp_site() {
        when().I_visit_site("http://testsharp.net");
        then().I_check_the_logo();
    }
	
	@AboutUsCategory
    @Test
    public void goto_testsharp_about_us() {
		when().I_visit_site("http://testsharp.net");
		then().I_click_on_the_about_us_button();
	}
    
}