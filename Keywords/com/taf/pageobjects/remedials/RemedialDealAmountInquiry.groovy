package com.taf.pageobjects.remedials

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class RemedialDealAmountInquiry extends BaseHelper {

	private TestObject drpOfficeName			= createTestObject("drpOfficeName", "id", "ucSearch_ddlHandlingOfficeId_ltlRefOfficeOfficeNameSearch_ddlReference") 
	private TestObject txfAgreementNo			= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch") 
	private TestObject drpRemedialDealStatus	= createTestObject("drpRemedialDealStatus", "id", "ucSearch_ddlMrRemDealStatCode_ltlRemDealTrxRemDealStatSearch_ddlReference") 
	private TestObject txfRemDealAmountNo		= createTestObject("txfRemDealAmountNo", "id", "ucSearch_txtRemDealTrxNo_ltlRemDealTrxRemDealTrxNoSearch") 
	private TestObject txfCustomerNo			= createTestObject("txfCustomerNo", "id", "ucSearch_txtCustName_ltlCustCustNameSearch") 
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	private TestObject txtRemedialStatus		= createTestObject("txtRemedialStatus", "id", "gvGrid_lblRemDealStat_0")
	private TestObject txtRemedialDealAmountNo	= createTestObject("txtRemedialDealAmountNo", "id", "gvGrid_lbRemDealTrxNo_0")
	private TestObject lblRequestDate			= createTestObject("lblRequestDate", "id", "gvGrid_lb_Rfa_ReqDt") 


	private void verifyLandingPage() {
		verifyLanding(drpOfficeName, "Remedial Deal Amount Inquiry")
		WebUI.takeScreenshot()
	}

	private void searchAgreementNo(String agreementNo) {
		countAgreementIsShowing() // if agreementNo showing > 1 click request date
		safetyInput(txfAgreementNo, agreementNo)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	private void countAgreementIsShowing() {
		TestObject agreementRow = createTestObject("agreementRow", "xpath", "//span[starts-with(@id,'gvGrid_lbAgrmntNo')]") 
		def rows = WebUiCommonHelper.findWebElements(agreementRow, 5)
		int countRow = rows.size()
		
		if(countRow > 1) {
			safetyClick(lblRequestDate)
		}
	}
	
	private void clickRemedialDealAmountNo() {
		safetyClick(txtRemedialDealAmountNo)
		switchToNewTab()
		WebUI.takeScreenshot()
	}
}
