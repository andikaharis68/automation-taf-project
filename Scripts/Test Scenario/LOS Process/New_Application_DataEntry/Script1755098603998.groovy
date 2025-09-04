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

Map scenarioData = [ScenarioId: GlobalVariable.SCENARIO_ID, TestDataName: 'LOS_Process_Credit_Simulation_TestData.xlsx', 'SheetNames': ['NewApplicationDE', 'MasterData']]
Map dataRow = [:]
dataRow += scenarioData
dataRow += BaseHelper.getTestDataMultipleSheet(dataRow['SheetNames'], GlobalVariable.TEST_DATA_LOCATION + "/" + dataRow['TestDataName'], dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("Credential", GlobalVariable.TEST_DATA_LOCATION + "/" + dataRow['TestDataName'], dataRow["CredentialId"])
BaseHelper.openBrowser()

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Simulation/Navigate_to_NewApplication_DataEntry'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Search_DataCustomer'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Next_Until_GuarantorPage'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Input_GuarantorData'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Input_ApplicationData'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Edit_AssetRegistrationData'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Input_InsuranceData'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Input_LifeInsuranceData'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Input_FinancialData'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Input_OtherInfo'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/New Application DE/Click_And_InputPromiseData_TnC'), dataRow)