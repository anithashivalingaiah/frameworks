package referLaterToFinish;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frameworks.pages.LoginPage_page;
import com.frameworks.utils.TestBase;

public class UserMenu_page extends TestBase{
	LoginPage_page loginPageObj;
	boolean flag; 
	WebDriverWait wait;
	
	//@FindBy(xpath = "//div[@id='userNavButton']")
	@FindBy(id = "userNavLabel")
	WebElement userNameMenuLink;
	//wait.until(ExpectedConditions.visibilityOf(userNameMenuLink));
	@FindBy(xpath = "//a[@title = 'My Profile']")
	//@FindBy(xpath = "//a[contains(text(), 'My Profile')]")
	WebElement myProfileBtn;
	@FindBy(xpath = "//a[@title='My Settings']")
	//a[@title = 'My Settings']
	//@FindBy(xpath = "//a[contains(text(), 'My Settings')]")
	WebElement mySettingsBtn;
	@FindBy(xpath = "//a[contains(text(), 'Developer Console')]")
	WebElement devConsoleBtn;
	@FindBy(xpath="//a[@title='Switch to Lightning Experience']")
	WebElement switchToLighting;
	@FindBy(xpath="//a[@title='Logout']")
	WebElement logoutBtn;
	@FindBy(xpath="//h3[contains(text(), 'Contact ')]//img[@title='Edit Profile']")
	WebElement editPen;
	@FindBy(id = "contactInfoContentId")
	WebElement switchToAboutTab;
	@FindBy(xpath = "//a[contains(text(), 'About')]")
	WebElement aboutTab;
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;
	@FindBy(xpath="//input[@value='Save All']")
	WebElement saveAll;
	@FindBy(id="tailBreadcrumbNode")
	WebElement changedUserName;
	
	public UserMenu_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String uname, String pword) {
		loginPageObj = new LoginPage_page();
		//loginPageObj.loginToSalesforce(prop.getProperty("userId"), prop.getProperty("passwordValue"));
		loginPageObj.username.sendKeys(uname);
		loginPageObj.password.sendKeys(pword);
		loginPageObj.loginBtn.click();
	}
	
	public boolean verifyUserMenuLink() {
		return userNameMenuLink.isDisplayed();	 
		
	}
	
	public boolean verifyMyProfileLink() {
		myProfileBtn.isDisplayed();
		return this != null;// this 'return this!=null' means making sure, it returns a boolean not null value. another way to do
							//is by 'return myProfileBtn.isDisplayed()', which will return a boolean value.
	}
	
	public boolean verifyMySettingsLink() {
		return mySettingsBtn.isDisplayed();
		
	}
	
	public boolean verifyDevConsoleLink() {
		return devConsoleBtn.isDisplayed();
		
	}
	 boolean verifyMyProf(){
		boolean flag = true;
		userNameMenuLink.click();
		 myProfileBtn.isDisplayed();
		  return flag;
	}
	
	public boolean verifyAll() {
		//boolean flag=true;
		Actions act = new Actions(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(userNameMenuLink));
			//wait.until(ExpectedConditions.visibilityOfAllElements(WebElements));
			act.moveToElement(userNameMenuLink).build().perform();
			userNameMenuLink.click();
		 if((userNameMenuLink.isDisplayed())&& (myProfileBtn.isDisplayed()) && (mySettingsBtn.isDisplayed()))
			 //&& (devConsoleBtn.isDisplayed())
		// && (switchToLighting.isDisplayed()))
			 //(logoutBtn.isDisplayed()))
			 {
			 flag =true; 
			} else {
				flag = false;
			}		 
		// return flag;
		} catch(Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	public boolean myProfileChangeLastName() {
		//boolean 
		userNameMenuLink.click();
		myProfileBtn.click();
		//wait.until(ExpectedConditions.visibilityOf(editPen));
		editPen.click();
		driver.switchTo().frame(switchToAboutTab);
		wait.until(ExpectedConditions.visibilityOf(switchToAboutTab));
		aboutTab.click();
		lastName.click();
		lastName.clear();
		lastName.sendKeys("foo");
		saveAll.click();
		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.visibilityOf(changedUserName));
		return changedUserName.isDisplayed(); 
		}
		
	
}
