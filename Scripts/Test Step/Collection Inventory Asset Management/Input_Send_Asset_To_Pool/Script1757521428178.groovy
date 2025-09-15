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
import com.taf.pageobjects.collectionInventoryAssetManagement.SendAssetToPoolPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

SendAssetToPoolPage sendAsset = new SendAssetToPoolPage()
MenuPage menu = new MenuPage()

'Step 1: Select pool'
sendAsset.selectPool(Pool)

'Step 2: Input send by'
sendAsset.inputSendBy(SendBy)

'Step 3: Input send date'
sendAsset.inputSendDate(SendDate)

'Step 4: Input send asset notes'
sendAsset.inputNotes(SendAssetNotes)

'Step 5: Click submit'
sendAsset.clickSubmit()

'Step 6: Verify popu message'
menu.verifySuccessMessage()