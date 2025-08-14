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

public class CollectionAssetInventoryApprovalPage extends BaseHelper {
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject lblAgreementNo = createTestObject("txtOffice", "", "")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")

	//table
	private TestObject lblAgreementNoTable = createTestObject("lblAgreementNoTable", "", "")
	private TestObject txtAgreementNoTable = createTestObject("txtAgreementNoTable", "", "")
	private TestObject lblProcess = createTestObject("lblProcess", "", "")
	private TestObject btnProcess = createTestObject("btnProcess", "", "")

	//detail
	private TestObject drpAction = createTestObject("drpAction", "", "")
	private TestObject txtAction = createTestObject("txtAction", "", "")
	private TestObject txfNotes = createTestObject("txfNotes", "", "")
	private TestObject drpAreaDeptHead = createTestObject("drpAreaDeptHead", "", "")
	private TestObject txtAreaDeptHead = createTestObject("txtAreaDeptHead", "", "")

	private TestObject btnSubmit = createTestObject("btnSubmit", "", "")

	//Popup
	private TestObject lblSuccess = createTestObject("lblSuccess", "", "")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Collection Asset Inventory Approval Page")
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
		WebUI.click(btnSearch)
	}

	public void clickProcess() {
		WebUI.click(btnProcess)
	}

	public void inputApprovalAction(String action, String notes, String deptHead, Boolean isFinal) {
		//action
		txtAction = createTestObject("txtAction", "text", "$action")
		WebUI.click(drpAction)
		WebUI.click(txtAction)
		//notes
		WebUI.setText(txfNotes, notes)
		if (isFinal == false) {
			//fh area dept head
			WebUI.click(drpAreaDeptHead)
			WebUI.click(txtAreaDeptHead)
		}

		WebUI.click(btnSubmit)
		verifyPopUpSuccess(lblSuccess, "Collection Asset Inventory Approval")
	}
}
