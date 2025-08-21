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
import com.taf.pageobjects.losCreditProcess.DeliveryOrderPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

DeliveryOrderPage data =  new DeliveryOrderPage()

'Step 1: take screenshot before'
WebUI.takeScreenshot()

'Step 2: input delivery information'
data.inputDeliveryInformation("661288", "K1235")

'Step 3: input asset attributes'
data.inputAssetAttribute("German", "6", "AUtomatic", "Blue", "")

'Step 4: input asset owner'
data.inputAssetOwner("09/08/2026")

'Step 5: input main document letter'
data.inputDocumentLetter("11/10/2025")

'Step 6: check all checkbox mandatory'
data.clickAllCheckBox("KAI243")

'Step 7: click save'
data.clickSave()

