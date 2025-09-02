package com.taf.pageobjects.disbursement

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

public class OnlineDisbursementInquiryPage extends BaseHelper {

	private TestObject txfBatchNo			= createTestObject("txfBatchNo","id", "txtBatchNo")
	private TestObject txfAgreementNo		= createTestObject("txfAgreementNo","id", "txtAgrmntNo")
	private TestObject drpAccountNo			= createTestObject("drpAccountNo","id", "ucBankAccNo_ddlReference")
	private TestObject drpApTypeName		= createTestObject("drpApTypeName","id", "ucApTypeName_ddlReference")
	private TestObject drpBankName			= createTestObject("drpBankName","id", "ucBankName_ddlReference")
	private TestObject drpStatus			= createTestObject("drpStatus","id", "ucStatus_ddlReference")
	private TestObject btnSearch			= createTestObject("btnSearch","id", "btnSearch")

	private TestObject txtBatchNo			= createTestObject("txtBatchNo", "id", "gvGrid_lbBatchNo_0")
	private TestObject txtVoucherNo			= createTestObject("txtVoucherNo", "id", "lbPayVoucherNo")  
	private TestObject txtStatus			= createTestObject("txtStatus", "id", "txtMrOnlDisbStat")
	
	private TestObject txtPaymentVoucherStatus = createTestObject("txtPaymentVoucherStatus", "id", "lblStat")

	private void verifyLandingInInquiryPage() {
		WebUI.delay(1)
		verifyLanding(txfBatchNo, "Online Disbursement Inquiry")
		WebUI.takeScreenshot()
	}

	private void searchByAgreementNo(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	private void clickBatchNoAndNavigateToNewTab() {
		safetyClick(txtBatchNo)
		WebUI.delay(2)
		switchToNewTab()
		WebUI.takeScreenshot()
	}
	private void clickVoucherNo() {
		safetyClick(txtVoucherNo)
		switchToNewTab()
		WebUI.takeScreenshot()
	}
	private String getStatus() {
		String strStatus = WebUI.getText(txtStatus)
	}
	private void verifyStatus(String status) {
		WebUI.verifyElementText(txtPaymentVoucherStatus, status)
	}
}
