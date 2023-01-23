package tickertape_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class maindriver {
	
	public static WebDriver driver;
	public static void CreaterInstance(String browser)
	{
		switch (browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\MSsqure\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		/*case "Firefox":
			System.setProperty("webdriver.firefox.driver", "C:\\Users\\bhaye\\OneDrive\\Desktop\\Data\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;*/
			
		case "Edge":
			System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Desktop\\MSsqure\\Edge Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println(browser+" is not correct keyword. Please select browser among Chrome, Firefox or Edge");
			break;
		}
	}



}
