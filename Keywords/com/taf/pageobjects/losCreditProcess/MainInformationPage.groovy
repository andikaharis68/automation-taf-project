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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class MainInformationPage extends BaseHelper {
	
	private TestObject btnNext				= createTestObject("btnNext", "text", "Next")
	private TestObject btnCancel			= createTestObject("btnCancel", "text", "Cancel")
	
	private TestObject txfPreviousAppNo		= createTestObject("txfPreviousAppNo", "xpath", "//*[@id='cLookupPrevApp_uclPrevApp_txt']") 
	private TestObject btnSearcPreviousAppNo= createTestObject("txfPreviousAppNo", "id", "ucLookupPrevApp_uclPrevApp_imb")
	private TestObject txfProdOfferingName	= createTestObject("txfProdOfferingName", "xpath", "//*[@id='ucLookupProdOffer_uclProductOffering_txt']") 
	private TestObject btnSearchProdName	= createTestObject("btnSearchProdName", "xpath", "//*[@id='ucLookupProdOffer_uclProductOffering_imb']")  
	private TestObject txtCurrency			= createTestObject("txtCurrency", "id", "lblCurr")
	private TestObject txfNumOfAsset		= createTestObject("txfNumOfAsset", "id", "ucINNumOfAsset_txtInput") 
	
	private TestObject txfOvlyAppNumber		= createTestObject("txfOvlyAppNumber","xpath","[contains(@id, 'txtSearchValue_0')]") 
	private TestObject btnOvlySearchAppNo	= createTestObject("btnOvlySearchAppNo", "xpath", "//*[@id='ucLookupPrevApp_uclPrevApp_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlySelect		= createTestObject("btnOvlySelect", "xpath", "[contains(@id, 'hpSelect_0')]")
	
	//sementara di gabung sini dulu main info page
	private TestObject txtCustomerName		= createTestObject("txtCustomerName", "xpath", "//*[@id='ucCreditProcessMainInfo_lbCustName']")
	private TestObject btnSaveContinue		= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont")
	private TestObject btnSaveApplication	= createTestObject("btnSaveApplication", "id", "lbl_Toolbar_Save") 
	private TestObject btnSubmit			= createTestObject("btnSubmit", "id", "lbl_Toolbar_Submit")
	private TestObject btnCancelApp			= createTestObject("btnCancelApp", "id", "lb_Toolbar_Cancel") 
	
	
	private void verifyLandingInMainPage() {
		verifyLanding(txfPreviousAppNo, "Main Information Page")
		WebUI.takeScreenshot()
	}
	
	private void clickNext() {
		safetyClick(btnNext)
		WebUI.takeScreenshot()
	}
	
	private void clickCancel() {
		safetyClick(btnCancel)
	}
	
	private void inputPreviousAppNo(String previousAppNo) {
		if(previousAppNo) {
			safetyClick(btnSearcPreviousAppNo)
			safetyInput(txfOvlyAppNumber, previousAppNo)
			safetyClick(btnOvlySearchAppNo)
			safetyClick(btnOvlySelect)
		}
	}
	private void clickSaveContinue() {
		safetyClick(btnSaveContinue)
	}
	private void verifyCustomername(String name) {
		WebUI.verifyElementText(WebUI.getText(txtCustomerName), name)
	}
}
