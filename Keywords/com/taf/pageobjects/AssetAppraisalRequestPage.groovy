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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class AssetAppraisalRequestPage extends BaseHelper{
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject lblAgreementNo = createTestObject("txtOffice", "", "")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")
	
	//Table
	private TestObject lblAgreementNoTable = createTestObject("lblAgreementNoTable", "", "")
	private TestObject txtAgreementNoTable = createTestObject("txtAgreementNoTable", "", "")
	private TestObject btnPencil = createTestObject("btnPencil", "", "")
	
	//Detail
	private TestObject btnLookUpMarketPrice = createTestObject("btnLookUpMarketPrice", "", "")
	private TestObject btnLookUpDeductionItem = createTestObject("btnLookUpDeductionItem", "", "")
	private TestObject txfMinSellingAmount = createTestObject("txfMinSellingAmount", "", "")
	private TestObject btnCalculate = createTestObject("btnCalculate", "", "")
	private TestObject btnSubmit = createTestObject("btnSubmit", "", "")
	
	//Approval Request
	private TestObject drpReasonDesc = createTestObject("drpReasonDesc", "", "")
	private TestObject txtReasonDesc = createTestObject("txtReasonDesc", "", "")
	private TestObject txfApprovalNotes = createTestObject("txfApprovalNotes", "", "")
	private TestObject drpApprovedBy = createTestObject("drpApprovedBy", "", "")
	private TestObject txtApprovedBy = createTestObject("txtApprovedBy", "", "")
	
	//Overlay Look Up Market Price
	private TestObject drpOfficeName = createTestObject("drpOfficeName", "", "")
	private TestObject txtOfficeName = createTestObject("txtOfficeName", "", "")
	private TestObject drpAssetName = createTestObject("drpAssetName", "", "")
	private TestObject txtAssetName = createTestObject("txtAssetName", "", "")
	private TestObject drpYear = createTestObject("drpYear", "", "")
	private TestObject txtYear = createTestObject("txtYear", "", "")
	private TestObject btnSearchOverlay = createTestObject("btnSearchOverlay", "", "")
	private TestObject btnSelect = createTestObject("btnSelect", "", "")
	
	//Overlay Deduction Item
	private TestObject txfDeductionItem = createTestObject("txfDeductionItem", "", "")
	
	private TestObject lblSuccess = createTestObject("lblSuccess", "", "")
	
	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Asset Appraisal Request Page")
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
		WebUI.click(btnSearch)
	}
	
	public void clickButtonPencil() {
		WebUI.click(btnSearch)
	}
	
	public void inputMarketPrice(String officeName, String assetName, String year) {
		txtOfficeName = createTestObject("txtOfficeName", "text", "$officeName")
		txtAssetName = createTestObject("txtAssetName", "text", "$assetName")
		txtYear = createTestObject("txtYear", "text", "$year")
		
		WebUI.click(btnLookUpMarketPrice)
		WebUI.click(drpOfficeName)
		WebUI.click(txtOfficeName)
		
		WebUI.click(drpAssetName)
		WebUI.click(txtAssetName)
		
		WebUI.click(drpYear)
		WebUI.click(txtYear)
		
		WebUI.click(btnSearchOverlay)
		WebUI.click(btnSelect)
	}
	
	public void inputDeductionItem(String deductionItem) {
		WebUI.click(btnLookUpDeductionItem)
		WebUI.setText(txfDeductionItem, deductionItem)
		WebUI.click(btnSearchOverlay)
		WebUI.click(btnSelect)
	}
	
	public void inputMinSellingAmount(String minSellingAmount) {
		WebUI.setText(txfMinSellingAmount, minSellingAmount)
	}
	
	public void clickCalculate() {
		WebUI.click(btnCalculate)
	}
	
	public void inputApprovalRequest(String reason, String approvalNotes, String approvedBy) {
		txtReasonDesc = createTestObject("txtReasonDesc", "text", reason)
		txtApprovedBy = createTestObject("txtApprovedBy", "text", approvedBy)

		WebUI.click(drpReasonDesc)
		WebUI.click(txtReasonDesc)
		WebUI.setText(txfApprovalNotes, approvalNotes)
		WebUI.click(drpApprovedBy)
		WebUI.click(txtApprovedBy)
		
		WebUI.click(btnSubmit)
		verifyPopUpSuccess(lblSuccess, "Asset Appraisal Request")
	}
	 
}
