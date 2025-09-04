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
import com.taf.pageobjects.losCreditProcess.OtherInfoPage
import com.taf.pageobjects.losCreditProcess.TermAndCondition

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

OtherInfoPage otherInfo = new OtherInfoPage()
TermAndCondition tnc = new TermAndCondition()

'Step 1: Select contract employee'
otherInfo.selectContractEmployee(ContractEmployeeLessThanTenor)

'Step 2: Select Rental bussiness without vehicle'
otherInfo.selectRentalBussiness(RentalBusinessWithoutVehicle)

'Step 3: Select Asset for Online Transport'
otherInfo.selectAssetforOnlienTransport(AssetForOnlineTransport)

'Step 4: Select Fraud Indication'
otherInfo.selectFraudIndication(FraudIndication)

'Step 5: Select High risk customer'
otherInfo.selectHighRiskCustomer(HighRiskCustomer)

'Step 6: Select high risk bussiness'
otherInfo.selectHighRiskBussiness(HighRiskBusiness)

'Step 7: Select credit approval process'
otherInfo.selectCreditApprovalProcess(CreditApprovalProcess)

'Step 8: Select owned vehicle'
otherInfo.selectOwnedVehicle(OwnedVehicle)

'Step 9: Select priority SEAL'
otherInfo.selectPrioritySeal(PrioritySEAL)

'Step 10: Input NPWP'
otherInfo.inputNPWP(Npwp)

'Step 11: Input NomorSKKumHam'
otherInfo.inputNomorSK(NomorSKKumHam)

'Step 12 Select STNK'
otherInfo.selectStnk(Stnk)

'Step 13: Select Status kepemilikan'
otherInfo.selectStatusKepemilikanNPWP(StatusKepemilikanNpwp)

'Step 14: Select CDE Notes'
otherInfo.selectCDEnotes(CdeNotes)

'Step 15: Click button save'
otherInfo.clickSave()

'Step 16: Verify Landing in Tnc Page'
tnc.verifyLandingInTnCPage()