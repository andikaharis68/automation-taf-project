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
import com.taf.pageobjects.losCreditProcess.ApplicationDataPage
import com.taf.pageobjects.losCreditProcess.AssetDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

ApplicationDataPage appData = new ApplicationDataPage()
MenuPage menu = new MenuPage()
AssetDataPage asset = new AssetDataPage()

'Step 1: Input Application data'
appData.inputApplicationData(MouNo, Tenor, PaymentFrequency, InterestMarginType, InstallmentScheme, FirstInstallmentType, SalesOfficer)

'Step 2: Select app source'
appData.inputApplicationInfoSection(ApplicationSource, FiduciaCovered, WayOfPayment)

'Step 3: Select and copy address from'
appData.selectAndCopyAddressFrom(MailingAddressFrom)

'Step 4: Input Phone number'
appData.inputPhoneNumbers(PhoneNumber, 1)

'Step 5: Select Characteristic of credit'
appData.selectCharacteristicOfCredit(CharacteristicOfCredit)

'Step 6: Click Save and continue'
appData.clickSaveContinue()

'Step 7: verify landing Asset registration data'
asset.verifyLandinginAssetDataPage()

