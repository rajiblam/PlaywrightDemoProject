package Factory;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	public Page initialiseBrowser(Properties prop)
	{
		String browserName=prop.getProperty("browser").trim();
		playwright=Playwright.create();
		switch(browserName.toLowerCase())
		{
			case "chromium":
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			case "firefox":
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			case "chrome":
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(1000));
				break;
			default:
				System.out.println("We not support this browser : "+browserName);
			break;
		}
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int height=(int)screensize.getHeight();
		int width=(int)screensize.getWidth();
		browserContext=browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page=browserContext.newPage();
		page.navigate(prop.getProperty("url"));
		return page;
	}
	
	public Properties initialiseProperties()
	{
		try {
			FileInputStream fileInput = new FileInputStream("./src/main/java/com/qa/config/config.properties");
			prop = new Properties();
			prop.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
