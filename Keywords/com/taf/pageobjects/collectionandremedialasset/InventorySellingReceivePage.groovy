package com.taf.pageobjects.collectionandremedialasset

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

public class InventorySellingReceivePage extends BaseHelper {
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject lblAgreementNo = createTestObject("txtOffice", "", "")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")

	//table
	private TestObject lblAgreementNoTable = createTestObject("lblAgreementNoTable", "", "")
	private TestObject txtAgreementNoTable = createTestObject("txtAgreementNoTable", "", "")
	private TestObject btnPencil = createTestObject("btnPencil", "", "")

	//Detail
	private TestObject txfReceiveFrom = createTestObject("txfReceiveFrom", "", "")
	private TestObject txfReferenceNo = createTestObject("txfReferenceNo", "", "")
	private TestObject drpWayOfpayment = createTestObject("drpWayOfpayment", "", "")
	private TestObject txtWayOfpayment = createTestObject("txtWayOfpayment", "", "")
	private TestObject drpBankAccount = createTestObject("drpBankAccount", "", "")
	private TestObject txtBankAccount = createTestObject("txtBankAccount", "", "")
	private TestObject txfNotes = createTestObject("txfNotes", "", "")
	private TestObject drpDate = createTestObject("drpDate", "", "")
	private TestObject txtDate = createTestObject("txtDate", "", "")

	private TestObject btnSubmit = createTestObject("", "", "")
	private TestObject lblSuccess = createTestObject("", "", "")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Inventory Selling Receive Page")
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
		WebUI.click(btnSearch)
	}

	public void clickButtonPencil() {
		WebUI.click(btnSearch)
	}

	public void inputPaymentDetail(String receiveFrom, String referenceNo, String wayOfPayment, String bankAccount, String notes, String date) {
		txtWayOfpayment = createTestObject("txtWayOfpayment", "text", "$wayOfPayment")
		txtBankAccount = createTestObject("txtBankAccount", "text", "$bankAccount")
		txtDate = createTestObject("txtDate", "text", "$date")

		WebUI.setText(txfReceiveFrom, receiveFrom)
		WebUI.setText(txfReferenceNo, referenceNo)
		WebUI.setText(txfNotes, notes)
		//way of payment
		WebUI.click(drpWayOfpayment)
		WebUI.click(txtWayOfpayment)
		//bank account
		WebUI.click(drpBankAccount)
		WebUI.click(txtBankAccount)
		//value date
		WebUI.click(drpDate)
		WebUI.click(txtDate)

		WebUI.click(btnSubmit)
		verifyPopUpSuccess(lblSuccess, "Inventory Selling Receive")
	}
}
