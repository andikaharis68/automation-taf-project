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
import com.taf.pageobjects.disbursement.DisbursementApprovalPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

DisbursementApprovalPage approval = new DisbursementApprovalPage()
MenuPage menu = new MenuPage()

'Step 0: Verify landing'
approval.verifyLandingPage()

'Step 1: Select Ap Type name '
approval.inputSearchApplication(ApTypeName, ApDestination, BankName)

'Step 2: Click Search'
approval.clickButtonSearch()

'Step 3: Click checkbox'
approval.checklistApDisbursement(ApplicationBalance)

'Step 4: Click Approved selected'
approval.clickButtonApproveSelected()

'Step 5: Get Voucher No'
approval.updatePaymentVoucherNoToExcel(TestDataName, ScenarioId)

'Step 6: Click Approve'
approval.clickButtonApprove()

'Step 7: Verify landing in disbursment approval page'
approval.verifyLandingPage()