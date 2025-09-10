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
import com.taf.pageobjects.disbursement.DisbursementSelectionPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

DisbursementSelectionPage selection = new DisbursementSelectionPage()
MenuPage menu = new MenuPage()

'Step 1: Search Application'
selection.inputSearchApplication(ApTypeName, APDueDateLessThan, BankName, ApDestinationSelection, OfficeName, InvoiceDate, IsReturnOnlineDisbursement)

'Step 2: Click search'
selection.clickButtonSearch()

'Step 3: Click checkbox'
selection.cheklistApDisbursement()

'Step 4: Click Add To Temp'
selection.clickButtonAddToTemp()

'Step 5: Get Selection Data'
selection.updateAppNoandBalanceToMasterData(TestDataName, ScenarioId)

'Step 6: Click Next'
selection.clickNext()

'Step 7: Select Way of payment'
selection.inputSelectionDetail(WayOfPayment, SourceBankAccount)

'Step 8: Click request approval'
selection.clickButtonRequestForApproval()

'Step 9: Click Confirmation Ok'
selection.clickConfirmationOK()

'Step 10: verify landing in disbursement selection'
selection.verifyLandingPage()
