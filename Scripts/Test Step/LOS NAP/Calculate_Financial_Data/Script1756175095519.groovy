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
import com.taf.pageobjects.losCreditProcess.NewApplicationDEPage
import com.taf.pageobjects.losCreditProcess.NewApplicationPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

NewApplicationPage financial = new NewApplicationPage()

'Step 1: Input Fees'
financial.inputFee(AdminFeeAmount, NotaryAmount, AdditionalAdminFee, OtherFee)

'Step 2: Input provision fee'
financial.inputProvisionFee(ProvisionType, ProvisionAmount)

'Step 3: Input Fiduciary'
financial.inputFiduciary(FiduciaOption, FiduciaFeeAmount)

'Step 4: Click calculate fee'
financial.clickCalculateFee()

'Step 5: Input financial Data'
financial.inputFinancialData(ResidualValue, Rate, Margin, GraceAmount, GracePeriod, Spread, TDPPaidatCompany, SubsidySupplier, SubsidyRate)

'Step 6: Click calculate installment'
financial.clickCalculateInstallment()

'Step 7: Click calculate'
financial.clickCalculate()

'step 8: cilck save and continue'
financial.clickSaveAndContinue()