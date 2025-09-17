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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class CollectionExpenseRequestPage extends BaseHelper {
	//search
	private TestObject ifmMainPage = createTestObject("ifmMainPage", "id", "mainPage")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	//CollectionExpenseRequest - Grid
	private TestObject btnIconAction = createTestObject("btnIconAction", "xpath", "//*[contains(@id, 'gvPaging_imbEdit')]")
	private TestObject btnIconExecute = createTestObject("btnIconExecute", "id", "gvPaging_imbExecute_0")
	//ResultOfSellingEstimation
	private TestObject lblAgreementNo = createTestObject("lblAgreementNo", "id", "ucAgrmntInfo_lbAgrmntNo")
	private TestObject txfExternalFee = createTestObject("txfExternalFee", "id", "ucRoSEstimation_ucINCollExpenseExternalFee_txtInput")
	private TestObject txfRepoFee = createTestObject("txfRepoFee", "id", "ucRoSEstimation_ucINCollExpenseSettlementFee_txtInput")
	private TestObject txfMobilizationFee = createTestObject("txfMobilizationFee", "id", "ucRoSEstimation_ucINCollExpenseMobilizationFee_txtInput")
	private TestObject txfDeliveryCharges = createTestObject("txfDeliveryCharges", "id", "ucRoSEstimation_ucINCollExpenseDeliveryCharges_txtInput")
	private TestObject txfOtherOperationalFee = createTestObject("txfOtherOperationalFee", "id", "ucRoSEstimation_ucINCollExpenseOtherRepossessionFee_txtInput")
	private TestObject txfTotalOperationalFee = createTestObject("txfTotalOperationalFee", "id", "ucRoSEstimation_ucINCollExpenseTotalOperasionalCollectionFee_txtInput")
	private TestObject txfDepositAmount = createTestObject("txfDepositAmount", "id", "ucRoSEstimation_ucINCaseAnalysisFormHPaidInstallment_txtInput")
	private TestObject txfWaivedAmount = createTestObject("txfWaivedAmount", "id", "ucRoSEstimation_ucINCaseAnalysisFormHWaivedAmt_txtInput")
	private TestObject btnCalculate = createTestObject("btnCalculate", "id", "lbCalculate")
	//Analysis
	private TestObject drpProblemType = createTestObject("drpProblemType", "id", "ucAnalysis_ucRefProblemType_ddlReference")
	private TestObject drpUnitHolder = createTestObject("drpUnitHolder", "id", "ucAnalysis_ucRefUnitHolder_ddlReference")
	private TestObject drpUnitLocation = createTestObject("drpUnitLocation", "id", "ucAnalysis_ucRefUnitLocation_ddlReference")
	private TestObject txfAnalysisNote = createTestObject("txfAnalysisNote", "id", "ucAnalysis_txtAnalysisNotes")
	private TestObject txfIsUnitExists = createTestObject("txfIsUnitExists", "xpath", "//*[contains(@for , 'ucAnalysis_rdlIsUnitExist') and text() = 'Yes']")
	private TestObject txfIsCustomerExists = createTestObject("txfIsCustomerExists", "xpath", "//*[contains(@for , 'ucAnalysis_rblIsCustExist') and text() = 'No']")
	//Action
	private TestObject btnHandlingBy = createTestObject("btnHandlingBy", "xpath", "//*[contains(@for , 'ucAction_rblHandlingBy') and text() = 'Internal']")
	private TestObject drpExecutor = createTestObject("drpExecutor", "id", "ucAction_UCReRalExecutor_ddlReference")
	private TestObject drpHandlingType = createTestObject("drpHandlingType", "id", "ucAction_ucRefHandlingType_ddlReference")
	private TestObject txfActionNote = createTestObject("txfActionNote", "id", "ucAction_txtActionNotes")
	//CollectionExpense
	private TestObject cbkAdvanceSettlement = createTestObject("cbkAdvanceSettlement", "id", "cbIsAdvance")
	private TestObject txfDisburseTo = createTestObject("txfDisburseTo", "id", "txtDisburseTo")
	private TestObject drpDisburseTo = createTestObject("drpDisburseTo", "id", "ucRefDisburseTo_ddlReference")
	private TestObject txfCollectionExpenseNote = createTestObject("txfCollectionExpenseNote", "id", "txtReqNotes")
	private TestObject cbkSubjectTax = createTestObject("cbkSubjectTax", "id", "cbIsSubjectToTax")
	private TestObject txfCollExpenseNote = createTestObject("txfCollExpenseNote", "id", "txtReqNotes")
	//bank account transfer info
	private TestObject drpBankName = createTestObject("drpBankName", "id", "ucBankName_ddlReference")
	private TestObject txfBankBranch = createTestObject("txfBankBranch", "id", "txtBankBranch")
	private TestObject txfAccountNo = createTestObject("txfAccountNo", "id", "txtAccNo")
	private TestObject txfAccountName = createTestObject("txfAccountName", "id", "txtAccName")
	//ApprovalRequest
	private TestObject drpReason = createTestObject("drpReason", "id", "ucApproval_ucRefReasonExpense_ddlReference")
	private TestObject drpToBeApprobeBy = createTestObject("drpToBeApprobeBy", "id", "ucApproval_ddlApvBy")
	private TestObject txfApprovalRequestNote = createTestObject("txfApprovalRequestNote", "id", "ucApproval_txtNotes")
	//menu
	private TestObject btnSubmit = createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")

	public void verifyLandingPageSearch() {
		WebUI.waitForElementPresent(ifmMainPage, 10)
	}
	
	public void getAgreementNumber(String filePath, String id) {
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = id
		
		WebUI.waitForElementPresent(lblAgreementNo, 10)
		String agreementNumber = WebUI.getText(lblAgreementNo)
		saveDataToExcel(agreementNumber, rowFilter, filePath, "MasterData", "AgreementNumber")
	}
	
	public void verifyLandingCollectionExpenseRequest() {
		if(!WebUI.waitForElementPresent(btnSubmit, 10)) {
			KeywordUtil.markFailed("Gagal masuk ke halaman request setelah klik icon action")
		}
		WebUI.takeScreenshot()
	}
	
	public void switchToMainPage(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
	}

	public void inputAgreementNo(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
	}

	public void clickButtonSearch() {
		safetyClick(btnSearch)
	}

	public void clickButtonIconAction() {
		WebUI.takeScreenshot()
		safetyClick(btnIconAction)
	}

	public void clickButtonIconExecute() {
		WebUI.takeScreenshot()
		safetyClick(btnIconExecute)
		handlePopupAlert()
	}
	
	public void verifySuccessExecute() {
		if(!WebUI.waitForElementNotPresent(btnIconExecute, 20, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markFailed("Failed setelah melakukan klik icon execute")
		}
		WebUI.takeScreenshot()
	}

	public void inputSellingEstimation(String externalFee, String repoFee) {
		safetyInput(txfExternalFee, externalFee)
		safetyInput(txfRepoFee, repoFee)
	}

	public void inputAnalysis(String problemType, String unitHolder, String unitLocation, String note) {
		WebUI.selectOptionByLabel(drpProblemType, problemType, false)
		WebUI.selectOptionByLabel(drpUnitHolder, unitHolder, false)
		WebUI.selectOptionByLabel(drpUnitLocation, unitLocation, false)
		safetyInput(txfAnalysisNote, note)
	}

	public void inputAction(String executor, String handlingType, String note) {
		WebUI.selectOptionByLabel(drpExecutor, executor, false)
		WebUI.selectOptionByLabel(drpHandlingType, handlingType, false)
		safetyInput(txfRepoFee, note)
	}

	public void inputCollectioExpense(String disburseTo, String note) {
		safetyInput(txfDisburseTo, note)
		safetyInput(txfCollectionExpenseNote, note)
	}
	
	public void inputExternalFee(String externalFee) {
		manualClearText(txfExternalFee)
		safetyInput(txfExternalFee, externalFee)
	}
	
	public void inputRepoFee(String repoFee) {
		manualClearText(txfRepoFee)
		safetyInput(txfRepoFee, repoFee)
	}

	public void inputMobilizationFee(String mobilizationlFee) {
		manualClearText(txfMobilizationFee)
		safetyInput(txfMobilizationFee, mobilizationlFee)
	}
		
	public void inputDeliveryCharge(String deliveryCharge) {
		manualClearText(txfDeliveryCharges)
		safetyInput(txfDeliveryCharges, deliveryCharge)
	}
	
	public void inputOtherOperationalFee(String otherOperationalFee) {
		manualClearText(txfOtherOperationalFee)
		safetyInput(txfOtherOperationalFee, otherOperationalFee)
	}
	
	public void inputTotalOperationalFee(String totalOperationalFee) {
		manualClearText(txfTotalOperationalFee)
		safetyInput(txfTotalOperationalFee, totalOperationalFee)
		WebUI.takeScreenshot()
	}
	
	public void clickButtonCalculate() {
		safetyClick(btnCalculate)
		WebUI.takeScreenshot()
	}
	
	public void selectProblemType(String problemType) {
		safetySelect(drpProblemType, problemType)
	}
	
	public void selectUnitHolder(String unitHolder) {
		safetySelect(drpUnitHolder, unitHolder)
	}
	
	public void selectLocation(String unitLocation) {
		safetySelect(drpUnitLocation, unitLocation)
	}

	public void selectIsUnitExist(String isUnit) {
		TestObject txfIsUnitExists = createTestObject("txfIsUnitExists", "xpath", "//*[contains(@for , 'ucAnalysis_rdlIsUnitExist') and contains(text(), '${isUnit}')]")
		 safetyClick(txfIsUnitExists)
	}
	
	public void selectIsCustomerExist(String isCustomer) {
		TestObject txfIsCustomerExists = createTestObject("txfIsCustomerExists", "xpath", "//*[contains(@for , 'ucAnalysis_rblIsCustExist') and contains(text(), '${isCustomer}')]")
		safetyClick(txfIsCustomerExists)
	}

	public void inputAnalysisNote(String note) {
		safetyInput(txfAnalysisNote, note)
		WebUI.takeScreenshot()
	}
	
	public void selectHandlingBy(String handlingBy) {
		TestObject btnHandlingBy = createTestObject("btnHandlingBy", "xpath", "//*[contains(@for , 'ucAction_rblHandlingBy') and text() = '${handlingBy}']")
		safetyClick(btnHandlingBy)
	}
	
	public void selectExecutor(String executor) {
		safetySelect(drpExecutor, executor)
	}
	
	public void selectHandlingType(String handlingType) {
		safetySelect(drpHandlingType, handlingType)
	}
	
	public void inputActionNote(String note) {
		safetyInput(txfActionNote, note)
	}
	
	public void inputAdvanceSettlement(String note) {
		safetyClick(cbkAdvanceSettlement)
		if(WebUI.waitForElementPresent(drpDisburseTo, 5)) {
			WebUI.selectOptionByIndex(drpDisburseTo, 1)
		}
		safetyInput(txfCollectionExpenseNote, note)
		WebUI.takeScreenshot()
	}
	
	public void inputNonAdvanceSettlement(String disburseTo, String isSubjectToTax, String note) {
		safetyInput(txfDisburseTo, disburseTo)
		if(isSubjectToTax == "Y") {
			safetyClick(cbkSubjectTax)
		}
		safetyInput(txfCollectionExpenseNote, note)
		WebUI.takeScreenshot()
	}
	
	
	public void inputApprovalRequest(String reason, String approvedBy, String note) {
		WebUI.selectOptionByLabel(drpReason, reason, false)
		WebUI.selectOptionByLabel(drpToBeApprobeBy, approvedBy, false)
		safetyInput(txfApprovalRequestNote, note)
		WebUI.takeScreenshot()
	}

	public void inputBankAccountTranferInfo(String bankName, String bankBranch, String AccountNo, String AccountName) {
		safetySelect(drpBankName, bankName)
		safetyInput(txfBankBranch, bankBranch)
		safetyInput(txfAccountNo, AccountNo)
		safetyInput(txfAccountName, AccountName)
	}

	public void clickButtonSubmit() {
		safetyClick(btnSubmit)
	}
	
	public void verifySuccessSubmit() {
		if(!WebUI.waitForElementPresent(btnSearch, 20)) {
			KeywordUtil.markFailed("Gagal melakukan submit request")
		}
		WebUI.takeScreenshot()
	}
}
