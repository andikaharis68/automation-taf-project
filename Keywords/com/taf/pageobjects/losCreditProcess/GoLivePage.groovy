package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.SimpleDateFormat

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

public class GoLivePage extends BaseHelper {
	private TestObject txfApplicationNo			= createTestObject("txfApplicationNo","id", "ucSearch_txtAppNo_ltlAppAppNo")
	private TestObject txfAgreementNo			= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	
	//Golive Grid
	private TestObject txtApplicationNoLink		= createTestObject("txtApplicationNoLink", "id", "gvGoLive_lblAppNo_0")
	private TestObject txtAgreementNoLink		= createTestObject("txtAgreementNoLink", "id", "gvGoLive_lbAgrmntNo_0")
	private TestObject btnEntry					= createTestObject("btnEntry", "id", "gvGoLive_ibGoLive_0")
	
	//Go live
	private TestObject lblBussinessDate			= createTestObject("lblBussinessDate", "id", "ltlBusinessDate")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject txfAgreementDate			= createTestObject("txfAgreementDate", "id", "ucAgrmntDt_txtDatePicker")
	
	private TestObject lblErrorMessage			= createTestObject("lblErrorMessage", "xpath", "//*[@id='errorList' and contains(@style, 'block')]//option")

	
	private void verifyLandingInGoLive() {
		verifyLanding(btnSearch, "Go Live")
		WebUI.takeScreenshot()
	}
	
	private void inputApplicationNo(String applicationNo) {
		safetyInput(txfApplicationNo, applicationNo)
	}
	
	private void clickButtonSearch() {
		safetyClick(btnSearch)
	}
	
	private void selectApplicationNo() {
		WebUI.waitForElementPresent(btnEntry, 30)
		WebUI.takeScreenshot()
		safetyClick(btnEntry)
	}
	
	private String getBussinessDate() {
		WebUI.switchToDefaultContent()
		String bussinessDate = WebUI.getText(lblBussinessDate)
		SimpleDateFormat inputFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.ENGLISH)
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy")
		
		// Parsing dan konversi
		Date date = inputFormat.parse(bussinessDate)
		String formattedDate = outputFormat.format(date)
		return formattedDate
	}
	
	private void inputAgreementDate(String formattedDate) {
		WebUI.takeScreenshot()
		safetyInput(txfAgreementDate, formattedDate)
	}
	
	private void clickButtonSubmit() {
		WebUI.takeScreenshot()
		safetyClick(btnSubmit)
	}
	
	private void verifySuccessGoLive() {
		WebUI.verifyElementPresent(btnSearch, 10)
		WebUI.takeScreenshot()
	}
}
