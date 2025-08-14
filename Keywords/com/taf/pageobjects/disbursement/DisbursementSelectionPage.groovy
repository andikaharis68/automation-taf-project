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

public class DisbursementSelectionPage extends BaseHelper {
	//search
	private TestObject drpAPTypeName = createTestObject("drpAPTypeName", "", "")
	private TestObject drpAPDueDate = createTestObject("drpAPDueDate", "", "")
	private TestObject drpBankName = createTestObject("drpBankName", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")
	//AP Disbursement Selection-Grid
	private TestObject cbkApDisbursement = createTestObject("cbkApDisbursement", "", "")
	private TestObject btnAddToTemp = createTestObject("btnAddToTemp", "", "")
	private TestObject txtApDestination = createTestObject("txtApDestination", "", "")
	private TestObject txtApDescription = createTestObject("txtApDescription", "", "")
	private TestObject btnNext = createTestObject("btnNext", "", "")
	//AP Disbursement Selection-Detail
	private TestObject drpWayOfPayment = createTestObject("drpWayOfPayment", "", "")
	private TestObject drpBankAccount = createTestObject("drpBankAccount", "", "")
	private TestObject btnRequestForApproval = createTestObject("btnRequestForApproval", "", "")
	//popup status
	private TestObject lblPopUpTransactioStatus = createTestObject("lblPopUpTransactioStatus", "", "")
	private TestObject txtPopUpTransactioStatus = createTestObject("txtPopUpTransactioStatus", "", "")

	public void inputSearchApplication(String apTypeName, String apDueDate, String bankName) {
		WebUI.selectOptionByLabel(drpAPTypeName, apTypeName, false)
		WebUI.selectOptionByLabel(drpAPDueDate, apDueDate, false)
		WebUI.selectOptionByLabel(drpBankName, bankName, false)
	}

	public void clickButtonSearch() {
		WebUI.click(btnSearch)
	}

	public void checklistApDisbursement(String apNo) {
		cbkApDisbursement = createTestObject("cbkApDisbursement", "", "")
		WebUI.click(cbkApDisbursement)
	}

	public void clickButtonAddToTemp() {
		WebUI.click(btnAddToTemp)
	}

	public String getApDestination() {
		return WebUI.getText(txtApDestination)
	}

	public String getApDescription() {
		return WebUI.getText(txtApDescription)
	}

	public void inputSelectionDetail(String wayOfPayment, String bankAccount) {
		WebUI.selectOptionByLabel(drpWayOfPayment, wayOfPayment, false)
		WebUI.selectOptionByLabel(drpBankAccount, bankAccount, false)
	}

	public void clickButtonRequestForApproval() {
		WebUI.click(btnAddToTemp)
	}

	public void verifyPopupStatusTransaction() {
		txtPopUpTransactioStatus = createTestObject("txtPopUpTransactioStatus", "", "")
		WebUI.waitForElementPresent(lblPopUpTransactioStatus, 10)
		WebUI.waitForElementPresent(txtPopUpTransactioStatus, 10)
	}
}
