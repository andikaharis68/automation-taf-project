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
import com.taf.pageobjects.MenuPage
import com.taf.pageobjects.remedials.RemedialDealAmountRequestPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

RemedialDealAmountRequestPage request = new RemedialDealAmountRequestPage()
MenuPage menu = new MenuPage()

'Step 1: Verify landing page'
request.verifyLandingPage()

'Step 2: Search agreement'
request.searchAgreement(HandlingOffice, AgreementNo, CustomerName)

'Step 3: Switch and close current windor'
BussinessDate = request.getBussinessDate()

'Step 4: Switch iframe main page'
menu.switchToIframeMainPage()

'Step 5: Click Edit Request'
request.clickEditRequest()

'Step 6: Verify landing in request detail'
request.verifyLandingRemedialDealAmountReqDetail()

'Step 7: Input Remedial deal amount'
request.inputRemedialDealAmount(DealAmount, Tenor, PaymentFrequency, InstallmentScheme, BussinessDate, NotesRequest)

'Step 8: Click Calculate Installment'
request.clickCalculateInstallment()

'Step 9: Input Approval Request'
request.inputApprovalRequestDetail(ReasonDescription, ToBeApprovedBy, NotesApprovalRequest)

'Step 10: Get credential id for username approval'
KeywordUtil.logInfo(ScenarioId)
request.updateCredentialIdforApproval(TestDataName, ScenarioId)

'Step 10: Click Submit'
request.clickSubmit()

'Step 11: Verify landing page'
request.verifyLandingPage()
