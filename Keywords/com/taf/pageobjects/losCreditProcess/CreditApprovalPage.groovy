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

public class CreditApprovalPage extends BaseHelper{
	//header
	private TestObject btnSubmit 				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	//approval request
	private TestObject txfCustomerIncome 		= createTestObject("txfCustomerIncome", "id", "ucCustIncome_txtInput")
	private TestObject txfSpouseIncome 			= createTestObject("txfSpouseIncome", "id", "ucSpouseIncomeApp_txtInput")
	private TestObject txfAdditionalIncome 		= createTestObject("txfAdditionalIncome", "id", "ucAdditionalIncome_txtInput")
	private TestObject btnCalculate 			= createTestObject("btnCalculate", "id", "lb_Form_CalcInstRatio")
	//approval recommendation
	private TestObject txfLatarBelakang 		= createTestObject("txfLatarBelakang", "id", "rptApvRcmndtn_txtRcmndtnValue_0")
	private TestObject txfFaktorMendukung 		= createTestObject("txfFaktorMendukung", "id", "rptApvRcmndtn_txtRcmndtnValue_1")
	private TestObject txfFaktorTidakMendukung 	= createTestObject("txfFaktorTidakMendukung", "id", "rptApvRcmndtn_txtRcmndtnValue_2")
	private TestObject txfSyarat 				= createTestObject("txfSyarat", "id", "rptApvRcmndtn_txtRcmndtnValue_3")
	private TestObject txfCaCalculation 		= createTestObject("txfCaCalculation", "id", "rptApvRcmndtn_txtRcmndtnValue_4")
	//approval action
	private TestObject drpAction 				= createTestObject("drpAction", "id", "ddlAction")
	private TestObject txfNotes 				= createTestObject("txfNotes", "id", "txtNotes")

	public void verifyLandingScreen() {
		verifyLanding(txfCustomerIncome, "Credit Approval")
		WebUI.takeScreenshot()
	}

	public void inputApprovalRequestSection(String customerIncome, String spouseIncome, String additionalIncome) {
		manualClearText(txfCustomerIncome)
		safetyInput(txfCustomerIncome, customerIncome)
		
		manualClearText(txfSpouseIncome)
		safetyInput(txfSpouseIncome, spouseIncome)
		
		manualClearText(txfAdditionalIncome)
		safetyInput(txfAdditionalIncome, additionalIncome)
	}
	
	public void clickCalculate() {
		safetyClick(btnCalculate)
		WebUI.takeScreenshot()
	}

	public void inputApprovalRecommendationSection(String latarBelakang, String faktorMendukung, String faktorTidakMendukung, String syarat, String caCalculation) {
		safetyInput(txfLatarBelakang, latarBelakang)
		safetyInput(txfFaktorMendukung, faktorMendukung)
		safetyInput(txfFaktorTidakMendukung, faktorTidakMendukung)
		safetyInput(txfSyarat, syarat)
		safetyInput(txfCaCalculation, caCalculation)
		WebUI.takeScreenshot()
	}

	public void inputApprovalAction(String action, String notes) {
		safetySelect(drpAction, action)
		safetyInput(txfNotes, notes)
		WebUI.takeScreenshot()
	}

	public void clickSubmit() {
		safetyClick(btnSubmit)
		WebUI.takeScreenshot()
	}
}
