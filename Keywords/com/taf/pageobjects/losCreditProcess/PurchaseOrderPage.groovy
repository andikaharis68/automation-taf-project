package com.taf.pageobjects.losCreditProcess

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

public class PurchaseOrderPage extends BaseHelper{
	//header
	private TestObject btnSave				= createTestObject(btnSave, "id", "lbSave")
	private TestObject btnSubmit			= createTestObject(btnSubmit, "id", "lbSubmit")
	
	//search
	private TestObject txfApplicationNo		= createTestObject(txfApplicationNo, "id", "ucSearch_txtAppNo_ltlAppAppNoSearch")
	private TestObject btnSearch			= createTestObject(btnSearch, "id", "ucSearch_btnSearch")
	private TestObject btnPencil			= createTestObject(btnPencil, "id", "gvAgrmnt_imbEdit_0")
	
	//supplier listing
	private TestObject btnPencilSupplier	= createTestObject("btnPencilSupplier", "xpath", "//input[contains(@id, 'gvSupplBranchList_ibEd')]")
	
	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	
	public void verifyLandingScreen() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainpage, 1)
		WebUI.takeScreenshot()
		verifyLanding(txfApplicationNo, "Purchase Order")
	}
	
	public void searchPurchaseOrderByApplicationNo(String applicationNo) {
		safetyInput(txfApplicationNo, applicationNo)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
		safetyClick(btnPencil)
	}
	
	
	public boolean clickEditOnSupplierListing() {
		WebUI.takeScreenshot()
		if(WebUI.waitForElementPresent(btnPencilSupplier, 3, FailureHandling.OPTIONAL)) {
			safetyClick(btnPencilSupplier)
			return true
		}else {
			return false
		}
		
	}
	
	public void clickSave() {
		WebUI.takeScreenshot()
		safetyClick(btnSave)
	}
	
	public void clickSubmit() {
		WebUI.takeScreenshot()
		safetyClick(btnSubmit)
		WebUI.delay(10)
		WebUI.takeScreenshot()
	}
}
