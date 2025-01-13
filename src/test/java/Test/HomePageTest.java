package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;

public class HomePageTest extends BaseClass {
	

	@Test(priority = 1)
	public void verifyPageTitle()
	{
		String pageTitle=homePage.getTitle();
		System.out.println("Page Title - "+pageTitle);
		Assert.assertEquals(pageTitle, "Learn Automation Courses");
	}
	@Test(priority = 2)
	public void verifyDisplayText()
	{
		Assert.assertEquals(homePage.getDisplayText(),"Learn Automation Courses");
		System.out.println("Display Text on Page : "+homePage.getDisplayText());
	}
	@Test(priority = 3)
	public void navigateToLoginPage()
	{
		homePage.navigateToLoginPage();
		//Assert.assertEquals(actualLoginPageText, "Sign In");
	//	return new loginPageTest();
	}

}
