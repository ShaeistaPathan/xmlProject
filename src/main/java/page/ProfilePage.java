package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ProfilePage {
	

	WebDriver driver;
	
	public ProfilePage (WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"summary\"]") WebElement SUMMARY_ELEMENT;
	
	public void validateProfilePage(String summary) throws InterruptedException {
//		waitForElement(driver, 10, SUMMARY_ELEMENT);
		Thread.sleep(2000);
		Assert.assertEquals(SUMMARY_ELEMENT.getText(),summary,"Wrong Page!!");
	}
	
  

}
