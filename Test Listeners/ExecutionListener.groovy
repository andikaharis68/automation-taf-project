import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.taf.helpers.JsonDataStore
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class ExecutionListener {
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		String testCaseName = testCaseContext.getTestCaseId().tokenize('/').last()
		GlobalVariable.TEST_CASE_NAME = testCaseName
	}
	
	@AfterTestCase
	def afterTestCase() {
		(GlobalVariable.IS_CLOSE_BROWSER) ? WebUI.closeBrowser() : KeywordUtil.logInfo("Browser Not Closed")
	}
	
	@BeforeTestSuite
	def beforeTestSuites(TestSuiteContext testSuiteContext) {
		String sourceId = RunConfiguration.getReportFolder()
		if (sourceId.contains("Set_Default_Data_Store")) {
			GlobalVariable.SCENARIO_ID = JsonDataStore.getValue("ScenarioId")
		} 
	
	}

	@AfterTestSuite
	def afterTestSuites(TestSuiteContext testSuiteContext) {
		String sourceId = RunConfiguration.getReportFolder()
		if (sourceId.contains("Set_Default_Data_Store")) {
			JsonDataStore.setValue("ScenarioId", JsonDataStore.getValue("ScenarioId") + 1)
		}
	}
}