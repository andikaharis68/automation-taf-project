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
import com.kms.katalon.core.util.KeywordUtil
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
	private TestObject btnCentralizeDataEntry 		= createTestObject("btnCentralizeDataEntry", "text", "Centralized Data Entry")
	private TestObject btnNewApplicationDataEntry	= createTestObject("btnNewApplicationDataEntry", "text", "New Application Data Entry")
	private TestObject btnNewApplication			= createTestObject("btnNewApplication", "text", "New Application")
	private TestObject btnNotifFromSalesAndCDE		= createTestObject("btnNotifFromSalesAndCDE", "xpath", "")
	private TestObject btnAgreementDistribution		= createTestObject("btnAgreementDistribution", "xpath", "")
	private TestObject btnPurchaseOrder				= createTestObject("btnPurchaseOrder", "text", "Purchase Order Agreement")
	private TestObject btnRequestHandling			= createTestObject("btnRequestHandling", "xpath", "")
	private TestObject btnDocumentSigner			= createTestObject("btnDocumentSigner", "xpath", "//a[text() = 'Document Signer' and @class = 'rtIn']")
	private TestObject btnDocumentPrinting			= createTestObject("btnDocumentPrinting", "xpath", "")
	private TestObject btnExpandApplicationInquiry	= createTestObject("btnApplicationInquiry", "xpath", "//span[text() = 'Application Inquiry']/preceding-sibling::span[@class = 'rtPlus']")
	private TestObject btnApplicationInquiry		= createTestObject("btnApplicationInquiry", "xpath", "//a[text() = 'Application Inquiry']")
	private TestObject btnAdditionalProcess			= createTestObject("btnAdditionalProcess", "xpath", "")
	private TestObject btnReturnHandlingTask		= createTestObject("btnReturnHandlingTask", "xpath", "")
	private TestObject btnUpdateLifeInsurance		= createTestObject("btnUpdateLifeInsurance", "xpath", "")
	private TestObject btnESign						= createTestObject("btnESign", "xpath", "")
	private TestObject btnCDECompletion				= createTestObject("btnCDECompletion", "text", "Centralized Data Entry Completion")
	private TestObject btnCreditApproval			= createTestObject("btnCreditApproval", "text", "Credit Approval with Decision Engine")


	private TestObject btnCreditProcess				= createTestObject("btnCreditProcess", "xpath", "//a[@id='rModuleList_lbModuleList_0']")
	private TestObject btnCustomer					= createTestObject("btnCustomer", "xpath", "//a[@id='rModuleList_lbModuleList_1']")
	private TestObject btnSupplier					= createTestObject("btnSupplier", "xpath", "//a[@id='rModuleList_lbModuleList_2']")
	private TestObject btnSurvey					= createTestObject("btnSurvey", "xpath", "//a[text() = 'Survey']")
	private TestObject btnMOU						= createTestObject("btnMOU", "xpath", "//a[@id='rModuleList_lbModuleList_4']")
	private TestObject btnLoanOriginationReports	= createTestObject("btnLoanOriginationReports", "xpath", "//a[@id='rModuleList_lbModuleList_5']")
	private TestObject btnTAFReports				= createTestObject("btnTAFReports", "xpath", "//a[@id='rModuleList_lbModuleList_6']")
	private TestObject btnInternalSystem			= createTestObject("btnInternalSystem", "xpath", "//a[@id='rModuleList_lbModuleList_7']")
	private TestObject btnCreditProcessInquiry		= createTestObject("btnCreditProcessInquiry", "xpath", "") // ada di favourite
	private TestObject btnSubMenuCustomer 			= createTestObject("btnSubMenuCustomer", "xpath", "//*[@id='rtvMenuTree']/ul/li[1]/div/a")
	private TestObject btnCustomerNegative			= createTestObject("btnCustomerNegative", "xpath", "")
	private TestObject btnProspect					= createTestObject("btnProspect", "id", "rModuleList_lbModuleList_0")
	private TestObject btnSurveyTaskAssignment		= createTestObject("btnSurveyTaskAssignment", "xpath", "//a[text() = 'Survey Task Assignment']")
	private TestObject btnDeliveryOrder				= createTestObject("btnDeliveryOrder", "xpath", "//a[text() = 'Delivery Order']")
	private TestObject btnCustomerConfirmation		= createTestObject("btnCustomerConfirmation", "xpath", "//a[text() = 'Customer Confirmation']")
	private TestObject btnInvoice					= createTestObject("btnInvoice", "xpath", "//a[text() = 'Invoice']")

	private TestObject lblSuccessMessage 			= createTestObject("lblSuccessMessage", "xpath", "//p[@id ='messageContent' and contains(text(), 'Save Success')]")
	private TestObject iframeMenu 					= createTestObject("iframeMenu", "xpath", "//*[@id='treeContainer']")
	private TestObject btnDocumentChecklist			= createTestObject("btnDocumentChecklist", "xpath", "//*[@id='rtvMenuTree']/ul/li[2]/div/a")

	private void verifyLandingMenuPage() {
		verifyLanding(drpMenu, "Menu")
	}

	private void clickDropdownMenu() {
		safetyClick(drpMenu)
	}

	private void clickDropdownFavourite() {
		WebUI.click(drpFavourite)
	}

	private void clickCustomer() {
		WebUI.click(btnCustomer)
		WebUI.takeScreenshot()
	}

	private void switchDefaultContent() {
		WebUI.switchToDefaultContent()
	}

	private void switchToIframeMenu() {
		WebUI.switchToDefaultContent()
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

	private void selectMenuLoanOrganitation() {
		BaseHelper.safetySelect(drpModul, "LOAN ORIGINATION")
	}

	private void selectMenuMarketing() {
		BaseHelper.safetySelect(drpModul, "MARKETING")
		WebUI.takeScreenshotAsCheckpoint("Testing Description Screenshot")
	}

	private void clickCreditSimulation() {
		BaseHelper.safetyClick(btnCreditSimulation)
	}

	private void clickCentralizedDataEntry() {
		BaseHelper.safetyClick(btnCentralizeDataEntry)
	}

	private void navigateToCreditSimulation() {
		WebUI.switchToDefaultContent()
		WebUI.click(drpMenu)
		WebUI.takeScreenshot()
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.click(btnCreditProcess)
		WebUI.selectOptionByLabel(drpModul, "LOAN ORIGINATION", false)
		WebUI.click(btnCreditSimulation)
		WebUI.switchToDefaultContent()
	}

	private void navigateToCentralizedDataEntryCompletion() {
		WebUI.switchToDefaultContent()
		WebUI.waitForElementPresent(drpMenu, 10)
		WebUI.click(drpMenu)
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.selectOptionByLabel(drpModul, "MARKETING", false)
		WebUI.click(btnProspect)
		WebUI.takeScreenshot()
		WebUI.click(btnCDECompletion)
		WebUI.switchToDefaultContent()
	}

	public void verifySuccessMessage() {
		WebUI.switchToDefaultContent()
		WebUI.waitForElementPresent(lblSuccessMessage, 206)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}

	private void navigateToNewApplicationDataEntry() {
		WebUI.click(btnNewApplicationDataEntry)
	}
	private void navigateToSurveyTask() {
		WebUI.switchToDefaultContent()
		WebUI.click(drpMenu)
		WebUI.delay(1)
		WebUI.takeScreenshot()
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.click(btnSurvey)
		WebUI.click(btnSurveyTaskAssignment)
		WebUI.switchToDefaultContent()
	}

	private void navigateToDeliveryOrder() {
		WebUI.switchToDefaultContent()
		WebUI.click(drpMenu)
		WebUI.delay(1)
		WebUI.takeScreenshot()
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.click(btnCreditProcess)
		WebUI.click(btnDeliveryOrder)
		WebUI.switchToDefaultContent()
	}

	private void navigateToNewApplication() {
		WebUI.switchToDefaultContent()
		WebUI.click(drpMenu)
		WebUI.takeScreenshot()
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.click(btnNewApplicationDataEntry)
		WebUI.takeScreenshot()
		WebUI.delay(2)
	}

	private void clickDocumentChecklist() {
		safetyClick(btnDocumentChecklist)
	}

	private void navigateToCustomerConfirmation() {
		WebUI.switchToDefaultContent()
		WebUI.click(drpMenu)
		WebUI.takeScreenshot()
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.click(btnCreditProcess)
		WebUI.click(btnCustomerConfirmation)
		WebUI.switchToDefaultContent()
	}

	private void navigateToInvoice() {
		WebUI.switchToDefaultContent()
		WebUI.click(drpMenu)
		WebUI.delay(1)
		WebUI.takeScreenshot()
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.click(btnCreditProcess)
		WebUI.click(btnInvoice)
		WebUI.switchToDefaultContent()
	}

	private void navigateToDocumentSigner() {
		WebUI.switchToDefaultContent()
		WebUI.click(drpMenu)
		WebUI.delay(1)
		WebUI.takeScreenshot()
		WebUI.switchToFrame(iframeMenu, 1)
		WebUI.click(btnCreditProcess)
		WebUI.click(btnDocumentSigner)
		WebUI.switchToDefaultContent()
	}

	private void navigateToPurchaseOrder() {
		switchDefaultContent()
		WebUI.waitForElementPresent(drpMenu, 10)
		clickDropdownMenu()
		switchToIframeMenu()
		safetySelect(drpModul, "LOAN ORIGINATION")
		safetyClick(btnCreditProcess)
		WebUI.takeScreenshot()
		safetyClick(btnPurchaseOrder)
		switchDefaultContent()
	}

	private void navigateToCreditApproval() {
		switchDefaultContent()
		WebUI.waitForElementPresent(drpMenu, 10)
		clickDropdownMenu()
		switchToIframeMenu()
		safetySelect(drpModul, "LOAN ORIGINATION")
		safetyClick(btnCreditProcess)
		WebUI.takeScreenshot()
		safetyClick(btnCreditApproval)
		switchDefaultContent()
	}

	private void navigateToApplicationInquiry() {
		switchDefaultContent()
		WebUI.waitForElementPresent(drpMenu, 10)
		clickDropdownMenu()
		switchToIframeMenu()
		safetySelect(drpModul, "LOAN ORIGINATION")
		safetyClick(btnCreditProcess)
		safetyClick(btnExpandApplicationInquiry)
		WebUI.takeScreenshot()
		safetyClick(btnApplicationInquiry)
		switchDefaultContent()
	}
}
