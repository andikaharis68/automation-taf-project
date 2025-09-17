import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

String testDataName = BaseHelper.getTestDataName()

Map scenarioData = [
	'ScenarioId' : GlobalVariable.SCENARIO_ID,
	'SheetNames': ['CreditApproval', 'MasterData']
]

Map dataRow = [:]
dataRow += scenarioData
dataRow += BaseHelper.getTestDataMultipleSheet(dataRow['SheetNames'], "${GlobalVariable.TEST_DATA_LOCATION}/${testDataName}", dataRow['ScenarioId'])
dataRow += BaseHelper.getTestDataByScenario("Credential", "${GlobalVariable.TEST_DATA_LOCATION}/${testDataName}", dataRow['CredentialId'])

dataRow += WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Placeholder'), dataRow)

int maxLoop = 10
int retryCount = 0 
while(!dataRow['IsSmsApprove'] && retryCount < maxLoop) {
	KeywordUtil.logInfo("===== Credit Approval Attempt: ${retryCount + 1} =====")
	BaseHelper.openBrowser()
	
	//Get Credential for Approval
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Navigate_To_Application_Inquiry'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Wait_Untill_Appear_Approvalfor'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Get_Approval_Credential'), dataRow)
	BaseHelper.closeBrowser()
	//Credit Approval
	BaseHelper.openBrowser()
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser_For_Credit_Approval'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Navigate_To_Credit_Approval_With_Decision_Engine'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Search_Credit_Approval_With_Decision_Engine'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Do_Credit_Approval_With_Decision_Engine'), dataRow)
	
	//Checking Step 
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Navigate_To_Application_Inquiry'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Select_Credit_Approval_Workflow'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Validate_Step_On_Sms_Approve'), dataRow)
	
	BaseHelper.closeBrowser()
    KeywordUtil.logInfo("IsSmsApprove result after attempt ${retryCount + 1}: " + dataRow['IsSmsApprove'])
	if(dataRow['IsSmsApprove']) {
		break;
	}
	
	retryCount++
}

if (dataRow['IsSmsApprove']) {
	KeywordUtil.logInfo("SMS Approve is true. Proceeding with Resume Sms Approve flow...")
	dataRow['CredentialId'] = '9'
	WebUI.openBrowser(GlobalVariable.WEB_WORKFLOW_URL)
	WebUI.maximizeWindow()
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Resume_Sms_Approve'), dataRow)
	BaseHelper.closeBrowser()
	
	//Checking step is ready for purchase order
	BaseHelper.openBrowser()
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/General/Login_Browser'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Navigate_To_Application_Inquiry'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Select_Credit_Approval_Workflow'), dataRow)
	WebUI.callTestCase(findTestCase('Test Cases/Test Step/LOS Process/Credit Approval with Decision Engine/Validate_Step_On_Purchase_Order'), dataRow)
} 

