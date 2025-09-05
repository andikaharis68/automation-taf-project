import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.pageobjects.losCreditProcess.ApplicationInquiryPage
import com.taf.pageobjects.losCreditProcess.ApplicationViewPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

ApplicationInquiryPage inquiry = new ApplicationInquiryPage()
ApplicationViewPage applicationView = new ApplicationViewPage()

'Step 1: verify landing in application inquiry screen'
inquiry.verifyLandingScreen()

'Step 2: search inquiry by application no'
inquiry.searchByApplicationNo(ApplicationNo)

'Step 3: select result by application no'
inquiry.selectInquiryByApplicationNo(ApplicationNo)

'Step 4: verify landing in application view screen'
applicationView.switchToSecondTab()
applicationView.verifyLandingScreen()

'Step 5: click tab approval history'
applicationView.clickTabApprovalHistory()

'Step 6: get approval credential'
Map appCreds = applicationView.getApprovalCredential()
ApprovalUsername = appCreds['lastOwner']
ApprovalPassword = Password
ApprovalOffice = appCreds['office']
ApprovalPosition = appCreds['lastNode']
ApprovalRole = appCreds['lastNode']

if (ApprovalRole.toString().equalsIgnoreCase("Credit Division Head")) {
	ApprovalOffice = "HEAD OFFICE"
	ApprovalPosition = "OPERATION BUSINESS DEVELOPMENT ADMINISTRATOR"
}

KeywordUtil.logInfo("$ApprovalUsername, $ApprovalPassword, $ApprovalOffice, $ApprovalPosition, $ApprovalRole")
WebUI.delay(5)