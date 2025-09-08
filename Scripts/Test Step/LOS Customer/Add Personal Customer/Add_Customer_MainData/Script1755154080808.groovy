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
import com.taf.pageobjects.customers.AddPersonalCustomerPage
import com.taf.pageobjects.customers.CustomerInformationPage
import com.taf.pageobjects.customers.MainDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomerInformationPage custInfo = new CustomerInformationPage()
AddPersonalCustomerPage addPersonal = new AddPersonalCustomerPage()
MainDataPage mainData = new MainDataPage()

'Step 1: Click button add customer data'
custInfo.addPersonalCustomer()

'Step 2: Switch to default content'
custInfo.switchToDefaultContent()

'Step 3: Switch to iframe menu'
custInfo.switchToIframeMain()
	
'Step 4: Verify landing add personal customer page'
addPersonal.verifyLandingAddPersonalPage()

'Step 5: Select Customer Model'
addPersonal.selectCustomerModel(CustomerModel)

'Step 6: Input Customer Name'
CustomerName = addPersonal.inputCustomerName(CustomerName)

'Step 7: Select Id Type'
addPersonal.selectIdType(IdType)

'Step 8: Input ID Number'
addPersonal.inputIdNumber(IdNumber)

'Step 9: Select Gender'
addPersonal.selectGender(Gender)

'Step 10: Input ID Expired Date'
addPersonal.inputIdExpiredDate(IdExpiredDate)

'Syep 11: Input POB'
addPersonal.inputPOB(BirthPlace)

'Step 12: Input DOB'
addPersonal.inputDOB(BirthDate)

'Step 13: Input NPWP'
addPersonal.inputNPWP(NPWP)

'Step 14: Input Mother Maiden Name'
addPersonal.inputMotherMaidenName(MotherMaidenName)

'Step 15: Click next button'
addPersonal.clickNextButton()

'Step 16: Click edit or new app'
mainData.clickNewCustomerIfPresent()

'Step 17: Get Application no'
ApplicationNo = mainData.getApplicationNo()

'Step 18: Switch to frame custform'
mainData.switchToIframeCustForm()

'Step 19: Verify landing in main data page'
mainData.verifyLandingInMainData()



