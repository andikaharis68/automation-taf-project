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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class WorkflowMonitoringPage extends BaseHelper{

	//step info - table
	private TestObject lblStepInfo =  createTestObject("txtLastStepName", "id", "ucSubSecGvWf_subSectionID")
	private TestObject txtLastStepName =  createTestObject("txtLastStepName", "xpath", "(//*[contains(@id, 'gvWFView_lblWFSubsytemActName')])[last()]")


	public void switchToSecondTab() {
		WebUI.switchToWindowIndex(1)
	}
	
	public void switchToFirstTab() {
		WebUI.switchToWindowIndex(0)
	}
	
	public void verifyLandingScreen() {
		WebUI.delay(5)
		WebUI.switchToDefaultContent()
		verifyLanding(lblStepInfo, "Workflow Monitoring")
		WebUI.takeScreenshot()
	}

	public void waitExecutionTimeHandling() {
		/*
		 * This Function made for wait execution time on backend
		 * Because the times is random, I assume 120s is great time to wait for stability testing
		 */
		WebUI.focus(txtLastStepName)
		KeywordUtil.logInfo(WebUI.getText(txtLastStepName))
		WebUI.delay(120)
		WebUI.refresh()
		WebUI.focus(txtLastStepName)
		KeywordUtil.logInfo(WebUI.getText(txtLastStepName))
	}

	public boolean verifyIsStepAlreadyOnSmsApprove() {
		WebUI.focus(txtLastStepName)//for ss purpose
		WebUI.takeScreenshot()
		String actualStep = WebUI.getText(txtLastStepName)

		return (actualStep == "SMS_APPROVE") ? true : false
	}

	public boolean verifyIsStepAlreadyOnApprovalfor() {
		WebUI.focus(txtLastStepName)//for ss purpose
		WebUI.takeScreenshot()
		String actualStep = WebUI.getText(txtLastStepName)
		KeywordUtil.logInfo("element " + actualStep)
		WebUI.delay(3)
		return (actualStep.containsIgnoreCase("Approval for")) ? true : false
	}

	public boolean verifyIsStepAlreadyOnPurchaseOrder() {
		WebUI.focus(txtLastStepName)//for ss purpose
		WebUI.takeScreenshot()
		String actualStep = WebUI.getText(txtLastStepName)

		return (actualStep == "Purchase Order") ? true : false
	}

	public void delayAndRefresh() {
		WebUI.delay(GlobalVariable.WAIT)
		WebUI.refresh()
	}

	public void verifyStep() {
		WebUI.focus(txtLastStepName)//for ss purpose
		WebUI.takeScreenshot()
	}
	
	public String getLastWorkFlow() {
		WebUI.focus(txtLastStepName)//for ss purpose
		WebUI.takeScreenshot()
		return WebUI.getText(txtLastStepName)
	}
	
	private boolean checkLastStepIsSurvey() {
		String actualLastStep = WebUI.getText(txtLastStepName).trim()
		WebUI.comment("Detected last step: '${actualLastStep}'")
		if(actualLastStep.contains("survey")) {
			return true
		} else {
			return false
		}
	}
	private void switchToPreviousTab() {
		int currentTab = WebUI.getWindowIndex()
		WebUI.switchToWindowIndex(currentTab - 1)
	}

	private void switchToPreviousTabAndCloseTab() {
		def driver = DriverFactory.getWebDriver()
		def tabs = driver.getWindowHandles().toList()
		driver.switchTo().window(tabs[0])
		driver.switchTo().window(tabs[1])
		driver.close()
		driver.switchTo().window(tabs[0])
		WebUI.delay(5)
		
	}
}
