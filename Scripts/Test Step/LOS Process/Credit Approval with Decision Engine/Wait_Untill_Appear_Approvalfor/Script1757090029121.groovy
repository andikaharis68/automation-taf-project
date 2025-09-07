import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper
import com.taf.pageobjects.losCreditProcess.ApplicationInquiryPage
import com.taf.pageobjects.losCreditProcess.ApplicationViewPage
import com.taf.pageobjects.losCreditProcess.WorkflowMonitoringPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

ApplicationInquiryPage inquiry = new ApplicationInquiryPage()
WorkflowMonitoringPage workflowMonitoring = new WorkflowMonitoringPage()

'Step 1: verify landing in application inquiry screen'
inquiry.verifyLandingScreen()

'Step 2: search inquiry by application no'
inquiry.searchByApplicationNo(ApplicationNo)

'Step 3: select result by application no'
inquiry.selectInquiryByApplicationStep()

'Step 1: switch to second tab'
workflowMonitoring.switchToSecondTab()

'Step 2: verify landing in workflow monitoring screen'
workflowMonitoring.verifyLandingScreen()

'Step 3: verify is step is already on sms approve'
IsApprovalfor = workflowMonitoring.verifyIsStepAlreadyOnApprovalfor()
KeywordUtil.logInfo("exis $IsApprovalfor")

int attempt = 0
while (!IsApprovalfor && GlobalVariable.COUNTER > attempt) {
	'Step 3.1: execution time handling'
	workflowMonitoring.delayAndRefresh()
	
	'Step 3.2: double check is step already on approval for after wait execution time'
	IsApprovalfor = workflowMonitoring.verifyIsStepAlreadyOnApprovalfor()
	
	attempt++
}

'Step 4: Switch to previous tab'
workflowMonitoring.switchToPreviousTabAndCloseTab()
