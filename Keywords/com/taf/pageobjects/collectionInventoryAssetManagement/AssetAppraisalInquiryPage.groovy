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

public class AssetAppraisalInquiryPage extends BaseHelper {
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//table
	private TestObject txtLastAgreementNo = createTestObject("txtLastAgreementNo", "xpath", "(//*[contains(@id, 'gvGrid_lblAgrmntNo')])[last()]")
	private TestObject txtLastAppraisalNo = createTestObject("txtLastAppraisalNo", "xpath", "(//*[contains(@id, 'gvGrid_lbAssetAppraisalNo')])[last()]")
	private TestObject txtLastAppraisalStatus = createTestObject("txtLastAppraisalStatus", "xpath", "(//*[contains(@id, 'gvGrid_lblMrAppraisalStat')])[last()]")
	
	//View Asset Appraisal
	//Asset Inventory view
	private TestObject txtOffice = createTestObject("txtOffice", "id", "ucAgrmntInfo_lblOffice")
	private TestObject txtLastTaskOwner = createTestObject("txtLastTaskOwner", "xpath", "(//span[text() = '-' and contains(@id, 'gvApvHist_lblApprovedBy')]/preceding::span[contains(@id, 'gvApvHist_lblApprovalTaskOwner')])[last()]")
	private TestObject txtLastNode = createTestObject("txtLastNode", "xpath", "(//span[text() = '-' and contains(@id, 'gvApvHist_lblApprovedBy')]/preceding::span[contains(@id, 'gvApvHist_lblApprovalNode')])[last()]")

	//detail
	private TestObject lblResult = createTestObject("lblResult", "", "")
	private TestObject txtResult = createTestObject("txtResult", "", "")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Asset Inventory Inquiry Page")
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
	}
	
	public void clickSearch() {
		safetyClick(btnSearch)
	}

	public Boolean verifyStatusRequest(String expectedStatus) {
		String actualStatus = WebUI.getText(txtLastAppraisalStatus)
		if (actualStatus.equalsIgnoreCase(expectedStatus)) {
			KeywordUtil.markPassed("Success : The Status is ($expectedStatus)")
			return true
		}else {
			KeywordUtil.markFailed("Failed : Actual status ($actualStatus) is not Matched with Expected status ($expectedStatus)")
			return false
		}
	}

	public void clickLastAgreementNo() {
		safetyClick(txtLastAgreementNo)
	}
	
	public void clickLastAppraisalNo() {
		safetyClick(txtLastAppraisalNo)
	}
	
	public void switchToSecondTab() {
		switchToNewTab()
	}
	
	public verifyLandingInViewAssetAppraisal() {
		verifyLanding(txtOffice, "Asset Inventory View")
	}
	
	public Map getApprovalCredential() {
		// focus on owner, for ss purpose
		WebUI.focus(txtLastTaskOwner)
		WebUI.takeScreenshot()
		String actualOffice = WebUI.getText(txtOffice)
		String actualNode = WebUI.getText(txtLastNode)
		String actualOwner = WebUI.getText(txtLastTaskOwner)
		String role = actualNode

		if (actualOffice.contains("-")) {
			String[] splitted = actualOffice.split("-")
			actualOffice = splitted[-1]
			if (actualOffice.contains(" ")) {
				String[] newSplitted = actualOffice.split(" ")
				actualOffice = newSplitted[0]
			}
		}
		
		Map credentialData = [:]
		credentialData['owner'] = actualOwner
		credentialData['office'] = actualOffice
		credentialData['position'] = actualNode
		credentialData['role'] = role

		return credentialData
	}

	public void verifyDetailStatus(String expectedStatus) {
		String actualStatus = WebUI.getText(txtResult)
		if (actualStatus.equalsIgnoreCase(expectedStatus)) {
			//Request atau Approve atau ApproveFinal
			KeywordUtil.markPassed("Success : The Detail Status is ($expectedStatus)")
		}else {
			KeywordUtil.markFailed("Failed : Actual detail status ($actualStatus) is not Matched with Expected detail status ($expectedStatus)")
		}
	}
	
	public void delayAndClickSearch() {
		WebUI.delay(5)
		clickSearch()
	}
}
