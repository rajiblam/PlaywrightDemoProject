package Test;

import org.testng.annotations.Test;

import Base.BaseClass;

public class loginPageTest extends BaseClass{
	
	@Test(priority=1)
	public void checkNavigationStatus()
	{
		loginPage=homePage.navigateToLoginPage();
	}
	
	@Test(priority=2)
	public void checkLogin()
	{
		loginPage.enterUsername(prop.getProperty("username"), prop.getProperty("password"));
	}

}
