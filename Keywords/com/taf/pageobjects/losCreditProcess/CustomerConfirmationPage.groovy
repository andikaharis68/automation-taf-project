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

public class CustomerConfirmationPage extends BaseHelper{

	private TestObject lblTitle			= createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfApplicationNo	= createTestObject("txfApplicationNo", "id", "ucSearch_txtAppNo_ltlAgrmntAppNo")
	private TestObject btnSearch		= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//section go live information
	private TestObject txfPersonName	= createTestObject("txfPersonName", "id", "txtCntctPerson")
	private TestObject drpRelationship	= createTestObject("drpRelationship", "id", "ucrefCustRelationship_ddlReference")
	private TestObject txfAgreementDate	= createTestObject("txfAgreementDate", "id", "ucdpAgrmntDt_txtDatePicker")
	private TestObject txfNotes			= createTestObject("txfNotes", "id", "txtNotes")

	private TestObject btnSubmit		= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")

	private TestObject iframeMain		= createTestObject("iframeMain", "id", "mainPage")



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
			TestObject btnPenEdit = createTestObject("btnPenEdit", "xpath", "${getXpath(rowExist)}/following::td[5]//input")
			WebUI.takeScreenshot()
			safetyClick(btnPenEdit)
		}else {
			KeywordUtil.markFailedAndStop("reff no not exist $appNo")
		}
	}

	private void inputGoLiveInformation(String name, String date, String relation, String note) {
		Robot robot = new Robot()
		
		safetyInput(txfPersonName, name, 1)
		safetySelect(drpRelationship, relation, 1)
		safetyInput(txfAgreementDate, date)
		robot.keyPress(KeyEvent.VK_TAB)
		robot.keyPress(KeyEvent.VK_TAB)
		safetyInput(txfNotes, note)
		WebUI.takeScreenshot()
	}

	private void clickSubmit() {
		safetyClick(btnSubmit, 1)
		WebUI.takeScreenshot()
	}
}
