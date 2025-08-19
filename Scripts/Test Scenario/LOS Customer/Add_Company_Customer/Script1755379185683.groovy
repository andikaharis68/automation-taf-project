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

String scenarioId = "1"
Map scenarioData = [:]
scenarioData += BaseHelper.getTestDataByScenario("Credentials", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", scenarioId)
scenarioData += BaseHelper.getTestDataByScenario("CustMainData",GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", scenarioId)
scenarioData += BaseHelper.getTestDataByScenario("MainData",GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", scenarioId)
BaseHelper.openBrowser()

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/NavigateTo_CustomerMain_Data'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Company Customer/Add_CustomerCompany_CustomerInformation'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Company Customer/Add_CustomerCompany_CustomerMainData'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)

scenarioData += BaseHelper.getTestDataByScenario("Address",GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", scenarioId)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Company Customer/Add_LegalAddressCompany'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Company Customer/Add_CompanyAddress'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)

scenarioData += BaseHelper.getTestDataByScenario("ContactInformation",GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", scenarioId)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Company Customer/Add_ContactInformation'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)

scenarioData += BaseHelper.getTestDataByScenario("FinancialData",GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", scenarioId)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Company Customer/Add_FinancialData'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)

scenarioData += BaseHelper.getTestDataByScenario("LegalDocument",GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", scenarioId)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Company Customer/Add_LegalDocument'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)

scenarioData += BaseHelper.getTestDataByScenario("OtherAttribute",GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", scenarioId)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Company Customer/Add_OtherAttribute'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
