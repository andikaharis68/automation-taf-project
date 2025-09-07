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

	private TestObject btnNext					= createTestObject("btnNext", "id", "lb_Toolbar_Next")
	private TestObject sectionAgreementTransfer	= createTestObject("sectionAgreementTransfer", "xpath", "//span[text() = 'AGREEMENT TRANSFER REQUEST']/preceding-sibling::a")
	private TestObject icnSearch				= createTestObject("icnSearch", "xpath", "//input[@id = 'uclCust_uclCust_imb']")

	//pop up section
	private TestObject txtCustomerName			= createTestObject("txtCustomerName", "xpath", "//input[@id = 'uclCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "uclCust_uclCust_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelect 				= createTestObject("btnSelect", "id", "uclCust_uclCust_umd_ctl00_gvL_hpSelect_0")//select first row


	private TestObject btnRequestSurvey1		= createTestObject("btnRequestSurvey1", "xpath", "//input[@id = 'lb_Form_ReqSurvey_Cust']")
	private TestObject btnRequestSurvey2		= createTestObject("btnRequestSurvey2", "xpath", "")

	//select all checkBox yes
	private TestObject btnSave					= createTestObject("btnSave", "id", "lb_Toolbar_Save")
	private TestObject lblNotification			= createTestObject("lblNotification", "xpath", "UCNotification_notificationContainer")

	//section approval request
	private TestObject sectionApprovalRequest	= createTestObject("sectionApprovalRequest", "xpath", "//span[text() = 'APPROVAL REQUEST']/preceding-sibling::a")
	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "xpath", "//select[@id = 'ucApprovalReq_ddlReason']")
	private TestObject drpApprover				= createTestObject("drpApprover", "xpath", "//select[@id = 'ucApprovalReq_ddlApvBy']")
	private TestObject txtNotes					= createTestObject("txtNotes", "xpath", "//textarea[@id = 'ucApprovalReq_txtNotes']")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")


	public void clickButtonNext() {
		WebUI.takeScreenshot()
		safetyClick(btnNext, 2)
	}

	public void expandAgreement(String custName, String custNo) {
		safetyClick(sectionAgreementTransfer)
		safetyClick(icnSearch, 1)
		safetyInput(txtCustomerName, custName)
		safetyClick(btnSearch, 1.5)
		safetyClick(btnSelect, 1.5)
		
	}

	public void saveAgreement() {
		WebUI.click(btnRequestSurvey1)
		WebUI.click(btnRequestSurvey2)
		
		checkListMandatory()
		
		WebUI.click(btnSave)
		WebUI.verifyElementVisible(lblNotification)
	}
	
	public void checkListMandatory() {
		def mandatory = getListElementByTestObject("//span[contains(@id, 'gvTermCondition_lblIsMandatory')]")
		
		mandatory.size().times { i -> 
			TestObject chkBox = createTestObject("chkBox", "xpath", "//span[@id = 'gvTermCondition_lblIsMandatory_$i' and text() = 'Yes']/following::input[1]")
			def isYes = WebUI.verifyElementPresent(chkBox, 1, FailureHandling.OPTIONAL)
			
			if(isYes) {
				safetyClick(chkBox, 1)
			}
		}
		
	}

	public void approval(String note, String reason, String approver) {

		WebUI.click(sectionApprovalRequest)
		WebUI.selectOptionByLabel(drpReasonDescription, reason, false)
		WebUI.selectOptionByLabel(drpApprover, approver, false)
		WebUI.setText(txtNotes, note)
		WebUI.click(btnSubmit)
	}
}
