package com.taf.pageobjects.disbursement

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

public class DisbursementSelectionPage extends BaseHelper {
	//search
	private TestObject drpAPTypeName 			= createTestObject("drpAPTypeName", "id", "ucSearch_ddlRefAccPayableTypeId_ltlRefAccPayableTypeAccPayableTypeNameSearch_ddlReference")
	private TestObject txfApDueDate 			= createTestObject("txfApDueDate", "id", "ucSearch_txtAccPayableDueDt_ltlAccPayableAccPayableDueDtSearch_txtDatePicker")
	private TestObject drpBankName 				= createTestObject("drpBankName", "id", "ucSearch_ddlAPDestBankCode_ltlRefBankBankNameSearch_ddlReference")
	private TestObject btnSearch 				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject txfApDestination			= createTestObject("txfApDestination", "id", "ucSearch_txtAccPayableDestination_ltlAccPayableAccPayableDestinationSearch") 

	//AP Disbursement Selection-Grid
	private TestObject btnAddToTemp				= createTestObject("btnAddToTemp", "id", "lb_Form_AddToTemp")
	private TestObject txtApDestination 		= createTestObject("txtApDestination", "id", "gvSelected_lblAccPayableDestination_0") 
	private TestObject txtApDescription 		= createTestObject("txtApDescription", "id", "gvSelected_lbAccPayableDescr_0")
	private TestObject txtApAmount				= createTestObject("txtApAmount", "id", "gvSelected_lblAccPayableAmt_0") 
	private TestObject txtAppNo				 	= createTestObject("txtAppNo", "id", "gvSelected_lblAccPayableNo_0")
	private TestObject txtBankAccountName		= createTestObject("txtBankAccountName", "id", "rptDisb_rptDetail_0_lblBankAccountName_0")
	private TestObject txtAppBalanceSelected	= createTestObject("txtAppBalanceSelected", "id", "gvSelected_lblAccPayableBalance_0")

	private TestObject btnNext 					= createTestObject("btnNext", "id", "lb_Form_Next")

	//AP Disbursement Selection-Detail
	private TestObject drpWayOfPayment 			= createTestObject("drpWayOfPayment", "id", "rptDisb_ucWOP_0_ddlReference_0")
	private TestObject drpBankAccount 			= createTestObject("drpBankAccount", "id", "rptDisb_ucBankAccName_0_ddlReference_0")
	private TestObject btnRequestForApproval 	= createTestObject("btnRequestForApproval", "id", "lb_Form_ReqForApv")

	//popup status
	private TestObject lblPopUpTransactioStatus = createTestObject("lblPopUpTransactioStatus", "", "")
	private TestObject txtPopUpTransactioStatus = createTestObject("txtPopUpTransactioStatus", "", "")


	private void verifyLandingPage() {
		verifyLanding(drpAPTypeName, "Disbursement Selection")
		WebUI.takeScreenshot()
	}

	public void inputSearchApplication(String apTypeName, String apDueDate, String bankName,String apDestination) {
		apDestination  = apDestination.trim()
		safetySelect(drpAPTypeName, apTypeName)
		safetyInput(txfApDueDate, apDueDate)
		clickEnter(txfApDueDate)
		safetySelect(drpBankName, bankName)
		safetyInput(txfApDestination, apDestination)
	}

	public void clickButtonSearch() {
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}

	public void checklistApDisbursement(String apDestination) {
		TestObject cbkApDisbursement = createTestObject("cbkApDisbursement", "xpath", "//tr[td//span[contains(text(),'$apDestination')]]//input[@type='checkbox']")
		safetyClick(cbkApDisbursement)
		WebUI.takeScreenshot()
	}

	public void clickButtonAddToTemp() {
		safetyClick(btnAddToTemp)
		WebUI.takeScreenshot()
	}

	public Map getDisbursementSelectionData() {
		Map selectionData = [:]
		selectionData['ApDescription'] = WebUI.getText(txtApDescription)
		selectionData['ApAmount']	= WebUI.getText(txtApAmount)
		return selectionData
	}

