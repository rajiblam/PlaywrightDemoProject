package Factory;

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
	//Using TreadLocal concept for providing copy of browser instance
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal< Playwright> tlPlaywright = new ThreadLocal<>();
	
	public static Playwright getPlaywright()
	{
		return tlPlaywright.get();
	}
	public static Browser getBrowser()
	{
		return tlBrowser.get();
	}
	public static BrowserContext getBrowserContext()
	{
		return tlBrowserContext.get();
	}
	public static Page getPage()
	{
		return tlPage.get();
	}
	
	public Page initialiseBrowser(Properties prop)
	{
		String browserName=prop.getProperty("browser").trim();
		tlPlaywright.set(Playwright.create());
		switch(browserName.toLowerCase())
		{
			case "chromium":
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
			case "firefox":
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
			case "chrome":
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(200)));
			break;
			default:
				System.out.println("We don't support this browser : "+browserName);
			break;
		}
		tlBrowserContext.set(getBrowser().newContext());
		tlPage.set(getBrowserContext().newPage());
		getPage().navigate(prop.getProperty("url").trim());
		return getPage();
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
