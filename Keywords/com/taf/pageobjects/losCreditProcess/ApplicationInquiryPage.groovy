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
	private TestObject txfAgreementNo		= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject btnSearch			= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//table
	private TestObject txtApplicationStep	= createTestObject("txtApplicationStep", "id", "gvApp_lbAppStep_0")
	private TestObject txtApplicationNo		= createTestObject("txtApplicationNo", "xpath", "//*[contains(@id, 'gvApp_lbAppNo') and text() = '0015APP20250600097']")
	private TestObject txtAgreementNo		= createTestObject("txtAgreementNo", "id", "gvApp_lbAgrmntNo_0")

	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	private TestObject txtHandlingOffice	= createTestObject("txtHandlingOffice", "id", "ucAgrmntInfo_lblHandlingOffice") 

	public void verifyLandingScreen() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainpage, 1)
		verifyLanding(txfApplicationNo, "Application Inquiry")
//		WebUI.takeScreenshot()
	}

	public void searchByApplicationNo(String applicationNo) {
		safetyInput(txfApplicationNo, applicationNo)
		safetyClick(btnSearch)
//		WebUI.takeScreenshot()
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
	
	public boolean checkApplicationStep(String step) {
		def actualStep = WebUI.getText(txtApplicationStep)
		return actualStep.equals(step)
	}
	
	public String getAgreementNo() {
		return WebUI.getText(txtAgreementNo)
	}
	private void searchAgreementNo(String agreementNo){
		safetyInput(txfAgreementNo, agreementNo)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	
	private void clickAgreementAndSwitchNewTab(String fileName, String scenarioId) {
		safetyClick(txtAgreementNo)
		switchToNewTab()
		WebUI.delay(0.5)
		WebUI.takeScreenshot()
		String office = WebUI.getText(txtHandlingOffice)
		updateHandlingOfficeToExcelData(fileName, scenarioId, office)
	}
	
	private void updateHandlingOfficeToExcelData(String fileName, String scenarioId, String office) {
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String strHandlingOffice = office
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId
		saveDataToExcel(strHandlingOffice, rowFilter, filePath, "RemedialDealAmountReq", "HandlingOffice")
		WebUI.delay(1)
	}
}
