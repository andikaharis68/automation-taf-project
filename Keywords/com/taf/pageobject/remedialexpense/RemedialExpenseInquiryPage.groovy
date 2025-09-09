package com.taf.pageobject.remedialexpense

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

public class RemedialExpenseInquiryPage extends BaseHelper{

	private TestObject txtAgreementNo	= createTestObject("txtAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch		= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject lblRequestDate	= createTestObject("lblRequestDate", "id", "gvPaging_lb_CollExpense_ReqDt")
	

	private TestObject lblReqNumber		= createTestObject("lblReqNumber", "id", "gvPaging_lblCollExpense_0")
	private TestObject lblResult		= createTestObject("lblApprovedBy", "id", "")
	private TestObject lblTaskOwner		= createTestObject("lblTaskOwner", "id", "//span[text() = '-' and contains(@id, 'ApprovalResult')]/preceding::span[contains(@id, 'TaskOwner')][1]")
	private TestObject lblNode			= createTestObject("lblNode", "id", "//span[text() = '-' and contains(@id, 'ApprovalResult')]/preceding::span[contains(@id, 'gvApvHist_lblApprovalNode')][1]")
	
	
	public void searchRemedial(String agreemetnNo) {
		safetyInput(txtAgreementNo, agreemetnNo)
		safetyClick(btnSearch, 3)
		WebUI.takeScreenshot()
	}
	
	public boolean checkStatus(String expected, String agreeNo) {
		 TestObject lblStatus		= createTestObject("lblStatus", "xpath", "(//a[text() = '$agreeNo']/following::span[contains(@id, 'gvPaging_lblCollExpStatus')])[1]")
		 def actual = WebUI.getText(lblStatus)
		 return actual.equals(expected)
	}
	
	public void clickReqNo() {
		safetyClick(lblReqNumber, 3)
	}
	
	public boolean checkApproval() {
		WebUI.focus(lblNode)
		WebUI.scrollToElement(lblTaskOwner, 2)
		WebUI.takeScreenshot()
		return WebUI.verifyElementPresent(lblTaskOwner, 3, FailureHandling.OPTIONAL)
	}
	
	public Map getApprover() {
		Map credential = [:]
		credential['node'] = WebUI.getText(lblNode)
		credential['owner'] = WebUI.getText(lblTaskOwner)
		
		return credential
	}
	
	public void clickDate() {
		safetyClick(lblRequestDate)
	}
	
}
