package com.taf.pageobjects.customers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

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
	private TestObject txfCreditBeginningBalance	= createTestObject("txfCreditBeginningBalance", "xpath", "//*[@id='gvBankStatementAddEdit_txtCustBankStatementDCreditAmt_0_txtInput_0']")

	//iframe
	private TestObject iframeMainpage 				= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")

	private TestObject lblSuccess					= createTestObject("lblSuccess", "xpath", "//*[contains(@text(), 'Save Success')]")
	private TestObject lblAlert						= createTestObject("lblAlert", "xpath", "//*[contains(@text(), 'Your request is being processed']")
	private TestObject btnOK						= createTestObject("btnOK", "xpath", "//*[text()= 'OK']")

	private void clickSaveContinue() {
		safetyClick(btnSaveContinue)
		WebUI.takeScreenshot()
		handlePopUperror(lblAlert, btnOK)
	}

	static void handlePopUperror(TestObject to, TestObject btnOk) {
		if(WebUI.verifyElementPresent(to, 10, FailureHandling.OPTIONAL)) {
			WebUI.click(btnOk)
		} else {
			KeywordUtil.logInfo("Alert not found")
		}
	}

	private void verifyLandinginFinancialPage() {
		verifyLanding(txfGrossMonthlyIncome, "Financial Data")
		WebUI.takeScreenshot()
	}

	private void inputGrossMonthlyIncome(String income) {
		if(income) {
			clearText(txfGrossMonthlyIncome)
			safetyInput(txfGrossMonthlyIncome, income)
		}
	}
	private void clearText(TestObject to) {
		safetyClick(to)
		WebUI.sendKeys(to, Keys.chord(Keys.CONTROL, "a"))
		WebUI.sendKeys(to,Keys.chord(Keys.BACK_SPACE))
	}

	private void inputGrossProfit(String grossProfit) {
		if(grossProfit) {
			clearText(txfGrossProfit)
			safetyInput(txfGrossProfit, grossProfit)
		}
	}

	private void inputOtherIncome(String otherIncome) {
		if(otherIncome) {
			clearText(txfOtherIncome)
			safetyInput(txfOtherIncome, otherIncome)
		}
	}

	private void inputSourceOfIncome(String sourceIncome) {
		if(sourceIncome) {
			safetyInput(txfSourceOfOtherIncome, sourceIncome)
		}
	}

	private void inputLivingCost(String cost) {
		if(cost) {
			clearText(txfLivingCost)
			safetyInput(txfLivingCost, cost)
		}
	}

	private void inputOtherMonthlyInstallment(String installment) {
		if(installment) {
			clearText(txfOtherMonthlyInstallment)
			safetyInput(txfOtherMonthlyInstallment, installment)
		}
	}
	private void clickCalculateIncome() {
		safetyClick(btnCalculateIncome)
		handleAlertIfPresent()
		WebUI.takeScreenshot()
	}
	private void clickAddCustAcc() {
		safetyClick(btnAddBankAcc)
		handleAlertIfPresent()
		WebUI.takeScreenshot()
	}

	private void selectBankName(String bankName) {
		if(bankName) {
			safetySelect(drpBankName, bankName)
		}
	}
	private void inputBranchName(String name) {
		if(name) {
			safetyInput(txfBankBranch, name)
		}
	}

	private void inputBICodeBank(String code) {
		if(code) {
			safetyInput(txfBICode, code)
		}
	}

	private void inputAccName(String name) {
		if(name) {
			safetyInput(txfAccName, name)
		}
	}

	private void inputAccountNo(String accNo) {
		if(accNo) {
			safetyInput(txfAccNo, accNo)
			WebUI.delay(2)
		}
	}

	private void selectBankAccPurpose(String purpose) {
		if(purpose) {
			safetyClick(drpBankAccPurpose)
			safetySelect(drpBankAccPurpose, purpose)
		}
	}

	private void clickSaveAccount() {
		safetyClick(btnSaveBankAcc)
		handleAlertIfPresent()
		WebUI.takeScreenshot()
	}
	private void clickAddStatement() {
		handleAlertIfPresent()
		safetyClick(btnAddBankStatement)
		handleAlertIfPresent()
		WebUI.takeScreenshot()
	}

	private void selectBankNameStatement(String bankName) {
		if(bankName) {
			safetySelect(drpBankNameStatement, bankName)
		}
	}
	private void inputBankBranchStatement(String branchStatement) {
		if(branchStatement) {
			safetyInput(txfBankBranchStatement, branchStatement)
		}
	}

	private void inputBICodeStatement(String code) {
		if(code) {
			safetyInput(txfBICodeStatement, code)
		}
	}

	private void inputAccNameStatement(String accNameStatement) {
		if(accNameStatement) {
			safetyInput(txfAccNameStatement, accNameStatement)
		}
	}

	private void inputAccNoStatement(String accNoStatement) {
		if(accNoStatement) {
			safetyInput(txfAccNoStatement, accNoStatement)
		}
	}

	private void clickCalculateStatement() {
		safetyClick(btnCalculateStatement)
		handleAlertIfPresent()
	}

	private void inputStatementBeginingBalance(String balance) {
		if(balance) {
			clearText(txfCreditBeginningBalance)
			safetyInput(txfCreditBeginningBalance, balance)
		}
	}

	private void selectStatementMonth(String month, Integer index) {
		if(month) {
			TestObject drpMonth = createTestObject("", "xpath", "//*[@id='gvBankStatementAddEdit_ddlMonth_${index}']")
			safetySelect(drpMonth, month)
		}
	}

	private void inputStatementYear(String year, Integer index) {
		if(year) {
			TestObject txfYear = createTestObject("txfYear", "xpath", "//*[@id='gvBankStatementAddEdit_txtYear_${index}']")
			safetyInput(txfYear, year)
			WebUI.delay(2)
		}
	}
	private void inputStatementDebit(String debit, Integer index) {
		if(debit) {
			TestObject drpDebit = createTestObject("drpDebit", "xpath", "//*[@id='gvBankStatementAddEdit_txtCustBankStatementDDebitAmt_${index}_txtInput_${index}']")
			clearText(drpDebit)
			safetyInput(drpDebit, debit)
		}
	}

	private void inputStatementCredit(String credit, Integer index) {
		if(credit) {
			TestObject drpCredit = createTestObject("drpCredit", "xpath", "//*[@id='gvBankStatementAddEdit_txtCustBankStatementDDebitAmt_${index}_txtInput_${index}']")
			clearText(drpCredit)
			safetyInput(drpCredit, credit)
		}
	}
	private void inputIncomeSection(String monthlyIncome) {
		inputGrossMonthlyIncome(monthlyIncome)
		clickCalculateIncome()
		WebUI.takeScreenshot()
	}

	private void inputCustomerBankAccount(String bankName, String branchName, String accountName, String accountNo, String purpose) {
		selectBankName(bankName)
		inputBranchName(branchName)
		inputAccName(accountName)
		inputAccountNo(accountNo)
		selectBankAccPurpose(purpose)
	}

	public void switchToIframeMain() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	public void verifySaveSuccess() {
		verifyPopUpSuccess(lblSuccess, "Financial Data")
	}
}
