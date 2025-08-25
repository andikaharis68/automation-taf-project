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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

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
import com.taf.helpers.BaseHelper
import com.taf.pageobjects.MenuPage
import com.taf.pageobjects.customers.AddressPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

AddressPage address = new AddressPage()
MenuPage menu = new MenuPage()

address.switchIframeMain()

address.switchIframeForm()

if(IsEditLegalAddress == "Y") {
	'Step 1: click add address'
	address.clickAddAddress()
	
	'Step 2: Select Address Type = Legal Address'
	address.selectAddressType("Legal Address")
	
	'Step 4: Input Address'
	address.inputAddress(LegalAddress)
	
	'Step 5: Input RT'
	address.inputRT(LegalRT)
	
	'Step 6: Input RW'
	address.inputRW(LegalRW)
	
	'Step 7: Select ZIP Code'
	address.searchAddressCompany(LegalZipCode)
	
	'Step 8: Check Customer Have Fixed Line'
	address.checkCustomerHaveFixedline(LegalCustomerDoesNotHaveFixedline)
	
	'Step 9: Input Phone 1'
	address.inputPhoneNumbers(LegalPhone1, 1)
	
	'Step 10: Input Phone 2'
	address.inputPhoneNumbers(LegalPhone2, 2)
	
	'Step 11: Input Phone 3'
	address.inputPhoneNumbers(LegalPhone3, 3)
	
	'Step 12: Input Fax'
	address.inputFax(LegalFax)
	
	'Step 13: Select Building Class Location'
	address.selectBuildingLocation(LegalBuildingLocationClass)
	
	'Step 14: Select Building Ownership'
	address.selectBuildingOwnerShip(LegalBuildingOwnership)
	
	'Step 15: Input Building price estimates'
	address.inputBuildingPriceEstimates(LegalBuildingPriceEstimates)
	
	'Step 16: Input Building stay length'
	address.inputBuildingStayLength(LegalBuildingStayLength)
	
	'Step 17: Input Direction description'
	address.inputDirectionDesc(LegalDirectionDescription)
	
	'Step 18: Input notes'
	address.inputNotes(LegalNotes)

	'Step 19: Click Save'
	address.clickSaveAddress()
}





