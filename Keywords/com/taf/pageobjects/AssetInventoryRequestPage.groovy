package com.taf.pageobjects

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

public class AssetInventoryRequestPage extends BaseHelper {
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject lblAgreementNo = createTestObject("txtOffice", "", "")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")

	//Table
	private TestObject lblAgreementNoTable = createTestObject("lblAgreementNoTable", "", "")
	private TestObject txtAgreementNoTable = createTestObject("txtAgreementNoTable", "", "")
	private TestObject lblExecute = createTestObject("lblExecute", "", "")
	private TestObject btnPencil = createTestObject("btnPencil", "", "")

	//Detail
	//Asset Inventory Info
	private TestObject drpInventoryDate = createTestObject("drpInventoryDate", "", "")
	private TestObject txtInventoryDate = createTestObject("txtInventoryDate", "", "")
	private TestObject txfInventoryNotes = createTestObject("txfInventoryNotes", "", "")

	//Approval Request
	private TestObject drpReasonDesc = createTestObject("drpReasonDesc", "", "")
	private TestObject txtReasonDesc = createTestObject("txtReasonDesc", "", "")
	private TestObject txfApprovalNotes = createTestObject("txfApprovalNotes", "", "")
	private TestObject drpApprovedBy = createTestObject("drpApprovedBy", "", "")
	private TestObject txtApprovedBy = createTestObject("txtApprovedBy", "", "")

	private TestObject btnSubmit = createTestObject("btnSubmit", "", "")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Asset Inventory Request Page")
	}

	public void clickSearch() {
		WebUI.click(btnSearch)
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
		clickSearch()
	}

	public void getAgreementNo() {
		WebUI.getText(txtAgreementNoTable)
	}

	public void clickButtonPencil() {
		WebUI.click(btnSearch)
	}

	public void inputAssetInventoryInfo(String inventoryDate, String inventorynotes) {
		verifyLanding(drpInventoryDate, "Asset Inventory Request Detail")
		WebUI.click(drpInventoryDate)
		WebUI.click(txtInventoryDate)// ini kayanya nanti butuh params inventoryDate
		WebUI.setText(txfInventoryNotes, inventorynotes)
	}

	public void inputApprovalRequest(String reason, String approvalNotes, String approvedBy) {
		TestObject txtReasonDesc = createTestObject("txtReasonDesc", "text", reason)
		TestObject txtApprovedBy = createTestObject("txtApprovedBy", "text", approvedBy)

		WebUI.click(drpReasonDesc)
		WebUI.click(txtReasonDesc)
		WebUI.setText(txfApprovalNotes, approvalNotes)
		WebUI.click(drpApprovedBy)
		WebUI.click(txtApprovedBy)
	}

	public void clickSubmit() {
		WebUI.click(btnSubmit)
	}
}
