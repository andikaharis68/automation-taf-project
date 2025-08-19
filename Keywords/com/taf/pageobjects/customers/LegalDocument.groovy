package com.taf.pageobjects.customers

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

public class LegalDocument extends BaseHelper {
	private TestObject btnSaveAndContinue 	= createTestObject("btnSaveAndContinue", "id", "lb_Form_SaveCont_EmergencyContact")
	private TestObject lblSuccess			= createTestObject("lblSuccess", "xpath", "//*[contains(text(), 'Save Success')]")
	private TestObject btnAdd 	= createTestObject("btnAdd", "id", "lb_Form_SaveCont_EmergencyContact")

	//table
	private TestObject drpLegalDocType 	= createTestObject("drpLegalDocType", "id", "gvLegalDocument_ddlLegalDocType_0")
	private TestObject txfDocumentNo 	= createTestObject("txfDocumentNo", "id", "gvLegalDocument_txt_CustCoyLegalDoc_DocNo_0")
	private TestObject txfDateIssue 	= createTestObject("txfDateIssue", "id", "gvLegalDocument_ucDPLegalDocDocDt_0_txtDatePicker_0")
	private TestObject txfDateExpired 	= createTestObject("txfDateExpired", "id", "gvLegalDocument_ucDPLegalDocDocExpiredDt_0_txtDatePicker_0")
	private TestObject txfNotes 	= createTestObject("txfNotes", "id", "gvLegalDocument_txt_CustCoyLegalDoc_DocNote_0")
	private TestObject txfNotaryName 	= createTestObject("txfNotaryName", "id", "gvLegalDocument_txt_CustCoyLegalDoc_NotaryName_0")
	private TestObject txfNotaryLocation 	= createTestObject("txfNotaryLocation", "id", "gvLegalDocument_txt_CustCoyLegalDoc_NotaryLocation_0")
	private TestObject btnDelete 	= createTestObject("btnDelete", "id", "gvLegalDocument_imbDelete_0")

	//iframe
	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")

	public void switchToIframeMain() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	public void verifyLandingScreen() {
		verifyLanding(drpLegalDocType, "Legal Document")
		WebUI.takeScreenshot()
	}
	
	public void clickAdd() {
		safetyClick(btnAdd)
	}
	
	public void inputLegalDocument(String legaldocType, String documentNo, String dateIssued, String expDate, String notes, String notaryName, String notaryLoc) {
		String[] splittedLegalDoc = legaldocType.split(";")
		String[] splittedDocNo = documentNo.split(";")
		String[] splittedDateIssued = dateIssued.split(";")
		String[] splittedExpDate = expDate.split(";")
		String[] splittedNotes = notes.split(";")
		String[] splittedNotaryName = notaryName.split(";")
		String[] splittedNotaryLoc = notaryLoc.split(";")
		
		KeywordUtil.logInfo("Size of item: " + splittedLegalDoc.size())
		for (int i=0; i<splittedLegalDoc.size(); i++) {
			KeywordUtil.logInfo("Input legal document ke: " + splittedLegalDoc[i+1])
			clickAdd()
			drpLegalDocType 	= createTestObject("drpLegalDocType", "id", "gvLegalDocument_ddlLegalDocType_${splittedLegalDoc[i]}")
			txfDocumentNo 		= createTestObject("txfDocumentNo", "id", "gvLegalDocument_txt_CustCoyLegalDoc_DocNo_${splittedLegalDoc[i]}")
			txfDateIssue 		= createTestObject("txfDateIssue", "id", "gvLegalDocument_ucDPLegalDocDocDt_${splittedLegalDoc[i]}_txtDatePicker_${splittedLegalDoc[i]}")
			txfDateExpired 		= createTestObject("txfDateExpired", "id", "gvLegalDocument_ucDPLegalDocDocExpired${splittedLegalDoc[i]}_txtDatePicker_${splittedLegalDoc[i]}")
			txfNotes 			= createTestObject("txfNotes", "id", "gvLegalDocument_txt_CustCoyLegalDoc_DocNote_${splittedLegalDoc[i]}")
			txfNotaryName 		= createTestObject("txfNotaryName", "id", "gvLegalDocument_txt_CustCoyLegalDoc_NotaryName_${splittedLegalDoc[i]}")
			txfNotaryLocation 	= createTestObject("txfNotaryLocation", "id", "gvLegalDocument_txt_CustCoyLegalDoc_NotaryLocation_${splittedLegalDoc[i]}")
			
			safetySelectEdit(drpLegalDocType, splittedLegalDoc[i])
			safetyInputEdit(txfDocumentNo, splittedDocNo[i])
			safetyInputEdit(txfDateIssue, splittedDateIssued[i])
			safetyInputEdit(txfDateExpired, splittedExpDate[i])
			safetyInputEdit(txfNotes, splittedNotes[i])
			safetyInputEdit(txfNotaryName, splittedNotaryName[i])
			safetyInputEdit(txfNotaryLocation, splittedNotaryLoc[i])
		}
		
	}
	
	public void clickSaveAndContinue() {
		safetyClick(btnSaveAndContinue)
	}
	
	public void verifySaveSuccess() {
		verifyPopUpSuccess(lblSuccess, "Legal Document")
	}
}
