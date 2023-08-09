package test;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import page.ProfilePage;
import util.BrowserFactory;


public class AddContactTest {

	WebDriver driver;

	@Test
	@Parameters({"userName", "password","FullName", "CompanyName", "Email", "Phone","Address", "City","State","Zip", "Country","Tag","Currency","Group","FormPassword","ConfirmFormPassword"})
	public void validUserShouldBeAbleToAddCustomer(String userName,String password, String fullName, String companyName, String email, String phone, String address, String city, String state, String zip, String country,String tag,String currency,String group,String formPassword,String confirmFormPassword) throws InterruptedException {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.validateAddContactPage("Add Contact");
		
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(companyName);
		addContactPage.insertEmail(email);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZipCode(zip);
		addContactPage.selectCountry(country);
		addContactPage.selectTags(tag);
		addContactPage.selectCurrency(currency);
		addContactPage.selectGroup(group);
		addContactPage.insertFormPassword(formPassword);
		addContactPage.insertConfirmFormPassword(confirmFormPassword);
		addContactPage.clickWelcomeEmail();
		addContactPage.clickSaveButton();
		
		ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
		profilePage.validateProfilePage("Summary");
		
		dashboardPage.clickListCustomerMenuButton();
		
//		addContactPage.varifyInsertedNameAndDelete();
		addContactPage.insertNameInSearchBoxAndSearchProfile();
		
		BrowserFactory.tearDown();
		
		
		
		
		
	}
}
