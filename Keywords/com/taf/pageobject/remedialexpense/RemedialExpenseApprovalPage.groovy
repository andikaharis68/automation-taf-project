package com.taf.pageobject.remedialexpense

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

public class RemedialExpenseApprovalPage extends BaseHelper{

	private TestObject txtAgreementNo		= createTestObject("txtAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch			= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	private TestObject drpApprovalAction	= createTestObject("drpApprovalAction", "id", "ddlAction")
	private TestObject txtNotes				= createTestObject("txtNotes", "id", "txtNotes")
	private TestObject btnSubmit			= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	
	private TestObject iframeMain			= createTestObject("iframeMain", "id", "mainPage")
	
		
	public void switchFrameMaian() {
		WebUI.switchToFrame(iframeMain, 3)
	}
	
	
	public void searchRemedial(String agreementNo) {
		safetyInput(txtAgreementNo, agreementNo)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	
	public void prosesRemedial(String agreementNo) {
		TestObject btnProcess = createTestObject("btnProcess", "xpath", "//a[text() = '$agreementNo']/following::input[1]")
		safetyClick(btnProcess, 3)
		WebUI.takeScreenshot()
	}
	
	public void inputApprovalAction(String action, String note) {
		safetySelect(drpApprovalAction, action)
		safetyInput(txtNotes, note)
		WebUI.takeScreenshot()
	}
	
	public void clickSubmit() {
		safetyClick(btnSubmit, 5)
		WebUI.takeScreenshot()
	}
}
