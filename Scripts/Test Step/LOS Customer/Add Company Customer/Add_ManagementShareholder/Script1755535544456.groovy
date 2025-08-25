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
import com.taf.pageobjects.customers.ManagementOrShareholderPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

ManagementOrShareholderPage management = new ManagementOrShareholderPage()
MenuPage menu = new MenuPage()

menu.switchIframeMainPage()

menu.switchIframeCustForm()

'Step 1: Click Add personal'
management.clickAddPersonal()

'Step 2: Get Data Management Type'
//Map ManagementData = management.getManagementData(ScenarioId, "Personal", GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", "ManagementShareholder")

'Step 3: Search Customer name'
management.searchCustomerName(FullName)

'Step 4: Select Job Position'
management.selectJobPosition(JobPosition)

'Step 5: Input share percentage personal'
management.inputSharePercentage(SharePersonal)

'Step 6: Click Save'
management.clickSavePersonal()

'Step 7: Click add company'
management.clickAddCompany()

'Step 8: Input CompanyName'
management.searchCustomerNameCompany(CompanyName)

'Step 9: input nitku'
management.inputNITku(NITKU)

'Step 10: Input share percentage'
management.inputSharePercentage(ShareCompany)

'Step 11: Check is Active'
management.checkIsActive(IsActive)

'Step 12: Check is Owner'
management.checkIsOwner(IsOwner)

'Step 13: Click Save Company'
management.clickSaveCompany()

'Step 14: Click Continue'
management.clickContinue()

'Step 15: Verify success message'
menu.verifySuccessMessage()






