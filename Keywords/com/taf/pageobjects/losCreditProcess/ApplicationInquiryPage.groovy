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

public class ApplicationInquiryPage extends BaseHelper {
	//search
	private TestObject txfApplicationNo		= createTestObject("txfApplicationNo", "id", "ucSearch_txtAppNo_ltlAppAppNoSearch")
	private TestObject btnSearch			= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//table
	private TestObject txtApplicationStep	= createTestObject("txtApplicationStep", "id", "gvApp_lbAppStep_0")
	private TestObject txtApplicationNo		= createTestObject("txtApplicationNo", "xpath", "//*[contains(@id, 'gvApp_lbAppNo') and text() = '0015APP20250600097']")

	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")

	public void verifyLandingScreen() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainpage, 1)
		verifyLanding(txfApplicationNo, "Application Inquiry")
		WebUI.takeScreenshot()
	}

	public void searchByApplicationNo(String applicationNo) {
		safetyInput(txfApplicationNo, applicationNo)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}

	public void verifyApplicationStepForPurchaseOrder() {
		String actualText = WebUI.getText(txtApplicationStep)
		if (actualText == "POP") {
			KeywordUtil.markPassed("Success: The Application Step for Purchase Order is POP")
		} else {
			KeywordUtil.markFailed("Failed: Either TestObject / actual text: $actualText , is not POP")
		}
		WebUI.takeScreenshot()
	}

	public void selectInquiryByApplicationNo(String applicationNo) {
		txtApplicationNo = createTestObject("txtApplicationNo", "xpath", "//*[contains(@id, 'gvApp_lbAppNo') and text() = '$applicationNo']")
		safetyClick(txtApplicationNo)
	}
	
	public void selectInquiryByApplicationStep() {
		safetyClick(txtApplicationStep)
	}
	
}
