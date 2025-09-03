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
import com.taf.pageobjects.confinsWorkflow.LoginPage
import com.taf.pageobjects.confinsWorkflow.MenuPage
import com.taf.pageobjects.confinsWorkflow.TaskMonitoringPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

MenuPage menu = new MenuPage()
TaskMonitoringPage task = new TaskMonitoringPage()
LoginPage login = new LoginPage()

'Step 0: Login'
login.doLogin("applconfins", "password")// mbak mintul pindahin ke test data ya nanti

'Step 1: Navigate to Task Monitoring'
menu.navigateToTaskMonitoring()

'Step 2: Switch To Iframe Main Page'
menu.switchIframeMainPage()

'Step 4: Search By TransactionNO/ApplicationNo'
task.searchByTransactionNo(ApplicationNo)

'Step 5: click Search'
task.clickSearch()

'Step 6: click select'
task.clickSelect()

'Step 7: click resume nya'
task.clickResume()