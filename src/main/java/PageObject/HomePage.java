package PageObject;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	//locator initialise
	private String pageText = "//h1[text()='Learn Automation Courses']";
	private String menuClick="(//div[@class='navbar-menu-links']//img)[1]";
	private String loginClick="//button[text()='Log in']";
	
	public HomePage(Page page) //construction initialise
	{
		this.page=page;
	}
	//action methods
	
	public String getTitle()
	{
		return page.title();
	}
	public String getDisplayText()
	{
		return page.innerText(pageText);
	}

	public LoginPage navigateToLoginPage()
	{
		page.click(menuClick);
		page.click(loginClick);
		return new LoginPage(page);
	}
}
