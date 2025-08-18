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
import com.taf.customers.AddressPage
import com.taf.customers.CustomerInformationPage
import com.taf.pageobjects.MenuPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

MenuPage menu = new MenuPage()
CustomerInformationPage custInfo = new CustomerInformationPage()

'Step 1. Click dropdown menu'
menu.clickDropdownMenu()

'Step 2: Switch to Iframe Menu'
menu.switchToIframeMenu()

'Step 3: Click button customer'
menu.clickCustomer()

'Step 4: Swith to default content'
menu.switchDefaultContent()

'Step 5: Switch to Iframe Menu'
menu.switchToIframeMenu()

'Step 6: Click submenu customer'
menu.clickSubMenuCustomer()

'Step 7: Swith to default content'
menu.switchDefaultContent()

'Step 8: Switch to Iframe Main'
custInfo.switchToIframeMain()

'Step 9: Verify Landing in Customer Information page'
custInfo.verifyLandingInCustInfoPage()
