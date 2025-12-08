package baseTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static Properties prop;
	private static String url;
	protected static WebDriver driver;
	protected String username;
	protected String password;
	private org.apache.logging.log4j.Logger log;
	
	@BeforeMethod
	public void launchApplication() {
		log=LogManager.getLogger(BaseTest.class);
		try {
			prop=new Properties();
			
			FileInputStream fis=new FileInputStream("D:\\Git\\CLMSTest\\CLMSTest\\src\\main\\resources\\config.properties");
			prop.load(fis);
			url=prop.getProperty("URL");
			
			username=prop.getProperty("username");
			
			password=prop.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable To Load File");
		}
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(url);
		log.debug("Opening Browser with " + url);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
