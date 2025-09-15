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

public class CashierTransactionPage extends BaseHelper{

	private TestObject drpWOP			= createTestObject("drpWOP", "xpath", "//select[@id = 'ddlWOP']")
	private TestObject drpAccountName	= createTestObject("drpAccountName", "xpath", "//select[@id = 'ddlBankAccount']")
	private TestObject txtDate			= createTestObject("txtDate", "xpath", "//input[@id = 'ucDatePicker_txtDatePicker']")
	private TestObject btnPaymentSingle	= createTestObject("btnPaymentSingle", "id", "lbPaySingle")

	public void inputChasier(String WOP, String accName, String date) {

		safetySelect(drpWOP, WOP, 1.5)
		safetySelect(drpAccountName, accName, 1.5)
		safetyInput(txtDate, date, 2)
	}

	public void clickPaymentSingle() {
		WebUI.takeScreenshot()
		WebUI.click(btnPaymentSingle)
	}
}
