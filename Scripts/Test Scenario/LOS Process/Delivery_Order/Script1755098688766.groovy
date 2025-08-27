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
Map dataRow = [:]
String testDataName = "LOS_Process_Credit_Simulation_TestData.xlsx"
dataRow += BaseHelper.getTestDataByScenario("DeliveryOrder", GlobalVariable.TEST_DATA_LOCATION + "/" + testDataName, scenarioId)
dataRow += BaseHelper.getTestDataByScenario("Credential", GlobalVariable.TEST_DATA_LOCATION + "/" + testDataName, dataRow["CredentialId"])

BaseHelper.openBrowser()

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(10)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Navigate_To_Delivery_Order'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Search_Application_Number'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Select_List_Of_Asset'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Input_Data_Delivery_Order'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Delivery Order/Submit_Asset'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)