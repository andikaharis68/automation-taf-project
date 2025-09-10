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
import com.taf.pageobjects.collectionInventoryAssetManagement.AssetInventoryRequestPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

AssetInventoryRequestPage inventoryRequest = new AssetInventoryRequestPage()
MenuPage menu = new MenuPage()

'Step 1: Switch To iframe menu'
menu.switchToIframeMenu()

'Step 2: Verify landing in asset inventory request page'
inventoryRequest.verifyLandingScreen()

'Step 3: Click search'
inventoryRequest.clickSearch()

'Step 4: Get agreement no'
NewAgreementNo = inventoryRequest.getAgreementNo()

'Step 5: Update agreement no to master data'
inventoryRequest.updateAgreementNoToMasterData(TestDataName, NewAgreementNo, ScenarioId)