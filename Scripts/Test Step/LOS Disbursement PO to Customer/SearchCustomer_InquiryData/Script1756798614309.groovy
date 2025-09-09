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
import com.taf.pageobjects.disbursement.OnlineDisbursementInquiryPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

OnlineDisbursementInquiryPage inquiry = new OnlineDisbursementInquiryPage()

'Step 1: Search customer by agreement no'
inquiry.searchByAgreementNo(AgreementNo)

'Step 2:retry search customer till status became success'
inquiry.retryInquiryStatus()

'Step 3: Click batch no'
inquiry.clickBatchNoAndNavigateToNewTab()

'Step 4: Get Status'
PaymentStatus = inquiry.getStatus()

'Step 5: Click Payment voucher no and switch new tab'
inquiry.clickVoucherNo()
