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

Map scenarioData = [ScenarioId: GlobalVariable.SCENARIO_ID, TestDataName: 'Remedial_Deal_Amount_TestData.xlsx', 'SheetNames': ['RemedialDealAmountReq', 'MasterData']]

Map dataRow = [:]
dataRow += scenarioData
dataRow += BaseHelper.getTestDataMultipleSheet(dataRow['SheetNames'], GlobalVariable.TEST_DATA_LOCATION + "/" + dataRow['TestDataName'], dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("Credential", GlobalVariable.TEST_DATA_LOCATION + "/" + dataRow['TestDataName'], dataRow["CredentialId"])
	
BaseHelper.openBrowser()
dataRow['Username'] = BaseHelper.selectCredentialBasedOnArea(dataRow['HandlingOffice'])
WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/Remedial Deal Amount/Navigate_to_RemedialDeal_AmountRequest'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/Remedial Deal Amount/SearchAgremeent_and_NextToDetail'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/Remedial Deal Amount/Navigate_to_RemedialDeal_AmountInquiry_andVerifyAfterRequest'), dataRow, FailureHandling.CONTINUE_ON_FAILURE)

