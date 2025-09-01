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

public class DisbursementExecutionPage extends BaseHelper {
	//search
	private TestObject drpAPTypeName 			 = createTestObject("drpAPTypeName", "xpath","//*[contains(@id, 'ltlRefAccPayableTypeAccPayableTypeNameSearch')]") 
	private TestObject txfApDestination 		 = createTestObject("txfApDestination", "xpath","//*[contains(@id, 'txtAccPayableDestination')]") 
	private TestObject drpBankName 				 = createTestObject("drpBankName", "xpath", "//*[contains(@id,'ltlRefBankBankNameSearch')]") 
	private TestObject txfPaymentVoucherDate 	 = createTestObject("txfPaymentVoucherDate", "xpath", "//*[contains(@id, 'ltlPayVoucherHPayVoucherDtLTESearch')]") 
	private TestObject btnSearch 				 = createTestObject("btnSearch", "id", "ucSearch_btnSearch") 
	
	//AP Disbursement Process-Grid
	private TestObject btnExecutedSelected 		 = createTestObject("btnExecutedSelected", "id", "lb_Btn_ExecuteSelected") 
	
	//AP Bank Disbursement
	private TestObject txfRecipientName 		 = createTestObject("txfRecipientName", "id", "txtRecipientName")
	private TestObject txfCurrencyRate 			 = createTestObject("txfCurrencyRate", "id", "ucInputNumber_PayVoucherH_CurrRateAmt_txtInput") 
	private TestObject txfDisbursementNote 		 = createTestObject("txfDisbursementNote", "id", "txtNotes") 
	private TestObject btnDisburse				 = createTestObject("btnDisburse", "id", "lbDisburse")
	//Popup status
	private TestObject lblPopupTransactionStatus = createTestObject("lblPopupTransactionStatus", "", "")
	private TestObject txtPopupTransactionStatus = createTestObject("txtPopupTransactionStatus", "", "")

	public void inputSearchApplication(String apTypeName, String apDestination, String bankName) {
		safetySelect(drpAPTypeName, apTypeName)
		safetyInput(txfApDestination, apDestination)
		safetySelect(drpBankName, bankName)
	}

	public void clickButtonSearch() {
		safetyClick(btnSearch)
	}

	public void clickExecutedSelected() {
		safetyClick(btnExecutedSelected)
		WebUI.takeScreenshot()
	}

	public void inputApBankDisbursement(String recipientName, String currencyRate, String disbursementNote) {
		safetyInput(txfRecipientName, recipientName)
		safetyInput(txfCurrencyRate, currencyRate)
		clearAndSetText(txfDisbursementNote, disbursementNote)
		WebUI.takeScreenshot()
	}

	public void clickButtonDisburse() {
		safetyClick(btnDisburse)
		WebUI.takeScreenshot()
	}

	public void checklistApDisbursement(String paymentVoucherNo) {
		TestObject cbkApDisbursement = createTestObject("cbkApDisbursement", "xpath", "//tr[td//a[contains(text(),'$paymentVoucherNo')]]//input[@type='checkbox']")
		safetyClick(cbkApDisbursement)
		WebUI.takeScreenshot()
	}
	private String getPaymentVoucherNoFromContext() {
		String paymentVoucherNo = ScenarioContext.get("PaymentVoucherNo")
		KeywordUtil.logInfo("appBalance" + paymentVoucherNo)
		return paymentVoucherNo
	}
	
	
}

