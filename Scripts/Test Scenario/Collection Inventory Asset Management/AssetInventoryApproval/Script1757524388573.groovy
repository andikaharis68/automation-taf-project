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


Map scenarioData = [ScenarioId: GlobalVariable.SCENARIO_ID, TestDataName: 'Collection_Inventory_Asset_Management_TestData.xlsx', 'SheetNames': ['AssetInventoryApv', 'MasterData']]
Map dataRow = [:]
dataRow += scenarioData
dataRow += BaseHelper.getTestDataMultipleSheet(dataRow['SheetNames'], GlobalVariable.TEST_DATA_LOCATION + "/" + dataRow['TestDataName'], dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("Credential", GlobalVariable.TEST_DATA_LOCATION + "/" + dataRow['TestDataName'], dataRow["CredentialId"])

dataRow += WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection Inventory Asset Management/Placeholder'), dataRow)

//Get Approval Credentials
BaseHelper.openBrowser()
WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection Inventory Asset Management/Navigate_To_Asset_Inventory_Inquiry'), dataRow)
WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection Inventory Asset Management/Get_Approval_Credential_Asset_Inventory'), dataRow)
BaseHelper.closeBrowser()

int maxLoop = GlobalVariable.COUNTER
int retryCount = 0
while(!dataRow['IsStatusApprove'] && retryCount < maxLoop) {
	KeywordUtil.logInfo("===== Approval Attempt: ${retryCount + 1} =====")
	
	//Do Approval
	BaseHelper.openBrowser()
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser_For_Credit_Approval'), dataRow)// ini dapat digunakan juga untuk login approval yg lain tidak hanya credit approval
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection Inventory Asset Management/Navigate_To_Asset_Inventory_Approval'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection Inventory Asset Management/Input_Asset_Inventory_Approval'), dataRow)
	BaseHelper.closeBrowser()
	
	//Checking Step and Get Approval Credentials If Needed
	BaseHelper.openBrowser()
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection Inventory Asset Management/Navigate_To_Asset_Inventory_Inquiry'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection Inventory Asset Management/Validate_Status_Asset_Inventory'), dataRow)
	if (!dataRow['IsStatusApprove']) {
		WebUI.callTestCase(findTestCase('Test Cases/Test Step/Collection Inventory Asset Management/Get_Approval_Credential_Asset_Inventory'), dataRow)		
	}
	BaseHelper.closeBrowser()
	
	retryCount++
}