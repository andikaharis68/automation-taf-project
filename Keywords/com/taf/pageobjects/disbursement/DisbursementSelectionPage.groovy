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
	private TestObject drpOfficeName			= createTestObject("drpOfficeName", "id", "ucSearch_ddlOfficeCode_ltlRefOfficeOfficeNameSearch_ddlReference")
	private TestObject txfApDueDate 			= createTestObject("txfApDueDate", "id", "ucSearch_txtAccPayableDueDt_ltlAccPayableAccPayableDueDtSearch_txtDatePicker")
	private TestObject drpBankName 				= createTestObject("drpBankName", "id", "ucSearch_ddlAPDestBankCode_ltlRefBankBankNameSearch_ddlReference")
	private TestObject btnSearch 				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject txfApDestination			= createTestObject("txfApDestination", "id", "ucSearch_txtAccPayableDestination_ltlAccPayableAccPayableDestinationSearch")
	private TestObject txfInvoiceDate			= createTestObject("txfInvoiceDate", "id", "ucSearch_txtInvoiceDt_ltlAccPayableInvoiceDtSearch_txtDatePicker")
	private TestObject drpIsReturnOnline		= createTestObject("drpIsReturnOnline", "id", "ucSearch_ddlIsOnlDisbReturn_ltlPayVoucherHIsOnlDisbReturn_ddlReference")

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
	private TestObject cbSelection				= createTestObject("cbSelection", "id", "gvGrid_cbCheck_0")
	private TestObject drpPage					= createTestObject("drpPage", "id", "ucGridFooter_ddlPageSize")


	private void verifyLandingPage() {
		verifyLanding(drpAPTypeName, "Disbursement Selection")
		WebUI.takeScreenshot()
		WebUI.delay(1)
	}

	public void clickButtonSearch() {
		safetyClick(btnSearch)
		WebUI.delay(2)
	}

	//select first row
	private void cheklistApDisbursement() {
		safetyClick(cbSelection)
		WebUI.takeScreenshot()
		WebUI.delay(5)
	}

	private void cheklistApDisWithEmptyOnlineDisburse() {
		cbSelection = createTestObject("cbSelection", "xpath", "//tr[td/span[normalize-space(text())='-']]//input[@type='checkbox']")
		if(WebUI.verifyElementPresent(cbSelection, 3, FailureHandling.OPTIONAL)) {
			WebUI.scrollToElement(cbSelection, 2)
			safetyClick(cbSelection)
			WebUI.comment("✅ Checkbox with '-' span clicked successfully.")
			WebUI.takeScreenshot()
			WebUI.delay(5)
		} else {
			safetySelect(drpPage, "50")
			WebUI.scrollToElement(cbSelection, 1)
			boolean isCbExist =  WebUI.verifyElementPresent(cbSelection, 1, FailureHandling.OPTIONAL)
			if(isCbExist) {
				safetyClick(cbSelection)
			} else {
				KeywordUtil.markFailed("Tidak ada product yg online disbursementny kosong")
			}
		}
	}

	public void clickButtonAddToTemp() {
		safetyClick(btnAddToTemp)
		WebUI.scrollToElement(txtApDescription, 2)
		WebUI.delay(3)
	}

	public Map getDisbursementSelectionData() {
		Map selectionData = [:]
		selectionData['ApDescription'] = WebUI.getText(txtApDescription)
		selectionData['ApAmount']	= WebUI.getText(txtApAmount)
		return selectionData
	}

	public void updateAppNoandBalanceToMasterData(String fileName, String scenarioId) {
		WebUI.scrollToElement(txtAppNo, 2)
		WebUI.takeScreenshot()

		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String appNo = WebUI.getText(txtAppNo)
		String appBalance = WebUI.getText(txtAppBalanceSelected)
		String apDestination = WebUI.getText(txtApDestination)

		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId

		saveDataToExcel(appNo, rowFilter, filePath, "MasterData", "ApplicationNo")
		saveDataToExcel(appBalance, rowFilter, filePath, "MasterData", "ApplicationBalance")
		saveDataToExcel(apDestination, rowFilter, filePath, "Approval", "ApDestinationApproval")		
		saveDataToExcel(apDestination, rowFilter, filePath, "Execution", "ApDestinationExecution")

		WebUI.delay(1)
	}
	
	public void updateAppNoandBalanceToMasterAndApproval(String fileName, String scenarioId) {
		WebUI.scrollToElement(txtAppNo, 2)
		WebUI.takeScreenshot()

		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String appNo = WebUI.getText(txtAppNo)
		String appBalance = WebUI.getText(txtAppBalanceSelected)
		String apDestination = WebUI.getText(txtApDestination)

		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId

		saveDataToExcel(appNo, rowFilter, filePath, "MasterData", "ApplicationNo")
		saveDataToExcel(appBalance, rowFilter, filePath, "MasterData", "ApplicationBalance")
		saveDataToExcel(apDestination, rowFilter, filePath, "Approval", "ApDestinationApproval")

		WebUI.delay(1)
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
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}

	public void clickButtonRequestForApproval() {
		safetyClick(btnRequestForApproval)
		WebUI.delay(1)
	}

	public void verifyPopupStatusTransaction() {
		txtPopUpTransactioStatus = createTestObject("txtPopUpTransactioStatus", "", "")
		WebUI.waitForElementPresent(lblPopUpTransactioStatus, 10)
		WebUI.waitForElementPresent(txtPopUpTransactioStatus, 10)
	}

	private void clickNext() {
		safetyClick(btnNext)
		WebUI.takeScreenshot()
		WebUI.delay(1)
	}
	private void clickConfirmationOK() {
		WebUI.delay(0.5)
		if(WebUI.waitForAlert(5,FailureHandling.OPTIONAL)) {
			WebUI.acceptAlert()
			WebUI.takeScreenshot()
		} else {
			KeywordUtil.logInfo("alert not found")
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
		WebUI.delay(1)
	}

	private void updateMasterDataPOtoCustomerNonSameday(String fileName, String scenarioId) {
		TestObject txtApDesc
		txtApDesc = createTestObject("txtApDesc", "id", "rptDisb_rptDetail_0_gvGridDetail_0_lbAccPayableDescr_0")

		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String agreementNo = getNumberFromString(txtApDesc)
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId

		saveDataToExcel(agreementNo, rowFilter, filePath, "MasterData", "AgreementNo")
		WebUI.delay(1)
	}
	public void clickRequestForApprovalandTakeScreenshot() {
		safetyClick(btnRequestForApproval)
		WebUI.delay(1)
	}

	public void inputSearchApplication(String apTypeName, String apDueDate, String bankName,String apDestination, String officeName, String invoiceDate, String isReturnOnlineDisburse) {
		if(officeName) {
			safetySelect(drpOfficeName, officeName)
		}

		safetySelect(drpAPTypeName, apTypeName)
		WebUI.delay(0.8)

		apDueDate = apDueDate.trim()
		safetyInput(txfApDueDate, apDueDate)
		pressEsc(txfApDueDate)
		WebUI.delay(0.8)

		safetySelect(drpBankName, bankName)
		WebUI.delay(0.8)

		if(apDestination) {
			apDestination  = apDestination.trim()
			safetyInput(txfApDestination, apDestination)
			WebUI.delay(0.8)
		}

		if(invoiceDate) {
			invoiceDate = invoiceDate.trim()
			safetyInput(txfInvoiceDate, invoiceDate)
			pressEsc(txfInvoiceDate)
			WebUI.delay(0.8)
		}

		if(isReturnOnlineDisburse) {
			safetySelect(drpIsReturnOnline, isReturnOnlineDisburse)
			WebUI.delay(0.8)
		}
	}
}
