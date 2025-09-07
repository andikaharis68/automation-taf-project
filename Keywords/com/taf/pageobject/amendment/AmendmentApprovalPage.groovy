package com.taf.pageobject.amendment

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

public class AmendmentApprovalPage extends BaseHelper{

	private TestObject drpAmendmentType = createTestObject("drpAmendmentType", "xpath", "//select[@id = 'ucrefAmendmentType_ddlReference']")
	private TestObject txtCustomerName	= createTestObject("txtCustomerName", "xpath", "//input[@id = 'ucSearch_txtCustName_ltlCustCustName']")
	private TestObject btnSearch		= createTestObject("btnSearch", "xpath", "//input[@id = 'ucSearch_btnSearch']")
	private TestObject btnProcess		= createTestObject("btnProcess", "id", "gvTask_lbProcess_0")

	private TestObject txtAgreementNo	= createTestObject("txtAgreementNo", "xpath", "//input[@id = 'ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo']")
	private TestObject list				= createTestObject("list", "xpath", "")


	public void searchAmendmentbyCustName(String amendmentType, String customerName) {

		WebUI.selectOptionByLabel(drpAmendmentType, amendmentType, false)
		WebUI.setText(txtCustomerName, customerName)
		WebUI.click(btnSearch)
	}

	public void searchAmendmentbyAgreementNo(String amendmentType, String agreementNo) {

		safetySelect(drpAmendmentType, amendmentType, 1)
		safetyInput(txtAgreementNo, agreementNo)
		safetyClick(btnSearch, 2)
		WebUI.takeScreenshot()
		safetyClick(btnProcess, 10)
	}

	public void searchAmendmentbyCustName2(String amendmentType, String customerName) {

		safetySelect(drpAmendmentType, amendmentType, false)
		safetyInput(txtCustomerName, customerName)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
		safetyClick(btnProcess, 10)
	}
}
