package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

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

public class SurveyTaskAssignment extends BaseHelper{

	private TestObject txfReffNo	= createTestObject("txfReffNo", "id", "ucSearch_txtTrxRefNo_ltlSrvyTaskRefNoSch")
	private TestObject btnSearch	= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	private TestObject lblTitle		= createTestObject("lblTitle", "id", "pageTitle")
	private TestObject iframeMain	= createTestObject("iframeMain", "id", "mainPage")


	private void verifyLandingSurveyPage() {
		WebUI.switchToFrame(iframeMain, 3)
		verifyLanding(lblTitle, 'Survey Task Assignment')
		WebUI.takeScreenshot()
	}

	private void searchTransactionByReferenceNumber(String reffNo) {
		safetyInput(txfReffNo, reffNo)
		safetyClick(btnSearch)
	}

	private void editTransaction(String reffNo) {
		TestObject rowExist = createTestObject("rowExist", "xpath", "//a[text() = '$reffNo']")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)

		if(rowExist) {
			TestObject btnPenEdit = createTestObject("btnPenEdit", "xpath", "${getXpath(rowExist)}/following::td[7]//input")
			WebUI.takeScreenshot()
			safetyClick(btnPenEdit)
		}else {
			KeywordUtil.markFailedAndStop("reff no not exist $reffNo")
		}
	}

	private void cancelAllTask() {
		WebUI.delay(2)
		def cancel = getListElementByTestObject("//input[@title = 'Cancel']") //digunakan untuk mendapatkan semua btn cancel
		def countCancel = cancel.size()
		TestObject btnCancel = createTestObject("btnCancel", "xpath", "(//input[@title = 'Cancel'])[1]")
		countCancel.times {
			WebUI.click(btnCancel)
			WebUI.delay(2)
			WebUI.acceptAlert()
			WebUI.delay(2)
			WebUI.takeScreenshot()
		}
	}
}
