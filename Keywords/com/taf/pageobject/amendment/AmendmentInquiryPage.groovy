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

public class AmendmentInquiryPage extends BaseHelper{

	private TestObject drpAmendmentType		= createTestObject("drpAmendmentType", "xpath", "//select[@id = 'ucSearch_ddlAmendmentTypeCode_ltlAmendmentTypeAmendmentTypeId_ddlReference']")
	private TestObject txtAgreementNumber	= createTestObject("txtAgreementNumber", "xpath", "//input[@id = 'ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch']")
	private TestObject btnSearch			= createTestObject("btnSearch", "xpath", "//input[@id = 'ucSearch_btnSearch']")
	private TestObject lblStatus			= createTestObject("lblStatus", "xpath", "//span[@id = 'gvPaging_lblStatus_0']")
	private TestObject lblReqNo				= createTestObject("lblReqNo", "id", "gvPaging_lbAmendmentNo_0")
	private TestObject lblRole				= createTestObject("lblRole", "id", "gvPrepayApvHist_lblApprovalNode_1")
	private TestObject lblUser				= createTestObject("lblUser", "id", "gvPrepayApvHist_lblApprovalTaskOwner_1")

	public searchAgreement(String amendmentType, String agreementNo) {

		WebUI.selectOptionByValue(drpAmendmentType, amendmentType, false)
		WebUI.setText(txtAgreementNumber, agreementNo)
		WebUI.click(btnSearch)

		//verify status or table
	}

	public String getRequestNumber() {
		return WebUI.getText(lblReqNo)
	}
	
	public void getTask() {
		WebUI.getText(lblRole)
		WebUI.getText(lblUser)
	}
	
	public void clickRequestNo() {
		safetyClick(lblReqNo, 3)
		WebUI.takeScreenshot()
	}
}

