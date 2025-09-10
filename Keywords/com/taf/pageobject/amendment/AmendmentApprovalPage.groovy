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

	private TestObject drpAmendmentType = createTestObject("drpAmendmentType", "id", "ucrefAmendmentType_ddlReference")
	private TestObject txfCustomerName	= createTestObject("txfCustomerName", "id", "ucSearch_txtCustName_ltlCustCustName")
	private TestObject txfAgreementNo	= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo") 
	private TestObject txfTransationNo	= createTestObject("txfTransationNo", "id", "ucSearch_txtTrxNo_ltlApvReqTrxNo") 
	private TestObject txfCurrentUser	= createTestObject("txfCurrentUser", "id", "ucSearch_txtCurrentUser_ltlApprovalCurrentUser") 
	private TestObject txfRequestBy		= createTestObject("txfRequestBy", "id", "ucSearch_txtRequestBy_ltlApprovalRequestBy") 
	private TestObject txfApprovalNo	= createTestObject("txfApprovalNo", "id", "ucSearch_txtApvNo_ltlApvSchemeRApvNo") 
	private TestObject txfTaskOwner		= createTestObject("txfTaskOwner", "id", "ucSearch_txtTaskOwner_ltlApprovalTaskOwner") 
	private TestObject txfRequestDate	= createTestObject("txfRequestDate", "id", "ucSearch_txtRequestDate_ltlApvSchemeRRequestDt_txtDatePicker")
	
	
	private TestObject btnSearch		= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnProcess		= createTestObject("btnProcess", "id", "gvTask_lbProcess_0")

	private TestObject txtAgreementNo	= createTestObject("txtAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject list				= createTestObject("list", "xpath", "")

	
	private void verifyLandingPage() {
		verifyLanding(drpAmendmentType, "Amendment Approval")
	}

	public void searchCustomerforApproval(String amendmentType,String agreementNo, String transactionNo, String reqBy,String currentUser,
		String customerName, String user, String approvalNo,
		String taskOwner, String date) {

		safetySelect(drpAmendmentType, amendmentType)
		inputIfExist(txfAgreementNo, agreementNo)
		inputIfExist(txfTransationNo, transactionNo)
		inputIfExist(txfRequestBy, reqBy)
		inputIfExist(txfCurrentUser, currentUser)
		inputIfExist(txfCustomerName, customerName)
		inputIfExist(txfApprovalNo, approvalNo)
		inputIfExist(txfTaskOwner, taskOwner)
		inputIfExist(txfRequestDate, taskOwner)
		
		
		safetyClick(btnSearch)
	}

	private void inputIfExist(TestObject to, String text) {
		if(text) {
			safetyInput(to, text)
			WebUI.delay(0.5)
		}
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
		safetyInput(txfCustomerName, customerName)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
		safetyClick(btnProcess, 10)
	}
}
