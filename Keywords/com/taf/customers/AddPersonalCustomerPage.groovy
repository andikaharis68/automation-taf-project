package com.taf.customers

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

public class AddPersonalCustomerPage extends BaseHelper {

	private TestObject lblSection 			= createTestObject("lblSection", "xpath", "//*[@id='ucSubsection_subSectionID']")
	private TestObject radCustomerModel		= createTestObject("radCustomerModel", "xpath", "//*[@id='rblCustModel_0']")
	private TestObject txfCustomerName		= createTestObject("txfCustomerName", "xpath", "//input[@id='txtCustName']")
	private TestObject drpIDType			= createTestObject("drpIDType", "xpath", "//*[@id='ucId_ucRefCustIdType_ddlReference']")
	private TestObject txfIDNumber			= createTestObject("txfIDNumber", "xpath", "//input[@id='ucId_txtCustIdNo']")
	private TestObject txfIDExpiredDate		= createTestObject("txfIDExpiredDate", "xpath", "//input[@id='ucIdExpiredDt_txtDatePicker']")
	private TestObject radGender			= createTestObject("radGender", "xpath", "//*[@id='rblCustGender_0']")
	private TestObject txfPOB				= createTestObject("txfPOB", "xpath", "//input[@id='txtBirthPlace']")
	private TestObject txfDOB				= createTestObject("txfDOB", "xpath", "//*[@id='ucBirthDate_txtDatePicker']")
	private TestObject txfNPWP				= createTestObject("txfNPWP", "xpath", "//*[@id='txtNpwp']")
	private TestObject txfMotherMaidenName	= createTestObject("txfMotherMaidenName", "xpath", "//*[@id='txtMotherMaidenName']")

	private TestObject btnNext				= createTestObject("btnNext", "xpath", "//*[@id='lb_Toolbar_Next']")
	private TestObject btnCancel			= createTestObject("btnCancel", "xpath", "//*[@id='lb_Toolbar_Cancel']")
	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	private TestObject lblNewCustomer		= createTestObject("lblNewCustomer", "xpath", "//*[@id='lb_Form_NewCustomer']")



	private void verifyLandingAddPersonalPage() {
		verifyLanding(txfCustomerName, "Add Personal Customer")
	}

	private void inputCustomerName(String name) {
		WebUI.setText(txfCustomerName, name)
	}


	private void selectCustomerModel(String model) {
		radCustomerModel = createTestObject("radCustomerModel", "xpath", "//*[starts-with(@id, 'rblCustModel_') and normalize-space(text())='$model']")
		if(model != "Professional") {
			WebUI.click(radCustomerModel)
		}
	}


	private void selectIdType(String idType) {
		TestObject drpSelected = createTestObject("drpSelected", "xpath", "//*[normalize-space(text())='$idType']")
//		WebUI.click(drpIDType)
//		WebUI.click(drpSelected)
		WebUI.selectOptionByLabel(drpIDType, idType, false)
	}

	private void inputIdNumber(String idNumber) {
		WebUI.setText(txfIDNumber, idNumber)
	}

	private void inputIdExpiredDate(String idExpiredDate) {
		WebUI.sendKeys(txfIDExpiredDate, idExpiredDate)
		hideDatePicker(txfIDExpiredDate)
	}
	private void selectGender(String gender) {
		radGender = createTestObject("radGender", "xpath", "//*[normalize-space(text())='$gender']")
		WebUI.click(radGender)
	}

	private void hideDatePicker(TestObject to) {
		WebUI.sendKeys(to, '\uE004') // Unicode dari Keys.TAB
	
	}
	private void inputPOB(String pob) {
		WebUI.setText(txfPOB, pob)
	}

	private void inputDOB(String dob) {
		WebUI.sendKeys(txfDOB, dob)
		hideDatePicker(txfDOB)
	}

	private void inputNPWP(String npwp) {
		if(WebUI.getText(txfNPWP) != "") {
			WebUI.setText(txfNPWP, npwp)
		} else {
			KeywordUtil.logInfo("NPWP auto filled")
		}
	}

	private void inputMotherMaidenName(String motherMaidenName) {
		WebUI.setText(txfMotherMaidenName, motherMaidenName)
	}
	private void switchToIframeMain() {
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	private void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}
	private void clickNextButton() {
		WebUI.click(btnNext)
	}
	private clickNewCustomer() {
		if(WebUI.verifyElementPresent(lblNewCustomer, 5)) {
			WebUI.click(lblNewCustomer)
		}
	}
}