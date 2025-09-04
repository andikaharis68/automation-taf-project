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

public class MenuPage extends BaseHelper {
	
	private TestObject drpMenu					= createTestObject("drpMenu", "id", "imgMenu")
	private TestObject drpModul					= createTestObject("drpModul", "id", "ddlSubSystem")
	
	//content
	private TestObject btnInstanceMonitoring 	= createTestObject("btnInstanceMonitoring", "text", "Instance Monitoring")
	private TestObject btnTaskMonitoring 		= createTestObject("btnTaskMonitoring", "text", "Task Monitoring")
	private TestObject btnTaskReAssignment 		= createTestObject("Task Re-Assignment", "text", "Task Re-Assignment")
	
	//footer
	private TestObject btnWorkflowMonitor 		= createTestObject("btnWorkflowMonitor", "id", "rModuleList_lbModuleList_0")
	private TestObject btnWorkflowSla 			= createTestObject("btnWorkflowSla", "id", "rModuleList_lbModuleList_1")
	
	//Iframse
	private TestObject iframeMenu 				= createTestObject("iframeMenu", "xpath", "//*[@id='treeContainer']")
	private TestObject iframeMainPage			= createTestObject("iframeMainPage", "xpath", "//*[@id='mainPage']")
	
	
	private void verifyLandingMenuPage() {
		verifyLanding(drpMenu, "Menu")
	}

	private void switchIframeMainPage() {
		WebUI.switchToFrame(iframeMainPage, 2)
	}

	private void switchDefaultContent() {
		WebUI.switchToDefaultContent()
	}

	private void switchToIframeMenu() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMenu, 1)
	}
	
	private void navigateToTaskMonitoring() {
		WebUI.switchToDefaultContent()
		safetyClick(drpMenu)
		switchToIframeMenu()
		safetySelect(drpModul, "WORKFLOW FOUNDATION")
		safetyClick(btnWorkflowMonitor)
		WebUI.takeScreenshot()
		safetyClick(btnTaskMonitoring)
		switchDefaultContent()
	}
}
