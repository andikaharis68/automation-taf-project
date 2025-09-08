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
	private TestObject cbBilyetGiro				= createTestObject("cbBilyetGiro", "id", "cbIsBilyetGiro")
	private TestObject txfBilyetGiroNo			= createTestObject("txfBilyetGiroNo", "id", "txtBilyetGiroNo")
	private TestObject txfBilyetGiroDate		= createTestObject("txfBilyetGiroDate", "id", "ucBilyetDt_txtDatePicker")


	public void inputSearchApplication(String apTypeName, String apDestination, String bankName) {
		safetySelect(drpAPTypeName, apTypeName)
		WebUI.delay(1)

		safetyInput(txfApDestination, apDestination)
		WebUI.delay(1)

		safetySelect(drpBankName, bankName)
		WebUI.delay(1)
	}

	public void clickButtonSearch() {
		safetyClick(btnSearch)
		WebUI.delay(2)
	}

	public void clickExecutedSelected() {
		safetyClick(btnExecutedSelected)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}
	
	private void isBilyetGiroCheck(String isBilyetGiro, bilyetGiroNo, bilyetGiroDate) {
		if(isBilyetGiro == "Y" ) {
			if(!WebUI.verifyElementChecked(cbBilyetGiro, 2, FailureHandling.OPTIONAL)) {
				safetyClick(cbBilyetGiro)
				WebUI.delay(1)
			}
			safetyInput(txfBilyetGiroNo,bilyetGiroNo)
			WebUI.delay(1)
			if(bilyetGiroDate) {
				safetyInput(txfBilyetGiroDate, bilyetGiroDate)
				clickTABKeyboard(txfBilyetGiroDate)
			}
		}
	}

	public void inputApBankDisbursement(String recipientName, String currencyRate, String disbursementNote, String isBilyetGiro,String bilyetGiroNo, String bilyetGiroDate) {
		isBilyetGiroCheck(isBilyetGiro, bilyetGiroNo, bilyetGiroDate)
		
		safetyInput(txfRecipientName, recipientName)
		WebUI.delay(2)

		clearAndSetText(txfCurrencyRate, currencyRate)
		WebUI.delay(1)

		clearAndSetText(txfDisbursementNote, disbursementNote)
		WebUI.delay(1)

		WebUI.takeScreenshot()
	}

	public void clickButtonDisburse() {
		safetyClick(btnDisburse)
		WebUI.takeScreenshot()
		WebUI.delay(3)
	}

	public void checklistApDisbursement(String paymentVoucherNo) {
		TestObject cbkApDisbursement = createTestObject("cbkApDisbursement", "xpath", "//tr[td//a[contains(text(),'$paymentVoucherNo')]]//input[@type='checkbox']")
		safetyClick(cbkApDisbursement)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}
	private void verifyLandingPage() {
		WebUI.delay(5)
		verifyLanding(drpAPTypeName, "Disbursement execution")
		WebUI.takeScreenshot()
		WebUI.delay(3)
	}
}

