package com.taf.pageobjects.remedials

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

public class CollectionUnblockRequest extends BaseHelper {

	private TestObject txtRemedialGroup			= createTestObject("txtRemedialGroup", "xpath", "//*[@id='ucSearch_tblFixedSearch']/tbody/tr[1]/td[2]")
	private TestObject drpOfficeName			= createTestObject("drpOfficeName", "id", "ucSearch_ddlRefOfficeId_ltlRefOfficeOfficeNameSearch_ddlReference")  
	private TestObject txfOverdueDaysGreater	= createTestObject("txfOverdueDaysGreater", "id", "ucSearch_txtOverdueDays_ltlCollAgrmntOverdueDaysGteSearch_txtInput")
	private TestObject txfLastActionDateGreater	= createTestObject("txfLastActionDateGreater", "id", "ucSearch_txtLastActionDt_ltlCollAgrmntLastActionDtGteSearch_txtDatePicker")
	private TestObject txfCustomerName			= createTestObject("txfCustomerName", "id", "ucSearch_txtCustName_ltlCustCustName")
	private TestObject drpTypeOfProblem			= createTestObject("drpTypeOfProblem", "id", "ucSearch_ddlCollCaseId_ltlCollCaseTypeOfProblem_ddlReference")
	private TestObject drpCollectorName			= createTestObject("drpCollectorName", "id", "ucSearch_ddlCurrentCollectorId_ltlCollectorCollectorName_ddlReference")
	private TestObject txfAgreementNo			= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject txfOverdueDaysLess		= createTestObject("txfOverdueDaysLess", "id", "ucSearch_txtOverdueDays_ltlCollAgrmntOverdueDaysLteSearch_txtInput")
	private TestObject txfLastActionDateLess	= createTestObject("txfLastActionDateLess", "id", "ucSearch_txtLastActionDt_ltlCollAgrmntLastActionDtLteSearch_txtDatePicker")
	private TestObject drpAttention				= createTestObject("drpAttention", "id", "ucSearch_ddlIsSpvAttention_ltlCollAgrmntIsSpvAttentionSearch_ddlReference")
	private TestObject drpEWSMonitoringStatus 	= createTestObject("drpEWSMonitoringStatus", "id", "ucSearch_ddlEwsMonitoringStat_ltlAgrmntEwsMonitoringStatSearch_ddlReference")
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnPencilUnblock			= createTestObject("btnPencilUnblock", "id", "gvPaging_imbUnblock_0") 
	
	private TestObject txfNotes					= createTestObject("txfNotes", "id", "txtNotesAttention")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit") 
	private TestObject txtAgreementNo			= createTestObject("txtAgreementNo", "id", "gvPaging_lbAgrmntNo_0") 

	private void verifyLandingPage() {
		WebUI.delay(1)
		verifyLanding(drpOfficeName, "Collection Unblock Request")
		WebUI.takeScreenshot()
	}

	private void selectIfExist(TestObject to, String selectedValue) {
		if(selectedValue) {
			WebUI.comment("select $selectedValue")
			safetySelect(to, selectedValue)
			WebUI.delay(0.3)
		}
	}

	private void inputDateIfExist(TestObject to, String date) {
		if(date) {
			WebUI.comment("input $date")
			safetyInput(to, date)
			pressEsc(to)
			WebUI.delay(0.3)
		}
	}

	private void inputIfExist(TestObject to, String text) {
		if(text) {
			WebUI.comment("input $text")
			manualClearText(to)
			safetyInput(to, text)
			WebUI.delay(0.3)
		}
	}
	private void searchCustomer(String officeName, String overdueDaysGreater, String lastActionGreater, String customerName,
			String typeOfProblem, String collectorName, String agreementNo, String overdueDaysLess, String lastActionDateLess,
			String attention, String ewsMorningStatus) {
			
		selectIfExist(drpOfficeName, officeName)
		inputIfExist(txfOverdueDaysGreater, overdueDaysGreater)
		inputDateIfExist(txfLastActionDateGreater, lastActionGreater)
		inputIfExist(txfCustomerName, customerName)
		selectIfExist(drpTypeOfProblem, typeOfProblem)
		selectIfExist(drpCollectorName, collectorName)
		inputIfExist(txfAgreementNo, agreementNo)
		inputIfExist(txfOverdueDaysLess, overdueDaysLess)
		inputDateIfExist(txfLastActionDateLess, lastActionDateLess)
		selectIfExist(drpAttention, attention)
		selectIfExist(drpEWSMonitoringStatus, ewsMorningStatus)
		
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
		
	}
	private void clickEditUnblock() {
		safetyClick(btnPencilUnblock)
		WebUI.takeScreenshot()
	}
	
	private void inputNotes(String notes) {
		WebUI.waitForElementPresent(txfNotes, 3, FailureHandling.OPTIONAL)
		inputIfExist(txfNotes, notes)
		WebUI.takeScreenshot()
	}
	private void clickSubmit() {
		safetyClick(btnSubmit)
	}
	
	public void updateAgreementNoToExcelData(String fileName, String scenarioId) {
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String agreementNo = WebUI.getText(txtAgreementNo)
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId

		saveDataToExcel(agreementNo, rowFilter, filePath, "MasterData", "AgreementNoMaster")
		saveDataToExcel(agreementNo, rowFilter, filePath, "RemedialDealAmountReq", "AgreementNoRequest")
		WebUI.delay(1)
	}
}
