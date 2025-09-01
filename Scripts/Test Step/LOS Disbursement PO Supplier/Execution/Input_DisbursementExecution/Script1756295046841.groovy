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
import com.taf.pageobjects.disbursement.DisbursementExecutionPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

DisbursementExecutionPage execution = new DisbursementExecutionPage()

'Step 1: Input search application'
execution.inputSearchApplication(ApTypeName, ApDestination, BankName)

'Step 2: Click Search'
execution.clickButtonSearch()

'Step 3: Check app disbursement'
execution.checklistApDisbursement(PaymentVoucherNo)

'Step 4: Click Executed Selected'
execution.clickExecutedSelected()

'Step 5: Input bank disbursement'
execution.inputApBankDisbursement(RecipientName, CurrencyRate, DisbursementNotes)

'Step 6: Click Disburse button'
execution.clickButtonDisburse()
