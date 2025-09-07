package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.joda.time.chrono.IslamicChronology
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class InsuranceDataPage extends BaseHelper {

	private TestObject lblSection			= createTestObject("lblSection", "id", "ucIGridSection_subSectionID")
	private TestObject btnCopyToAll			= createTestObject("btnCopyToAll","id","lb_Form_CopyToAll")
	private TestObject btnCopySelected		= createTestObject("btnCopySelected","id","lb_Form_DeleteSelected")
	private TestObject btnEdit				= createTestObject("btnEdit","id","gvEntryIns_imbEdit_0")
	private TestObject btnNext				= createTestObject("btnNext","id","lb_Toolbar_Next")
	private TestObject btnCancel			= createTestObject("btnCancel","id","lb_Toolbar_Cancel")
	private TestObject drpSchemeName		= createTestObject("drpSchemeName", "id", "ucInsInit_ucRefInsSchmName_ddlReference")
	private TestObject drpRateType			= createTestObject("drpRateType", "id", "ucInsInit_ucRefInsRateType_ddlReference")
	private TestObject drpMainCoverageType	= createTestObject("drpMainCoverageType", "id", "ucRefMainCvgType_ddlReference")
	private TestObject btnCalculate			= createTestObject("btnCalculate", "id", "ucInsrate_lb_Form_Calculate")
	private TestObject btnSave				= createTestObject("btnSave", "id", "lb_Toolbar_Save")
	private TestObject btnSaveContinue		= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont")
	private TestObject btnNextToSaveContinue= createTestObject("btnNextToSaveContinue", "id", "lb_Form_Next")

	private TestObject txfInscoBranchName	= createTestObject("txfInscoBranchName", "id", "ucInsInit_txtInscoBranchNameInsInitCust")
	private TestObject txfPolicyName		= createTestObject("txfPolicyName", "id", "ucInsInit_txtPolicyName")
	private TestObject txfStartDate			= createTestObject("txfStartDate", "id", "ucInsInit_ucDPCustCoverStartDt_txtDatePicker")
	private TestObject txfInsuranceNotes	= createTestObject("txfInsuranceNotes", "id", "ucInsInit_txtNotes")
	private TestObject txfPolicyNo			= createTestObject("txfPolicyNo", "id", "ucInsInit_txtPolicyNo")
	private TestObject txfCoverageAmount	= createTestObject("txfCoverageAmount", "id", "ucInsInit_ucINInsCvgAmt_txtInput")
	private TestObject txfEndDate			= createTestObject("txfEndDate", "id", "ucInsInit_ucDPCustCoverEndDt_txtDatePicker")
	private TestObject txfInsuranceLength	= createTestObject("txfInsuranceLength", "id", "ucInsInit_ucINInsLength_txtInput")


	private void verifyLandingInInsuranceData() {
		verifyLanding(lblSection, "Insurance Data")
		WebUI.takeScreenshot()
	}
	private void clickEdit() {
		safetyClick(btnEdit)
		WebUI.takeScreenshot()
	}

	private void clickNext() {
		WebUI.takeScreenshot()
		safetyClick(btnNext)
		WebUI.delay(1)
	}

	private void selectSchemeName(String schemeName) {
		boolean isElementEnabled  = WebUI.verifyElementPresent(drpSchemeName, 3, OPTIONAL)
		if(schemeName && isElementEnabled) {
			safetySelect(drpSchemeName, schemeName)
		}
	}

	private void selectRateType(String rateType) {
		boolean isElementEnabled  = WebUI.verifyElementPresent(drpRateType, 3, OPTIONAL)
		if(rateType && isElementEnabled) {
			safetySelect(drpRateType, rateType)
		}
	}

	private void selectMainCoverageType(String mainCoverageType) {
		boolean isElementEnabled  = WebUI.verifyElementPresent(drpMainCoverageType, 3, OPTIONAL)
		if(mainCoverageType && isElementEnabled) {
			safetySelect(drpMainCoverageType, mainCoverageType)
		}
		WebUI.takeScreenshot()
	}
	private void clickCalculate() {
		WebUI.scrollToElement(btnCalculate, 5)
		safetyClick(btnCalculate)
		WebUI.takeScreenshot()
	}
	private void clickSave() {
		WebUI.scrollToElement(btnSave, 5)
		safetyClick(btnSave)
		handleAlertIfPresent()
		if(WebUI.verifyElementPresent(btnSave, 2, OPTIONAL)) {
			safetyClick(btnSave)
		}
		WebUI.takeScreenshot()
	}

	private void clickSaveAfterCalculate() {
		TestObject btnSave = createTestObject("btnSave", "id","lbSave" )
		WebUI.scrollToElement(btnSave, 5)
		safetyClick(btnSave)
		handleAlertIfPresent()
		if(WebUI.verifyElementPresent(btnSave, 2, OPTIONAL)) {
			safetyClick(btnSave)
		}
		WebUI.takeScreenshot()
	}
	private void clickSaveAndContinue() {
		safetyClick(btnSaveContinue)
	}
	private void clickNextToSaveAndContinue() {
		safetyClick(btnNextToSaveContinue)
		WebUI.takeScreenshot()
	}
	
	private String selectInsuredBy(String insuredBy) {
		if (!insuredBy) return getSelectedRadioLabel()
		TestObject radioOption = createTestObject("radioOption", "xpath", "//label[normalize-space(text())='${insuredBy}']/preceding-sibling::input[@type='radio']")
		// Try to click if not disabled
		if(!checkOptionDisabled(radioOption)) {
			safetyClick(radioOption)
			WebUI.delay(1)
			return insuredBy
		}
		// Fallback: get currently selected label
		return getSelectedRadioLabel()
	}
	
	private boolean isInsuredByOptionDisabled(String insuredBy) {
		TestObject radioOption = createTestObject("radioOption", "xpath", "//label[normalize-space(text())='${insuredBy}']/preceding-sibling::input[@type='radio']")
		return checkOptionDisabled(radioOption)
	}
	
	private String getSelectedRadioLabel() {
		TestObject radios = createTestObject("radios", "xpath", "//input[contains(@id,'ucInsInit_rblInsAssetCoveredBy_')]")
		List<WebElement> radioList = WebUI.findWebElements(radios, 5)
		for (WebElement radio : radioList) {
			if (radio.isSelected()) {
				String id = radio.getAttribute("id")
				TestObject labelObj = new TestObject("labelForRadio")
				labelObj.addProperty("xpath", ConditionType.EQUALS, "//label[@for='${id}']")
				String labelText = WebUI.getText(labelObj)
				KeywordUtil.logInfo("Insured by " + labelText + ".")
				return labelText
			}
		}
		return "Not found checked"
	}


	private void selectCoverPeriod(String coverPeriod) {
		TestObject radCoverPeriod = createTestObject("radCoverPeriod","xpath","//label[normalize-space(text())='${coverPeriod}']/preceding-sibling::input[@type='radio']")
		boolean isElementEnabled  = WebUI.verifyElementPresent(radCoverPeriod, 3, OPTIONAL)
		if(coverPeriod?.trim() && isElementEnabled) {
			safetyClick(radCoverPeriod)
		}
	}

	private void inputInsuranceDataInitCustomer(String inscoBranchName,
			String policyName, String startDate, String insuranceNote, String policyNo, String coverageAmount, String endDate) {

		WebUI.comment("Input data initialization insured by Customer.")
		inputInscoBranchName(inscoBranchName)
		inputPolicyName(policyName)
		inputStartDate(startDate)
		inputInsuranceNotes(insuranceNote)
		inputPolicyNo(policyNo)
		inputCoverageAmount(coverageAmount)
		inputEndDate(endDate)
		WebUI.takeScreenshot()
	}

	private void inputInsuranceOtherDataInitCompany(String schemeName, String rateType, String main,String coverPeriod, String length) {
		WebUI.comment("Input data initialization insured by Company.")
		selectSchemeName(schemeName)
		selectRateType(rateType)
		selectMainCoverageType(main)
		selectCoverPeriod(coverPeriod)
		inputInsuranceLength(length)
		WebUI.takeScreenshot()
	}



	private void inputInsuranceNotes(String notes) {
		boolean isElementEnabled = WebUI.verifyElementPresent(txfInsuranceNotes, 3, OPTIONAL)
		if(notes?.trim() && isElementEnabled) {
			safetyInput(txfInsuranceNotes, notes)
		}
	}

	private void inputInscoBranchName(String name) {
		boolean isElementEnabled = WebUI.verifyElementPresent(txfInscoBranchName, 3, OPTIONAL)
		if(name && isElementEnabled) {
			safetyInput(txfInscoBranchName, name)
			WebUI.delay(1)
		}
	}
	private void inputPolicyName(String name) {
		boolean isElementEnabled = WebUI.verifyElementPresent(txfPolicyName, 3, OPTIONAL)
		if(name && isElementEnabled) {
			safetyInput(txfPolicyName, name)
		}
	}

	private void inputStartDate(String date) {
		boolean isElementEnabled = WebUI.verifyElementPresent(txfStartDate, 3, OPTIONAL)
		if(date && isElementEnabled) {
			WebUI.scrollToElement(txfStartDate, 1)
			safetyInput(txfStartDate, date)
			clickEnter(txfStartDate)
			WebUI.delay(1)
		}
	}

	private void inputPolicyNo(String policyNo) {
		boolean isElementEnabled = WebUI.verifyElementPresent(txfPolicyNo, 3, OPTIONAL)
		if(policyNo && isElementEnabled) {
			safetyInput(txfPolicyNo, policyNo)
			WebUI.delay(1)
		}
	}
	private void inputCoverageAmount(String amount) {
		boolean isElementEnabled = WebUI.verifyElementPresent(txfCoverageAmount, 3, OPTIONAL)
		if(amount && isElementEnabled) {
			manualClearText(txfCoverageAmount)
			safetyInput(txfCoverageAmount, amount)
			WebUI.delay(1)
		}
	}

	private void inputEndDate(String date) {
		boolean isElementEnabled = WebUI.verifyElementPresent(txfEndDate, 3, OPTIONAL)
		if(date && isElementEnabled) {
			WebUI.scrollToElement(txfEndDate, 1)
			safetyInput(txfEndDate, date)
			clickTABKeyboard(txfEndDate)
			WebUI.delay(1)
		}
	}

	private void inputDataInitializationPersonal(String schemeName, String coverPeriod, String rateType) {
		selectSchemeName(schemeName)
		selectCoverPeriod(coverPeriod)
		selectRateType(rateType)
		WebUI.delay(1)
	}
	private void inputInsuranceLength(String length) {
		boolean isDisabled = checkOptionDisabled(txfInsuranceLength)
		if(length?.trim() && !isDisabled) {
			safetyInput(txfInsuranceLength, length)
		}
	}
}
