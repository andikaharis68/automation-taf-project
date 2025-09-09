package com.taf.pageobject.remedialexpense

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

public class RemedialExpenseRequestPage extends BaseHelper{

	private TestObject txtAgreementNo			= createTestObject("txtAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject drpBucketName			= createTestObject("drpBucketName", "id", "ucSearch_ddlCollBucketId_ltlCollBucketCollBucketName_ddlReference")
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")


	private TestObject txtExternalFee			= createTestObject("txtExternalFee", "id", "ucRoSEstimation_ucINCollExpenseExternalFee_txtInput")
	private TestObject txtRepoFee				= createTestObject("txtRepoFee", "id", "ucRoSEstimation_ucINCollExpenseSettlementFee_txtInput")
	private TestObject txtMobilizationFee		= createTestObject("txtMobilizationFee", "id", "ucRoSEstimation_ucINCollExpenseMobilizationFee_txtInput")
	private TestObject txtDeliveryCharges		= createTestObject("txtDeliveryCharges", "id", "ucRoSEstimation_ucINCollExpenseDeliveryCharges_txtInput")
	private TestObject txtOtherOperationalFee	= createTestObject("txtOtherOperationalFee", "id", "ucRoSEstimation_ucINCollExpenseOtherRepossessionFee_txtInput")
	private TestObject txtTotalOperationalFee	= createTestObject("txtTotalOperationalFee", "id", "ucRoSEstimation_ucINCollExpenseTotalOperasionalCollectionFee_txtInput")
	private TestObject txtDepositAMount			= createTestObject("txtDepositAMount", "id", "ucRoSEstimation_ucINCaseAnalysisFormHPaidInstallment_txtInput")
	private TestObject txtWaivedAmount			= createTestObject("txtWaivedAmount", "id", "ucRoSEstimation_ucINCaseAnalysisFormHWaivedAmt_txtInput")
	private TestObject btnCalculate				= createTestObject("btnCalculate", "id", "lbCalculate")

	private TestObject drpProblemType			= createTestObject("drpProblemType", "id", "ucAnalysis_ucRefProblemType_ddlReference")
	private TestObject drpUnitHolder			= createTestObject("drpUnitHolder", "id", "ucAnalysis_ucRefUnitHolder_ddlReference")
	private TestObject drpUnitLocation			= createTestObject("drpUnitLocation", "id", "ucAnalysis_ucRefUnitLocation_ddlReference")
	private TestObject txtNotesAnalyst			= createTestObject("txtNotesAnalyst", "id", "ucAnalysis_txtAnalysisNotes")


	private TestObject drpHandlingType			= createTestObject("drpHandlingType", "id", "ucAction_UCReRalExecutor_ddlReference")
	private TestObject drpExecutor				= createTestObject("drpExecutor", "id", "ucAction_UCReRalExecutor_ddlReference")
	private TestObject txtNotesAction			= createTestObject("txtNotesAction", "id", "ucAction_txtActionNotes")

	private TestObject chkAdvanceSettlement		= createTestObject("chkAdvanceSettlement", "id", "cbIsAdvance")
	private TestObject drpDisburseTo			= createTestObject("drpDisburseTo", "id", "")
	private TestObject txtDisburseTo			= createTestObject("drpDisburseTo", "id", "txtDisburseTo")
	private TestObject txtNoteRemedialExpense	= createTestObject("txtNoteRemedialExpense", "id", "txtReqNotes")

	//	private TestObject btnCalculate

	private TestObject drpBankName				= createTestObject("drpBankName", "id", "ucBankName_ddlReference")
	private TestObject txtBankBranch			= createTestObject("txtBankBranch", "id", "txtBankBranch")
	private TestObject txtAccountNo				= createTestObject("txtAccountNo", "id", "txtAccNo")
	private TestObject txtAccountName			= createTestObject("txtAccountName", "id", "txtAccName")

	private TestObject drpReason				= createTestObject("drpReason", "id", "ucApproval_ucRefReasonExpense_ddlReference")
	private TestObject drpApprover				= createTestObject("drpApprover", "id", "ucApproval_ddlApvBy")
	private TestObject txtNotesApproval			= createTestObject("txtNotesApproval", "id", "ucApproval_txtNotes")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")



	public void searchRemedialByAgreementNo(String agreementNo, String bucketName) {
		safetyInput(txtAgreementNo, agreementNo)
		safetySelect(drpBucketName, bucketName)
		safetyClick(btnSearch, 2)
		WebUI.takeScreenshot()
	}

	public void selectRemedial(String agreementNo) {
		TestObject btnAction = createTestObject("btnAction", "xpath", "//a[text() = '$agreementNo']/following::input[1]")
		safetyClick(btnAction, 5)
		WebUI.takeScreenshot()n
	}
	
	public void executeRemedial(String agreementNo) {
		TestObject btnExecute = createTestObject("btnExecute", "xpath", "//a[text() = '$agreementNo']/following::input[contains(@id, 'gvPaging_imbExecute')]")
		safetyClick(btnExecute, 9.5)
		WebUI.takeScreenshot()
	}

	public void inputResultSelling(String externalFee, String repoFee, String mobFee, String delivCharge, String opFee, String depoAmount, String waivedAmount) {
		manualClearText(txtExternalFee, 1)
		safetyInput(txtExternalFee, externalFee, 1.5)

		manualClearText(txtRepoFee, 1)
		safetyInput(txtRepoFee, repoFee, 1.5)

		manualClearText(txtMobilizationFee, 1)
		safetyInput(txtMobilizationFee, mobFee, 1.5)

		manualClearText(txtDeliveryCharges, 1)
		safetyInput(txtDeliveryCharges, delivCharge, 1.5)

		manualClearText(txtOtherOperationalFee, 1)
		safetyInput(txtOtherOperationalFee, opFee, 1.5)

		//		manualClearText(txtTotalOperationalFee, 1)
		//		safetyInput(txtTotalOperationalFee, "")

		manualClearText(txtDepositAMount, 1)
		safetyInput(txtDepositAMount, depoAmount, 1.5)

		manualClearText(waivedAmount, 1)
		safetyInput(waivedAmount, waivedAmount, 1.5)
	}

	public void clickCalculate() {
		safetyClick(btnCalculate, 3)
		WebUI.takeScreenshot()
	}

	public void inputAnalyst(String probType, String holder, String location, String unitExist, String custExist, String note) {

		TestObject rdnUnitExist		= createTestObject("rdnUnitExist", "xpath", "//label[contains(@for, 'UnitExist') and text() = '$unitExist']/preceding-sibling::input")
		TestObject rdnCustomerExist	= createTestObject("rdnCustomerExist", "xpath", "//label[contains(@for, 'CustExist') and text() = '$custExist']/preceding-sibling::input")

		safetySelect(drpProblemType, probType)

		safetySelect(drpUnitHolder, holder)

		safetySelect(drpUnitLocation, location)

		safetyClick(rdnUnitExist)
		safetyClick(rdnCustomerExist)

		safetyInputEdit(txtNotesAnalyst, note)

		WebUI.takeScreenshot()
	}

	public void inputAction(String handleBy, String handleType, String executor, String note) {

		TestObject rdnHndlingBy	= createTestObject("rdnHndlingBy", "xpath", "//label[contains(@for, 'HandlingBy') and text() = '$handleBy']/preceding-sibling::input")

		safetyClick(rdnHndlingBy)
		safetySelect(drpHandlingType, handleType)
		safetySelect(drpExecutor, executor)
		safetyInput(txtNotesAction, note)
	}

	public void selectRemedialAdvance(String isAdvance, String diburse, String note) {

		if(isAdvance == "Yes") {
			WebUI.check(chkAdvanceSettlement)
			safetySelect(drpDisburseTo, diburse, 2)
		}else {
			safetyInput(txtDisburseTo, diburse)
		}

		safetyInput(txtNoteRemedialExpense, note)
	}

	public void inputBankAccount(String bankName, String bankBranch, String accNo, String accName) {
		safetySelect(drpBankName, bankName, 3)

		safetyInput(txtBankBranch, bankBranch)
		safetyInput(txtAccountNo, accNo)
		safetyInput(txtAccountName, accName)
	}

	public void inputApprovalRequest(String reason, String approver, String note) {

		safetySelect(drpReason, reason, 1)
		safetySelect(drpApprover, approver)
		safetyInput(txtNotesApproval, note)
		WebUI.takeScreenshot()
	}

	public void clickSubmit() {
		safetyClick(btnSubmit)
	}
}
