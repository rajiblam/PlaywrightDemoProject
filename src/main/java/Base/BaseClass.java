package Base;

import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Page;
import Factory.PlaywrightFactory;
import PageObject.HomePage;
import PageObject.LoginPage;

public class BaseClass {
	
	Page page;
	PlaywrightFactory factory;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	@BeforeTest
	public  void setUp()
	{
		factory = new PlaywrightFactory();
		prop=factory.initialiseProperties();
		page=factory.initialiseBrowser(prop);
		homePage=new HomePage(page);
	}

	@AfterTest
	public  void tearDown()
	{
		page.context().browser().close();
		//browser.close();
	}

}
