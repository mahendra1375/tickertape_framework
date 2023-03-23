package tickertape_automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class common{
	public static WebDriver driver;
	public static void click(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void hover(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}
	
	public static boolean isDisplayed(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public static void sendKeys(String xpath, String text) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public static void stock(String stock_name) throws InterruptedException
	{
        driver.findElement(By.xpath("//input[@id=\"search-stock-input\"]")).sendKeys(stock_name);
		
		Thread.sleep(5000);
		List<WebElement> text_webelement = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li/a/div[1]/p[1]/span[1]"));
		List<WebElement> click_webelement= driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li/a/div"));
		int count = text_webelement.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
		String value = text_webelement.get(i).getText();
		System.out.println(value);
		
		if(value.contentEquals("Infosys Ltd"))
		{
			click_webelement.get(i).click();
			break;
		}
		else
		{
			
		}
	}
	}
	
	public static void popup() throws InterruptedException
	{
		Thread.sleep(10000);
		try
		{
			driver.findElement(By.xpath("//button[@class=\"jsx-2679829868 jsx-2491292752 regular secondary button-root\"][1]")).click();
			
		}
		catch(NoSuchElementException e)
		{
			
		}
	}
}



