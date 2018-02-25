package com.maven.automation.MavenAutomation.Home;

import org.testng.annotations.Test;

import com.projectx.projectx.Common.TestBase;
import com.projectx.projectx.UI.LoginPage;

import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC001_VerifyLoginWithInvalidecredentTest extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidecredentTest.class.getName());
	
	
  @Test
  public void f() {
	 log.info("--------Starting TC001_VerifyLoginWithInvalidecredentTest---------"); 
	 LoginPage userlogin = new LoginPage(driver);
	 userlogin.loginToApplication("test@gmai.com", "Password");
	 Assert.assertEquals("Authentication failed.", userlogin.getInvalidLoginText());
	 log.info("---------Ending TC001_VerifyLoginWithInvalidecredentTest ---------");
	 
  }
  @BeforeTest
  public void beforeTest() {
	 startupValidation();		
  }

  @AfterTest
  public void afterTest() {
  }

}
