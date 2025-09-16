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

public class SurveyTaskAssignmentPage extends BaseHelper{
	
	private TestObject txtTransactionReffNo	= createTestObject("txtTransactionReffNo", "xpath", "")
	private TestObject btnSearch			= createTestObject("btnSearch", "xpath", "")
	private TestObject btnPenAction			= createTestObject("btnPenAction", "xpath", "")
	private TestObject btnCancel			= createTestObject("btnCancel", "xpath", "")
	private TestObject lblNotification		= createTestObject("lblNotification", "xpath", "")
	
	public void searchTransaction(String reffNo) {
		
		WebUI.setText(txtTransactionReffNo, reffNo)
		WebUI.click(btnSearch)
		WebUI.click(btnPenAction)
		//looping for click all cancel button
		WebUI.click(btnCancel)
		//handel pop up
		WebUI.verifyElementVisible(lblNotification)
		
	}
	
	
	
}
