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

public class PaymentRecievePage extends BaseHelper{

	private TestObject txtAgreementNumber	= createTestObject("txtAgreementNumber", "xpath", "")
	private TestObject btnSearch			= createTestObject("btnSearch", "xpath", "")
	private TestObject txtRecieveForm		= createTestObject("txtRecieveForm", "xpath", "")
	private TestObject txtNotes				= createTestObject("txtNotes", "xpath", "")
	private TestObject txtReferenceNo		= createTestObject("txtReferenceNo", "xpath", "")
	private TestObject txtAmount			= createTestObject("txtAmount", "xpath", "")
	private TestObject btnPenAction			= createTestObject("btnPenAction", "xpath", "")
	private TestObject btnSubmit			= createTestObject("btnSubmit", "xpath", "")


	public void searchAgreement(String agreementNo) {

		WebUI.setText(txtAgreementNumber, agreementNo)
		WebUI.click(btnSearch)
	}

	public void inputDataRecieve(String recieveForm, String note, String reffNo, String amount) {

		WebUI.setText(txtRecieveForm, recieveForm)
		WebUI.setText(txtNotes, note)
		WebUI.setText(txtReferenceNo, reffNo)
		WebUI.setText(txtAmount, amount)

		WebUI.click(btnPenAction)
	}

	public void clickSubmit() {

		WebUI.click(btnSubmit)
	}
}
