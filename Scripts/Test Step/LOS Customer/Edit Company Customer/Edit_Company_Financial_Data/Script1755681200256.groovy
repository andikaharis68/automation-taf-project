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
import com.taf.pageobjects.customers.FinancialDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

FinancialDataPage financialData = new FinancialDataPage()

MenuPage menu = new MenuPage()

menu.switchIframeMainPage()

menu.switchIframeCustForm()

if(IsEditFinancialData == "Y") {

	'Step 2: input Income Section'
	financialData.inputIncomeSection(GrossMonthlyIncome, GrossProfit, OtherIncome, SourceOfOtherIncome, LivingCost, OtherMonthlyInstallment)
	
	'Step 3: Click add customer bank account'
	financialData.clickAddCustAcc()
	
	'Step 4: Input customer bank account section'
	financialData.inputCustomerBankAccount(BankName, BankBranch, BankBranchBICode, AccountName, AccountNo, CustomerBankAccountPurpose)
	
	'Step 5: Click save bank account'
	financialData.clickSaveAccount()
	
	'Step 6: Click Add Statement'
	financialData.clickEditStatement()
	
	'Step 7: Input Bank Statement'
	financialData.inputBankStatementCompany(StatementBankName, StatementBankBranch, StatementBankBranchBICode, StatementAccountName, StatementAccountNo, StatementBeginingBalance)
	
	'Step 8: Select Statement 1'
	financialData.selectStatement(StatementMonth1, StatementYear1,StatementDebit1, StatementCredit1 , 0)
	
	'Step 9: Select Statement 2'
	financialData.selectStatement(StatementMonth2, StatementYear2,StatementDebit2, StatementCredit2 , 1)
	
	'Step 10: Select Statement 3'
	financialData.selectStatement(StatementMonth3, StatementYear3,StatementDebit3, StatementCredit3 , 2)
	
	'Step 11: Click Calculate'
	financialData.clickCalculateStatement()
	
	'Step 12: Click save bank statement'
	financialData.clickSaveBankStatement()
	
	
}

'Step 6: Click save and continue'
financialData.clickSaveContinue()

'Step 7: Verify save success'
menu.verifySuccessMessage()