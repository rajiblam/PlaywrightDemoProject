package PageObject;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	private String loginText="input#email1";
	private String passwordText="input#password1";
	private String loginButton="//button[text()='Sign in']";
	private String loginErrorMessage="h2.errorMessage";
	
	public LoginPage(Page page)
	{
		this.page=page;
	}

	public void enterWrongUsername(String uName, String pWord)
	{
		page.fill(loginText, uName);
		page.fill(passwordText, pWord);
		page.click(loginButton);
	}
	
	public String loginErrorMessage()
	{
		String errorText= page.locator(loginErrorMessage).innerText();
		System.out.println("Error Text :"+errorText);
		return errorText;
	}
	
	
}
