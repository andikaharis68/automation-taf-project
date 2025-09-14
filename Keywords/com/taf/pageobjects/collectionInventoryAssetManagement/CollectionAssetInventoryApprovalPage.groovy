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

public class CollectionAssetInventoryApprovalPage extends BaseHelper {
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//table
	private TestObject txtAgreementNo = createTestObject("txtAgreementNoTable", "id", "gvTask_lblAgrmntNo_0")
	private TestObject btnProcess = createTestObject("btnProcess", "id", "gvTask_ibProcess_0")

	//detail
	private TestObject drpAction = createTestObject("drpAction", "id", "ddlAction")
	private TestObject txfNotes = createTestObject("txfNotes", "id", "txtNotes")
	private TestObject drpAreaDeptHead = createTestObject("drpAreaDeptHead", "id", "gvNextPerson_ddlNodeNextPerson_0")

	private TestObject btnSubmit = createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Collection Asset Inventory Approval Page")
	}

	public void doSearch(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
	}
	
	public void clickSearch() {
		safetyClick(btnSearch)
	}

	public void clickProcess() {
		safetyClick(btnProcess)
	}

	public void selectAction(String action) {
		WebUI.focus(drpAction)
		WebUI.takeScreenshot()
		safetySelect(drpAction, action)
	}
	
	public void inputNotes(String notes) {
		safetyInput(txfNotes, notes)
	}
	
	public void clickSubmit() {
		WebUI.takeScreenshot()
		safetyClick(btnSubmit)
	}
}
