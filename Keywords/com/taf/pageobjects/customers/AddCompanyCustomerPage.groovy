package com.taf.pageobjects.customers

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

public class AddCompanyCustomerPage extends BaseHelper {

	private TestObject txfCustomerName				= createTestObject("txfCustomerName", "xpath", "//*[@id='ucCustMainInfo_txt_Cust_CustName']")
	private TestObject drpIDCompanyType				= createTestObject("drpIDCompanyType", "xpath", "//*[@id='ucCustMainInfo_ucRefMrCoyType_ddlReference']")
	private TestObject txtfCustomerNPWP 			= createTestObject("txtfCustomerNPWP", "xpath", "//*[@id='ucCustMainInfo_txt_Cust_Npwp']")
	private TestObject txtfCustomerNitku 			= createTestObject("txtfCustomerNitku", "xpath", "//*[@id='ucCustMainInfo_txt_CustCoy_Nitku']")
	private TestObject btnNext						= createTestObject("btnNext", "xpath", "//*[@id='lb_Toolbar_Next']")
	private TestObject btnNewApplication			= createTestObject("btnNewApplication", "xpath", "//*[@id='lb_Form_NewCust']")


	private void selectCustomerModel(String model) {
		if (model?.trim()) {
			TestObject radCustomerModel = createTestObject("radCustomerModel","xpath",	"//label[normalize-space(text())='${model}']/preceding-sibling::input[@type='radio']")
			if (!WebUI.verifyElementChecked(radCustomerModel, 1, FailureHandling.OPTIONAL)) {
				safetyClick(radCustomerModel)
			}
		}
	}

	private void inputCustomerName(String customerName) {
		safetyInput(txfCustomerName, customerName)
	}

	private void inputCustomerNPWP() {
		String randomNPWP = generateRandomNPWP()
		KeywordUtil.logInfo("NPWP : $randomNPWP")
		safetyInput(txtfCustomerNPWP, randomNPWP)
	}

	private void inputCustomerNitku(String customerNitku) {
		safetyInput(txtfCustomerNitku, customerNitku)
	}

	private void selectCompanyType(String companyType) {
		safetySelect(drpIDCompanyType, companyType)
	}

	private void clickNextButton() {
		safetyClick(btnNext)
	}
	private void clickNewApplicationIfPresent() {
		if(WebUI.verifyElementPresent(btnNewApplication, 2, FailureHandling.OPTIONAL)) {
			safetyClick(btnNewApplication)
		} else {
			KeywordUtil.logInfo("button new application not present")
		}
	}
}
