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

Map scenarioData = [ScenarioId: GlobalVariable.SCENARIO_ID, TestDataName: 'LOS_New_Application_Retail_MultiAset.xlsx', 'SheetNames': ['Invoice', 'MasterData']]
Map dataRow = ['AgreementNo':'', 'InvoiceDate':'']
dataRow += scenarioData
dataRow += BaseHelper.getTestDataMultipleSheet(dataRow['SheetNames'], GlobalVariable.TEST_DATA_LOCATION + "/" + dataRow['TestDataName'], dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("Credential", GlobalVariable.TEST_DATA_LOCATION + "/" + dataRow['TestDataName'], dataRow["CredentialId"])

BaseHelper.openBrowser()

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow)
WebUI.delay(10)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Navigate_To_Application_Inquiry'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Inquiry_Get_Agreement_No'), dataRow)


WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Invoice/Navigate_To_Invoice'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Invoice/Search_Agreement_Number'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Invoice/Search_Purchase_Order'), dataRow)