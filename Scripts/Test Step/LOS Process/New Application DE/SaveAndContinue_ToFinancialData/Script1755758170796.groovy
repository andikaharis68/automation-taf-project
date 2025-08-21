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
import com.taf.pageobjects.losCreditProcess.ComissionDataPage
import com.taf.pageobjects.losCreditProcess.FinancialDataPage
import com.taf.pageobjects.losCreditProcess.LifeInsuranceDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

LifeInsuranceDataPage lifeInsurance = new LifeInsuranceDataPage()
MenuPage menu = new MenuPage()
FinancialDataPage financial = new FinancialDataPage()
ComissionDataPage comission = new ComissionDataPage()

'Step 1: Click save and continue'
lifeInsurance.clickSaveAndContinue()

'Step 2: Verify Notif success'
menu.verifySuccessMessage()

'Step 3: Verify Landing in Financial Data'
financial.verifyLandingInFinancialData()

'Step 4: Click calculate fee'
financial.clickCalculateFee()

'Step 5: Click calculate installment'
financial.clickCalculateInstallment()

'Step 6: Click calculate'
financial.clickCalculate()

'Step 7: Click save and continue'
financial.clickSaveContinue()

'Step 8: verify notif success'
menu.verifySuccessMessage()

'Step 9: Verify landing in comission data page'
comission.verifyLandingInComissionData()

