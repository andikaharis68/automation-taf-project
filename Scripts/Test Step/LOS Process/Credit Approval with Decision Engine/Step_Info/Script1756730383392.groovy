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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.pageobjects.losCreditProcess.ApplicationInquiryPage
import com.taf.pageobjects.losCreditProcess.WorkflowMonitoringPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

ApplicationInquiryPage info = new ApplicationInquiryPage()
WorkflowMonitoringPage workflowMonitoring = new WorkflowMonitoringPage()


'Step 1: delay and take screenshot'
WebUI.delay(3)
WebUI.takeScreenshot()

'Step 2: klik application step'
info.selectInquiryByApplicationStep()

'Step 3: switch to second tab'
workflowMonitoring.switchToSecondTab()

'Step 4: verify landing in workflow monitoring screen'
workflowMonitoring.verifyLandingScreen()

'Step 5: verify is step is already on sms approve'
StepCheck = workflowMonitoring.getLastWorkFlow()

'Step 6: switch to first tab'
workflowMonitoring.switchToFirstTab()

