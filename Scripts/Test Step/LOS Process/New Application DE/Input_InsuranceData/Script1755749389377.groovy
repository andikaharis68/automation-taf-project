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
import com.taf.pageobjects.losCreditProcess.InsuranceDataPage
import com.taf.pageobjects.losCreditProcess.LifeInsuranceDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

InsuranceDataPage insuranceData = new InsuranceDataPage()
LifeInsuranceDataPage lifeInsurance = new LifeInsuranceDataPage()

'Step 1: Click Edit'
insuranceData.clickEdit()

'Step 2: Select Scheme Name'
insuranceData.selectSchemeName(SchemeName)

'Step 3: Select Rate Type'
insuranceData.selectRateType(RateType)

'Step 4: Click next'
insuranceData.clickNext()

'Step 5: Select Main coverage type'
insuranceData.selectMainCoverageType(MainCoverageType)

'Step 6: Click Calculate'
insuranceData.clickCalculate()

'Step 7: Click save'
insuranceData.clickSave()

'Step 8: Click next'
insuranceData.clickNextToSaveAndContinue()

'Step 9: click save and continue'
//insuranceData.clickSaveAndContinue()

'Step 10: Verify landing in life insurance data'
lifeInsurance.verifyLandingInLifeInsuranceData()
