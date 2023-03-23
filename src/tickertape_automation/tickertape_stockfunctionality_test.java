package tickertape_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tickertape_stockfunctionality_test{

 WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{    maindriver.CreaterInstance("Chrome");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\MSsqure\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.tickertape.in/");
		driver.manage().window().maximize();
		try
		{
			driver.findElement(By.xpath("//i[@class=\"jsx-1245644719 jsx-2319868650 icon-Close text-24 text-primary\"]")).click();
		}
		catch (NoSuchElementException e)
		{
			
		}
		
	}
	
	
    
	@Test(priority=1)
	
	public void verify_dropdown_clickability()
	{
		
		driver.findElement(By.xpath("//input[@id=\"search-stock-input\"]")).click();
		boolean enability_test=driver.findElement(By.xpath("//input[@id=\"search-stock-input\"]")).isEnabled();
		System.out.println(enability_test);
		Assert.assertTrue(enability_test);
	}
	
	@Test(priority=2)
	public void verify_dropdown_editable()
	{
		driver.findElement(By.xpath("//input[@id=\"search-stock-input\"]")).sendKeys("Infosys");
	}
	
	@Test(priority=3)
	public void verify_sugeetion_list() 
	{
		driver.findElement(By.xpath("//input[@id=\"search-stock-input\"]")).sendKeys("Infosys");
		List<WebElement> text_webelement = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li/a/div[1]/p[1]/span[1]"));
	int count = text_webelement.size();
	for(int i=0;i<count;i++)
	{
		String value = text_webelement.get(i).getText();
		System.out.println(value);
		
	}
	}
	
	/*@Test(priority=4) 
	public void verify_stockselection() throws InterruptedException
	{
		common.stock("Infosys");
	}
	
	@Test(priority=5)
	public void forcast_functionality() throws InterruptedException
	{
		common.stock("infosys");
		Thread.sleep(15000);
		driver.findElement(By.xpath("//a[text()=\"Forecasts\"]")).click();
	}
	
	@Test(priority=6)
	public void Verify_finance_tab() throws InterruptedException
	{
		common.stock("infosys");
		
		Thread.sleep(20000);
		try
			{
			driver.findElement(By.xpath("(//*[@class=\"jsx-2679829868 jsx-2491292752 regular secondary button-root\"])[1]")).click();
			}
		catch(NoSuchElementException e)
			{
			System.out.println("no popup found");
			}
		
		
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//a[text()=\"Financials\"]")).click();

	}
	
	@Test(priority=7)
	public void verify_income_tab() throws InterruptedException
	{
		common.stock("infosys");
		Thread.sleep(20000);
		try
		{
			driver.findElement(By.xpath("//button[@class=\"jsx-2679829868 jsx-2491292752 regular secondary button-root\"][1]")).click();
			
		}
		catch(NoSuchElementException e)
		{
			
		}
	
	driver.findElement(By.xpath("//a[text()=\"Financials\"]")).click();
	
	Thread.sleep(4000);
	
	boolean incometab = driver.findElement(By.xpath("//div[@class=\"jsx-1394820613 segment-control-container relative statement-picker \"]")).isDisplayed();
	Assert.assertTrue(incometab);
	
	WebElement tab = driver.findElement(By.xpath("//div[@class=\"jsx-1394820613 segment-control-container relative statement-picker \"]"));
	String tab_values = tab.getText();
	System.out.println(tab_values);

	
	boolean consiladated_tab = driver.findElement(By.xpath("//h2[@class=\"jsx-2537935686 mb32 typography-h5 text-primary\"]")).isDisplayed();
	Assert.assertTrue(consiladated_tab);
	
	WebElement consiladated =  driver.findElement(By.xpath("//h2[@class=\"jsx-2537935686 mb32 typography-h5 text-primary\"]"));
	String consiladated_value=consiladated.getText();
	System.out.println(consiladated_value);
	Assert.assertEquals(consiladated_value, "Consolidated Financial Statements");
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@value=\"income\"]")).click();

	}

	@Test(priority=8)
	public void verify_balancesheet_tab() throws InterruptedException
	{
		
	common.stock("infosys");	
	common.popup();
	
	driver.findElement(By.xpath("//a[text()=\"Financials\"]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//div[@class=\"jsx-1394820613 typography-body-medium-m segment-container    \"]")).click();

	}
	
	@Test(priority=9)
	public void verify_cashflow_tab() throws InterruptedException
	{
		common.stock("Infosys");
		common.popup();
	
	driver.findElement(By.xpath("//a[text()=\"Financials\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@value=\"cashflow\"]")).click();

	}
	
	@Test(priority=10)
	public void verify_peers_tab() throws InterruptedException
	{
		
		common.stock("Infosys");
		common.popup();
	
	driver.findElement(By.xpath("//a[text()=\"Peers\"]")).click();

	}
	
	@Test(priority=11)
	public void verify_valuation_tab() throws InterruptedException
	{
		common.stock("Infosys");
		common.popup();
	
	driver.findElement(By.xpath("//a[text()=\"Peers\"]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//input[@value=\"valuation\"]")).click();

	}
	
	@Test(priority=12)
	public void verify_technical_tab() throws InterruptedException
	{
		common.stock("Infosys");
		common.popup();
		driver.findElement(By.xpath("//a[text()=\"Peers\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=\"technical\"]")).click();

	}
	
	@Test(priority=13)
	public void verify_forecast_tab() throws InterruptedException
	{
	common.stock("Infosys");
	common.popup();
	driver.findElement(By.xpath("//a[text()=\"Peers\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@value=\"forecast\"]")).click();

	}
	
	@Test(priority=14)
	public void verify_Holdings_tab() throws InterruptedException
	{
		common.stock("Infosys");
		common.popup();
		
		driver.findElement(By.xpath("//a[text()=\"Holdings\"]")).click();

	}
	
	@Test(priority=15)
	public void verify_News_tab() throws InterruptedException
	{
		common.stock("Infosys");
		common.popup();
			
		driver.findElement(By.xpath("//a[text()=\"News\"]")).click();

	}
	
	@Test(priority=16)
	public void verify_Events_tab() throws InterruptedException
	{
		common.stock("Infosys");
		common.popup();
		driver.findElement(By.xpath("//a[text()=\"Events\"]")).click();

	}*/
	
	
	@AfterMethod
	
	public void close()
	{
	driver.quit();
	}
	
}


