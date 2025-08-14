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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class ConfirmAssetToPoolPage extends BaseHelper{
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
	private TestObject txfReceiveBy = createTestObject("txfReceiveBy", "", "")
	private TestObject drpReceiveDate = createTestObject("drpReceiveDate", "", "")
	private TestObject txtReceiveDate = createTestObject("txtReceiveDate", "", "")
	private TestObject txfNotes = createTestObject("txfNotes", "", "")
	private TestObject btnSubmit = createTestObject("btnSubmit", "", "")

	//Popup
	private TestObject lblSuccess = createTestObject("lblSuccess", "", "")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Confirm Asset To Pool Page")
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
		WebUI.click(btnSearch)
	}

	public void clickButtonPencil() {
		WebUI.click(btnPencil)
	}

	public void inputReceiveAsset(String receiveBy, String receiveDate, String notes) {
		WebUI.setText(txfReceiveBy, receiveBy)

		WebUI.click(drpReceiveDate)
		WebUI.click(txtReceiveDate)

		WebUI.setText(txfNotes, notes)
		WebUI.click(btnSubmit)

		verifyPopUpSuccess(lblSuccess, "Confirm Asset To Pool")
	}
}
