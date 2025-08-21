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
import com.taf.pageobjects.losCreditProcess.GuarantorPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

GuarantorPage guarantor = new GuarantorPage()
MenuPage menu = new MenuPage()

'Step 1: click add personal'
guarantor.clickAddPersonal()

'Step 2: Input customer name'
guarantor.inputCustomerName(GuarantorPersonal)

'Step 3: Select Customer relationship'
guarantor.selectCustRelationship(CustomerRelationshipPersonal)

'Step 4: Click Save'
guarantor.clickSave()

'Step 5: Click Add Company'
guarantor.clickAddCompany()

'Step 6: Input customer name'
guarantor.inputCustomerName(GuarantorCompany)

'Step 7: Select Customer relationship'
guarantor.selectCustRelationship(CustomerRelationshipCompany)

'Step 8: Click Save'
guarantor.clickSave()

'Step 9: Click save and continue'
guarantor.clickSaveContinue()

'Step 10: verify notif success'
menu.verifySuccessMessage()

'Step 11:switch to iframe '

'Step 10: verify landing'


