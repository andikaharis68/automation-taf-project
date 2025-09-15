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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class ReschedulingRequestPage extends BaseHelper{

	private TestObject sectionRescheduleReq		= createTestObject("sectionRescheduleReq", "xpath", "")
	private TestObject sectionNewFinancial		= createTestObject("sectionNewFinancial", "xpath", "")
	private TestObject txtEfectiveDate			= createTestObject("txtEfectiveDate", "xpath", "")
	private TestObject drpDueDate				= createTestObject("drpDueDate", "xpath", "")
	private TestObject txtTenor					= createTestObject("txtTenor", "xpath", "")
	private TestObject drpPayFrequency			= createTestObject("drpPayFrequency", "xpath", "")
	private TestObject drpInstallmentScheme		= createTestObject("drpInstallmentScheme", "xpath", "")
	private TestObject btnNext					= createTestObject("btnNext", "xpath", "")
	private TestObject btnCalculate				= createTestObject("btnCalculate", "xpath", "")
	private TestObject sectionApprovalReq		= createTestObject("sectionApprovalReq", "xpath", "")
	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "xpath", "")
	private TestObject drpApprover				= createTestObject("drpApprover", "xpath", "")
	private TestObject txtNotes					= createTestObject("txtNotes", "xpath", "")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "xpath", "")
	private TestObject lblNotification			= createTestObject("lblNotification", "xpath", "")
	private TestObject lblDocAgreement			= createTestObject("lblDocAgreement", "xpath", "")
	private TestObject lblLastInstallment		= createTestObject("lblLastInstallment", "xpath", "")
	private TestObject lblBalanceAmount			= createTestObject("lblBalanceAmount", "id", "")


	public void reschedule(String efectiveDate, String dueDate, String tenor, String payFreq, String scheme) {

		WebUI.click(sectionRescheduleReq)
		WebUI.click(sectionNewFinancial)

		safetyInput(txtEfectiveDate, efectiveDate, 2)
		clickTABKeyboard(txtEfectiveDate)
		safetySelect(drpDueDate, dueDate, 2)

		safetyInput(txtTenor, tenor)
		safetySelect(drpPayFrequency, payFreq, 1)
		safetySelect(drpInstallmentScheme, scheme, 1)
		WebUI.takeScreenshot()

		safetyClick(btnNext, 2)
		WebUI.takeScreenshot()
		safetyClick(btnCalculate)
		//scroll bottom
	}

	public void approval(String reason, String approver, String note) {

		WebUI.click(sectionApprovalReq)

		safetySelect(drpReasonDescription, reason, 2)
		safetySelect(drpApprover, approver, 2)
		safetyInput(txtNotes, note)
		safetyClick(btnSubmit)

		WebUI.verifyElementVisible(lblNotification)
		WebUI.verifyElementNotVisible(lblDocAgreement)
	}
	
	public void writeBalance(String balance) {
		String excelFilePath = GlobalVariable.TEST_DATA_LOCATION + "/Amendment_Reschedule_TestData.xlsx"
		Map criteria = ["ScenarioId":GlobalVariable.SCENARIO_ID]
		saveDataToExcel(balance, criteria, excelFilePath, "MasterData", "AmountBalance")
	}
	
	public void getBalance() {
		WebUI.focus(lblBalanceAmount)
		String actual = WebUI.getText(lblBalanceAmount)
		KeywordUtil.logInfo(actual)
		String modify = actual.replaceAll("[^0-9]", "")
		writeBalance(modify)
	}
}
