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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.pageobjects.losCreditProcess.WorkflowMonitoringPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WorkflowMonitoringPage workflowMonitoring = new WorkflowMonitoringPage()

'Step 1: switch to second tab'
workflowMonitoring.switchToSecondTab()

'Step 2: verify landing in workflow monitoring screen'
workflowMonitoring.verifyLandingScreen()

'Step 3: verify is step is already on sms approve'
IsSmsApprove = workflowMonitoring.verifyIsStepAlreadyOnSmsApprove()

int counter = 0
while (!IsSmsApprove && GlobalVariable.COUNTER > counter) {
	'Step 3.1: execution time handling'
	workflowMonitoring.delayAndRefresh()
	
	'Step 3.2: double check is step already on sms approve after wait execution time'
	IsSmsApprove = workflowMonitoring.verifyIsStepAlreadyOnSmsApprove()
}
