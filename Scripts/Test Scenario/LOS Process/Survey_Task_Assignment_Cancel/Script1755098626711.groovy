import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.fge.jsonschema.library.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String testDataName = BaseHelper.getTestDataName()

Map scenarioData = [ 
	'ScenarioId': GlobalVariable.SCENARIO_ID,  
	'SheetNames': ['Survey', 'MasterData'],
	'StepApplication': 'PAP',
	'StepCheck': false, 
	'Counter': 1
] 

Map dataRow = [:]
dataRow += scenarioData
dataRow += BaseHelper.getTestDataMultipleSheet(dataRow['SheetNames'], "${GlobalVariable.TEST_DATA_LOCATION}/${testDataName}", dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("Credential", "${GlobalVariable.TEST_DATA_LOCATION}/${testDataName}", dataRow["CredentialId"])
BaseHelper.openBrowser()

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow)

//Checking Step
while(5 > dataRow['Counter']) {
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Navigate_To_Application_Inquiry'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Checking_Step_Application'), dataRow)
	if(dataRow['StepCheck']) {
		break
	}
	dataRow['Counter'] += 1
	WebUI.delay(GlobalVariable.WAIT)
}

WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Check_Survey_Needed'), dataRow)
if(dataRow['StepCheck']) {
	//Main Step
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Survey Task Assignment Cancel/Navigate_To_Survey_Task'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Survey Task Assignment Cancel/Search_Transaction_Reference'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Survey Task Assignment Cancel/Cancel_Survey_Task_Assignment'), dataRow)
}
