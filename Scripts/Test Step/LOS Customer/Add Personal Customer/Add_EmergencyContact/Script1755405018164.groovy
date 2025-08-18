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
contact.inputName(Name)

'Step 3: Select Customer Relationship'
contact.selectCustomerRelationship(CustRelationship)

'Step 4: Input phone number1 '
contact.inputMobilePhone(MobilePhone1, 1)

'Step 5: Input phone number2'
contact.inputMobilePhone(MobilePhone2, 2)

'Step 6: Input phone number3'
contact.inputMobilePhone(MobilePhone3, 3)

'Step 7: Input email1'
contact.inputEmails(Email1, 1)

'Step 8: Input email2'
contact.inputEmails(Email2, 2)

'Step 9: Input address'
contact.inputAddress(Address)

'Step 10: Input RT'
contact.inputRT(RT)

'Step 11: Input RT'
contact.inputRW(RW)

'Step 12: Select Address'
contact.searchAddress(City)

'Step 13: Input phone number1 '
contact.inputPhoneNumbers(Phone1, 1)

'Step 14: Input phone number2'
contact.inputPhoneNumbers(Phone2, 2)

'Step 15: Input fax'
contact.inputFax(Fax)

'Step 16: Click save contact'
contact.clickSaveContact()

'Step 17: Verify Landing in Financial Data'
financial.verifyLandinginFinancialPage()



