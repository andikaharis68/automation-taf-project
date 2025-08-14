package com.taf.pageobjects.collectionandremedialasset

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

public class InventorySellingRequestPage extends BaseHelper {
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject lblAgreementNo = createTestObject("txtOffice", "", "")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")
	
	//Table
	private TestObject lblAgreementNoTable = createTestObject("lblAgreementNoTable", "", "")
	private TestObject txtAgreementNoTable = createTestObject("txtAgreementNoTable", "", "")
	private TestObject btnPencil = createTestObject("btnPencil", "", "")
	
	//Detail - List of Bidder
	private TestObject txfBidderName = createTestObject("txfBidderName", "", "")
	private TestObject txfBidderAmount = createTestObject("txfBidderAmount", "", "")
	private TestObject drpBidderDate = createTestObject("drpBidderDate", "", "")
	private TestObject txtBidderDate = createTestObject("txtBidderDate", "", "")
	private TestObject txfNik = createTestObject("txfNik", "", "")
	private TestObject txfNpwp = createTestObject("txfNpwp", "", "")
	private TestObject drpBidderType = createTestObject("drpBidderType", "", "")
	private TestObject txtBidderType = createTestObject("txtBidderType", "", "")
	private TestObject txfEmail = createTestObject("txfEmail", "", "")
	private TestObject radWinner = createTestObject("radWinner", "", "")
	private TestObject btnAdd = createTestObject("btnAdd", "", "")
	
	//Detail - Auction Detail
	private TestObject txfPpn = createTestObject("txfPpn", "", "")
	private TestObject btnCalculate = createTestObject("btnCalculate", "", "")
	
	//Detail - Approval Request
	private TestObject drpReasonDesc = createTestObject("drpReasonDesc", "", "")
	private TestObject txtReasonDesc = createTestObject("txtReasonDesc", "", "")
	private TestObject txfApprovalNotes = createTestObject("txfApprovalNotes", "", "")
	private TestObject drpApprovedBy = createTestObject("drpApprovedBy", "", "")
	private TestObject txtApprovedBy = createTestObject("txtApprovedBy", "", "")

	private TestObject btnSubmit = createTestObject("btnSubmit", "", "")
	private TestObject lblSuccess = createTestObject("lblSuccess", "", "")
	
	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Inventory Selling Request Page")
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
		WebUI.click(btnSearch)
	}

	public void clickButtonPencil() {
		WebUI.click(btnSearch)
	}
	
	public void inputListOfBidder(String bidderName, String bidderAmount, String bidderDate, String nik, String npwp, String bidderType, String email) {
		txtBidderDate = createTestObject("txtBidderDate", "text", "$bidderDate")
		txtBidderType = createTestObject("txtBidderType", "text", "$bidderType")
		
		WebUI.setText(txfBidderName, bidderName)
		WebUI.setText(txfBidderAmount, bidderAmount)
		//bider date
		WebUI.click(drpBidderDate)
		WebUI.click(txtBidderDate)
		WebUI.setText(txfNik, nik)
		//bidder type
		WebUI.click(drpBidderType)
		WebUI.click(txtBidderType)//COMPANY or PERSONAL
		WebUI.setText(txfEmail, email)
	}
	
	public void inputAuctionDetail(String ppn) {
		WebUI.setText(txfPpn, ppn)
		WebUI.click(btnCalculate)
	}
	
	public void clickAdd() {
		WebUI.click(btnAdd)
	}
	
	public void inputApprovalRequest(String reason, String approvalNotes, String approvedBy) {
		TestObject txtReasonDesc = createTestObject("txtReasonDesc", "text", reason)
		TestObject txtApprovedBy = createTestObject("txtApprovedBy", "text", approvedBy)

		WebUI.click(drpReasonDesc)
		WebUI.click(txtReasonDesc)
		WebUI.setText(txfApprovalNotes, approvalNotes)
		WebUI.click(drpApprovedBy)
		WebUI.click(txtApprovedBy)
		
		WebUI.click(btnSubmit)
		verifyPopUpSuccess(lblSuccess, "Inventory Selling Request")
	}

}
