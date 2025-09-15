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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class ChangeDueDateRequestPage extends BaseHelper{

	private TestObject txtEfectiveDate			= createTestObject("txtEfectiveDate", "xpath", "//input[@id = 'ucdpEffDt_txtDatePicker']")
	private TestObject txtNewDueDate			= createTestObject("txtNewDueDate", "xpath", "//input[@id = 'ucdpNewDueDt_txtDatePicker']")
	private TestObject btnCalculate				= createTestObject("btnCalculate", "id", "lb_Form_Calculate")
	private TestObject tableCicilan				= createTestObject("tableCicilan", "xpath", "//div[@id = 'dNewAmortization']")
	private TestObject lblAmount				= createTestObject("lblAmount", "id", "ucSummary_lblBalanceAmt")
	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "id", "ucApprovalRequest_ddlReason")
	private TestObject drpApprover				= createTestObject("drpApprover", "id", "ucApprovalRequest_ddlApvBy")
	private TestObject txtNotes					= createTestObject("txtNotes", "xpath", "//textarea[@id = 'ucApprovalRequest_txtNotes']")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject lblNotification			= createTestObject("lblNotification", "xpath", "")

	public void calculate(String efectiveDate, String dueDate) {

		safetyInputEdit(txtEfectiveDate, efectiveDate, 1)
		clickTABKeyboard(txtNewDueDate)
		safetyInputEdit(txtNewDueDate, dueDate, 1)
		clickTABKeyboard(btnCalculate)
		safetyClick(btnCalculate, 2)
		WebUI.verifyElementVisible(tableCicilan)
		WebUI.focus(tableCicilan)
		WebUI.takeScreenshot()
	}

	public void approval(String reason, String approver, String note) {

		safetySelect(drpReasonDescription, reason, 1)
		safetySelect(drpApprover, approver, 1)
		safetyInput(txtNotes, note, 1)
		WebUI.takeScreenshot()
		safetyClick(btnSubmit, 2)
		WebUI.takeScreenshot()
	}
	
	public void writeBalance(String balance) {
		String excelFilePath = GlobalVariable.TEST_DATA_LOCATION + "/Amendment_Change_DueDate_TestData.xlsx"
		Map criteria = ["ScenarioId":GlobalVariable.SCENARIO_ID]
		saveDataToExcel(balance, criteria, excelFilePath, "MasterData", "AmountBalance")
	}
	
	public void getBalance() {
		String actual = WebUI.getText(lblAmount)
		KeywordUtil.logInfo(actual)
		String modify = actual.replaceAll("[^0-9]", "")
		writeBalance(modify)
	}
}
