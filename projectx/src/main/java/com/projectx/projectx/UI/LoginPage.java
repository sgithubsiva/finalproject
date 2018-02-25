package com.projectx.projectx.UI;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	@FindBy(css=".login")WebElement LoginLink;
	@FindBy(css="#email")WebElement EmailAddress;
	@FindBy(css="#passwd")WebElement Password;
	@FindBy(css="#SubmitLogin")WebElement SiginButton;
	@FindBy(css=".alert.alert-danger>ol>li")WebElement ErrorMsg;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String EmailId, String PasswordId) {		
		LoginLink.click();
		log.info(" clicked on signin by using object:" + LoginLink.toString());
		EmailAddress.sendKeys(EmailId);
		log.info(" Entered the  email address :"+ EmailId+"by using object is: "+ EmailAddress.toString());
		Password.sendKeys(PasswordId);
		log.info(" Entered on password :"+ PasswordId+ "by using the object is:"+ Password.toString() );
		SiginButton.click();
		log.info(" clicked on submit button by using object:"+ SiginButton.toString() );
	}
	
	public String getInvalidLoginText() {
		System.out.println(ErrorMsg.getText());
		return ErrorMsg.getText();		
	}
}
