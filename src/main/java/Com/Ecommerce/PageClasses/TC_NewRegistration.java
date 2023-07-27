package Com.Ecommerce.PageClasses;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Ecommerce.BaseClas.Ecommerce_BaseClass;
import net.bytebuddy.utility.RandomString;

public class TC_NewRegistration extends Ecommerce_BaseClass {

	// 1
	public TC_NewRegistration() {

		PageFactory.initElements(driver, this);
	}

	// 2
	@FindBy(xpath = "//button[contains(text(),'Register')]")
	public WebElement Login;

	@FindBy(id = "gender-male")
	public WebElement Gendermale;

	@FindBy(id = "gender-female")
	public WebElement Genderfemale;

	@FindBy(id = "FirstName")
	public WebElement Firstname;

	@FindBy(id = "LastName")
	public WebElement LastName;

	@FindBy(xpath = "//input[@type=\"email\"]")
	public WebElement Email;

	@FindBy(id = "Password")
	public WebElement Password;

	@FindBy(id = "ConfirmPassword")
	public WebElement Confirmpassword;

	@FindBy(id = "register-button")
	public WebElement RegButton;

	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	public WebElement RegSuccessfully;

	// 3
	public void NewRegistration() {
		Login.click();
	}

	public void Selectgender() {
		Gendermale.click();
	}

	public void SetFirstName(String FirstName) {
		Firstname.sendKeys(FirstName);
	}

	public void SetLastName(String Lastname) {
		LastName.sendKeys(Lastname);
	}

	public void SetEmail(String EmailId) {
		Email.sendKeys(EmailId);
	}

	public void SetPasword(String Pass) {
		Password.sendKeys(Pass);
	}

	public void SetConfirmedPass(String Conpass) {
		Confirmpassword.sendKeys(Conpass);
	}

	public void RegButton() {
		RegButton.click();
	}
}
