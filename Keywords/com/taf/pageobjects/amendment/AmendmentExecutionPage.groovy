package com.taf.pageobjects.amendment

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

public class AmendmentExecutionPage extends BaseHelper{

	private TestObject drpAmendmentType = createTestObject("drpAmendmentType", "xpath", "//select[@id = 'ucrefAmendmentType_ddlReference']")
	private TestObject txtCustomerName	= createTestObject("txtCustomerName", "xpath", "//input[@id = 'ucSearch_txtCustName_ltlCustCustNameSearch']")
	private TestObject txtAgreementNo	= createTestObject("txtAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject btnSearch		= createTestObject("btnSearch", "xpath", "//input[@id = 'ucSearch_btnSearch']")
	private TestObject iframeMain		= createTestObject("iframeMain", "id", "mainPage")


	public void switchMain() {
		WebUI.switchToFrame(iframeMain, 3)
	}
	
	public void searchAmendment(String amendmentType, String agreementNo, String customerName) {

		safetySelect(drpAmendmentType, amendmentType, 2)
		safetyInputEdit(txtAgreementNo, agreementNo, 1)
		safetyInputEdit(txtCustomerName, customerName, 1)
		WebUI.click(btnSearch)
		WebUI.takeScreenshot()

		clickPenAction(customerName)
	}

	private void clickPenAction(String agreementNo) {

		TestObject btnPenAction		= createTestObject("btnPenAction", "id", "gvAgrmnt_imbEdit_0")
	}
}
