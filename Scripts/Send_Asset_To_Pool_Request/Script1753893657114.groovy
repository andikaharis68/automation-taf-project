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
import com.taf.pageobjects.AssetInventoryRequestPage
import com.taf.pageobjects.LoginPage
import com.taf.pageobjects.SendAssetToPoolPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

LoginPage login = new LoginPage()
AssetInventoryRequestPage inventoryReq = new AssetInventoryRequestPage()
SendAssetToPoolPage sendAsset = new SendAssetToPoolPage()

'Login'
login.login("", "")

'Menu '
/*Ini nanti ditambahin ya soalnya ga buat dulu page menu
 * select dropdown collection
 * select menu repossess
 * select submenu asset inventory request
 */

'Get Agreement No'
inventoryReq.verifyLandingScreen()
inventoryReq.clickSearch()
String ValueAgreementNo = inventoryReq.getAgreementNo()

'Menu - Navigate to Send Asset Pool'
/*
 * select dropdown inventory asset management
 * select menu send asset to pool
 * select submenu send asset to pool
 */

'Send Asset To Pool'
'Do Search'
sendAsset.verifyLandingScreen()
sendAsset.doSearch(ValueAgreementNo, CollectionGroup)

'Click Button Pencil of result data'
sendAsset.clickButtonPencil()

'Input And Submit Mandatory Field'
sendAsset.inputSendAsset(Pool, SendBy, SendDate, SendNotes)

'Verify Success'
sendAsset.verifyPopupSuccess()
