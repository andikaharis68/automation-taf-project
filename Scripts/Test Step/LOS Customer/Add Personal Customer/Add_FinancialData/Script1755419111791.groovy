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

'Step 1: input Income Section and click calculate'
financial.inputIncomeSection(GrossMonthlyIncome, GrossProfit, OtherIncome, SourceOfOtherIncome, LivingCost, OtherMonthlyInstallment)

'Step 2: Click Add Bank Account'
financial.clickAddCustAcc()

'Step 3: Input customer bank account section'
financial.inputCustomerBankAccount(BankName, BankBranch,BankBranchBICode, AccountName, AccountNo, CustomerBankAccountPurpose)

'Step 4: Click Save account'
financial.clickSaveAccount()

'Step 5: Click Add Statement'
financial.clickAddStatement()

'Step 6: Input Bank Statement'
financial.inputBankStatement(StatementBankName, StatementBankBranch, StatementBankBranchBICode, StatementAccountName, StatementAccountNo, StatementBeginingBalance)

'Step 7: Select Statement 1'
financial.selectStatement(StatementMonth1, StatementYear1,StatementDebit1, StatementCredit1 , 1)

'Step 8: Select Statement 2'
financial.selectStatement(StatementMonth2, StatementYear2,StatementDebit2, StatementCredit2 , 2)

'Step 9: Select Statement 3'
financial.selectStatement(StatementMonth3, StatementYear3,StatementDebit3, StatementCredit3 , 3)

'Step 10: Click Calculate'
financial.clickCalculateStatement()

'Step 11: Click save bank statement'
financial.clickSaveBankStatement()

'Step 12: Click Save and continue'
financial.clickSaveContinue()

'Step 13: Verify Landing in other attribute page'
attr.verifyLandingInOtherAttribute()

financial.takeScreenShot()