package com.taf.pageobjects

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

public class MenuPage extends BaseHelper {

	private TestObject drpModul						= createTestObject("drpModul", "id", "ddlSubSystem")
	private TestObject drpMenu						= createTestObject("drpMenu", "xpath", "//img[@id='imgMenu']")
	private TestObject drpFavourite 				= createTestObject("drpFavourite", "xpath", "//img[@id='imgFavourite']")
	private TestObject btnCreditSimulation 			= createTestObject("btnCreditSimulation", "text", "Credit Simulation")
	private TestObject btnNewApplicationDataEntry	= createTestObject("btnNewApplicationDataEntry", "xpath", "")
	private TestObject btnNewApplication			= createTestObject("btnNewApplication", "xpath", "")
	private TestObject btnNotifFromSalesAndCDE		= createTestObject("btnNotifFromSalesAndCDE", "xpath", "")
	private TestObject btnAgreementDistribution		= createTestObject("btnAgreementDistribution", "xpath", "")
	private TestObject btnPurchaseOrder				= createTestObject("btnPurchaseOrder", "xpath", "")
	private TestObject btnRequestHandling			= createTestObject("btnRequestHandling", "xpath", "")
	private TestObject btnDocumentSigner			= createTestObject("btnDocumentSigner", "xpath", "")
	private TestObject btnDocumentPrinting			= createTestObject("btnDocumentPrinting", "xpath", "")
	private TestObject btnApplicationInquiry		= createTestObject("btnApplicationInquiry", "xpath", "")
	private TestObject btnAdditionalProcess			= createTestObject("btnAdditionalProcess", "xpath", "")
	private TestObject btnReturnHandlingTask		= createTestObject("btnReturnHandlingTask", "xpath", "")
	private TestObject btnUpdateLifeInsurance		= createTestObject("btnUpdateLifeInsurance", "xpath", "")
	private TestObject btnESign						= createTestObject("btnESign", "xpath", "")

	private TestObject btnCreditProcess				= createTestObject("btnCreditProcess", "xpath", "//a[@id='rModuleList_lbModuleList_0']")
	private TestObject btnCustomer					= createTestObject("btnCustomer", "xpath", "//a[@id='rModuleList_lbModuleList_1']")
	private TestObject btnSupplier					= createTestObject("btnSupplier", "xpath", "//a[@id='rModuleList_lbModuleList_2']")
	private TestObject btnSurvey					= createTestObject("btnSurvey", "xpath", "//a[@id='rModuleList_lbModuleList_3']")
	private TestObject btnMOU						= createTestObject("btnMOU", "xpath", "//a[@id='rModuleList_lbModuleList_4']")
	private TestObject btnLoanOriginationReports	= createTestObject("btnLoanOriginationReports", "xpath", "//a[@id='rModuleList_lbModuleList_5']")
	private TestObject btnTAFReports				= createTestObject("btnTAFReports", "xpath", "//a[@id='rModuleList_lbModuleList_6']")
	private TestObject btnInternalSystem			= createTestObject("btnInternalSystem", "xpath", "//a[@id='rModuleList_lbModuleList_7']")
	private TestObject btnCreditProcessInquiry		= createTestObject("btnCreditProcessInquiry", "xpath", "") // ada di favourite
	private TestObject btnSubMenuCustomer 			= createTestObject("btnSubMenuCustomer", "xpath", "//*[@id='rtvMenuTree']/ul/li[1]/div/a")
	private TestObject btnCustomerNegative			= createTestObject("btnCustomerNegative", "xpath", "")
	private TestObject iframeMenu 					= createTestObject("iframeMenu", "xpath", "//*[@id='treeContainer']")

	private void verifyLandingMenuPage() {
		verifyLanding(drpMenu, "Menu")
	}

	private void clickDropdownMenu() {
		WebUI.click(drpMenu)
	}

	private void clickDropdownFavourite() {
		WebUI.click(drpFavourite)
	}

	private void clickCustomer() {
		WebUI.click(btnCustomer)
	}
	private void clickCreditSimulation() {
		WebUI.click(btnCreditSimulation)
	}

	private void switchDefaultContent() {
		WebUI.switchToDefaultContent()
	}

	private void switchToIframeMenu() {
		WebUI.switchToFrame(iframeMenu, 1)
	}

	private void clickNewApplicationData() {
		WebUI.click(btnNewApplicationDataEntry)
	}

	private void clickNewApplication() {
		WebUI.click(btnNewApplication)
	}

	private void clickNotifFromSales() {
		WebUI.click(btnNotifFromSalesAndCDE)
	}

	private void clickAgreementDistribution() {
		WebUI.click(btnAgreementDistribution)
	}
	private void clickPurchaseOrder() {
		WebUI.click(btnPurchaseOrder)
	}

	private void clickRequestHandling() {
		WebUI.click(btnRequestHandling)
	}

	private void clickDocumentSigner() {
		WebUI.click(btnDocumentSigner)
	}

	private void clickDocumentPrinting() {
		WebUI.click(btnDocumentPrinting)
	}
	private void clickApplicationInquiry() {
		WebUI.click(btnApplicationInquiry)
	}
	private void clickAdditionalProcess() {
		WebUI.click(btnAdditionalProcess)
	}
	private void clickReturnHandlingTask() {
		WebUI.click(btnReturnHandlingTask)
	}
	private void clickUpdateLifeInsurance() {
		WebUI.click(btnUpdateLifeInsurance)
	}

	private void clickESign() {
		WebUI.click(btnESign)
	}

	private void clickCreditProcess() {
		WebUI.click(btnCreditProcess)
	}

	private void clickSupplier() {
		WebUI.click(btnSupplier)
	}

	private void clickCustomerNegative() {
		WebUI.click(btnCustomerNegative)
	}

	private void clickSurvey() {
		WebUI.click(btnSurvey)
	}
	private void clickMOU() {
		WebUI.click(btnMOU)
	}

	private void clickLoanOriginationReports() {
		WebUI.click(btnLoanOriginationReports)
	}
	private void clickCreditProcessInquiry() {
		WebUI.click(btnCreditProcessInquiry)
	}
	private void clickSubMenuCustomer() {
		WebUI.click(btnSubMenuCustomer)
	}

	private void clickTAFReports() {
		WebUI.click(btnTAFReports)
	}
	private void clickInternalSystem() {
		WebUI.click(btnInternalSystem)
	}

	private void navigateToCreditSimulation() {
		WebUI.switchToDefaultContent()
		WebUI.click(drpMenu)
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.click(btnCreditProcess)
		WebUI.selectOptionByLabel(drpModul, "LOAN ORIGINATION", false)
		WebUI.click(btnCreditSimulation)
		WebUI.switchToDefaultContent()
	}
}