	public void updateAppNoandBalanceToMasterData(String fileName, String scenarioId) {
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String appNo = WebUI.getText(txtAppNo)
		String appBalance = WebUI.getText(txtAppBalanceSelected)
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId
		
		saveDataToExcel(appNo, rowFilter, filePath, "MasterData", "ApplicationNo")
		saveDataToExcel(appBalance, rowFilter, filePath, "MasterData", "ApplicationBalance")
	}
	public String getApDescription() {
		return WebUI.getText(txtApDescription)
	}

	public void inputSelectionDetail(String wayOfPayment, String bankAccount) {
		safetySelect(drpWayOfPayment, wayOfPayment)
		if(wayOfPayment.equalsIgnoreCase("Bank")) {
			safetySelect(drpBankAccount, bankAccount)
		} else {
			KeywordUtil.logInfo("Way of payment is $wayOfPayment")
		}
		WebUI.takeScreenshot()
	}

	public void clickButtonRequestForApproval() {
		safetyClick(btnRequestForApproval)
	}

	public void verifyPopupStatusTransaction() {
		txtPopUpTransactioStatus = createTestObject("txtPopUpTransactioStatus", "", "")
		WebUI.waitForElementPresent(lblPopUpTransactioStatus, 10)
		WebUI.waitForElementPresent(txtPopUpTransactioStatus, 10)
	}

	private void clickNext() {
		safetyClick(btnNext)
		WebUI.takeScreenshot()
	}
	private void clickConfirmationOK() {
		WebUI.delay(0.5)
		if(WebUI.waitForAlert(5)) {
			WebUI.acceptAlert()
			WebUI.takeScreenshot()
		} else {
			KeywordUtil.markFailed("alert not found")
		}
	}
	public void updateMasterDataPOtoCustomer(String fileName, String scenarioId) {
		TestObject txtApDesc, txtAppNo
		txtApDesc = createTestObject("txtApDesc", "id", "rptDisb_rptDetail_0_gvGridDetail_0_lbAccPayableDescr_0") 
		txtAppNo  = createTestObject("txtAppNo", "id", "rptDisb_rptDetail_0_gvGridDetail_0_lblAccPayableNo_0")   
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String appNo = WebUI.getText(txtAppNo)
		String agreementNo = getNumberFromString(txtApDesc)
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId
		
		saveDataToExcel(appNo, rowFilter, filePath, "MasterData", "ApplicationNo")
		saveDataToExcel(agreementNo, rowFilter, filePath, "MasterData", "AgreementNo")
	}
	
	private void updateMasterDataPOtoCustomerNonSameday(String fileName, String scenarioId) {
		TestObject txtApDesc, txtAppNo, txtApBalance
		txtApDesc = createTestObject("txtApDesc", "id", "rptDisb_rptDetail_0_gvGridDetail_0_lbAccPayableDescr_0")
		txtAppNo  = createTestObject("txtAppNo", "id", "rptDisb_rptDetail_0_gvGridDetail_0_lblAccPayableNo_0")
		txtApBalance = createTestObject("txtApBalance", "id", "rptDisb_rptDetail_0_gvGridDetail_0_lblAPBalance_0") 
		
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String appNo = WebUI.getText(txtAppNo)
		String agreementNo = getNumberFromString(txtApDesc)
		String apAmount = WebUI.getText(txtApBalance)
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId
		
		saveDataToExcel(appNo, rowFilter, filePath, "MasterData", "ApplicationNo")
		saveDataToExcel(agreementNo, rowFilter, filePath, "MasterData", "AgreementNo")
		saveDataToExcel(apAmount, rowFilter, filePath, "MasterData", "ApplicationBalance")
		
	}
	public void clickRequestForApprovalandTakeScreenshot() {
		safetyClick(btnRequestForApproval)
		WebUI.takeScreenshot()
	}
}
