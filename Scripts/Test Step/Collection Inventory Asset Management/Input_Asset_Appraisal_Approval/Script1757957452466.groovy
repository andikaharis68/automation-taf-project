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
import com.taf.pageobjects.collectionInventoryAssetManagement.AssetAppraisalApprovalPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

MenuPage menu = new MenuPage()
AssetAppraisalApprovalPage approval = new AssetAppraisalApprovalPage()

'Step 1: switch to iframe main page'
menu.switchIframeMainPage()

'Step 2: verify landing in asset inventory approval page'
approval.verifyLandingScreen()

'Step 3: do search by agreement no'
approval.doSearch(AgreementNo)

'Step 4: click button search'
approval.clickSearch()

'Step 5: click process on first result of search'
approval.clickProcess()

'Step 6. select approval action'
approval.selectAction(ApraisalApvAction)

'Step 7: input notes'
approval.inputNotes(ApraisalApvNotes)

'Step 8: click button submit'
approval.clickSubmit()

'Step 9: verify popup success'
menu.verifySuccessMessage()