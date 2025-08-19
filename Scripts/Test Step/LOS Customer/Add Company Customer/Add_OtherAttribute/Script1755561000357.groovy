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
import com.taf.pageobjects.customers.OtherAttributePage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

OtherAttributePage attr = new OtherAttributePage()

'Step 1: Handler iFrame, switch to default then switch to main frame'
attr.switchToIframeMain()

'Step 2: Verify landing in other attribute'
attr.verifyLandingInOtherAttribute()

'Step 2: Select Debitor grup'
attr.selectDebitorGroup(DebitorGroup)

'Step 3: Select Counterpart group'
attr.selectCounterpartCategory(CounterpartCategory)

'Step 4: Select Sustainable financial bussiness'
attr.selectSustainableFinancial(SustainableFinancialBusiness)

'Step 5: click Save and Submit'
attr.clickSave()