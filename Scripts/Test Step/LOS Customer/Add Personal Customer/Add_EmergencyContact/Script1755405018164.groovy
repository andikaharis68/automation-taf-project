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
import com.taf.pageobjects.customers.EmergencyContactPage
import com.taf.pageobjects.customers.FinancialDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

EmergencyContactPage contact = new EmergencyContactPage()
FinancialDataPage financial = new FinancialDataPage()

'Step 1: Click Add'
contact.clickAddContact()

'Step 2: Input name'
contact.inputName(EmergencyName)

'Step 3: Select Customer Relationship'
contact.selectCustomerRelationship(EmergencyCustomerRelationship)

'Step 4: Input phone number1 '
contact.inputMobilePhone(EmergencyMobilePhone1, 1)

'Step 5: Input phone number2'
contact.inputMobilePhone(EmergencyMobilePhone2, 2)

'Step 6: Input phone number3'
contact.inputMobilePhone(EmergencyMobilePhone3, 3)

'Step 7: Input email1'
contact.inputEmails(EmergencyEmail1, 1)

'Step 8: Input email2'
contact.inputEmails(EmergencyEmail2, 2)

contact.takeScreenShot()

'Step 9: Input Emergency Address'
contact.inputAddress(EmergencyAddress)

'Step 10: Input Emergency RT'
contact.inputRT(EmergencyRT)

'Step 11: Input Emergency RW'
contact.inputRW(EmergencyRW)

'Step 12: Search Address'
contact.searchAddress(EmergencyZipCode)

'Step 13: Input Phone number 1'
contact.inputPhoneNumbers(EmergencyPhoneNumber1, 1)

'Step 14: Input Phonu number 2'
contact.inputPhoneNumbers(EmergencyPhoneNumber2, 2)

'Step 15: Input Emergency Fax'
contact.inputFax(EmergencyFax)

'Step 16: Click save contact'
contact.clickSaveContact()

'Step 17: Verify Landing in Financial Data'
financial.verifyLandinginFinancialPage()



