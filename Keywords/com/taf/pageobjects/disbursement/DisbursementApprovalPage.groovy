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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class DisbursementApprovalPage extends BaseHelper {
	//search
	private TestObject drpAPTypeName			 = createTestObject("drpAPTypeName", "id", "ucSearch_ddlRefAccPayableTypeId_ltlRefAccPayableTypeAccPayableTypeNameSearch_ddlReference")
	private TestObject txfApDestination 		 = createTestObject("txfApDestination", "id", "ucSearch_txtAccPayableDestination_ltlAccPayableAccPayableDestinationSearch")
	private TestObject drpBankName 				 = createTestObject("drpBankName", "id", "ucSearch_ddlAPDestBankCode_ltlRefBankBankNameSearch_ddlReference")
	private TestObject txfPaymentVoucherDate 	 = createTestObject("txfPaymentVoucherDate", "id", "ucSearch_txtPayVoucherDt_ltlPayVoucherHPayVoucherDtLTESearch_txtDatePicker")
	private TestObject btnSearch				 = createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//AP Disbursement Approval-Grid
	private TestObject btnApproveSelected		 = createTestObject("btnApproveSelected", "id", "lb_Btn_ApproveSelected")
	private TestObject btnApprove 				 = createTestObject("btnApprove", "id", "lb_Form_Approve")
	//popup status
	private TestObject txtPopupStatus			 = createTestObject("txtPopupStatus", "", "")
	private TestObject btnPopupOke				 = createTestObject("btnPopupOke", "", "")
	private TestObject lblPopupTransactionStatus = createTestObject("lblPopupTransactionStatus", "", "")
	private TestObject txtPopupTransactionStatus = createTestObject("txtPopupTransactionStatus", "", "")
	private TestObject txtVoucherNo				 = createTestObject("txtVoucherNo", "id", "rptDetail_lblPayVoucherNo_0")

	public void inputSearchApplication(String apTypeName, String apDestination, String bankName) {
		safetySelect(drpAPTypeName, apTypeName)
		WebUI.delay(0.8)
		safetyInput(txfApDestination, apDestination)
		WebUI.delay(0.8)
		safetySelect(drpBankName, bankName)
		WebUI.delay(0.8)
		
	}

	public void clickButtonSearch() {
		safetyClick(btnSearch)
		WebUI.delay(3)
	}

	public void checklistApDisbursement(String apBalance) {
		
		TestObject cbkApDisbursement = createTestObject("cbkApDisbursement", "xpath", "//span[normalize-space(text())='$apBalance']/ancestor::tr//input[@type='checkbox']")
		safetyClick(cbkApDisbursement)
		WebUI.takeScreenshot()
	}

	public void clickButtonApproveSelected() {
		safetyClick(btnApproveSelected)
		WebUI.takeScreenshot()
	}

	public void clickButtonApprove() {
		safetyClick(btnApprove)
		WebUI.takeScreenshot()
	}

	public void clickButtonPopupOke() {
		WebUI.waitForElementPresent(txtPopupStatus, 10)
		safetyClick(btnPopupOke)
	}

	public void verifyPopupStatusTransaction() {
		txtPopupTransactionStatus = createTestObject("txtPopUpTransactioStatus", "", "")
		WebUI.waitForElementPresent(lblPopupTransactionStatus, 10)
		WebUI.waitForElementPresent(txtPopupTransactionStatus, 10)
	}

	public void updatePaymentVoucherNoToExcel(String fileName, String scenarioId) {
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String paymentVoucherNo = WebUI.getText(txtVoucherNo)
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId

		saveDataToExcel(paymentVoucherNo, rowFilter, filePath, "MasterData", "PaymentVoucherNo")
	}
}

