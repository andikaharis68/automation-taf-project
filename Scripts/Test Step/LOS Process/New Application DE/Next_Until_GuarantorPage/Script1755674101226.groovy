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
import com.taf.pageobjects.MenuPage
import com.taf.pageobjects.losCreditProcess.CustomerDataPage
import com.taf.pageobjects.losCreditProcess.GuarantorPage
import com.taf.pageobjects.losCreditProcess.MainInformationPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

MainInformationPage mainInfo = new MainInformationPage()
GuarantorPage guarantor = new GuarantorPage()
CustomerDataPage customer = new CustomerDataPage()
MenuPage menu = new MenuPage()

'Step 1: Click Next'
mainInfo.clickNext()

'Step 2: Update Application No To Excel Test Data (for next steps purpose)'
customer.updateAppNoToMasterData(TestDataName, ScenarioId)

'Step 3: Click Tab customer'
customer.clickTabCustomer()

'Step 4: Switch to iframe app'
customer.switchToIframeApp()

'Step 5: Click Save and continue'
customer.clickSaveContinue()

'Step 6: verify succcess message'
//menu.verifySuccessMessage()

'Step 7: verify Landing in guarantor'
guarantor.verifyLandingInGuarantorPage()

