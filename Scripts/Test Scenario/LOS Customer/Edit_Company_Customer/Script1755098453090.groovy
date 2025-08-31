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
import com.taf.helpers.BaseHelper as BaseHelper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String scenarioId = GlobalVariable.SCENARIO_ID
List<String> sheetNames = [
	'Credentials', 'CustMainData', 'MainData', 'LegalAddress', 'CompanyAddress', 'ManagementShareholder', 
	'ContactInformation', 'ContactInformation', 'FinancialData', 'LegalDocument', 'OtherAttribute']

Map scenarioData = [:]
scenarioData = BaseHelper.getTestDataMultipleSheet(sheetNames, "$GlobalVariable.TEST_DATA_LOCATION/LOS_Customer_Edit_Company_TestData.xlsx", scenarioId)

BaseHelper.openBrowser()
WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Add Personal Customer/NavigateTo_CustomerMain_Data'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Search_Company_Data'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Main_Data'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Legal_Address'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Company_Address'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Management_Shareholder'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Contact_Information'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Financial_Data'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Legal_Document'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Other_Attribute'), scenarioData, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Customer/Edit Company Customer/Edit_Company_Verify_Success'), scenarioData, FailureHandling.STOP_ON_FAILURE)

