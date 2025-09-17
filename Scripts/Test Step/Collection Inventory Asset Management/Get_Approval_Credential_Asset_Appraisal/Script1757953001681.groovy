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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.pageobjects.MenuPage
import com.taf.pageobjects.collectionInventoryAssetManagement.AssetAppraisalInquiryPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

MenuPage menu = new MenuPage()
AssetAppraisalInquiryPage inquiry = new AssetAppraisalInquiryPage()


'Step 1: switch to iframe main page'
menu.switchToIframeMainPage()

'Step 2: verify landing in inquiry page'
inquiry.verifyLandingScreen()

'Step 3: do search by agreement no'
inquiry.doSearch(AgreementNo)

'Step 4: click button search'
inquiry.clickSearch()

'Step 5: click last appraisal no'
inquiry.clickLastAppraisalNo()

'Step 6: switch to second tab'
inquiry.switchToSecondTab()

'Step 7: switch to default content'
menu.switchDefaultContent()

'Step 8: verify landing in view asset appraisal'
inquiry.verifyLandingInViewAssetAppraisal()

'Step 9: get approval credential'
Map appCreds = inquiry.getApprovalCredential()
ApprovalUsername = appCreds['owner']
ApprovalOffice = appCreds['office']
ApprovalPosition = appCreds['position']
ApprovalRole = appCreds['role']

KeywordUtil.logInfo("${appCreds}")