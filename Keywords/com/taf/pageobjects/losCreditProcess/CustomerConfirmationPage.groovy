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

public class CustomerConfirmationPage extends BaseHelper{

	private TestObject lblTitle			= createTestObject("lblTitle", "id", "")
	private TestObject txfApplicationNo	= createTestObject("txfApplicationNo", "id", "")
	private TestObject btnSearch		= createTestObject("btnSearch", "id", "")

	//section go live information
	private TestObject txfPersonName	= createTestObject("txfPersonName", "id", "")
	private TestObject drpRelationship	= createTestObject("drpRelationship", "id", "")
	private TestObject txfAgreementDate	= createTestObject("txfAgreementDate", "id", "")
	private TestObject txfNotes			= createTestObject("txfNotes", "id", "")

	private TestObject btnSubmit		= createTestObject("btnSubmit", "id", "")

	private TestObject iframeMain		= createTestObject("iframeMain", "id", "")



	private void verifyLandingCustomerConfirmationPage() {
		WebUI.switchToFrame(iframeMain, 3)
		verifyLanding(lblTitle, 'Customer Confirmation')
		WebUI.takeScreenshot()
	}

	private void searchTransactionByApplicationNumber(String appNo) {
		safetyInput(txfApplicationNo, appNo)
		safetyClick(btnSearch)
	}

	private void entryTransaction(String appNo) {
		TestObject rowExist = createTestObject("rowExist", "xpath", "//a[text() = '$appNo']")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)

		if(rowExist) {
			TestObject btnPenEdit = createTestObject("btnPenEdit", "xpath", "${getXpath(rowExist)}/following::td[7]//input")
			WebUI.takeScreenshot()
			safetyClick(btnPenEdit)
		}else {
			KeywordUtil.markFailedAndStop("reff no not exist $appNo")
		}
	}

	private void inputGoLiveInformation(String name, String date, String relation, String note) {

		safetyInput(txfPersonName, name, 1)
		safetySelect(drpRelationship, relation, 1)
		safetyInput(txfAgreementDate, date)
		WebUI.click(txfNotes)
		safetyInput(txfNotes, note)
		WebUI.takeScreenshot()
	}

	private void clickSubmit() {
		safetyClick(btnSubmit, 2)
		WebUI.takeScreenshot()
	}
}
