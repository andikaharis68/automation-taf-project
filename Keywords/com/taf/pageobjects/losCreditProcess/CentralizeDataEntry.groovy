package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

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

public class CentralizeDataEntry extends BaseHelper {
	//iFrame
	private TestObject iframeMainpage 				= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	private TestObject txfSearchCustomerName 		= createTestObject("txfSearchCustomerName", "id", "ucSearch_txtCustName_ltlProspectCustName")
	private TestObject btnSearch 					= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnIconActionProspect 		= createTestObject("btnIconActionProspect", "id", "gvProspectTeleDataEntry_imbEdit_0")
	private TestObject btnMatchingCustomer 			= createTestObject("btnMatchingCustomer", "id", "lb_Toolbar_Matching")
	private TestObject lblCustomerType  			= createTestObject("lblCustomerType", "id", "lblCustType")
	private TestObject txfCustomerName 				= createTestObject("txfCustomerName", "id", "txtCustName")
	private TestObject txfBirthPlace 				= createTestObject("txfBirthPlace", "id", "txtBirthPlace")
	private TestObject txfBirthDate 				= createTestObject("txfBirthDate", "id", "ucBirthDt_txtDatePicker")
	private TestObject txfIdNo 						= createTestObject("txfIdNo", "id", "txtIdNo")
	private TestObject drpCompanyType 				= createTestObject("drpCompanyType", "id", "ucMrCoyType_ddlReference")
	private TestObject lblSuccessMessage 			= createTestObject("lblSuccessMessage", "xpath", "//p[@id ='messageContent' and contains(text(), 'Save Success')]")

	public void switchToMainPage() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainpage, 2)
	}

	public void searchCustomerName(String customerName) {
		retrySearchCustomer(customerName, txfCustomerName, btnSearch, btnIconActionProspect)
	}

	public void selectProspect() {
		WebUI.waitForElementPresent(btnIconActionProspect, 10)
		WebUI.takeScreenshot()
		WebUI.click(btnIconActionProspect)
		WebUI.delay(2)
	}
	
	public Boolean checkIsSearchResultFound() {
		if (WebUI.waitForElementPresent(btnIconActionProspect, 5, FailureHandling.OPTIONAL)) {
			return true
		}else {
			return false
		}
	}
	
	public void delay() {
		WebUI.delay(GlobalVariable.WAIT)
		KeywordUtil.logInfo("Already Delay ${GlobalVariable.WAIT} seconds, and ready to search again!")
	}
	

	public String checkCustomerType() {
		WebUI.waitForElementPresent(lblCustomerType, 10)
		String customerType = WebUI.getText(lblCustomerType)
		return customerType
	}
	
	public void inputCustomerMainData(String customerName, String birthPlace, String birthDate, String idNumber) {
		WebUI.takeScreenshot()		
		safetyInput(txfCustomerName, customerName)
		safetyInput(txfBirthPlace, birthPlace)
		safetyInput(txfBirthDate, birthDate)
		KeywordUtil.logInfo("1")
		WebUI.sendKeys(txfBirthDate, Keys.chord(Keys.ENTER))
		if(idNumber == "AUTO") {
			idNumber = generateRandomNik()
		}
		safetyInput(txfIdNo, idNumber)
		WebUI.sendKeys(txfBirthDate, Keys.chord(Keys.ENTER))
	}
	
	public void inputCustomerMainDataCompany(String customerModel, String CompanyType) {
		WebUI.takeScreenshot()
		TestObject rbtCustomerModel = createTestObject("rbtCustomerModel", "text", customerModel)
		WebUI.waitForElementPresent(rbtCustomerModel, 10)
		safetyClick(rbtCustomerModel)
		safetySelect(drpCompanyType, CompanyType)
	}

	public void clickButtonMatchingCustomer() {
		handlePopupAlert()
		WebUI.click(btnMatchingCustomer)
		WebUI.takeScreenshot()
		WebUI.delay(10)
	}

	public void verifySuccessMessage() {
		WebUI.verifyElementPresent(btnSearch, 20)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}
}
