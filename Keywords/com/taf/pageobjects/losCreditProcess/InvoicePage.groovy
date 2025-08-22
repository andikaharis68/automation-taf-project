package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.Robot
import java.awt.event.KeyEvent

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

	private TestObject lblTitle				= createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfAgreementNo		= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch			= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//section 2
	private TestObject txfAgreementNo2		= createTestObject("txfAgreementNo2", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch2			= createTestObject("btnSearch2", "id", "ucSearch_btnSearch")
	private TestObject btnAddToTemp			= createTestObject("btnAddToTemp", "id", "lb_Form_AddToTemp")
	private TestObject btnNext				= createTestObject("btnNext", "id", "lb_Toolbar_Next")

	//section invoice summary
	private TestObject txfInvoiceDate		= createTestObject("txfInvoiceDate", "id", "ucDPInvoiceDate_txtDatePicker")
	private TestObject txfInvoiceNumber		= createTestObject("txfInvoiceNumber", "id", "txtInvoiceNo")
	private TestObject btnSave				= createTestObject("btnSave", "id", "lb_Toolbar_Save")

	private TestObject iframeMain			= createTestObject("iframeMain", "id", "mainPage")


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
		TestObject rowExist = createTestObject("rowExist", "xpath", "//input[@id = 'gvSupp_ibInvoice_0']")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)

		if(rowExist) {
			WebUI.takeScreenshot()
			safetyClick(rowExist)
		}else {
			KeywordUtil.markFailedAndStop("agreement no not exist $agreeNo")
		}
	}

	private void searchTransactionPurchase(String agreeNo) {
		//belum tau swithc iframe
		safetyInput(txfAgreementNo2, agreeNo)
		safetyClick(btnSearch2)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}

	private void selectOrder(String agreeNo) {
		TestObject rowExist = createTestObject("rowExist", "xpath", "//a[text() = '$agreeNo']")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)

		if(rowExist) {
			TestObject btnAdd = createTestObject("btnAdd", "xpath", "${getXpath(rowExist)}/preceding::td[3]/input")
			WebUI.click(btnAdd)
			WebUI.delay(1)
			WebUI.click(btnAddToTemp)
			WebUI.delay(1)
			WebUI.takeScreenshot()
		}else {
			KeywordUtil.markFailedAndStop("agreement no not exist $agreeNo")
		}
	}

	private void inputInvoiceSummary(String invoiceNo, String invoiceDate) {
		Robot robot = new Robot()
		
		WebUI.setText(txfInvoiceDate, invoiceDate)
		WebUI.delay(2)
		robot.keyPress(KeyEvent.VK_TAB)
		WebUI.setText(txfInvoiceNumber, invoiceNo)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}

	private void clickSave() {
		safetyClick(btnSave)
		WebUI.takeScreenshot()
	}
	
	private void clickNext() {
		safetyClick(btnNext)
		WebUI.takeScreenshot()
	}
}
