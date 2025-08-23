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

public class InsuranceDataPage extends BaseHelper {
	
	private TestObject btnCopyToAll			= createTestObject("btnCopyToAll","id","lb_Form_CopyToAll") 
	private TestObject btnCopySelected		= createTestObject("btnCopySelected","id","lb_Form_DeleteSelected") 
	private TestObject btnEdit				= createTestObject("btnEdit","id","gvEntryIns_imbEdit_0") 
	private TestObject btnNext				= createTestObject("btnNext","id","lb_Toolbar_Next")
	private TestObject btnCancel			= createTestObject("btnCancel","id","lb_Toolbar_Cancel") 
	private TestObject drpSchemeName		= createTestObject("drpSchemeName", "id", "ucInsInit_ucRefInsSchmName_ddlReference") 
	private TestObject drpRateType			= createTestObject("drpRateType", "id", "ucInsInit_ucRefInsRateType_ddlReference")
	private TestObject drpMainCoverageType	= createTestObject("drpMainCoverageType", "id", "ucRefMainCvgType_ddlReference") 
	private TestObject btnCalculate			= createTestObject("btnCalculate", "id", "ucInsrate_lb_Form_Calculate")
	private TestObject btnSave				= createTestObject("btnSave", "id", "lbSave")
	private TestObject btnSaveContinue		= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont") 
	private TestObject btnNextToSaveContinue= createTestObject("btnNextToSaveContinue", "id", "lb_Form_Next")
	
	private void verifyLandingInInsuranceData() {
		verifyLanding(btnCopyToAll, "Insurance Data")
		WebUI.takeScreenshot()
	}
	private void clickEdit() {
		safetyClick(btnEdit)
		WebUI.takeScreenshot()
	}
	
	private void clickNext() {
		WebUI.takeScreenshot()
		WebUI.click(btnNext)
		WebUI.delay(1)
	}
	
	private void selectSchemeName(String schemeName) {
		safetySelect(drpSchemeName, schemeName)
	}
	
	private void selectRateType(String rateType) {
		safetySelect(drpRateType, rateType)
	}
	
	private void selectMainCoverageType(String mainCoverageType) {
		safetySelect(drpMainCoverageType, mainCoverageType)
		WebUI.takeScreenshot()
	}
	private void clickCalculate() {
		safetyClick(btnCalculate)
	}
	private void clickSave() {
		safetyClick(btnSave)
		WebUI.takeScreenshot()
	}
	private void clickSaveAndContinue() {
		safetyClick(btnSaveContinue)
	}
	private void clickNextToSaveAndContinue() {
		safetyClick(btnNextToSaveContinue)
		WebUI.takeScreenshot()
	}
}
