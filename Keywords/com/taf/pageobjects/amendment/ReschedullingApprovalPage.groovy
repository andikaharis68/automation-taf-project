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

public class ReschedullingApprovalPage extends BaseHelper{

	private TestObject sectionApprovalAction	= createTestObject("sectionApprovalAction", "xpath", "")
	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "xpath", "//select[@id = 'ddlAction']")
	private TestObject drpApprover				= createTestObject("drpApprover", "xpath", "")
	private TestObject txtNotes					= createTestObject("txtNotes", "xpath", "//textarea[@id = 'txtNotes']")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject lblNotification			= createTestObject("lblNotification", "xpath", "")

	public void approval(String reason, String approver, String note) {

		WebUI.click(sectionApprovalAction)

		safetySelect(drpReasonDescription, reason, 1)
//		safetySelect(drpApprover, approver, 1)
		safetyInput(txtNotes, note, 1)
		WebUI.takeScreenshot()
		safetyClick(btnSubmit, 2)
//		WebUI.verifyElementVisible(lblNotification)
		WebUI.takeScreenshot()
	}
}
