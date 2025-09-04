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

public class LifeInsuranceDataPage extends BaseHelper {

	private TestObject lblSection			= createTestObject("lblSection", "xpath", "//*[@id='ucToggleLifeInsInfo_subSectionID']")
	private TestObject btnSaveContinue		= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont")
	private TestObject cbIsCoveredInsurance	= createTestObject("cbIsCoveredInsurance", "id", "cbIsCoverLifeIns")
	private TestObject drpLifeInscoBranch	= createTestObject("drpLifeInscoBranch", "id", "ddlLifeInscoName")
	private TestObject drpPremiumPayment	= createTestObject("drpPremiumPayment","id", "ddlPaymentMethod")
	private TestObject txfNotes				= createTestObject("txfNotes", "id", "txt_LifeInsH_NewCoverNotes")

	private void verifyLandingInLifeInsuranceData() {
		WebUI.delay(5)
		verifyLanding(lblSection, "Life Insurance")
		WebUI.takeScreenshot()
	}

	private void clickSaveAndContinue() {
		WebUI.delay(0.5)
		safetyClick(btnSaveContinue)
	}
	private void isCoveredInsurance(String isCoveredInsurance) {
		if(isCoveredInsurance?.trim().equalsIgnoreCase("Y") ) {
			WebUI.check(cbIsCoveredInsurance)
			WebUI.delay(1)
		}
	}
	private void selectLifeInscoBranchName(String branchName) {
		if(branchName) {
			safetySelect(drpLifeInscoBranch, branchName)
			WebUI.delay(1)
		}
	}
	private void selectCustomerInsured(String custInsured) {
		if(custInsured) {
			TestObject cbCustInsured = createTestObject("cbCustInsured","xpath","//label[normalize-space(text())='${custInsured}']/preceding-sibling::input[@type='checkbox']")
			String strChecked = WebUI.getAttribute(cbCustInsured, "checked")
			boolean isChecked = strChecked.toBoolean()
			if(!isChecked) {
				safetyClick(cbCustInsured)
				WebUI.delay(1)
			}
		}
	}
	private void selectPremiumPaymentMethod(String paymentMethod) {
		if(paymentMethod) {
			safetySelect(drpPremiumPayment, paymentMethod)
			WebUI.delay(1)
		}
	}
	private void inputNotes(String notes) {
		if(notes) {
			safetyInput(txfNotes, notes)
			WebUI.delay(1)
		}
	}
	private inputLifeInsuranceInfo(String isCOverInsurance, String branchName, String customerInsured, String premiumPayment, String notes) {
		boolean isOptionDisabled = checkOptionDisabled(cbIsCoveredInsurance)
		if(!isOptionDisabled) {
			isCoveredInsurance(isCOverInsurance)
			selectLifeInscoBranchName(branchName)
			selectCustomerInsured(customerInsured)
			selectPremiumPaymentMethod(premiumPayment)
			inputNotes(notes)
		}
	}
}
