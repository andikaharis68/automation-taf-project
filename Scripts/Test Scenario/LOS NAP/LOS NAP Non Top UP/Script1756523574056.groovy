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

String scenarioId = GlobalVariable.SCENARIO_ID
String testDataName = BaseHelper.getTestDataName()
Map dataRow = [:]

dataRow += BaseHelper.getTestDataByScenario("NewApplication", GlobalVariable.TEST_DATA_LOCATION + "/" + testDataName, scenarioId)
dataRow += BaseHelper.getTestDataByScenario("Credential", GlobalVariable.TEST_DATA_LOCATION + "/" + testDataName, dataRow["CredentialId"])
dataRow += ["ExcelName" : testDataName,
			"ApplicationNo" : ""]

BaseHelper.openBrowser()

WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(10)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Navigate_To_New_Application'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Add_New_Application'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Input_Customer_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Input_Gurantor_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Input_Application_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Inpu_Asset_Data_Non_TopUp'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Edit_Asset_Registration'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Edit_Insurance_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Input_Insurance_Life_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Calculate_Financial_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Calculate_Commission_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Input_Other_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Input_Other_Info_Data'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Term_And_Condition'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS NAP/Click_Submit_New_Application'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)

//step check inquiry
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Navigate_To_Application_Inquiry'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Select_Credit_Approval_Workflow'), dataRow)