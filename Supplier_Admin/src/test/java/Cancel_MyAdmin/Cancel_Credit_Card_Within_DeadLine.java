package Cancel_MyAdmin;

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

import ObjectRepository.Amend;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.MultiAcco;
import ObjectRepository.NewAccoBooking;
import ObjectRepository.Operations;
import ObjectRepository.PaymentPage;
import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;

public class Cancel_Credit_Card_Within_DeadLine {
	public WebDriver driverqa;
	Configuration Config = new Configuration();
	Takescreenshot obj= new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	NewAccoBooking acco = new NewAccoBooking();
	Operations opo = new Operations();
	Logger logger = Logger.getLogger("Cancel_Credit_Card_Within_DeadLine");
	String SearchRateexpected;
	String errorpath;
	 @Test
	 @Parameters({ "browsername" })
	  public void CancelCreditCardWithinDeadLine(String browsername) throws Exception {
		  test = rep.startTest("Credit Card Cancel Within DeadLine");
		  ExcelDataConfig excel;
		  excel = new ExcelDataConfig(Config.getExcelPathBook());
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
			    String URL = excel.getData(0, 1, 5) + "/_myadmin";
				driverqa.get(URL);
				logger.info("Test Case Started");
				test.log(LogStatus.INFO, "Starting Login");
				WebElement username = driverqa.findElement(LoginPage.uname);
				username.clear();
				username.sendKeys(excel.getData(0, 1, 1));
				WebElement password = driverqa.findElement(LoginPage.pwd);
				password.clear();
				password.sendKeys(excel.getData(0, 1, 2));
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
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Log-In.jpg");

		} catch (Exception e) {
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Log-In.jpg");
			test.log(LogStatus.FAIL, "Login");
			errorpath=Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Log-In.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
			
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
				 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Customer-Search.jpg");
			
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Navigation to customer search page");
				errorpath=Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Customer-Search.jpg";
				logger.info(e.getMessage());
				test.log(LogStatus.FAIL, e.getMessage());
				rep.endTest(test);
				rep.flush();
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Customer-Search.jpg");
				Assert.assertTrue(false, e.getMessage());
				
			}
		     logger.info("Selecting Customer");
		     test.log(LogStatus.INFO, "Selecting Customer");
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.company));
				 driverqa.findElement(Operations.company).sendKeys(excel.getData(0, 6, 1));
				 Thread.sleep(2000);
				 action.sendKeys(Keys.ARROW_DOWN).build().perform();
				 action.sendKeys(Keys.ENTER).build().perform();
				 Thread.sleep(2000);
				 action.sendKeys(Keys.ENTER).build().perform();
				 Thread.sleep(2000);
				 
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Customer-list.jpg");
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
				    obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Customer-list.jpg");
					test.log(LogStatus.FAIL, "Customer Selection");
					errorpath=Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Customer-list.jpg";
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					
				}
			 logger.info("Applying search Filters");
			 logger.info("Starting HotelSearch Credit Card Within DeadLine");
			 try{
				 test.log(LogStatus.INFO, "Starting HotelSearch Credit Card Within DeadLine");
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.AccomUnit));
				 driverqa.findElement(NewAccoBooking.AccomUnit).sendKeys(excel.getData(0, 9, 1));
				 Thread.sleep(2000);
				 action.sendKeys(Keys.ARROW_DOWN).build().perform();
				 action.sendKeys(Keys.ENTER).build().perform();
				 driverqa.findElement(NewAccoBooking.inDate).clear();
				 driverqa.findElement(NewAccoBooking.inDate).sendKeys(excel.getData(0, 18, 1));
				 driverqa.findElement(NewAccoBooking.outDate).clear();
				 driverqa.findElement(NewAccoBooking.outDate).sendKeys(excel.getData(0, 18, 2));
				 String expected=excel.getData(0, 9, 1);
				 Select noofchild = new Select(driverqa.findElement(MultiAcco.child1));
				 noofchild.selectByIndex(1);
				 Thread.sleep(2000);
				 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Search-Hotel-filters.jpg");
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.bookChannel));
				 driverqa.findElement(NewAccoBooking.bookChannel).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyChannel));
				 driverqa.findElement(NewAccoBooking.thirdPartyChannel).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdParty));
				 driverqa.findElement(NewAccoBooking.thirdParty).click();
				 Thread.sleep(2000);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.searchButton));
				 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Booking-Channel-filters.jpg");
				 driverqa.findElement(NewAccoBooking.searchButton).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyresultHotel));
				 String result= driverqa.findElement(NewAccoBooking.thirdPartyresultHotel).getText();
				 Thread.sleep(2000);
				 wait.until(ExpectedConditions.elementToBeClickable(NewAccoBooking.thirdPartyroomType));
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyroomType));
				 driverqa.findElement(NewAccoBooking.thirdPartyroomType).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyDeadline));
				 Thread.sleep(2000);
				 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_Deadline/Search-Result_Deadline.jpg");
				 String actualdeadline= driverqa.findElement(NewAccoBooking.thirdPartyDeadline).getText();
				 String expecteddeadline=excel.getData(0, 30, 1);
				 Assert.assertTrue(result.contains(expected));
				 Assert.assertTrue(actualdeadline.contains(expecteddeadline));
				 test.log(LogStatus.INFO, "Ending HotelSearch Credit Card Within DeadLine");
				 test.log(LogStatus.PASS, "PASSED HotelSearch Credit Card Within DeadLine");
				 logger.info("Hotel Search Complete Credit Card Within DeadLine");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Hotel Search Credit Card Within DeadLine");
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Search-Result.jpg");
				errorpath=Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Search-Result.jpg";
				logger.info(e.getMessage());
				test.log(LogStatus.FAIL, e.getMessage());
				rep.endTest(test);
				rep.flush();
				Assert.assertTrue(false, e.getMessage());
				
			}
			
				try {
					test.log(LogStatus.INFO, "Starting Hotel Book Credit Card Within DeadLine");
					logger.info("Starting Hotel Book");
					wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyroomSelectionbookoutdead));
					driverqa.findElement(NewAccoBooking.thirdPartyroomSelectionbookoutdead).click();
				    Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Room-Selection.jpg");
					wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyprocedetoBookingoutdead));
					driverqa.findElement(NewAccoBooking.thirdPartyprocedetoBookingoutdead).click();
					logger.info("Entering Passenger details");
					test.log(LogStatus.INFO, "Entering Passenger details");
					wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.paxFname));
					driverqa.findElement(NewAccoBooking.paxFname).sendKeys(excel.getData(0, 21, 1));
					Thread.sleep(2000);
					driverqa.findElement(NewAccoBooking.paxLname).sendKeys(excel.getData(0, 21, 2));
					Select passengertitle = new Select(driverqa.findElement(NewAccoBooking.paxtitle));
					passengertitle.selectByIndex(1);
					driverqa.findElement(NewAccoBooking.paxFname2).sendKeys(excel.getData(0, 22, 1));
					Thread.sleep(1000);
					driverqa.findElement(NewAccoBooking.paxLname2).sendKeys(excel.getData(0, 22, 2));
					Select passengertitle2 = new Select(driverqa.findElement(NewAccoBooking.paxtitle2));
					passengertitle2.selectByIndex(1);
					driverqa.findElement(NewAccoBooking.paxFnameCHILD).sendKeys(excel.getData(0, 23, 1));
					Thread.sleep(1000);
					driverqa.findElement(NewAccoBooking.paxLnameCHILD).sendKeys(excel.getData(0, 23, 2));
					Select passengertitle3 = new Select(driverqa.findElement(NewAccoBooking.paxtitle3));
					passengertitle3.selectByIndex(1);
					driverqa.findElement(NewAccoBooking.acceptChkBX).click();
					Thread.sleep(2000);
					 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Passenger-Details.jpg");
					logger.info("Entered Passenger details");
					test.log(LogStatus.INFO, "Entered Passenger details");
					test.log(LogStatus.PASS, "Passenger details");
					driverqa.findElement(NewAccoBooking.bookBtn).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.confirmBook));
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Proceed-To-Booking.jpg");
					driverqa.findElement(NewAccoBooking.confirmBook).click();
				
					logger.info("Entering Payment Details");
					test.log(LogStatus.INFO, "Entering Payment Details");
					wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentPage.ccType));
					Select paymentmode = new Select(driverqa.findElement(PaymentPage.ccType));
					paymentmode.selectByIndex(1);
					driverqa.findElement(PaymentPage.ccNum).sendKeys(excel.getData(0, 42, 1));
					driverqa.findElement(PaymentPage.cvv).sendKeys(excel.getData(0, 43, 1));
					driverqa.findElement(PaymentPage.ccName).sendKeys(excel.getData(0, 44, 1));
					Select expiryYear = new Select(driverqa.findElement(PaymentPage.expYear));
					expiryYear.selectByIndex(2);
					Select expirydate = new Select(driverqa.findElement(PaymentPage.expMonth));
					expirydate.selectByIndex(11);
					driverqa.findElement(PaymentPage.zip).sendKeys(excel.getData(0, 41, 1));
					driverqa.findElement(PaymentPage.termsconditions).click();
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Card-Details.jpg");
				    driverqa.findElement(PaymentPage.confirmPayment).click();
				    logger.info("Completed Payment Details");
				    test.log(LogStatus.PASS, "Completed Payment Details");
					wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.thirdPartyconfirmStatus));
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/booking-Details.jpg");
					String expectedbookingstatus = "Confirmed";
					String actualbookingstatus = driverqa.findElement(NewAccoBooking.thirdPartyconfirmStatus).getText();
					System.out.println(actualbookingstatus);
					String actualhoteltitle= driverqa.findElement(NewAccoBooking.thirdPartyafterbookhotelcreditcard).getText();
					System.out.println(actualhoteltitle);
					String expectedhoteltitle=excel.getData(0, 9, 1);
					String actualStartDate= driverqa.findElement(NewAccoBooking.thirdPartyafterbookCheckInCreditCardOutDead).getText();
					System.out.println(actualStartDate);
					String expectedStartDate=excel.getData(0, 38, 1);
					String actualEndDate= driverqa.findElement(NewAccoBooking.thirdPartyafterbookCheckOutCreditCardOutDead).getText();
					System.out.println(actualEndDate);
					String expectedEndDate= excel.getData(0, 39, 1);
					Assert.assertTrue(actualhoteltitle.contains(expectedhoteltitle));
					Assert.assertTrue(actualStartDate.contains(expectedStartDate));
					Assert.assertTrue(actualEndDate.contains(expectedEndDate));
					Assert.assertTrue(actualbookingstatus.contains(expectedbookingstatus));
					test.log(LogStatus.INFO, "Ending HotelBook Credit Card Within DeadLine");
				    test.log(LogStatus.PASS, "PASSED HotelBook Credit Card Within DeadLine");
				    logger.info("Hotel Book Complete Credit Card Within DeadLine");


				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Hotel Book Credit Card Within DeadLine");
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Booking.jpg");
					errorpath=Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Booking.jpg";
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					
				}
				try {
					test.log(LogStatus.INFO, "Starting to Cancel Credit Card Within DeadLine");
					logger.info("Starting to Cancel Credit Card Within DeadLine");
					driverqa.findElement(Amend.cancelButton).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(Amend.ProceedwithwithinDeadlineCancellation));
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Proceed-To-Cancellation.jpg");
					driverqa.findElement(Amend.ProceedwithwithinDeadlineCancellation).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(Amend.ProcdwithCancltn));
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/Confirm-Cancellation.jpg");
	                String ExpectedCancellationTitle = "Cancelled";
	                driverqa.findElement(Amend.ProcdwithCancltn).click();
	                Thread.sleep(2000);
	                wait.until(ExpectedConditions.visibilityOfElementLocated(Amend.CancellationTitlePrePay));
	                String ActualCancellationTitle= driverqa.findElement(Amend.CancellationTitlePrePay).getText();
	                System.out.println(ActualCancellationTitle);
	                System.out.println(ExpectedCancellationTitle);
	                Assert.assertTrue(ActualCancellationTitle.contains(ExpectedCancellationTitle));
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Accommodation_Cancel_Credit_Card_Within_DeadLine/After-Cancel.jpg");
					test.log(LogStatus.PASS, "Cancellation Credit Card Within DeadLine");
					logger.info("Completed Cancellation Credit Card Within DeadLine");
				

				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Hotel Cancel Credit Card Within DeadLine");
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Cancellation.jpg");
					errorpath=Config.SnapShotPath() + "/Cancel/Error/Accommodation_Cancel_Credit_Card_Within_DeadLine/Cancellation.jpg";
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					
				}
	 }
	 
	  @AfterMethod
	  public void getResult(ITestResult result) {
		  if (result.getStatus() == ITestResult.FAILURE) {
		 
		
		test.log(LogStatus.FAIL, test.addScreenCapture(errorpath));
		  test.log(LogStatus.FAIL, result.getThrowable());
		  }
		  rep.endTest(test);
		  }


		@AfterTest
		public void afterTest() {

			rep.endTest(test);
			rep.flush();
			driverqa.close();
		}
	 }



