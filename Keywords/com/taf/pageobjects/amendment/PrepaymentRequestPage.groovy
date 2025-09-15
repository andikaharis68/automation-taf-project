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

public class PrepaymentRequestPage extends BaseHelper{

	private TestObject txtDate				= createTestObject("txtDate", "xpath", "//input[@id = 'ucDpEffectiveDt_txtDatePicker']")
	private TestObject btnCalculatePayment	= createTestObject("btnCalculatePayment", "xpath", "//input[@id = 'lbCalPrepaymet']")
	private TestObject drpReasonDescription	= createTestObject("drpReasonDescription", "xpath", "//select[@id = 'ucApproval_ddlReason']")
	private TestObject drpApprovedBy		= createTestObject("drpApprovedBy", "xpath", "//select[@id = 'ucApproval_ddlApvBy']")
	private TestObject txtNotes				= createTestObject("txtNotes", "xpath", "//textarea[@id = 'ucApproval_txtNotes']")
	private TestObject btnSubmit			= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject lblNotification		= createTestObject("lblNotification", "xpath", "//p[@id = 'messageContent']")
	private TestObject lblBalanceAmount		= createTestObject("lblBalanceAmount", "xpath", "")


	public void calculatePayment(String date) {

		WebUI.setText(txtDate, date)
		WebUI.click(btnCalculatePayment)
	}

	public void approve(String reasonDescription, String approver, String notes) {

		WebUI.selectOptionByLabel(drpReasonDescription, reasonDescription, false)
		WebUI.selectOptionByLabel(drpApprovedBy, approver, false)
		WebUI.setText(txtNotes, notes)
	}
	
	public String getBalance() {
		return WebUI.getText(lblBalanceAmount)
	}

	public void clickSubmit() {

		WebUI.click(btnSubmit)
		WebUI.verifyElementPresent(lblNotification, 5)
	}
}
