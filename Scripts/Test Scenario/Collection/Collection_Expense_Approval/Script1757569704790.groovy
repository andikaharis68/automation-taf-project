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

String testDataName = BaseHelper.getTestDataNameCollection()
String scenarioId = GlobalVariable.SCENARIO_ID
List<String> sheetNames = ['Credentials', 'MasterData', 'Approval']

Map scenarioData = [
	"TestDataPath" : "${GlobalVariable.TEST_DATA_LOCATION}/${testDataName}",
	"ScenarioId" : GlobalVariable.SCENARIO_ID,
	"TaskOwner" : "",
	"IsStatusApproved" : false
]

int maxAttemp = 1
while(!scenarioData['IsStatusApproved'] && maxAttemp < 8 ) {	
	scenarioData += BaseHelper.getTestDataMultipleSheet(sheetNames, scenarioData["TestDataPath"] , scenarioData["ScenarioId"])
	WebUI.comment("get information taks owner, attemp " + maxAttemp)
	BaseHelper.openBrowser()
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), scenarioData, FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection/Navigate_To_Collection_Expense_Inquiry'), scenarioData, FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection/Search_Collection_Expense_Inquiry'), scenarioData, FailureHandling.STOP_ON_FAILURE)
	if(scenarioData['IsStatusApproved'] == true) {
		break
	}
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection/Get_Task_Owner_Inquiry'), scenarioData, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.comment("tobe approve with user : " + scenarioData['Username'])
	BaseHelper.openBrowser()
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), scenarioData, FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection/Navigate_To_Collection_Expanse_Approval'), scenarioData, FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection/Search_Collection_Expense_Approval'), scenarioData, FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection/Input_Data_Collection_Expense_Approval'), scenarioData, FailureHandling.STOP_ON_FAILURE)
	maxAttemp++
}
