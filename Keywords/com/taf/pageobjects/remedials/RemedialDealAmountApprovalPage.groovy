package com.taf.pageobjects.remedials

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

public class RemedialDealAmountApprovalPage extends BaseHelper {

	private TestObject txfAgreementNo	= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo") 
	private TestObject txfTransactionNo	= createTestObject("txfTransactionNo", "id", "ucSearch_txtTrxNo_ltlApvReqTrxNo") 
	private TestObject txfRequestBy		= createTestObject("txfRequestBy", "id", "ucSearch_txtRequestBy_ltlApprovalRequestBy") 
	private TestObject txfCurrentUser	= createTestObject("txfCurrentUser", "id", "ucSearch_txtCurrentUser_ltlApprovalCurrentUser")
	private TestObject txfCustomerName	= createTestObject("txfCustomerName", "id", "ucSearch_txtCustName_ltlCustCustName") 
	private TestObject txfApprovalNo	= createTestObject("txfApprovalNo", "id", "ucSearch_txtApvNo_ltlApvSchemeRApvNo") 
	private TestObject txfTaskOwner		= createTestObject("txfTaskOwner", "id", "ucSearch_txtTaskOwner_ltlApprovalTaskOwner") 
	private TestObject txfRequestDate	= createTestObject("txfRequestDate", "id", "ucSearch_txtRequestDate_ltlApvSchemeRRequestDt_txtDatePicker") 
	private TestObject btnSearch		= createTestObject("btnSearch", "id", "ucSearch_btnSearch") 
	private TestObject btnProcess		= createTestObject("btnProcess", "id", "gvTask_ibProcess_0") 
	private TestObject txfNotes			= createTestObject("txfNotes", "id", "txtNotes") 
	private TestObject drpAction		= createTestObject("drpAction","id", "ddlAction")
	private TestObject btnSubmit		= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	
	private void verifyLandingPage() {
		verifyLanding(txfAgreementNo, "Remedial Deal Amount Approval")
		WebUI.takeScreenshot()
	}
	
	private void searchAgreement(String agreementNo, String transactionNo, String requestBy, String currentUser, String customerName,
		String approvalNo, String taskOwner, String date) {
		
		inputIfExist(txfAgreementNo, agreementNo)
		inputIfExist(txfTransactionNo, transactionNo)
		inputIfExist(txfRequestBy, requestBy)
		inputIfExist(txfCurrentUser, currentUser)
		inputIfExist(txfCustomerName, customerName)
		inputIfExist(txfApprovalNo, approvalNo)
		inputIfExist(txfTaskOwner, taskOwner)
		inputIfExist(txfRequestDate, date)
		
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	
	private void inputIfExist(TestObject to, String textInputted) {
		if(textInputted) {
			safetyInput(to, textInputted)
			WebUI.delay(0.3)
		}
	}
	
	private void inputApprovalAction(String action, String notes) {
		WebUI.scrollToElement(drpAction, 2)
		WebUI.takeScreenshot()
		safetySelect(drpAction, action)
		WebUI.delay(0.3)
		inputIfExist(txfNotes, notes)
	}
	
	private void clickProcess() {
		safetyClick(btnProcess)
	}
	
	private void clickSubmit() {
		WebUI.takeScreenshot()
		safetyClick(btnSubmit)
	}
	
} 
