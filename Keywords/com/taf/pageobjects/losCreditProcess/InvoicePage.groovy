package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class InvoicePage extends BaseHelper{

	private TestObject lblTitle				= createTestObject("lblTitle", "id", "")
	private TestObject txfAgreementNo		= createTestObject("txfAgreementNo", "id", "")
	private TestObject btnSearch			= createTestObject("btnSearch", "id", "")

	//section 2
	private TestObject txfAgreementNo2		= createTestObject("txfAgreementNo2", "id", "")
	private TestObject btnSearch2			= createTestObject("btnSearch2", "id", "")
	private TestObject chkPurchaseOrder		= createTestObject("chkPurchaseOrder", "id", "")
	private TestObject btnAddToTemp			= createTestObject("btnAddToTemp", "id", "")
	private TestObject btnNext				= createTestObject("btnNext", "id", "")

	//section invoice summary
	private TestObject txfInvoiceDate		= createTestObject("txfInvoiceDate", "id", "")
	private TestObject txfInvoiceNumber		= createTestObject("txfInvoiceNumber", "id", "")
	private TestObject btnSave				= createTestObject("btnSave", "id", "")

	private TestObject iframeMain			= createTestObject("iframeMain", "id", "")


	private void verifyLandingInvoicePage() {
		WebUI.switchToFrame(iframeMain, 3)
		verifyLanding(lblTitle, 'Invoice')
		WebUI.takeScreenshot()
	}

	private void searchTransactionByReferenceNumber(String reffNo) {
		safetyInput(txfAgreementNo, reffNo)
		safetyClick(btnSearch)
	}

	private void actionTransaction(String agreeNo) {
		TestObject rowExist = createTestObject("rowExist", "xpath", "//a[text() = '$agreeNo']")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)

		if(rowExist) {
			TestObject btnPenEdit = createTestObject("btnPenEdit", "xpath", "${getXpath(rowExist)}/following::td[4]//input")
			WebUI.takeScreenshot()
			safetyClick(btnPenEdit)
		}else {
			KeywordUtil.markFailedAndStop("reff no not exist $agreeNo")
		}
	}

	private void searchTransactionPurchase(String agreeNo) {
		//belum tau swithc iframe
		safetyInput(txfAgreementNo2, agreeNo)
		safetyClick(btnSearch2)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}

	private void selectOrder() {
		//pilih cehckbox nya
		WebUI.click(btnAddToTemp)
		WebUI.takeScreenshot()
	}

	private void inputInvoiceSummary(String invoiceNo, String invoiceDate) {
		WebUI.setText(txfInvoiceDate, invoiceDate)
		WebUI.delay(2)
		WebUI.click(txfInvoiceNumber)
		WebUI.setText(txfInvoiceNumber, invoiceNo)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}

	private void clickSave() {
		safetyClick(btnSave)
		WebUI.takeScreenshot()
	}
}
