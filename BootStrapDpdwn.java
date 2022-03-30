package SeleniumBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BootStrapDpdwn {
	
	WebDriver driver;
	
	@Test
	public void access() {
	System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\March07Artifact\\Drivers\\chromedriver.exe");				
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.amway.in/nutrition/c/00000001#!page=0");
	
	WebElement dpdwn = driver.findElement(By.cssSelector("div.amw-dropdown"));
	
	dpdwn.click();
	
	List<WebElement> values = driver.findElements(By.cssSelector("ul.amw-dropdown-list li"));
	
	int count = values.size(); //to get the total values in the dropdown
	
	for(int i=0; i<count; i++) {
		//String valueToBeSelected = values.get(i).getAttribute("innerHTML");
		 WebElement eachElement = values.get(i);
		 String valueToBeSelected = eachElement.getAttribute("innerHTML");
		 
		 System.out.println("Value fetched is for index : " + i + "===>" + valueToBeSelected);
		
		if(valueToBeSelected.trim().equalsIgnoreCase("Price: High To Low")) {
			eachElement.click();
		}
	}
	
	}

}
