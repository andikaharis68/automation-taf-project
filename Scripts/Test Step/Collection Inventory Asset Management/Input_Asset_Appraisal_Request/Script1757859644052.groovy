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
import com.taf.pageobjects.collectionInventoryAssetManagement.AssetAppraisalRequestPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

MenuPage menu = new MenuPage()
AssetAppraisalRequestPage request = new AssetAppraisalRequestPage() 

'Step 1: switch to iframe main page'
menu.switchIframeMainPage()

'Step 2: verify landing in asset appraisal request page'
request.verifyLandingScreen()

'Step 3: do search by agreement no'
request.doSearch(AgreementNo)

'Step 4: click button search'
request.clickSearch()

'Step 5: click first button pencil based on result search'
request.clickButtonPencil()

'Step 6: select market price'
request.selectMarketPrice(MarketPriceOffice, MarketPriceAssetName, MarketPriceYear)

'Step 7: select deduction item'
request.selectDeducItem(DeductionItem)

'Step 8: input minimum selling amount'
request.inputMinSellingAmount(MinSellingAmt)

'Step 9: click button calculate'
request.clickCalculate()

'Step 10: select reason description'
request.selectReasonDescription(AppraisalReasonDescription)

'Step 11: input notes'
request.inputNotes(AppraisalReqNotes)

'Step 12: select approved by'
request.selectApprovedBy(AppraisalToBeApprovedBy)

'Step 13: click submit'
request.clickSubmit()

'Step 14: verify popup success'
menu.verifySuccessMessage()