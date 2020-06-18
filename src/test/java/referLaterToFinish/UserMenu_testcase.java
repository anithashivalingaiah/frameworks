package referLaterToFinish;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.frameworks.pages.LoginPage_page;
import com.frameworks.utils.TestBase;

public class UserMenu_testcase extends TestBase{
	UserMenu_page uMenuPageObj;
	LoginPage_page loginPageObj;
	
	UserMenu_testcase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialiseBrowser("chrome");
		uMenuPageObj = new UserMenu_page();
		loginPageObj = new LoginPage_page();
		loginPageObj.loginToSalesforcePO(prop.getProperty("userId"), prop.getProperty("passwordValue"));
		
	}
	
	@Test(priority=1)
	public void validateUserMenuLink() {
		boolean flag = uMenuPageObj.verifyUserMenuLink();
		Assert.assertTrue(flag, "this case fails if the Userlink is not displayed");
	}
	
	@Test(priority=2)
	public void validateMyProfileBtn() {
		boolean flag =uMenuPageObj.verifyMyProfileLink();
		Assert.assertTrue(flag, "this case fails if myProfile button is not displayed");
	}
	
	//@Test(priority=3) 
	//public void validateMySettingsLink() {
		//boolean flag = uMenuPageObj.verifyMySettingsLink();
	//	Assert.assertTrue(flag, "this fails if mySettings link is not displayed");
	//}
	@Test(priority =4)
	public void validateDevConsoleLink() {
		boolean flag = uMenuPageObj.verifyDevConsoleLink();
		Assert.assertTrue(flag, "this fails if developer console link is not displayed");
	}
	/*
	 * @Test(priority=1) public void loginTest2() {
	 * uMenuPageObj.login(prop.getProperty("userId"),
	 * prop.getProperty("passwordValue")); }
	 */
	
	/*
	 * @Test(priority =2) public void validateUserMenuLink() { loginTest2(); boolean
	 * flag = uMenuPageObj.verifyUserMenuLink(); Assert.assertTrue(flag); }
	 */
	
	/*
	 * @Test(priority=3) public void validateMyProf() { loginTest2(); boolean flag
	 * =uMenuPageObj.verifyMyProf(); Assert.assertTrue(flag); }
	 */
	/*
	 * @Test(priority =1) public void validateuserMenuAll() { //loginTest2();
	 * boolean flag =uMenuPageObj.verifyAll(); Assert.assertTrue(flag); //boolean
	 * flag =uMenuPageObj.verifyUserMenuLink(); }
	 * 
	 * @Test(priority =2) public void editAndValidateLastName() { //loginTest2();
	 * boolean flag = uMenuPageObj.myProfileChangeLastName();
	 * Assert.assertTrue(flag);
	 */
	//}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	
	

}
