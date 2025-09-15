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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class ConfirmAssetToPoolPage extends BaseHelper{
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//Table
	private TestObject btnFirstPencil = createTestObject("btnFirstPencil", "id", "gvGrid_imbEdit_0")

	//Detail
	private TestObject txfReceiveBy = createTestObject("txfReceiveBy", "id", "txtReceiveBy")
	private TestObject txfReceiveDate = createTestObject("txtReceiveDate", "id", "ucReceiveDt_txtDatePicker")
	private TestObject txfNotes = createTestObject("txfNotes", "id", "txtNotes")
	private TestObject btnSubmit = createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Confirm Asset To Pool Page")
		WebUI.takeScreenshot()
	}

	public void doSearch(String agreementNo) {
		safetySelect(txfAgreementNo, agreementNo)
	}
	
	public void clickSearch() {
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}

	public void clickButtonPencil() {
		safetyClick(btnFirstPencil)
	}
	
	public void inputReceiveBy(String receiveBy) {
		WebUI.takeScreenshot()
		safetyInput(txfReceiveBy, receiveBy)
	}
	
	public void inputReceiveDate(String receiveDate) {
		safetyInput(txfReceiveDate, receiveDate)
	}
	
	public void inputNotes(String notes) {
		safetyInput(txfNotes, notes)
	}
	
	public void clickSubmit() {
		WebUI.takeScreenshot()
		safetyClick(btnSubmit)
	}
}
