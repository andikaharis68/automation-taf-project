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
import com.taf.helpers.BaseHelper

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String testDataName = BaseHelper.getTestDataName()
String scenarioId = GlobalVariable.SCENARIO_ID
Map dataRow = [:]

dataRow += BaseHelper.getTestDataByScenario("Remedial", GlobalVariable.TEST_DATA_LOCATION + "/" + testDataName, scenarioId)
dataRow += BaseHelper.getTestDataByScenario("Credential", GlobalVariable.TEST_DATA_LOCATION + "/" + testDataName, dataRow["CredentialId"])
dataRow += ["statusRemed" : false,
			"counter" : 0]

BaseHelper.openBrowser()

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(10)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Navigate_To_Remedial_Expense_Request'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Select_Remedial_Request_Expense'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Completion_Data_Remedial_Advance'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)

//section inquiry
WebUI.delay(60)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Navigate_To_Remedial_Expense_Inquiry'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Remedial_Inquiry_Check_Status'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)

//section approval
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Navigate_To_Remedial_Expense_Approval'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Remedial_Approval'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)


//section check inquiry
while(!dataRow["statusRemed"] || dataRow["counter"] < 3) {
	WebUI.delay(60)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Navigate_To_Remedial_Expense_Inquiry'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Remedial_Inquiry_Check_Status'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
}

if(!dataRow["statusRemed"]) {
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Remedial_Inquiry_Get_Approval'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
}


//need script to looping approver

//section execute
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Navigate_To_Remedial_Expense_Request'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Remedial_Execute'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)


//section inquiry
WebUI.delay(60)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Navigate_To_Remedial_Expense_Inquiry'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Remedial Expense/Remedial_Inquiry_Check_Status'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)