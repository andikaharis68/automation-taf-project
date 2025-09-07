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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class NewApplicationDEPage extends BaseHelper {

	private TestObject btnAdd				= createTestObject("btnAdd", "id", "lb_Toolbar_Add")
	private TestObject txfApplicationNo		= createTestObject("txfApplicationNo", "id", "ucSearch_txtAppNo_ltlAppAppNoSearch]")
	private TestObject txfProductOfferName	= createTestObject("txfProductOfferName", "xpath", "//*[contains(@id,'txtProdOfferingName')]")
	private TestObject txfOrderDate1		= createTestObject("txfOrderDate1", "xpath", "[contains(@id, 'ltlProspectOrdOrderDtGteSearch')]")
	private TestObject drpTaskClaim			= createTestObject("drpTaskClaim", "xpath", "[contains(@id, 'ltlWfPagingTaskClaimStat')]")
	private TestObject txfCustomerName		= createTestObject("txfCustomerName", "id", "ucSearch_txtCustNamePaging_ltlCustCustNameSearch")
	private TestObject txfSalesPersonName	= createTestObject("txfSalesPersonName", "xpath", "[contains(@id, 'txtEmpName')]")
	private TestObject txfOrderDate2		= createTestObject("txfOrderDate2", "xpath", "[contains(@id, 'ltlProspectOrdOrderDtLteSearch')]")
	private TestObject txfTaskClaimBy		= createTestObject("txfTaskClaimBy", "xpath", "[contains(@id, 'txtusername')]")

	private TestObject btnSearch 			= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnReset				= createTestObject("btnReset", "id", "ucSearch_lbReset")

	//application listing
	private TestObject txtApplicationNo		= createTestObject("txtApplicationNo", "id", "gvApp_lbAppNo_0")
	private TestObject txtCustomerName		= createTestObject("txtCustomerName", "id", "gvApp_lbCustName_0")
	private TestObject txtProdOfferName		= createTestObject("txtProdOfferName", "id", "gvApp_lbProdOfferingName_0")
	private TestObject btnEditPencil		= createTestObject("btnEditPencil", "id", "gvApplication_imbEdit_0")
	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")

	public void switchToMainPage() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainpage, 2)
	}

	private void clickAddApplication() {
		safetyClick(btnAdd)
	}

	private void clickSearch() {
		safetyClick(btnSearch)
	}

	private void searchCustomerName(String name) {
		retrySearchCustomer(name.trim(), txfCustomerName, btnSearch, btnEditPencil)
		WebUI.takeScreenshot()
	}

	private void verifyLandingInNewAppPage() {
		verifyLanding(btnAdd, "New Application")
		WebUI.takeScreenshot()
	}

	private void clickEditData() {
		safetyClick(btnEditPencil)
	}
}
