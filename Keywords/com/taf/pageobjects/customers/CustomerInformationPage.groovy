package com.taf.pageobjects.customers

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class CustomerInformationPage extends BaseHelper {

	private TestObject txfCustomerNo			= createTestObject("txfCustomerNo", "xpath", "//input[@id='ucSearch_txtCustNo_ltlCustCustNo']")
	private TestObject drpCustomerType			= createTestObject("drpCustomerType", "xpath", "//select[@id='ucSearch_ddlCustType_ltlCustCustType_ddlReference']")
	private TestObject txfAddress				= createTestObject("txfAddress", "xpath", "//input[@id='ucSearch_txtAddrTypeName_ltlCustAddrAddr']")
	private TestObject txfCustomerName			= createTestObject("txfCustomerName", "xpath", "//input[@id='ucSearch_txtCustName_ltlCustCustName']")
	private TestObject drpCustomerRating		= createTestObject("drpCustomerRating", "xpath", "//select[@id='ucSearch_ddlCustRating_ltlCustCustRating_ddlReference']")
	private TestObject btnSearch				= createTestObject("btnSearch", "xpath", "//input[@id='ucSearch_btnSearch']")
	private TestObject btnReset					= createTestObject("btnReset", "xpath", "//a[@id='ucSearch_lbReset']")

	private TestObject btnAddPersonalCustomer	= createTestObject("btnAddPersonalCustomer", "xpath", "//a[@id='lb_Toolbar_AddPersonal']")
	private TestObject btnAddCompanyCustomer	= createTestObject("btnAddCompanyCustomer", "xpath", "//a[@id='lb_Toolbar_AddCompany']")

	private TestObject btnPenEditCustomer		= createTestObject("btnPenEditCustomer", "id", "gvCustomer_imbEdit_0")
	private TestObject lblCustomerNo			= createTestObject("lblCustomerNo", "id", "gvCustomer_lbl_Cust_CustNo_0")

	private TestObject iframeMainpage 			= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")


	private void verifyLandingInCustInfoPage() {
		verifyLanding(txfCustomerNo, "Customer Information")
	}

	private void inputCustomerName(String name) {
		safetyInput(txfCustomerName, name)
	}

	private void selectCustomerType(String customerType) {
		safetySelect(drpCustomerType, customerType)
	}

	private void inputAddress(String address) {
		safetyInput(txfAddress, address)
	}

	private void inputCustomerNo(String customerNo) {
		safetyInput(txfCustomerNo, customerNo)
	}
	private void selectCustomerRating(String customerRating) {
		safetySelect(drpCustomerRating, customerRating)
	}
	private void clickSearch() {
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}

	private void clickReset() {
		safetyClick(btnReset)
	}
	private void addPersonalCustomer() {
		safetyClick(btnAddPersonalCustomer)
	}
	private void addCompanyCustomer() {
		safetyClick(btnAddCompanyCustomer)
		WebUI.takeScreenshot()
	}
	private void switchToIframeMain() {
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	private void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}

	private void searchCustomerName(String fullname) {
		safetyInput(txfCustomerNo, fullname)
		WebUI.takeScreenshot()
	}


	private void clickEdit() {
		WebUI.click(btnPenEditCustomer)
	}

	private void verifyTableCustomer(String expectedNo) {
		def actual = WebUI.getText(lblCustomerNo)
		boolean compare = actual.equals(expectedNo)
		if(compare) {
			WebUI.takeScreenshot()
		}else {
			KeywordUtil.markFailedAndStop("Customer Number Different")
		}
	}
	private void clickCustomerHyperlink(String fullname) {
		WebUI.delay(5)
		TestObject txtFullName
		if(fullname) {
			txtFullName = createTestObject("txtFullName", "xpath", "//*[text()= '$fullname']")
		} else {
			txtFullName = createTestObject("txtFullName", "id", "gvCustomer_lbl_Cust_CustName_0")
		}

		if(WebUI.verifyElementPresent(txtFullName, 5)) {
			KeywordUtil.markPassed("customer $fullname is exist")
			safetyClick(txtFullName)
			WebUI.delay(2)
			switchToNewTab()
			WebUI.takeScreenshot()
		} else {
			KeywordUtil.markFailed("customer $fullname is not found")
		}
	}

	private void clickCustomerHyperlinkEdit() {
		TestObject hyperlink = createTestObject("hyperlink", "xpath", "//*[@id='gvCustomer_lbl_Cust_CustName_0']")
		safetyClick(hyperlink)
		WebUI.delay(8)
		WebUI.switchToWindowIndex(1)
		WebUI.takeScreenshot()
	}
	private void switchToNewTab2() {
		int currentTab = WebUI.getWindowIndex()
		WebUI.switchToWindowIndex(currentTab + 1)
	}
}
