package com.taf.pageobjects.confinsWorkflow

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

public class TaskMonitoringPage extends BaseHelper{
	
	//activity task list
	private TestObject txfTransactionNo = createTestObject("btnWorkflowSla", "id", "ucSearch_txtTransactionCode_ltlWfTaskListsTransactionCode")
	private TestObject btnSearch 		= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnSelect		= createTestObject("btnSelect", "id", "gvUserTask_lb_ResumeTask_0")
	
	//activity task form
	private TestObject btnResume		= createTestObject("btnResume", "id", "lbResume")
	
	public void verifyLandingScreen() {
		verifyLanding(txfTransactionNo, "Task Monitorung")
	}
	
	public void searchByTransactionNo(String applicationNo) {
		safetyInput(txfTransactionNo, applicationNo)
	}
	
	public void clickSearch() {
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	
	public void clickSelect() {
		safetyClick(btnSelect)
	}
	
	public void clickResume(){
		WebUI.delay(2)
		WebUI.takeScreenshot()
		safetyClick(btnResume)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}	
	
}
