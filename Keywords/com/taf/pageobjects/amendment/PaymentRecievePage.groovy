package com.taf.pageobjects.amendment

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

	private TestObject txtAgreementNumber	= createTestObject("txtAgreementNumber", "xpath", "//input[@id = 'ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch']")
	private TestObject btnSearch			= createTestObject("btnSearch", "xpath", "//input[@id = 'ucSearch_btnSearch']")
	private TestObject txtRecieveForm		= createTestObject("txtRecieveForm", "xpath", "//input[@id = 'txtRcvFrom']")
	private TestObject txtNotes				= createTestObject("txtNotes", "xpath", "//textarea[@id = 'txtNotes']")
	private TestObject txtReferenceNo		= createTestObject("txtReferenceNo", "xpath", "//input[@id = 'txtReferenceNo']")
	private TestObject txtAmount			= createTestObject("txtAmount", "xpath", "//input[@id = 'ucReceiveAmt_txtInput']")
	private TestObject btnSubmit			= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject btnEdit				= createTestObject("btnEdit", "id", "gvPaymentReceive_imbEdit_0")

	public void searchAgreement(String agreementNo) {

		safetyInput(txtAgreementNumber, agreementNo, 1)
		safetyClick(btnSearch, 2)
		
		WebUI.takeScreenshot()
	}

	public void inputDataRecieve(String recieveForm, String note, String reffNo, String amount, String agreeNo) {

		safetyInput(txtRecieveForm, recieveForm, 2)
		safetyInput(txtNotes, note, 1)
		safetyInput(txtReferenceNo, reffNo, 2)
		manualClearText(txtAmount)
		safetyInput(txtAmount, amount, 1)
		WebUI.takeScreenshot()
		selectAmendment(agreeNo)
	}

	public void selectAmendment(String agreeNo) {
		TestObject btnPenAction	= createTestObject("btnPenAction", "xpath", "//a[text() = '$agreeNo']/following::input[1]")
		safetyClick(btnPenAction, 5)
		WebUI.takeScreenshot()
	}

	public void clickSubmit() {
		safetyClick(btnSubmit, 3)
		WebUI.takeScreenshot()
	}
}
