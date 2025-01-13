package PageObject;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	private String loginText="input#email1";
	private String passwordText="input#password1";
	private String loginButton="//button[text()='Sign in']";
	
	public LoginPage(Page page)
	{
		this.page=page;
	}

	public void enterUsername(String uName, String pWord)
	{
		page.fill(loginText, uName);
		page.fill(passwordText, pWord);
		page.click(loginButton);
	}
	
	
}
