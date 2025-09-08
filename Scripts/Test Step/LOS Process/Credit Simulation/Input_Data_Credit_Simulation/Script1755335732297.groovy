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
import com.taf.pageobjects.losCreditProcess.CreditSimulation

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CreditSimulation credsim = new CreditSimulation()
credsim.switchToIframeMain()

'Step 0: click button add'
credsim.clickAdd()

'Step 1: input section main information'
credsim.inputMainInformation(CustomerName, CustomerType, ProductOfferingCode, MaritalStatus, NumOfAsset)

'Step 2: input section application data'
credsim.inputApplicationData(Tenor, InstallmentScheme, PaymentFrequency)

'Step 3: input section life insurance data'
if(CustomerType == "Personal") {	
	credsim.inputLifeInsuranceData(LifeInscoBranchName, PremiumPaymentMethod)
}

'Step 4: klik next'
credsim.clickNext()

'Step 4: klik add asset data'
credsim.clickAddAsset()

'Step 5: input section asset data'
credsim.inputAssetData(SupplierBranchName, AssetName, AssetPrice, DpType, DownPayment, AssetUsage)

'Step 5: klik next'
credsim.clickNext()

'Step 6: input section insurance data initialization'
credsim.inputInsuranceDataInitialization(SchemeName)

'Step 7: input section insurance rate to customer'
credsim.inputInsuranceRateToCustomer(MainCoverageType1, MainCoverageType2)

'Step 8: klik next'
credsim.clickNext()

'Step 9: input asset data'
credsim.calculateFeeAndFinancialData()

'Step 10: klik next'
credsim.clickNext()

'Step 11: klik generate'
credsim.clickGenerate()

'Step 12: klik next'
credsim.clickNext()
