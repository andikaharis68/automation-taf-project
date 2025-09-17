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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.pageobjects.MenuPage
import com.taf.pageobjects.remedials.PaymentReceiveAfterWoPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

PaymentReceiveAfterWoPage payment  = new PaymentReceiveAfterWoPage()
MenuPage menu = new MenuPage()

'Step 0: verify landing page'
payment.verifyLandingPage()

'Step 1: search cashier info'
payment.searchCashierTrxInfo(WOP, AccountName, ValueDate)

'Step 2: Search payment info'
payment.inputPaymentInfo(OfficeName, CustomerName, OverdueDaysPaymentGreaterThan, WORequestNo, WODateGreaterThan, DealAmountGreaterThan, 
	AgreementNo, OverdueDaysPaymentLessThan, WODateLessThan, DealAmountLessThan)

'Step 3: switch to agreement tab'
payment.switchToAgreementTab()

'Step 4: Switch iframe main page'
menu.switchToIframeMainPage()

'Step 5: Click edit'
payment.clickEdit()

'Step 6: input payment detail info '
payment.inputPaymentDetailInfo(ReceiveFrom, NotesPayment, ReferenceNo, ReceiveAmount)

'Step 7: Click Calculate'
payment.clickCalculate()

'Step 8: Click Submit'
payment.clickSubmit()

'Step 9: open agreement tab again and refresh after submit payment'
payment.openAgreementTabAndRefresh()



