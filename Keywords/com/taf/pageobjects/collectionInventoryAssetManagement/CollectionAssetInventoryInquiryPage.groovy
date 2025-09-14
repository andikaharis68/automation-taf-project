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

public class CollectionAssetInventoryInquiryPage extends BaseHelper{
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//table
	private TestObject txtAgreementNo = createTestObject("txtAgreementNo", "id", "gvPaging_lbAgrmntNo_0")
	private TestObject txtRequestNo = createTestObject("txtRequestNo", "id", "gvPaging_lblInventoryRequestNo_0")
	private TestObject txtStatus = createTestObject("txtStatus", "id", "gvPaging_lblInventoryStatus_0")
	
	//Asset Inventory view
	private TestObject txtOffice = createTestObject("txtStatus", "id", "ucAgrmntInfo_lblOffice")
	private TestObject txtLastTaskOwner = createTestObject("txtStatus", "xpath", "(//span[text() = '-' and contains(@id, 'gvApvHist_lblApprovedBy')]/preceding::span[contains(@id, 'gvApvHist_lblApprovalTaskOwner')])[last()]")
	private TestObject txtLastNode = createTestObject("txtStatus", "xpath", "(//span[text() = '-' and contains(@id, 'gvApvHist_lblApprovedBy')]/preceding::span[contains(@id, 'gvApvHist_lblApprovalNode')])[last()]")
	

	//detail
	private TestObject lblResult = createTestObject("lblResult", "", "")
	private TestObject txtResult = createTestObject("txtResult", "", "")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Asset Inventory Inquiry Page")
		WebUI.takeScreenshot()
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
	}
	
	public void clickSearch() {
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}

	public Boolean verifyStatusRequest(String expectedStatus) {
		String actualStatus = WebUI.getText(txtStatus)
		if (actualStatus.equalsIgnoreCase(expectedStatus)) {
			KeywordUtil.markPassed("Success : The Status is ($expectedStatus)")
			return true
		}else {
			KeywordUtil.markFailed("Failed : Actual status ($actualStatus) is not Matched with Expected status ($expectedStatus)")
			return false
		}
	}

	public void clickFirstAgreementNo() {
		safetyClick(txtAgreementNo)
	}
	
	public void clickFirstRequestNo() {
		safetyClick(txtRequestNo)
	}
	
	public void switchToSecondTab() {
		switchToNewTab()
	}
	
	public verifyLandingInInventoryView() {
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
		}
		
		if (actualNode.equalsIgnoreCase("FIELD HANDLING HEAD")) {
			actualNode = "AR MANAGEMENT HEAD" //14-sep-2025 : at least for now on the name of role and position is "AR MANAGEMENT HEAD"
			role = actualNode
		} else if(actualNode.equalsIgnoreCase("FH AREA DEPT HEAD")) {
			actualNode = "OPERATION DIVISION HEAD"
			role = "OPR AND SERVICE DIVISION HEAD"
			
			if (actualOffice.contains(" ")) {
				String[] splitted = actualOffice.split(" ")
				actualOffice = splitted[0]
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
