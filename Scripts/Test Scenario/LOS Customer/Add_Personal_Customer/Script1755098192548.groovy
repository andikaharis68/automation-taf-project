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
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


BaseHelper.openBrowser()
Map ScenarioData = ['ScenarioId' : '1']

Map dataRow = [:]
dataRow += ScenarioData
dataRow += BaseHelper.getTestDataByScenario("Credentials", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_Customer_TestData.xlsx", dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("CustMainData",GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_Customer_TestData.xlsx", dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("MainData", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_Customer_TestData.xlsx", dataRow['ScenarioId'])

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(10)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/NavigateTo_CustomerMain_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_Customer_MainData'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Input_MainData'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_LegalAddress'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_ResidenceAddress'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_JobAddress'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)

dataRow += BaseHelper.getTestDataByScenario("Family", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_Customer_TestData.xlsx", dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("JobData", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_Customer_TestData.xlsx", dataRow['ScenarioId'])

WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_FamilyCustomer'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_JobData'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)

dataRow += BaseHelper.getTestDataByScenario("EmergencyContact", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_Customer_TestData.xlsx", dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("FinancialData", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_Customer_TestData.xlsx", dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("OtherAttribute", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_Customer_TestData.xlsx", dataRow['ScenarioId'])


WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_EmergencyContact'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_FinancialData'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_OtherAttribute'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)









