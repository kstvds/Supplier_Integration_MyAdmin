package SaveItenary_MyAdmin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.NewAccoBooking;
import ObjectRepository.Operations;
import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;

public class Save_Credit_Card_Within_DeadLine {
	public WebDriver driverqa;
	Configuration Config = new Configuration();
	Takescreenshot obj= new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	NewAccoBooking acco = new NewAccoBooking();
	Operations opo = new Operations();
	Logger logger = Logger.getLogger("Save_Credit_Card_Within_DeadLine");
	//String SearchRateexpected;
	 @Test
	 @Parameters({ "browsername" })
	  public void SaveCreditCardWithinDeadLine(String browsername) throws Exception {
		  test = rep.startTest("Credit Card Save Within Deadline");
		  ExcelDataConfig excel;
		  excel = new ExcelDataConfig(Config.getExcelPathSave());
		  PropertyConfigurator.configure("Log4j.properties");
		  logger.info("Test Case Started");
		if (browsername.equalsIgnoreCase("CH")) {
			       driverqa = new DriverAndObjectDetails(DriverName.CH).CreateDriver();
				} else if (browsername.equalsIgnoreCase("IE")) {
					driverqa = new DriverAndObjectDetails(DriverName.IE).CreateDriver();
				} else {
					driverqa = new DriverAndObjectDetails(DriverName.FF).CreateDriver();
				}
			    WebDriverWait wait= new WebDriverWait(driverqa, 30);
			    Actions action = new Actions(driverqa);
	           try{
			    logger.info("Browser Opened");
				driverqa.get(Config.getApplicationUrl());
				logger.info("Test Case Started");
				test.log(LogStatus.INFO, "Starting Login");
				WebElement username = driverqa.findElement(LoginPage.uname);
				username.clear();
				username.sendKeys(excel.getData(5, 1, 0));
				WebElement password = driverqa.findElement(LoginPage.pwd);
				password.clear();
				password.sendKeys(excel.getData(5, 1, 1));
				driverqa.findElement(LoginPage.submit).click();
				Thread.sleep(1000);
				String expectedtitle = "DOTWconnect.com::DOTWconnect.com: My Admin";
				String atualtitle = driverqa.getTitle();
				Assert.assertEquals(atualtitle, expectedtitle);
				test.log(LogStatus.INFO, "Ending Login");
				test.log(LogStatus.PASS, "PASSED Login");
				logger.info("Login Successful");
				wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.operation));
				Thread.sleep(2000);
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Log-In.jpg");

		} catch (Exception e) {
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit_Card_Within_DeadLine/Log-In.jpg");
			test.log(LogStatus.FAIL, "Login");
		}
		logger.info("Searching Customer");
		
		     try {
				test.log(LogStatus.INFO, "Navigating to customer search page");
				 logger.info("Navigating to customer search page");
				 driverqa.findElement(HomePage.operation).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.newBooking));
				 driverqa.findElement(Operations.newBooking).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.AccomBook));
				 driverqa.findElement(Operations.AccomBook).click();
				 Thread.sleep(2000);
				 String searchcustatualtitle = driverqa.getTitle();
				 String searchcustexpectedtitle = "DOTWconnect.com::New Accommodation Booking";
				 Assert.assertEquals(searchcustatualtitle, searchcustexpectedtitle);
				 logger.info("Navigated to customer search page");
				 test.log(LogStatus.PASS, "Navigated to customer search page");
				 Thread.sleep(2000);
				 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Customer-Search.jpg");
			
			} catch (Exception e) {
				logger.info(e.getMessage());
				test.log(LogStatus.FAIL, e.getMessage());
				rep.endTest(test);
				rep.flush();
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit_Card_Within_DeadLine/Customer-Search.jpg");
				Assert.assertTrue(false, e.getMessage());
				test.log(LogStatus.FAIL, "Navigation to customer search page");
			}
		     logger.info("Selecting Customer");
		     test.log(LogStatus.INFO, "Selecting Customer");
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.company));
				 driverqa.findElement(Operations.company).sendKeys(excel.getData(5, 4, 0));
				 Thread.sleep(2000);
				 action.sendKeys(Keys.ARROW_DOWN).build().perform();
				 action.sendKeys(Keys.ENTER).build().perform();
				 Thread.sleep(2000);
				 action.sendKeys(Keys.ENTER).build().perform();
				 Thread.sleep(2000);
				 
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Customer-list.jpg");
				wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.chooseCustbook));
				driverqa.findElement(Operations.chooseCustbook).click();
				Thread.sleep(1000);
				String searchpageactualtitle = driverqa.getTitle();
				String searchpageexpectedtitle = "DOTWconnect.com::";
				Assert.assertEquals(searchpageactualtitle, searchpageexpectedtitle);
				logger.info("Customer Selected");
				test.log(LogStatus.PASS, "Customer Selected");
				
			 }
			 catch (Exception e) {
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit_Card_Within_DeadLine/Customer-list.jpg");
					test.log(LogStatus.FAIL, "Customer Selection");
				}
			 logger.info("Applying search Filters");
			 logger.info("Starting HotelSearch Credit Card");
			 try{
				 test.log(LogStatus.INFO, "Starting HotelSearch Credit Card");
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.AccomUnit));
				 driverqa.findElement(NewAccoBooking.AccomUnit).sendKeys(excel.getData(5, 7, 0));
				 Thread.sleep(2000);
				 action.sendKeys(Keys.ARROW_DOWN).build().perform();
				 action.sendKeys(Keys.ENTER).build().perform();
				 driverqa.findElement(NewAccoBooking.inDate).clear();
				 driverqa.findElement(NewAccoBooking.inDate).sendKeys(excel.getData(5, 10, 0));
				 driverqa.findElement(NewAccoBooking.outDate).clear();
				 driverqa.findElement(NewAccoBooking.outDate).sendKeys(excel.getData(5, 10, 1));
				 String expected=excel.getData(5, 7, 0);
				 Thread.sleep(2000);
				 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Search-Hotel-filters.jpg");
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.bookChannel));
				 driverqa.findElement(NewAccoBooking.bookChannel).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyChannel));
				 driverqa.findElement(NewAccoBooking.thirdPartyChannel).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdParty));
				 driverqa.findElement(NewAccoBooking.thirdParty).click();
				 Thread.sleep(2000);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.searchButton));
				 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Booking-Channel-filters.jpg");
				 driverqa.findElement(NewAccoBooking.searchButton).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyresultHotel));
				 String result= driverqa.findElement(NewAccoBooking.thirdPartyresultHotel).getText();
				 Thread.sleep(2000);
				 wait.until(ExpectedConditions.elementToBeClickable(NewAccoBooking.thirdPartyroomType));
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyroomType));
				 driverqa.findElement(NewAccoBooking.thirdPartyroomType).click();
				 Thread.sleep(2000);
				 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Search-Result.jpg");
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyDeadline));
				 String actualdeadline= driverqa.findElement(NewAccoBooking.thirdPartyDeadline).getText();
				 String expecteddeadline=excel.getData(5, 19, 0);
				 Assert.assertTrue(result.contains(expected));
				 Assert.assertTrue(actualdeadline.contains(expecteddeadline));
				 test.log(LogStatus.INFO, "Ending HotelSearch Credit Card");
				 test.log(LogStatus.PASS, "PASSED HotelSearch Credit Card");
				 logger.info("Hotel Search Complete Credit Card");
			} catch (Exception e) {
				logger.info(e.getMessage());
				test.log(LogStatus.FAIL, e.getMessage());
				rep.endTest(test);
				rep.flush();
				Assert.assertTrue(false, e.getMessage());
				test.log(LogStatus.FAIL, "Hotel Search Credit Card");
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit_Card_Within_DeadLine/Search-Result.jpg");
			}
			
				try {
					test.log(LogStatus.INFO, "Starting Hotel Save Itenary Credit Card");
					 logger.info("Starting Hotel Save Credit Card");
					 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyroomSelectionsaveoutdead));
					 driverqa.findElement(NewAccoBooking.thirdPartyroomSelectionsaveoutdead).click();
					 Thread.sleep(2000);
					 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Room-Selection.jpg");
					 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyprocedetoBooksaveoutdead));
					 driverqa.findElement(NewAccoBooking.thirdPartyprocedetoBooksaveoutdead).click();
					 logger.info("Entering Passenger details");
					 test.log(LogStatus.INFO, "Entering Passenger details");
					 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.paxFname));
					driverqa.findElement(NewAccoBooking.paxFname).sendKeys(excel.getData(5, 13, 0));
					Thread.sleep(2000);
					driverqa.findElement(NewAccoBooking.paxLname).sendKeys(excel.getData(5, 13, 1));
					Select passengertitle = new Select(driverqa.findElement(NewAccoBooking.paxtitle));
					passengertitle.selectByIndex(1);
					driverqa.findElement(NewAccoBooking.paxFname2).sendKeys(excel.getData(5, 14, 0));
					Thread.sleep(1000);
					driverqa.findElement(NewAccoBooking.paxLname2).sendKeys(excel.getData(5, 14, 1));
					Select passengertitle2 = new Select(driverqa.findElement(NewAccoBooking.paxtitle2));
					passengertitle2.selectByIndex(1);
					driverqa.findElement(NewAccoBooking.acceptChkBX).click();
					Thread.sleep(2000);
					 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Passenger-Details.jpg");
					logger.info("Entered Passenger details");
					test.log(LogStatus.INFO, "Entered Passenger details");
					test.log(LogStatus.PASS, "Passenger details");
					driverqa.findElement(NewAccoBooking.thirdPartsavebooking).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartsaveItncart));
					driverqa.findElement(NewAccoBooking.thirdPartsaveItncart).click();
					Thread.sleep(2000);
					String actualhoteltitle= driverqa.findElement(NewAccoBooking.thirdPartyaftersavehotel).getText();
					String expectedhoteltitle=excel.getData(5, 7, 0);
					String actualStartDate= driverqa.findElement(NewAccoBooking.thirdPartyaftersaveCheckin).getText();
					String expectedStartDate=excel.getData(5, 17, 0);
					String actualEndDate= driverqa.findElement(NewAccoBooking.thirdPartyaftersaveCheckout).getText();
					String expectedEndDate= excel.getData(5, 18, 0);
					Assert.assertTrue(actualhoteltitle.contains(expectedhoteltitle));
					Assert.assertTrue(actualStartDate.contains(expectedStartDate));
					Assert.assertTrue(actualEndDate.contains(expectedEndDate));
					//Assert.assertTrue(actualRate.contains(SearchRateexpected));
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Itenary-Details.jpg");
					test.log(LogStatus.INFO, "Ending HotelSave Credit Card");
				    test.log(LogStatus.PASS, "PASSED HotelSave Credit Card");
				    logger.info("Hotel Save Complete Credit Card");
				}
				catch (Exception e) {
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					test.log(LogStatus.FAIL, "Hotel Save Itenary Credit Card");
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit_Card_Within_DeadLine/Save-Itenary.jpg");

				}
				    try {
						test.log(LogStatus.INFO, "Starting Delete from Itenary");
						logger.info("Starting Delete from Itenary");
						wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyremovefromcart));
						driverqa.findElement(NewAccoBooking.thirdPartyremovefromcart).click();
						Thread.sleep(2000);
						obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Confirm-Delete-Itenary-Details.jpg");
						wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyconfirmremovefromcart));
						driverqa.findElement(NewAccoBooking.thirdPartyconfirmremovefromcart).click();
						wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyremovefromcartconfirmtext));
						Thread.sleep(2000);
						obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit_Card_Within_DeadLine/Deleted-Itenary-Details.jpg");
						String Deletesuccesstext= driverqa.findElement(NewAccoBooking.thirdPartyremovefromcartconfirmtext).getText();
						String expectedDeletesuccesstext= excel.getData(5, 20, 0);
						System.out.println(Deletesuccesstext);
						System.out.println(expectedDeletesuccesstext);
						Assert.assertTrue(Deletesuccesstext.contains(expectedDeletesuccesstext));
						test.log(LogStatus.INFO, "Ending Deleting from Itenary");
						test.log(LogStatus.PASS, "Deleting from Itenary");
						logger.info("Deleted from Itenary");
					} catch (Exception e) {
						logger.info(e.getMessage());
						test.log(LogStatus.FAIL, e.getMessage());
						rep.endTest(test);
						rep.flush();
						Assert.assertTrue(false, e.getMessage());
						test.log(LogStatus.FAIL, "Hotel Delete from Itenary Credit Card Within Daedline");
						obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit_Card_Within_DeadLine/Delete-Itenary.jpg");

					}

				
	 }
	 
	  @AfterMethod
		public void getResult(ITestResult result) {
			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(LogStatus.FAIL, result.getThrowable());
			}
			rep.endTest(test);
		}

		@AfterTest
		public void afterTest() {

			rep.endTest(test);
			rep.flush();
			//driverqa.close();
		}
	 }

