package com.taf.pageobjects.losCreditProcess

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

public class ApplicationViewPage extends BaseHelper{
	//main info	
	private TestObject lblMainInfo = createTestObject("lblMainInfo", "id", "ucCreditProcessMainInfo_ucToogleMainInfo_subSectionID")
	private TestObject txtOriginalOffice = createTestObject("txtOriginalOffice", "id", "ucCreditProcessMainInfo_lblOriginalOffice")
	
	//tab
	private TestObject btnTabApprovalHistory = createTestObject("btnTabApprovalHistory", "id", "lb_Tab_ApvHist")
	
	//approval history
	private TestObject txtLastNode = createTestObject("txtLastNode", "xpath", "//span[text() = '-' and contains(@id, 'gvApvHist_lblApprovedBy')]/preceding::span[contains(@id, 'gvApvHist_lblApprovalNode')][1]")
	private TestObject txtLastTaskOwner = createTestObject("txtLastTaskOwner", "xpath", "//span[text() = '-' and contains(@id, 'gvApvHist_lblApprovedBy')]/preceding::span[contains(@id, 'gvApvHist_lblApprovalTaskOwner')][1]")
	
	public void switchToSecondTab() {
		WebUI.switchToWindowIndex(1)
	}
	
	public void verifyLandingScreen() {
		WebUI.delay(5)
		WebUI.switchToDefaultContent()
		verifyLanding(lblMainInfo, "Application View")
		WebUI.takeScreenshot()
	}
	
	public void clickTabApprovalHistory() {
		safetyClick(btnTabApprovalHistory)
	}
	
	public Map getApprovalCredential() {
		// focus on owner, for ss purpose
		WebUI.focus(txtLastTaskOwner)
		WebUI.scrollToElement(txtLastTaskOwner, 2)
		WebUI.takeScreenshot()
		String actualOffice = WebUI.getText(txtOriginalOffice)
		String actualNode = WebUI.getText(txtLastNode)
		String actualOwner = WebUI.getText(txtLastTaskOwner)
		
		if (actualNode.startsWith("CA")) {
			String[] splitted = actualNode.split(" ")
			actualNode = "Credit Analyst " + splitted[-1]
		}
		
		Map credentialData = [:]
		credentialData['office'] = actualOffice
		credentialData['lastNode'] = actualNode
		credentialData['lastOwner'] = actualOwner
		
		return credentialData
	}
}
