package com.taf.pageobjects.collectionInventoryAssetManagement

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class CollectionAssetInventoryRequestPage extends BaseHelper {
	//header
	private TestObject lblTitle				= createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfAgreementNo		= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject btnSearch 			= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//Table
	private TestObject txtFirstAgreementNo	= createTestObject("txtFirstAgreementNo", "id", "gvPaging_lblAgrmntNo_0")
	private TestObject lblExecute			= createTestObject("lblExecute", "", "")
	private TestObject btnFirstPencil		= createTestObject("btnFirstPencil", "id", "gvPaging_imbExtend_0")

	//Detail
	//Asset Inventory Info
	private TestObject txfInventoryDate		= createTestObject("txfInventoryDate", "id", "ucdpInventoryDt_txtDatePicker")
	private TestObject txfInventoryNotes	= createTestObject("txfInventoryNotes", "id", "txtNotes")

	//Approval Request
	private TestObject drpReasonDesc		= createTestObject("drpReasonDesc", "id", "ucApproval_ddlReason")
	private TestObject txfApprovalNotes 	= createTestObject("txfApprovalNotes", "id", "ucApproval_txtNotes")
	private TestObject drpApprovedBy 		= createTestObject("drpApprovedBy", "id", "ucApproval_ddlApvBy")

	private TestObject btnSubmit 			= createTestObject("btnSubmit", "id", "lb_Form_Submit")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Asset Inventory Request Page")
		WebUI.takeScreenshot()
	}

	public void clickSearch() {
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}

	public void doSearchByAgreementNo(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
	}

	public String getAgreementNo() {
		return WebUI.getText(txtFirstAgreementNo)
	}
	
	public void updateAgreementNoToMasterData(String fileName, String newAgreementNo, String scenarioId) {
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId
		
		saveDataToExcel(newAgreementNo, rowFilter, filePath, "MasterData", "AgreementNo")
	}

	public void clickButtonPencil() {
		safetyClick(btnSearch)
	}

	public void inputInfoNotes(String notes) {
		WebUI.focus(txfInventoryNotes)
		WebUI.takeScreenshot()
		safetyInput(txfInventoryNotes, notes)
	}
	
	public void selectReasonDescription(String reason) {
		safetySelect(drpReasonDesc, reason)
	}
	
	public void inputApprovalNotes(String notes) {
		safetyInput(txfApprovalNotes, notes)
	}
	
	public void selectApprovedBy(String approvedBy) {
//		safetySelect(drpApprovedBy, approvedBy)
		safetySelectByIndex(drpApprovedBy, approvedBy)
		WebUI.takeScreenshot()
	}
	
	public void clickSubmit() {
		safetyClick(btnSubmit)
		WebUI.takeScreenshot()
	}
}
