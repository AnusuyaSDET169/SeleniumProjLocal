package pack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class seleniumGrid  {

	 private WebDriver driver;
	    private String baseUrl = "http://www.example.com";

	    @BeforeClass
	    @Parameters("browser")
	    public void setUp(String browser) throws MalformedURLException {
	        
	        if (browser.equals("chrome"))
	        {
	        	ChromeOptions options=new ChromeOptions();
		        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
	        } else if (browser.equals("firefox")) {
	        	FirefoxOptions options1=new FirefoxOptions();
		        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options1);       	
	        }
	    }

	    @Test
	    public void testExample() {
	        driver.get(baseUrl);
	        System.out.println(driver.getTitle());
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
}
