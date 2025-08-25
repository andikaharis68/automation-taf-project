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

public class AgreementTransferRequestPage extends BaseHelper{

	private TestObject btnNext					= createTestObject("btnNext", "xpath", "")
	private TestObject sectionAgreementTransfer	= createTestObject("sectionAgreementTransfer", "xpath", "")
	private TestObject icnSearch				= createTestObject("icnSearch", "xpath", "")

	//pop up section
	private TestObject txtCustomerName			= createTestObject("txtCustomerName", "xpath", "")
	private TestObject btnSearch				= createTestObject("btnSearch", "xpath", "")


	private TestObject btnRequestSurvey1		= createTestObject("btnRequestSurvey1", "xpath", "")
	private TestObject btnRequestSurvey2		= createTestObject("btnRequestSurvey2", "xpath", "")

	//select all checkBox yes
	private TestObject btnSave					= createTestObject("btnSave", "xpath", "")
	private TestObject lblNotification			= createTestObject("lblNotification", "xpath", "")

	//section approval request
	private TestObject sectionApprovalRequest	= createTestObject("sectionApprovalRequest", "xpath", "")
	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "xpath", "")
	private TestObject drpApprover				= createTestObject("drpApprover", "xpath", "")
	private TestObject txtNotes					= createTestObject("txtNotes", "xpath", "")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "xpath", "")


	public void clickButtonNext() {
		WebUI.click(btnNext)
	}

	public void expandAgreement(String custName, String custNo) {
		WebUI.click(sectionAgreementTransfer)
		WebUI.click(icnSearch)
		WebUI.setText(txtCustomerName, custName)
		WebUI.click(btnSearch)
		//select button based on customer name and customer no
		TestObject btnSelect 				= createTestObject("btnSelect", "xpath", "")
	}

	public void saveAgreement() {
		WebUI.click(btnRequestSurvey1)
		WebUI.click(btnRequestSurvey2)
		//looping to click checkbox
		TestObject chkBox 					= createTestObject("chkBox", "xpath", "")
		WebUI.check(chkBox)

		WebUI.click(btnSave)
		WebUI.verifyElementVisible(lblNotification)
	}

	public void approval(String note, String reason, String approver) {

		WebUI.click(sectionApprovalRequest)
		WebUI.selectOptionByLabel(drpReasonDescription, reason, false)
		WebUI.selectOptionByLabel(drpApprover, approver, false)
		WebUI.setText(txtNotes, note)
		WebUI.click(btnSubmit)
	}
}
