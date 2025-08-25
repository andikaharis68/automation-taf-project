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

String scenarioId = "1"
List<String> sheetNames = [
	'Credentials', 'CustMainData', 'MainData', 'LegalAddress', 'ResidenceAddress', 'JobAddress', 'Family',
	'JobData', 'EmergencyContact', 'FinancialData', 'OtherAttribute']
Map scenarioData = [:]
scenarioData = BaseHelper.getTestDataMultipleSheet(sheetNames, "$GlobalVariable.TEST_DATA_LOCATION/LOS_Customer_Add_Personal_TestData.xlsx", scenarioId)

BaseHelper.openBrowser()
WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/NavigateTo_CustomerMain_Data'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_Customer_MainData'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Input_MainData'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_LegalAddress'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_ResidenceAddress'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_JobAddress'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_FamilyCustomer'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_JobData'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_EmergencyContact'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_FinancialData'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Add_OtherAttribute'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/Verify_AddCustomer_Success'), scenarioData, FailureHandling.CONTINUE_ON_FAILURE)








