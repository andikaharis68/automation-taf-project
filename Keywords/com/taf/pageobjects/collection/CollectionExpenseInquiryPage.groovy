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

public class CollectionExpenseInquiryPage extends BaseHelper {
	//search
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject txtRequestNo = createTestObject("txtRequestNo", "id", "gvPaging_lblCollExpense_0")
	private TestObject drpStatus = createTestObject("drpStatus", "id", "ucSearch_ddlStatus_ltlCollExpenseMrCollExpenseStatSearch_ddlReference")
	private TestObject txtRequestNumber = createTestObject("txtRequestNumber", "id", "gvPaging_lblCollExpense_0")

	public void inputAgreementNo(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
	}
	
	public void selectFilterStatus(String status) {
		safetySelect(drpStatus, status)
	}

	public void clickButtonSearch() {
		safetyClick(btnSearch)
	}

	public boolean verifyStatusRequest(String status) {
		TestObject txtStatus = createTestObject("txtStatus", "xpath", "//*[contains(@id, 'gvPaging_lblCollExpStatus') and text() = '${status}']")
		if(WebUI.waitForElementPresent(txtStatus, 10)) {
			return true
		} else {
			return false
		}
	}
	
	public void clickRequestNumber() {
		safetyClick(txtRequestNumber)
	}
}
