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

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String testDataName = BaseHelper.getTestDataName()

Map scenarioData = [ ScenarioId: GlobalVariable.SCENARIO_ID, 
					'SheetNames': ['DeliveryOrder', 'MasterData'],
					'StepApplication': 'RVC', //ini step apps nya
					'StepCheck': false, //ini step check nya. nampung hasil dari euqals actual step dan expectation step
					'Counter': 0] //ini counter nya
Map dataRow = [:]
dataRow += scenarioData
dataRow += BaseHelper.getTestDataMultipleSheet(dataRow['SheetNames'], "${GlobalVariable.TEST_DATA_LOCATION}/${testDataName}", dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("Credential", "${GlobalVariable.TEST_DATA_LOCATION}/${dataRow['TestDataName']}", dataRow["CredentialId"])

BaseHelper.openBrowser()

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow)
WebUI.delay(10)

//Checking Step
while(!dataRow['StepCheck'] && (GlobalVariable.COUNTER > dataRow['Counter'])) {
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Navigate_To_Application_Inquiry'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Checking_Step_Application'), dataRow)
	dataRow['Counter'] += 1
	KeywordUtil.logInfo("$dataRow['StepCheck']")
	WebUI.delay(GlobalVariable.WAIT)
}
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Step_Info'), dataRow)
if(!dataRow['StepCheck']) {
	KeywordUtil.markFailedAndStop("Step tidak sampai RVC")
}

WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Navigate_To_Delivery_Order'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Search_Application_Number'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Select_List_Of_Asset'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Input_Data_Delivery_Order'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Submit_Asset'), dataRow)