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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class AssetAppraisalRequestPage extends BaseHelper{
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	
	//Table
	private TestObject txtAgreementNo = createTestObject("txtAgreementNo", "id", "gvGrid_lblAgrmntNo_0")
	private TestObject btnPencil = createTestObject("btnPencil", "id", "gvGrid_imbEdit_0")
	
	//Detail
	private TestObject txfMinSellingAmount = createTestObject("txfMinSellingAmount", "id", "ucMinSellAmt_txtInput")
	private TestObject btnCalculate = createTestObject("btnCalculate", "id", "lb_Form_Calculate")
	private TestObject btnSubmit = createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	
	//Approval Request
	private TestObject drpReasonDesc = createTestObject("drpReasonDesc", "id", "ucApproval_ddlReason")
	private TestObject txfApprovalNotes = createTestObject("txfApprovalNotes", "id", "ucApproval_txtNotes")
	private TestObject drpApprovedBy = createTestObject("drpApprovedBy", "id", "ucApproval_ddlApvBy")
	
	//Overlay Look Up Market Price
	private TestObject btnLookUpMarketPrice = createTestObject("btnLookUpMarketPrice", "id", "ucMarketPrice_uclMarketPrice_imb")
	private TestObject drpOvlOfficeName = createTestObject("drpOvlOfficeName", "id", "ucMarketPrice_uclMarketPrice_umd_ctl00_ucS_rptFixedSearch_ucReference_0_ddlReference_0")
	private TestObject drpOvlAssetName = createTestObject("drpOvlAssetName", "id", "ucMarketPrice_uclMarketPrice_umd_ctl00_ucS_rptFixedSearch_ucReference_1_ddlReference_1")
	private TestObject drpOvlYear = createTestObject("drpOvlYear", "id", "ucMarketPrice_uclMarketPrice_umd_ctl00_ucS_rptFixedSearch_ucReference_2_ddlReference_2")
	private TestObject btnOvlSearchMarketplace = createTestObject("btnOvlSearchMarketplace", "id", "ucMarketPrice_uclMarketPrice_umd_ctl00_ucS_lbSearch")
	private TestObject btnOvlSelectMarketplace = createTestObject("btnOvlSelectMarketplace", "id", "ucMarketPrice_uclMarketPrice_umd_ctl00_gvL_hpSelect_0")
	
	//Overlay Deduction Item
	private TestObject btnLookUpDeductionItem = createTestObject("btnLookUpDeductionItem", "id", "gvListDeduction_ucLookupDeduction_0_uclDeduction_0_imb_0")
	private TestObject txfOvlDeductionItem = createTestObject("txfOvlDeductionItem", "id", "gvListDeduction_ucLookupDeduction_0_uclDeduction_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_0")
	private TestObject btnOvlSearchDeductionItem = createTestObject("btnOvlSearchDeductionItem", "id", "gvListDeduction_ucLookupDeduction_0_uclDeduction_0_umd_0_ctl00_0_ucS_0_lbSearch_0")
	private TestObject btnOvlSelectDeductionItem = createTestObject("btnOvlSelectDeductionItem", "id", "ucMarketPrice_uclMarketPrice_umd_ctl00_gvL_hpSelect_0")
	
	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Asset Appraisal Request Page")
		WebUI.takeScreenshot()
	}

	public void doSearch(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
	}
	
	public void clickSearch() {
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	
	public void clickButtonPencil() {
		safetyClick(btnSearch)
	}
	
	public void selectMarketPrice(String officeName, String assetName, String year) {
		safetyClick(btnLookUpMarketPrice)
		WebUI.delay(1)
		safetySelect(drpOvlOfficeName, officeName)
		safetySelect(drpOvlAssetName, assetName)
		safetySelect(drpOvlYear, year)
		WebUI.delay(1)
		safetyClick(btnOvlSearchMarketplace)
		safetyClick(btnOvlSelectMarketplace)
		
	}
	
	public void selectDeducItem(String deductionItem) {
		safetyClick(btnLookUpDeductionItem)
		WebUI.delay(1)
		safetyInput(txfOvlDeductionItem, "%$deductionItem%")
		WebUI.delay(1)
		safetyClick(btnOvlSearchDeductionItem)
		safetyClick(btnOvlSelectDeductionItem)
	}
	
	public void inputMinSellingAmount(String minSellingAmount) {
		manualClearText(txfMinSellingAmount)
		safetyInput(txfMinSellingAmount, minSellingAmount)
	}
	
	public void clickCalculate() {
		safetyClick(btnCalculate)
	}
	
	public void selectReasonDescription(String reason) {
		safetySelect(drpReasonDesc, reason)
	}
	
	public void inputNotes(String notes) {
		safetyInput(txfApprovalNotes, notes)
	}
	
	public void selectApprovedBy(String approveBy) {
		safetySelectByIndex(drpApprovedBy, approveBy)
	}
	
	public void clickSubmit() {
		safetyClick(btnSubmit)
	}
	 
}
