package com.taf.pageobjects.customers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class FinancialDataPage extends BaseHelper {

	private TestObject btnSaveContinue				= createTestObject("btnSaveAndContinue", "xpath", "//*[@id='lb_Form_SaveCont_FinancialData']")
	private TestObject txfGrossMonthlyIncome		= createTestObject("txfGrossMonthlyIncome", "xpath", "//*[@id='txt_CustFinData_GrossMonthlyIncomeAmt_txtInput']")
	private TestObject txfGrossProfit				= createTestObject("txfGrossProfit", "xpath", "//*[@id='txt_CustFinData_GrossProfitAmt_txtInput']")
	private TestObject txfOtherIncome				= createTestObject("txfOtherIncome", "xpath", "//*[@id='txt_CustFinData_OthIncomeAmt_txtInput']")
	private TestObject txfSourceOfOtherIncome		= createTestObject("txfSourceOfOtherIncome", "xpath", "//*[@id='txt_CustFinData_SourceOfOthIncome']")
	private TestObject txfLivingCost				= createTestObject("txfLivingCost", "xpath", "//*[@id='txt_CustFinData_LivingCostAmt_txtInput']")
	private TestObject txfOtherMonthlyInstallment	= createTestObject("txfOtherMonthlyInstallment", "xpath", "//*[@id='txt_CustFinData_OthMonthlyInstAmt_txtInput']")
	private TestObject btnCalculateIncome 			= createTestObject("btnCalculateIncome", "xpath", "//*[@id='btnCalculate']")

	private TestObject btnAddBankAcc				= createTestObject("btnAddBankAcc", "xpath", "//*[@id='lb_Form_Add_BankAcc']")
	private TestObject drpBankName					= createTestObject("drpBankName", "xpath", "//*[@id='ucBankStatementCustBankAcc_ucBankName_ddlReference']")
	private TestObject txfBankBranch				= createTestObject("txfBankBranch", "xpath", "//*[@id='ucBankStatementCustBankAcc_txtBankBranch']")
	private TestObject txfBICode					= createTestObject("txfBICode", "xpath", "//*[@id='ucBankStatementCustBankAcc_txtBiCode']")
	private TestObject txfAccName					= createTestObject("txfAccName", "xpath", "//*[@id='ucBankStatementCustBankAcc_txtAccName']")
	private TestObject txfAccNo						= createTestObject("txfAccNo", "xpath", "//*[@id='ucBankStatementCustBankAcc_txtAccNo']")
	private TestObject drpBankAccPurpose			= createTestObject("drpBankAccPurpose", "xpath", "//*[@id='ucCustBankAccPurpose_ddlReference']")
	private TestObject btnSaveBankAcc				= createTestObject("btnSaveBankAcc", "xpath", "//*[@id='lb_Form_Save_BankAcc']")

	private TestObject btnAddBankStatement			= createTestObject("btnAddBankStatement", "xpath", "//*[@id='lb_Form_Add_BankStatement']")
	private TestObject drpBankNameStatement			= createTestObject("drpBankNameStatement", "xpath", "//*[@id='ucBankStatement_ucBankName_ddlReference']")
	private TestObject txfBankBranchStatement		= createTestObject("txfBankBranchStatement", "xpath", "//*[@id='ucBankStatement_txtBankBranch']")
	private TestObject txfBICodeStatement			= createTestObject("txfBICodeStatement", "xpath", "//*[@id='ucBankStatement_txtBiCode']")
	private TestObject txfAccNameStatement			= createTestObject("txfAccNameStatement", "xpath", "//*[@id='ucBankStatement_txtAccName']")
	private TestObject txfAccNoStatement			= createTestObject("txfAccNoStatement", "xpath", "//*[@id='ucBankStatement_txtAccNo']")
	private TestObject btnSaveStatement				= createTestObject("btnSaveStatement", "xpath", "//*[@id='lb_Form_Save_BankStatement']")
	private TestObject btnCalculateStatement		= createTestObject("btnCalculateStatement", "xpath", "//*[@id='lb_Form_Calculate_BankStatementAddEdit']")
	//*[@id="gvBankStatementAddEdit_ddlMonth_1"]
	private TestObject txfCreditBeginningBalance	= createTestObject("txfCreditBeginningBalance", "xpath", "//*[@id='gvBankStatementAddEdit_txtCustBankStatementDCreditAmt_0_txtInput_0']")



	private void clickSaveContinue() {
		WebUI.click(btnSaveContinue)
		WebUI.delay(2)
	}

	private void verifyLandinginFinancialPage() {
		verifyLanding(txfGrossMonthlyIncome, "Financial Data")
	}

	private void inputGrossMonthlyIncome(String income) {
		safetyInputEdit(txfGrossMonthlyIncome, income)
//		if(income) {
//			WebUI.setText(txfGrossMonthlyIncome, income)
//			WebUI.delay(2)
//		}
	}

	private void inputGrossProfit(String grossProfit) {
		safetyInputEdit(txfGrossProfit, grossProfit)
//		if(grossProfit) {
//			WebUI.setText(txfGrossProfit, grossProfit)
//			WebUI.delay(2)
//		}
	}

	private void inputOtherIncome(String otherIncome) {
		safetyInputEdit(txfOtherIncome, otherIncome)
//		if(otherIncome) {
//			WebUI.setText(txfOtherIncome, otherIncome)
//			WebUI.delay(2)
//		}
	}

	private void inputSourceOfIncome(String sourceIncome) {
		safetyInputEdit(txfSourceOfOtherIncome, sourceIncome)
//		if(sourceIncome) {
//			WebUI.setText(txfSourceOfOtherIncome, sourceIncome)
//			WebUI.delay(2)
//		}
	}

	private void inputLivingCost(String cost) {
		safetyInputEdit(txfLivingCost, cost)
//		if(cost) {
//			WebUI.setText(txfLivingCost, cost)
//			WebUI.delay(2)
//		}
	}

	private void inputOtherMonthlyInstallment(String installment) {
		safetyInputEdit(txfOtherMonthlyInstallment, installment)
//		if(installment) {
//			WebUI.setText(txfOtherMonthlyInstallment, installment)
//			WebUI.delay(2)
//		}
	}
	private void clickCalculateIncome() {
		WebUI.click(btnCalculateIncome)
	}
	private void clickAddCustAcc() {
		WebUI.click(btnAddBankAcc)
	}

	private void selectBankName(String bankName) {
		safetySelectEdit(drpBankName, bankName)
//		if(bankName) {
//			WebUI.selectOptionByLabel(drpBankName, bankName, false)
//			WebUI.delay(2)
//		}
	}
	private void inputBranchName(String name) {
		safetyInputEdit(txfBankBranch, name)
//		if(name) {
//			WebUI.setText(txfBankBranch, name)
//			WebUI.delay(2)
//		}
	}

	private void inputBICodeBank(String code) {
		safetyInputEdit(txfBICode, code)
//		if(code) {
//			WebUI.setText(txfBICode, code)
//			WebUI.delay(2)
//		}
	}

	private void inputAccName(String name) {
		safetyInputEdit(txfAccName, name)
//		if(name) {
//			WebUI.setText(txfAccName, name)
//			WebUI.delay(2)
//		}
	}

	private void inputAccountNo(String accNo) {
		safetyInputEdit(txfAccNo, accNo)
//		if(accNo) {
//			WebUI.setText(txfAccNo, accNo)
//			WebUI.delay(2)
//		}
	}

	private void selectBankAccPurpose(String purpose) {
		safetySelectEdit(drpBankAccPurpose, purpose)
//		if(purpose) {
//			WebUI.click(drpBankAccPurpose)
//			WebUI.selectOptionByLabel(drpBankAccPurpose, purpose, trues)
//		}
	}

	private void clickSaveAccount() {
		WebUI.click(btnSaveBankAcc)
	}
	private void clickAddStatement() {
		handleAlertIfPresent()
		WebUI.click(btnAddBankStatement)
		WebUI.delay(2)
	}

	private void selectBankNameStatement(String bankName) {
		if(bankName) {
			WebUI.selectOptionByLabel(drpBankNameStatement, bankName, false)
			WebUI.delay(2)
		}
	}
	private void inputBankBranchStatement(String branchStatement) {
		if(branchStatement) {
			WebUI.setText(txfBankBranchStatement, branchStatement)
			WebUI.delay(2)
		}
	}

	private void inputBICodeStatement(String code) {
		if(code) {
			WebUI.setText(txfBICodeStatement, code)
			WebUI.delay(2)
		}
	}

	private void inputAccNameStatement(String accNameStatement) {
		if(accNameStatement) {
			WebUI.setText(txfAccNameStatement, accNameStatement)
			WebUI.delay(2)
		}
	}

	private void inputAccNoStatement(String accNoStatement) {
		if(accNoStatement) {
			WebUI.setText(txfAccNoStatement, accNoStatement)
			WebUI.delay(2)
		}
	}

	private void clickCalculateStatement() {
		WebUI.click(btnCalculateStatement)
	}

	private void inputStatementBeginingBalance(String balance) {
		if(balance) {
			WebUI.setText(txfCreditBeginningBalance, balance)
			WebUI.delay(2)
		}
	}

	private void selectStatementMonth(String month, Integer index) {
		if(month) {
			TestObject drpMonth = createTestObject("", "xpath", "//*[@id='gvBankStatementAddEdit_ddlMonth_${index}']")
			WebUI.selectOptionByLabel(drpMonth, month, false)
			WebUI.delay(2)
		}
	}

	private void inputStatementYear(String year, Integer index) {
		if(year) {
			TestObject txfYear = createTestObject("txfYear", "xpath", "//*[@id='gvBankStatementAddEdit_txtYear_${index}']")
			WebUI.setText(txfYear, year)
			WebUI.delay(2)
		}
	}
	private void inputStatementDebit(String debit, Integer index) {
		if(debit) {
			TestObject drpDebit = createTestObject("drpDebit", "xpath", "//*[@id='gvBankStatementAddEdit_txtCustBankStatementDDebitAmt_${index}_txtInput_${index}']")
			WebUI.setText(drpDebit, debit)
			WebUI.delay(2)
		}
	}

	private void inputStatementCredit(String credit, Integer index) {
		if(credit) {
			TestObject drpCredit = createTestObject("drpCredit", "xpath", "//*[@id='gvBankStatementAddEdit_txtCustBankStatementDDebitAmt_${index}_txtInput_${index}']")
			WebUI.setText(drpCredit, credit)
			WebUI.delay(2)
		}
	}
	private void handleAlertIfPresent() {
		if(WebUI.waitForAlert(5)) {
			WebUI.acceptAlert()
		} else {
			KeywordUtil.logInfo("Alert not found")
		}
	}
}
