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
import com.taf.pageobjects.losCreditProcess.AssetDataPage
import com.taf.pageobjects.losCreditProcess.InsuranceDataPage as InsuranceDataPage
import com.taf.pageobjects.losCreditProcess.LifeInsuranceDataPage as LifeInsuranceDataPage
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

InsuranceDataPage insuranceData = new InsuranceDataPage()
AssetDataPage asset = new AssetDataPage()
LifeInsuranceDataPage lifeInsurance = new LifeInsuranceDataPage()

'Step 1: Click Edit'
insuranceData.clickEdit()

'Step 2: Get radio selected'
ActualInsuredBy = insuranceData.selectInsuredBy(InsuredBy)

IsInsuredByDisabled = insuranceData.isInsuredByOptionDisabled(InsuredBy)

if (ActualInsuredBy == 'Customer') {
	
    'Step 3: Input Insurance Data init customer'
    insuranceData.inputInsuranceDataInitCustomer(InscoBranchName, PolicyName, StartDate, InsuranceNote, PolicyNo, CoverageAmount,  EndDate)
} else if (ActualInsuredBy == 'Company') {
	
    'Step 3: Input Insurance Data initialization company'
    insuranceData.inputInsuranceOtherDataInitCompany(SchemeName, RateType, MainCoverageType, CoverPeriod, InsuranceLength)
	
} else {
	
    'Step 3: Input Insurance Data initialization Customer/Company'
    insuranceData.inputInsuranceDataInitCustomer(InscoBranchName, PolicyName, StartDate, InsuranceNote, PolicyNo, CoverageAmount, EndDate)

    insuranceData.inputInsuranceOtherDataInitCompany(SchemeName, RateType, MainCoverageType, CoverPeriod, InsuranceLength)
}

if (!(IsInsuredByDisabled)) {
    'Step 4: Click next'
    insuranceData.clickNext()

    'Step 6.1: Check error after click save and continue'
	asset.checkErrorAfterClickSave()

    'Step 5: Click calculate'
    insuranceData.clickCalculate()

    'Step 6: Click save after calculate'
    insuranceData.clickSaveAfterCalculate()
	
} else {
    'Step 6: Click save'
    insuranceData.clickSave()
}

'Step 7: Click next'
insuranceData.clickNextToSaveAndContinue()

'Step 8: click save and continue'
insuranceData.clickSaveAndContinue()

'Step 9: Verify landing in life insurance data'
lifeInsurance.verifyLandingInLifeInsuranceData()