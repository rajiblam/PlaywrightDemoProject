package PageObject;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	//locator initialise
	private String pageText = "//h1[text()='Learn Automation Courses']";
	private String menuClick="(//div[@class='navbar-menu-links']//img)[1]";
	private String loginClick="//button[text()='Log in']";
	private String loginPageSingInText="//h2[text()='Sign In']";
	
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

	public String doLogin()
	{
		page.click(menuClick);
		page.click(loginClick);
		return page.innerText(loginPageSingInText);
	}
}
