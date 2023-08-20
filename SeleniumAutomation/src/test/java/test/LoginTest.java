package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resorce.Base;

public class LoginTest extends Base {
	
	@Test
	
	public void login() throws IOException, InterruptedException {
	WebDriver driver=intializerDriver();
	driver.get(prop.getProperty("url"));
	
		
	}

}
