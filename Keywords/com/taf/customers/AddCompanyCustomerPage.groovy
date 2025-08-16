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

	private void selectCustomerModel(String customerModel) {
		def radCustomerModel = createTestObject("radCustomerModel", "xpath", "//*[starts-with(@id, 'rblCustModel_') and normalize-space(text())='$customerModel']")
		if(radCustomerModel) {
			WebUI.click(radCustomerModel)
		} else {
			KeywordUtil.logInfo("not found the test object")
		}
	}

	private void inputCustomerName(String customerName) {
		WebUI.setText(txfCustomerName, customerName)
	}

	private void inputCustomerNPWP(String customerNPWP) {
		WebUI.setText(txtfCustomerNPWP, customerNPWP)
	}

	private void inputCustomerNitku(String customerNitku) {
		WebUI.setText(txfCustomerName, customerNitku)
	}

	private void selectCompanyType(String companyType) {
		WebUI.setText(drpIDCompanyType, companyType)
	}

	private void clickNextButton() {
		WebUI.click(btnNext)
	}
}
