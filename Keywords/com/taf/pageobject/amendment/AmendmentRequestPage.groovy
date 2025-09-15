package com.taf.pageobject.amendment

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

public class AmendmentRequestPage extends BaseHelper{

	private TestObject drpAmendmentType = createTestObject("drpAmendmentType", "xpath", "//select[@id = 'ucrefAmendmentType_ddlReference']") 
	private TestObject txfAgreementNo	= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch") 
	private TestObject txtCustomerName	= createTestObject("txtCustomerName", "xpath", "//input[@id = 'ucSearch_txtCustName_ltlCustCustNameSearch']")
	private TestObject btnSearch		= createTestObject("btnSearch", "xpath", "//input[@id = 'ucSearch_btnSearch']")
	private TestObject txfAddress		= createTestObject("txfAddress", "id", "ucSearch_txtAddress_ltlCustAddrAddrSearch") 
	private TestObject btnPencil		= createTestObject("btnPencil","id", "gvAgrmnt_imbEdit_0") 
	private TestObject iframeMain		= createTestObject("iframeMain", "id", "mainPage")
	
	
	
	private void verifyLandingPage() {
		WebUI.switchToFrame(iframeMain, 3)
		verifyLanding(drpAmendmentType, "Amendment Request")
		WebUI.takeScreenshot()
	}

	private void selectAmendmentType(String type) {
		safetySelect(drpAmendmentType, type, 1)
		WebUI.delay(0.8)
		
	}
	public void searchAmendment(String amendmentType, String customerName, String agreementNo, String address) {

		selectAmendmentType(amendmentType)
		inputIfTextExist(txtCustomerName, customerName)
		inputIfTextExist(txfAgreementNo, agreementNo)
		inputIfTextExist(txfAddress, address)
		
		safetyClick(btnSearch, 1)
		WebUI.delay(0.8)
		WebUI.takeScreenshot()
		
		safetyClick(btnPencil)
	}

	private void inputIfTextExist(TestObject to, String label) {
		if(label) {
			safetyInput(to, label)
			WebUI.delay(0.8)
		}
	}
	
}
