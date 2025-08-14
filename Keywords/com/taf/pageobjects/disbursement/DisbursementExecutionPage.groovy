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

public class DisbursementExecutionPage extends BaseHelper {
	//search
	private TestObject drpAPTypeName = createTestObject("drpAPTypeName", "", "")
	private TestObject txfApDestination = createTestObject("txfApDestination", "", "")
	private TestObject drpBankName = createTestObject("drpBankName", "", "")
	private TestObject drpPaymentVoucherDate = createTestObject("drpPaymentVoucherDate", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")
	//AP Disbursement Process-Grid
	private TestObject btnIconAction = createTestObject("btnIconAction", "", "")
	//AP Bank Disbursement
	private TestObject txfRecipientName = createTestObject("txfRecipientName", "", "")
	private TestObject txfCurrencyRate = createTestObject("txfCurrencyRate", "", "")
	private TestObject txfDisbursementNote = createTestObject("txfDisbursementNote", "", "")
	private TestObject btnDisburse = createTestObject("btnDisburse", "", "")
	//Popup status
	private TestObject lblPopupTransactionStatus = createTestObject("lblPopupTransactionStatus", "", "")
	private TestObject txtPopupTransactionStatus = createTestObject("txtPopupTransactionStatus", "", "")

	public void inputSearchApplication(String apTypeName, String apDestination, String bankName, String voucherDate) {
		WebUI.selectOptionByLabel(drpAPTypeName, apTypeName, false)
		WebUI.setText(txfApDestination, apDestination)
		WebUI.selectOptionByLabel(drpBankName, bankName, false)
		WebUI.selectOptionByLabel(drpPaymentVoucherDate, voucherDate, false)
	}

	public void clickButtonSearch() {
		WebUI.click(btnSearch)
	}

	public void clickButtonIconAction() {
		WebUI.click(btnIconAction)
	}

	public void inputApBankDisbursement(String recipientName, String currencyRate, String disbursementNote) {
		WebUI.setText(txfRecipientName, recipientName)
		WebUI.setText(txfCurrencyRate, currencyRate)
		WebUI.setText(txfDisbursementNote, disbursementNote)
	}

	public void clickButtonDisburse() {
		WebUI.click(btnDisburse)
	}

	public void verifyPopupStatusTransaction() {
		txtPopupTransactionStatus = createTestObject("txtPopUpTransactioStatus", "", "")
		WebUI.waitForElementPresent(lblPopupTransactionStatus, 10)
		WebUI.waitForElementPresent(txtPopupTransactionStatus, 10)
	}
}

