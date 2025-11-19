package baseTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static Properties prop;
	private static String url;
	protected WebDriver driver;
	protected String username;
	protected String password;
	
	@BeforeTest
	public void launchApplication() {
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("D:\\Git\\CLMSTest\\CLMSTest\\src\\test\\resources\\config.properties");
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
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
