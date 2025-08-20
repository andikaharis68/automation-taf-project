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
import com.taf.pageobjects.customers.FinancialDataPage
import com.taf.pageobjects.customers.OtherAttributePage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

FinancialDataPage financial = new FinancialDataPage()
OtherAttributePage attr = new OtherAttributePage()

'Step 1: Input Gross Monthly Income'
financial.inputGrossMonthlyIncome(GrossMonthlyIncome)

'Step 2: Input Gross Profit'
financial.inputGrossProfit(GrossProfit)

'Step 3: Input Other Income'
financial.inputOtherIncome(OtherIncome)

'Step 4: Input Source of Income'
financial.inputSourceOfIncome(SourceOfOtherIncome)

'Step 5: Input Living Cost'
financial.inputLivingCost(LivingCost)

'Step 6: Input Other Monthly Installment'
financial.inputOtherMonthlyInstallment(OtherMonthlyInstallment)

'Step 7: Click Calculate Income'
financial.clickCalculateIncome()

'Step 8: Click Add Bank Account'
financial.clickAddCustAcc()

'Step 9: Input bank name'
financial.selectBankName(BankName)

'Step 10: Input Bank Branch Name'
financial.inputBranchName(BankBranch)

'Step 11: Input Bank BI Code'
financial.inputBICodeBank(BankBranchBICode)

'Step 12: Input Acc Name'
financial.inputAccName(AccountName)

'Step 13: Input Acc No'
financial.inputAccountNo(AccountNo)

'Step 14: Click Save and continue'
financial.clickSaveContinue()

'Step 15: Verify Landing in other attribute page'
attr.verifyLandingInOtherAttribute()