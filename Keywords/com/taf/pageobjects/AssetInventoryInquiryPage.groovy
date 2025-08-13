package com.taf.pageobjects

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

public class AssetInventoryInquiryPage extends BaseHelper{
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject lblAgreementNo = createTestObject("txtOffice", "", "")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")

	//table
	private TestObject lblAgreementNoTable = createTestObject("lblAgreementNoTable", "", "")
	private TestObject txtAgreementNoTable = createTestObject("txtAgreementNoTable", "", "")
	private TestObject lblInventoryStatus = createTestObject("lblInventoryStatus", "", "")
	private TestObject txtInventoryStatus = createTestObject("txtInventoryStatus", "", "")

	//detail
	private TestObject lblResult = createTestObject("lblResult", "", "")
	private TestObject txtResult = createTestObject("txtResult", "", "")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Asset Inventory Inquiry Page")
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
		WebUI.click(btnSearch)
	}

	public void verifyStatusRequest(String expectedStatus) {
		String actualStatus = WebUI.getText(txtInventoryStatus)
		if (actualStatus.equalsIgnoreCase(expectedStatus)) {
			KeywordUtil.markPassed("Success : The Status is ($expectedStatus)")
		}else {
			KeywordUtil.markFailed("Failed : Actual status ($actualStatus) is not Matched with Expected status ($expectedStatus)")
		}
	}

	public void clickAgreementNo(String agreementNo) {
		txtAgreementNoTable = createTestObject("txtAgreementNoTable", "text", "$agreementNo")
		WebUI.click(txtAgreementNoTable)
	}

	public void verifyDetailStatus(String expectedStatus) {
		String actualStatus = WebUI.getText(txtResult)
		if (actualStatus.equalsIgnoreCase(expectedStatus)) {
			//Request atau Approve atau ApproveFinal
			KeywordUtil.markPassed("Success : The Detail Status is ($expectedStatus)")
		}else {
			KeywordUtil.markFailed("Failed : Actual detail status ($actualStatus) is not Matched with Expected detail status ($expectedStatus)")
		}
	}
}
