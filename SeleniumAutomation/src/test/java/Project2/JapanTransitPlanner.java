package Project2;
import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.google.common.annotations.VisibleForTesting;


public class JapanTransitPlanner {
	
	
	
	
	// Project2
		//automate Japan Transit Planner 
		
		//* Start Chrome driver,
	//GO to Japan Transit Planner top page, https://world.jorudan.co.jp/mln/en/?sub_lang=ja
	//Get web-site title
	//locate From column Enter station name 'OSAKA' . 
	//locate To column Enter station name 'Tokyo'.
	//locate  Date column Enter "7/25/2023/"
	//locate  Time column Enter "14:00
	
	//locate  'Depart' radio,click radio button
	//
	
	//* GO to 'Route Option',
	//locate  'IC Card' radio button.click radio button
	//locate 'Non-Reserved Seat'.click radio button
	//locate  'Search' button,Click 
	
	
	//* Got next page
	//locate  'Search' button,Click 
	
	//*Go to Result page
	//print out result
	
	

	private WebDriver driver;
	private String url="https://world.jorudan.co.jp/mln/en/?sub_lang=ja";

	@Test
	public void SearchTransitJapan() throws InterruptedException {
	
			System.setProperty("webdriver.chrome", "");
		    ChromeOptions options=new ChromeOptions();
		    options.addArguments("--remote-allow-origins=*");
		    driver=new ChromeDriver(options);
		    
		    driver.get(url);
		   driver.manage().window().maximize();
		   
		    
String actualwebsiteTitle= driver.getTitle();
System.out.println("Website title is: "+actualwebsiteTitle);
String expectedTitleString="Route Search - Japan Transit Planner | Norikae Annai";
assertEquals(actualwebsiteTitle,expectedTitleString);
		 
 WebElement Syppatsu=driver.findElement(By.xpath("//*[@id=\"from_value\"]"));
 Syppatsu.clear();
 Syppatsu.sendKeys("Osaka");
 Thread.sleep(1*1000);
 
 WebElement Tocyaku=driver.findElement(By.cssSelector("#to_value"));
 Tocyaku.clear();
Tocyaku.sendKeys("Tokyo");
Thread.sleep(1*1000);

 
WebElement Nichiji=driver.findElement(By.cssSelector("#js_date"));
Nichiji.clear();
Nichiji.sendKeys("07/25/2023");
Thread.sleep(1*1000);

WebElement JikanTai=driver.findElement(By.cssSelector("#js_time"));
JikanTai.clear();
JikanTai.sendKeys("14:00");
Thread.sleep(1*1000);

WebElement Arrival=driver.findElement(By.cssSelector("#ft1"));
Arrival.click();
Thread.sleep(1*1000);
WebElement SeatPreference=driver.findElement(By.cssSelector("#us1"));
SeatPreference.click();
Thread.sleep(1*1000);
WebElement FareTypesIC=driver.findElement(By.cssSelector("#ic1"));
FareTypesIC.click();
Thread.sleep(1*1000);



 WebElement kensakuElement=driver.findElement(By.xpath("//*[@id=\"search_button_main1\"]"));
 kensakuElement.click();
 
 WebElement kensakunextElement=driver.findElement(By.xpath("//*[@id=\"search_button_main\"]"));
 kensakunextElement.click();
 

 Thread.sleep(3*1000);
 
 WebElement resulBoxAreaElement=driver.findElement(By.className("result_list"));
 List<WebElement> aList=resulBoxAreaElement.findElements(By.tagName("a"));
 WebElement Rout1=aList.get(0);
 String rout1ResultString=Rout1.getText();
 System.out.println("                       ");
 System.out.println("------------- - Result - ------------------- ");
 System.out.println("                       ");
 
 System.out.println("From Osaka to Tokyo Rout1 Result is: "+rout1ResultString);
 
 WebElement Rout2=aList.get(1);
 String rout2ResultString=Rout2.getText();
 System.out.println("-------------------------------- ");
 System.out.println("From Osaka to Tokyo Rout2 Result is: "+rout2ResultString);
 
 
 WebElement Rout3=aList.get(2);
 String rout3ResultString=Rout3.getText();
 System.out.println("-------------------------------- ");
 System.out.println("From Osaka to Tokyo Rout3 Result is: "+rout3ResultString);
 
 
 WebElement Rout4=aList.get(3);
 String rout4ResultString=Rout4.getText();
 System.out.println("-------------------------------- ");
 System.out.println("From Osaka to Tokyo Rout4 Result is: "+rout4ResultString);
 
 
 WebElement Rout5=aList.get(4);
 String rout5ResultString=Rout5.getText();
 System.out.println("-------------------------------- ");
 System.out.println("From Osaka to Tokyo Rout1 Result is: "+rout5ResultString);
 System.out.println("------------- - Result - ------------------- ");

		   
		   Thread.sleep(5*1000);
		   
		   driver.quit();
		   
		    
		}
			}


