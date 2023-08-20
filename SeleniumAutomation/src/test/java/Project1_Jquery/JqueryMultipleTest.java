package Project1_Jquery;

import javax.swing.text.html.CSS;

import org.checkerframework.checker.units.qual.Acceleration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bsh.commands.dir;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryMultipleTest {
	
	
	// Project1
		//automate https://jqueryui.com /
		
//	//* Start Chrome driver,
	//GO to https://jqueryui.com /
	//Get web-site title
		//* GO to 'Accordion',Test select
		//locate  Section1,Section2,Section3,Section4 open each section. During the select highlight each selection.
		
	
	//* SrollDown , Click API icon and Return
			//locate API move to web-site bottom.click API , and Navigate to Return 
		
	//* GO to 'Autocomplete',Enter text
			//locate  Tag,Enter  text 'Categories'.
			//
	
	
	//* GO to 'Checkboxradio',Test Radio button and Checkbox

	//locate  'London' radio,'5 Star'and 'Queen' check-box,select and check
	//
	
	//* GO to 'Controlgroup',Test Selectdropdown,radio button and Check-box
		//locate  'SUV'in select-drop-down area.
	//Select 'insurance' check-box,
	//select 'Automatic' check-box blow area
		

	
	
	private WebDriver driver;
	private String url = "https://jqueryui.com ";
	
	@BeforeClass
	public void BeforeClass() {
		
		System.out.println("---- This is Frist Project for Musabay Academy ----- *****By Shukur");
	}
	@AfterClass
	public void AfterClass() {
		
			}

	@BeforeMethod		
	public void beforeEachTest() { 
			
			try {
				
			
		
		System.setProperty("webdriver.chrome", "");
	    ChromeOptions options=new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    driver=new ChromeDriver(options);
	    
	    driver.get(url);
	   driver.manage().window().maximize();
	   
	   String actualwebsiteTitle= driver.getTitle();
	   System.out.println("Website title is: "+actualwebsiteTitle);
	   String expectedTitleString="jQuery UI";
	   AssertJUnit.assertEquals(actualwebsiteTitle,expectedTitleString);
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	  @AfterMethod
	 	public void AfterEchTest() {
		  
		  try {
			
		   Thread.sleep(3000);
		   
		   if(!(driver==null)) {
			   driver.close();
		      driver.quit();
		   }
		  } catch (Exception e) {
				e.printStackTrace();
				}
			}
	
		
		
		public void switchFrame() {
			WebElement frame = driver.findElement(By.cssSelector("#content > iframe"));
			driver.switchTo().frame(frame);
			
		}
		
		public void switchBack() {
			driver.switchTo().defaultContent();
		}

		@Test
		public void ClickAccordion() throws InterruptedException {
		driver.get(url);
		System.out.println("Action : Opent Jquery Homepage---:  "+url);
		
		WebElement accordionElement = driver.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(1) > a"));
			
		highlightelement(accordionElement);
				
		accordionElement.click();
		
		this.switchFrame();
		WebElement select2=driver.findElement(By.cssSelector("#ui-id-3"));
		System.out.println("Action: Select Section2  ");
		highlightelement(select2);
				select2.click();;
				
				WebElement select3=driver.findElement(By.cssSelector("#ui-id-5"));
				highlightelement(select3);
						select3.click();;
						
						WebElement select4=driver.findElement(By.cssSelector("#ui-id-7"));
						highlightelement(select4);
								select4.click();
		
		this.switchBack();
		
	WebElement actionElement=driver.findElement(By.linkText("API"));
	scrollIntoView(actionElement);
	highlightelement(actionElement);
	actionElement.click();
	Thread.sleep(500);
	driver.navigate().back();
	
	
	WebElement Autocomplete=driver.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(2) > a"));
	scrollIntoView(Autocomplete);
	highlightelement(Autocomplete);
	Autocomplete.click();
	this.switchFrame();
	
	WebElement Autocompletetext=driver.findElement(By.xpath("//*[@id=\"tags\"]"));
	highlightelement(Autocompletetext);
    Autocompletetext.sendKeys("Catogories");
	this.switchBack();
	
	WebElement CheckBoxRadio=driver.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(4) > a"));
	highlightelement(CheckBoxRadio);
	CheckBoxRadio.click();
	
	this.switchFrame();
	clickAElement(By.xpath("/html/body/div/fieldset[1]/label[3]"));
	handlecheckBox(By.xpath("/html/body/div/fieldset[2]/label[4]/span[1]"),true);
	handlecheckBox(By.xpath("/html/body/div/fieldset[3]/label[3]/span[1]"),true);
	this.switchBack();
	
clickAElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(5) > a"));
this.switchFrame();
	
	selectDropDown(By.xpath("//*[@id=\"car-type\"]"),"SUV");
	
	clickAElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[2]/span[1]"));
	handlecheckBox(By.xpath("/html/body/div[1]/fieldset[1]/div/label[3]/span[1]"),true);
	clickAElement(By.xpath("/html/body/div[1]/fieldset[2]/div/label[2]"));
	
	
		}
		
		
		public void highlightelement(WebElement element) throws InterruptedException {
			
		
			for(int i=1; i<4; i++) {
			WrapsDriver wrappedElemDriver= (WrapsDriver)element;
			JavascriptExecutor js=(JavascriptExecutor)wrappedElemDriver.getWrappedDriver();
			
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"color:red; border: 4px solid yellow");
					Thread.sleep(500);
					
		js.executeScript ("arguments [0].setAttribute('style', arguments [1]);", element," ");
		Thread.sleep(250);
		}
		}
			public void scrollIntoView(WebElement element) throws InterruptedException {

				Actions action = new Actions(driver);
				action.scrollToElement(element).build().perform();
				Thread.sleep(500);
				
			
		}
		

public void handlecheckBox(By by, boolean ischecked) throws InterruptedException  {
	
	WebElement checkBox=driver.findElement(by);
		highlightelement(checkBox);
		
		if(ischecked==true) {
			if(checkBox.isSelected()) {
		}else {	
		checkBox.click();
		
		}
			
		}else {
			if(checkBox.isSelected()) {
				checkBox.click(); 
				}else {
					
				}
			Thread.sleep(500);
		}
}
		
		public void clickAElement(By by) throws InterruptedException {
			WebElement element=driver.findElement(by);
			highlightelement(element);
			element.click();
}
		
		public void selectDropDown(By by, String optionValue) throws InterruptedException {
			
			WebElement dropDownElem=driver.findElement(by);
			highlightelement(dropDownElem);
			
			Select select=new Select(dropDownElem);
			select.selectByVisibleText(optionValue);
			
}
}
