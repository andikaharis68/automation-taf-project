package com.taf.pageobjects.collection

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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class CollectionExpenseRequestPage extends BaseHelper {
	//search
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")
	//CollectionExpenseRequest - Grid
	private TestObject btnIconAction = createTestObject("btnIconAction", "", "")
	private TestObject btnIconExecute = createTestObject("btnIconExecute", "", "")
	//ResultOfSellingEstimation
	private TestObject txfExternalFee = createTestObject("txfExternalFee", "", "")
	private TestObject txfRepoFee = createTestObject("txfRepoFee", "", "")
	private TestObject btnCalculate = createTestObject("btnCalculate", "", "")
	//Analysis
	private TestObject drpProblemType = createTestObject("drpProblemType", "", "")
	private TestObject drpUnitHolder = createTestObject("drpUnitHolder", "", "")
	private TestObject drpUnitLocation = createTestObject("drpUnitLocation", "", "")
	private TestObject txfAnalysisNote = createTestObject("txfAnalysisNote", "", "")
	//Action
	private TestObject drpExecutor = createTestObject("drpExecutor", "", "")
	private TestObject drpHandlingType = createTestObject("drpHandlingType", "", "")
	private TestObject txfActionNote = createTestObject("txfActionNote", "", "")
	//CollectionExpense
	private TestObject cbkAdvanceSettlement = createTestObject("cbkAdvanceSettlement", "", "")
	private TestObject txfDisburseTo = createTestObject("txfDisburseTo", "", "")
	private TestObject txfCollectionExpenseNote = createTestObject("txfCollectionExpenseNote", "", "")
	//bank account transfer info
	private TestObject drpBankName = createTestObject("drpBankName", "", "")
	private TestObject drpBankBranch = createTestObject("drpBankBranch", "", "")
	private TestObject drpAccountNo = createTestObject("drpAccountNo", "", "")
	private TestObject drpAccountName = createTestObject("drpAccountName", "", "")
	//ApprovalRequest
	private TestObject drpReason = createTestObject("drpReason", "", "")
	private TestObject drpToBeApprobeBy = createTestObject("drpToBeApprobeBy", "", "")
	private TestObject txfApprovalRequestNote = createTestObject("txfApprovalRequestNote", "", "")
	//menu
	private TestObject btnSubmit = createTestObject("btnSubmit", "", "")


	public void inputAgreementNo(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
	}

	public void clickButtonSearch() {
		WebUI.click(btnSearch)
	}

	public void clickButtonIconAction(String agreementNo) {
		btnIconAction = createTestObject("btnIconAction", "", "")
		WebUI.click(btnIconAction)
	}

	public void clickButtonIconExecute(String agreementNo) {
		btnIconExecute = createTestObject("btnIconExecute", "", "")
		WebUI.click(btnIconExecute)
	}

	public void inputSellingEstimation(String externalFee, String repoFee) {
		WebUI.setText(txfExternalFee, externalFee)
		WebUI.setText(txfRepoFee, repoFee)
	}

	public void inputAnalysis(String problemType, String unitHolder, String unitLocation, String note) {
		WebUI.selectOptionByLabel(drpProblemType, problemType, false)
		WebUI.selectOptionByLabel(drpUnitHolder, unitHolder, false)
		WebUI.selectOptionByLabel(drpUnitLocation, unitLocation, false)
		WebUI.setText(txfAnalysisNote, note)
	}

	public void inputAction(String executor, String handlingType, String note) {
		WebUI.selectOptionByLabel(drpExecutor, executor, false)
		WebUI.selectOptionByLabel(drpHandlingType, handlingType, false)
		WebUI.setText(txfRepoFee, note)
	}

	public void inputCollectioExpense(String disburseTo, String note) {
		WebUI.setText(txfDisburseTo, note)
		WebUI.setText(txfCollectionExpenseNote, note)
	}

	public void checlistAdvenceSettlement() {
		WebUI.click(cbkAdvanceSettlement)
	}

	public void clickButtonCalculate() {
		WebUI.click(btnCalculate)
	}

	public void inputApprovalRequest(String reason, String approvedBy, String note) {
		WebUI.selectOptionByLabel(drpReason, reason, false)
		WebUI.selectOptionByLabel(drpToBeApprobeBy, approvedBy, false)
		WebUI.setText(txfApprovalRequestNote, note)
	}

	public void inputBankAccountTranferInfo(String bankName, String bankBranch, String AccountNo, String AccountName) {
		WebUI.selectOptionByLabel(drpBankName, bankName, false)
		WebUI.selectOptionByLabel(drpBankBranch, bankBranch, false)
		WebUI.selectOptionByLabel(drpAccountNo, AccountNo, false)
		WebUI.selectOptionByLabel(drpAccountName, AccountName, false)
	}

	public void clickButtonSubmit() {
		WebUI.click(btnSubmit)
	}
}
