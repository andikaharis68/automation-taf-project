package com.taf.pageobjects.collection

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

public class CollectionExpenseApprovalPage extends BaseHelper {
	//search
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnIconProcess = createTestObject("btnIconProcess", "id", "gvTask_ibProcess_0")
	//Approval Action
	private TestObject drbAction = createTestObject("drbAction", "id", "ddlAction")
	private TestObject txfApprovalActionNote = createTestObject("txfApprovalActionNote", "id", "txtNotes")
	private TestObject btnSubmit = createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")

	
	public void inputAgreementNo(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
	}

	public void clickButtonSearch() {
		safetyClick(btnSearch)
	}

	public void clickButtonIconProcess() {
		WebUI.takeScreenshot()
		if(WebUI.waitForElementPresent(btnIconProcess, 2)) {			
			safetyClick(btnIconProcess)
		} else {
			KeywordUtil.logInfo("Tidak terdapat button process pada Agreement Number tersebut")
		}
	}
	
	public void selectApprove(String action) {
		WebUI.takeScreenshot()
		safetySelect(drbAction, action)
	}
	
	public void inputNote(String note) {
		safetyInput(txfApprovalActionNote, note)
		WebUI.takeScreenshot()
	}
	
	public void clickButtonSubmit() {
		safetyClick(btnSubmit)
	}
	
	public void verifySuccessSubmit() {
		if(!WebUI.waitForElementPresent(btnSearch, 20)) {
			KeywordUtil.markFailed("Gagal melakukan submit approval")
		}
		WebUI.takeScreenshot()
	}
}
